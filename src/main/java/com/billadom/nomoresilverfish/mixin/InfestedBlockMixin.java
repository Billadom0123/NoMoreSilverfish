package com.billadom.nomoresilverfish.mixin;

import net.minecraft.world.level.block.InfestedBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InfestedBlock.class)
public class InfestedBlockMixin {

    @Inject(method = "spawnInfestation", at = @At("HEAD"), cancellable = true)
    private void NoMoreSilverfish$spawnInfestation(CallbackInfo ci) {
        ci.cancel();
    }


}
