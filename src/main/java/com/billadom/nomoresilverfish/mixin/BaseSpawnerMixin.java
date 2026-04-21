package com.billadom.nomoresilverfish.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BaseSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(BaseSpawner.class)
public class BaseSpawnerMixin {

    @ModifyVariable(
            method = "setEntityId",
            at = @At("HEAD"),
            argsOnly = true,
            ordinal = 0
    )
    private EntityType<?> nomoresilverfish$modifyEntityType(EntityType<?> original) {
        if (original.equals(EntityType.SILVERFISH)) {
            return EntityType.ZOMBIE;
        }
        return original;
    }
//    public void setEntityId(EntityType<?> p_253682_, @Nullable Level p_254041_, RandomSource p_254221_, BlockPos p_254050_) {
//        this.getOrCreateNextSpawnData(p_254041_, p_254221_, p_254050_).getEntityToSpawn().putString("id", BuiltInRegistries.ENTITY_TYPE.getKey(p_253682_).toString());
//    }
}
