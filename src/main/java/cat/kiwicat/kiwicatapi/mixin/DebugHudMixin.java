package cat.kiwicat.kiwicatapi.mixin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cat.kiwicat.kiwicatapi.KiwiCatAPI;
import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DebugHud.class)
public abstract class DebugHudMixin {
    @Inject(
            method = {"getLeftText"},
            at = {@At("RETURN")},
            cancellable = true
    )
    private void addCustomInfo(CallbackInfoReturnable<List<String>> cir) {
        List<String> list = new ArrayList((Collection)cir.getReturnValue());
        list.add("");
        list.add("KiwiCatAPI " + KiwiCatAPI.VERSION);
        cir.setReturnValue(list);
    }
}

