package com.jsorrell.carpetskyadditions.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {
  protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
    super(entityType, world);
  }

  @Inject(at = @At("HEAD"), method = "initialize")
  protected void equipEndermanGrass(ServerWorldAccess world,
                                        LocalDifficulty difficulty,
                                        SpawnReason spawnReason,
                                        EntityData entityData,
                                        NbtCompound entityNbt,
                                        CallbackInfoReturnable<EntityData> cir) {
    LivingEntity _this = this;
    if (_this instanceof EndermanEntity enderman) {
      if (world.getDimension().effects().toString().equals("minecraft:overworld") && random.nextFloat() <= 0.01) {
        enderman.setCarriedBlock(Blocks.GRASS_BLOCK.getDefaultState());
      }
    }
  }
}
