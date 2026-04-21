package com.billadom.nomoresilverfish.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerLevel.class)
public class ServerLevelMixin {

    @Inject(method = "addEntity", at = @At("HEAD"), cancellable = true)
    private void NoMoreSilverfish$addEntity(Entity p_8873_, CallbackInfoReturnable<Boolean> cir) {
        if (p_8873_.getType() == EntityType.SILVERFISH) {
            cir.setReturnValue(false);
        }
    }
}
