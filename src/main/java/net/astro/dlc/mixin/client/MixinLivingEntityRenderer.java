package net.astro.dlc.mixin.client;

import net.astro.dlc.effect.ModEffects;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public abstract class MixinLivingEntityRenderer<T extends LivingEntity, M extends EntityModel<T>> {
    @Inject(method = "isShaking", at = @At("HEAD"), cancellable = true)
    protected void injectGetTicksRequiredToFreeze(T pEntity, CallbackInfoReturnable<Boolean> info) {
        if(pEntity.getActiveEffectsMap().containsKey(ModEffects.FREEZING.get())) {
            info.setReturnValue(true);
        }
    }
}
