package com.billadom.nomoresilverfish.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

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

    @Inject(
            method = "getOrCreateDisplayEntity",
            at = @At("RETURN"),
            cancellable = true
    )
    private void nomoresilverfish$modifyDisplayEntity(Level p_254323_, RandomSource p_254353_, BlockPos p_254313_, CallbackInfoReturnable<Entity> cir) {
        Entity displayEntity = cir.getReturnValue();
        if (displayEntity != null && displayEntity.getType() == EntityType.SILVERFISH) {
            cir.setReturnValue(null);
        }
    }

//    @Nullable
//    public Entity getOrCreateDisplayEntity(Level level, BlockPos pos) {
//        if (this.displayEntity == null) {
//            CompoundTag compoundtag = this.getOrCreateNextSpawnData(level, level.getRandom(), pos).getEntityToSpawn();
//            if (!compoundtag.contains("id", 8)) {
//                return null;
//            }
//
//            this.displayEntity = EntityType.loadEntityRecursive(compoundtag, level, Function.identity());
//            if (compoundtag.size() == 1 && this.displayEntity instanceof Mob) {
//            }
//        }
//
//        return this.displayEntity;
//    }
}
