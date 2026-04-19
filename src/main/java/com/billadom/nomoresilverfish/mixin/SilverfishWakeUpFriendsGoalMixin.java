package com.billadom.nomoresilverfish.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.world.entity.monster.Silverfish$SilverfishWakeUpFriendsGoal")
public class SilverfishWakeUpFriendsGoalMixin {

    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void NoMoreSilverfish$tick(CallbackInfo ci) {
        ci.cancel();
    }
}
