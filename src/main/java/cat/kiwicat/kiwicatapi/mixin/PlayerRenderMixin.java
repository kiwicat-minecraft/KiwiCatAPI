package cat.kiwicat.kiwicatapi.mixin;

import cat.kiwicat.kiwicatapi.api.SkinMaker;
import cat.kiwicat.kiwicatapi.api.SkinProvider;
import cat.kiwicat.kiwicatapi.client.KiwiCatAPIClient;
import cat.kiwicat.kiwicatapi.api.SkinInfo;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.SkinTextures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class PlayerRenderMixin {

    @Inject(method = "getSkinTextures", at = @At("RETURN"), cancellable = true)
    private void replaceSkin(CallbackInfoReturnable<SkinTextures> cir) {

        final SkinTextures.Model[] model = new SkinTextures.Model[1];

        AbstractClientPlayerEntity self =
                (AbstractClientPlayerEntity) (Object) this;

        SkinTextures original = cir.getReturnValue();

        if (!KiwiCatAPIClient.blacklist) {

            SkinMaker.providers().forEach(provider -> {
                for(SkinInfo skin : provider.create().getSkins()){
                    if (skin.getUsername().equals(self.getName().getString())) {

                        if (skin.isSLIM()) {
                            model[0] = SkinTextures.Model.SLIM;
                        } else {
                            model[0] = SkinTextures.Model.WIDE;
                        }

                        SkinTextures modified = new SkinTextures(
                                skin.getTexture(),
                                original.textureUrl(),
                                original.capeTexture(),
                                original.elytraTexture(),
                                model[0],
                                original.secure()
                        );

                        cir.setReturnValue(modified);
                        return;
                    }
                }
            } );



        } else {
            SkinMaker.providers().forEach(provider -> {

                for (SkinInfo skin : provider.create().getSkins()) {

                    if (skin.getUsername().equals(self.getName().getString())) {
                        return;
                    }
                }

                if (!provider.create().getSkins().isEmpty()) {

                    SkinInfo skin_first = KiwiCatAPIClient.SkinChanges.get(0);

                    if (skin_first.isSLIM()) {
                        model[0] = SkinTextures.Model.SLIM;
                    } else {
                        model[0] = SkinTextures.Model.WIDE;
                    }

                    SkinTextures modified = new SkinTextures(
                            skin_first.getTexture(),
                            original.textureUrl(),
                            original.capeTexture(),
                            original.elytraTexture(),
                            model[0],
                            original.secure()
                    );

                    cir.setReturnValue(modified);
                }
            });
        }
    }
}