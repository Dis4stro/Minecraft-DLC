package net.astro.dlc.blocks.flowers;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LevitationDandelion extends ModFlower {

    public LevitationDandelion(MobEffect pSuspiciousStewEffect, int pEffectDuration, Properties pProperties) {
        super(pSuspiciousStewEffect, pEffectDuration, pProperties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return super.mayPlaceOn(pState, pLevel, pPos);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        VoxelShape voxelshape = this.getShape(pState, pLevel, pPos, CollisionContext.empty());
        Vec3 vec3 = voxelshape.bounds().getCenter();
        double d0 = (double)pPos.getX() + vec3.x;
        double d1 = (double)pPos.getZ() + vec3.z;

        if (pRandom.nextInt(5) == 0) {
            pLevel.addParticle(ParticleTypes.CLOUD, d0 + pRandom.nextDouble() / 5.0D, (double)pPos.getY() + (0.5D - pRandom.nextDouble()), d1 + pRandom.nextDouble() / 5.0D, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (!pLevel.isClientSide()) {
            if (pEntity instanceof LivingEntity) {
                LivingEntity livingentity = (LivingEntity)pEntity;
                livingentity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 80, 1));
            }
        }
    }
}
