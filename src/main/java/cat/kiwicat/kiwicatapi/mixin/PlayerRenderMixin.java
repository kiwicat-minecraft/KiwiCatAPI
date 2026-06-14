package cat.kiwicat.kiwicatapi.mixin;

import cat.kiwicat.kiwicatapi.client.KiwiCatAPIClient;
import cat.kiwicat.kiwicatapi.client.util.SkinInfo;
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

        SkinTextures.Model model;

        AbstractClientPlayerEntity self =
                (AbstractClientPlayerEntity) (Object) this;

        SkinTextures original = cir.getReturnValue();

        if (!KiwiCatAPIClient.blacklist) {

            for (SkinInfo skin : KiwiCatAPIClient.SkinChanges) {

                if (skin.getUsername().equals(self.getName().getString())) {

                    if (skin.isSLIM()) {
                        model = SkinTextures.Model.SLIM;
                    } else {
                        model = SkinTextures.Model.WIDE;
                    }

                    SkinTextures modified = new SkinTextures(
                            skin.getTexture(),
                            original.textureUrl(),
                            original.capeTexture(),
                            original.elytraTexture(),
                            model,
                            original.secure()
                    );

                    cir.setReturnValue(modified);
                    return;
                }
            }

        } else {

            for (SkinInfo skin : KiwiCatAPIClient.SkinChanges) {

                if (skin.getUsername().equals(self.getName().getString())) {
                    return;
                }
            }

            if (!KiwiCatAPIClient.SkinChanges.isEmpty()) {

                SkinInfo skin_first = KiwiCatAPIClient.SkinChanges.get(0);

                if (skin_first.isSLIM()) {
                    model = SkinTextures.Model.SLIM;
                } else {
                    model = SkinTextures.Model.WIDE;
                }

                SkinTextures modified = new SkinTextures(
                        skin_first.getTexture(),
                        original.textureUrl(),
                        original.capeTexture(),
                        original.elytraTexture(),
                        model,
                        original.secure()
                );

                cir.setReturnValue(modified);
            }
        }
    }
}