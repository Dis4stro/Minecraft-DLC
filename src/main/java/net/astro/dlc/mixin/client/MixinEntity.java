package net.astro.dlc.mixin.client;

import net.astro.dlc.effect.ModEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class MixinEntity {
    @Inject(method = "isFullyFrozen", at = @At("HEAD"), cancellable = true)
    protected void injectIsFullyFrozen(CallbackInfoReturnable<Boolean> info) {
        Entity entity = (Entity)((Object)this);
        if(entity instanceof LivingEntity lEntity){
            if(lEntity.getActiveEffectsMap().containsKey(ModEffects.FREEZING.get())) {
                info.setReturnValue(true);
            }
        }
    }
}
