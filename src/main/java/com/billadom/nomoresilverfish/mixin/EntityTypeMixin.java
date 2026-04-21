package com.billadom.nomoresilverfish.mixin;

import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityType.class)
public class EntityTypeMixin {

    @Inject(method = "spawn*", at = @At("HEAD"), cancellable = true)
    private void NoMoreSilverfish$spawn(CallbackInfoReturnable<Boolean> cir) {
        EntityType<?> entityType = (EntityType<?>) (Object) this;
        if (entityType == EntityType.SILVERFISH) {
            cir.setReturnValue(false);
        }
    }
}
