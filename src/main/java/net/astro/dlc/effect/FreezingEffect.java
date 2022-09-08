package net.astro.dlc.effect;

import net.minecraft.network.chat.Component;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;


public class FreezingEffect extends MobEffect {

    protected FreezingEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {

        boolean isFireEntity = pLivingEntity.getType().is(EntityTypeTags.FREEZE_HURTS_EXTRA_TYPES);
        float damageDelay = switch (pAmplifier) {
            case 0 -> 1.5f;
            case 1 -> 0.8f;
            case 2 -> 1f;
            default -> 1.15f;
        };
        int damage = switch (pAmplifier){
            case 0, 1 -> 1;
            case 2 -> 2;
            default -> 4;
        };

        if (!pLivingEntity.level.isClientSide && pLivingEntity.tickCount % (damageDelay*20) == 0) {
            int j = isFireEntity ? damage*5 : damage;
            pLivingEntity.hurt(DamageSource.FREEZE, (float)j);
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }

    @Override
    public double getAttributeModifierValue(int pAmplifier, @NotNull AttributeModifier pModifier) {
        return Math.max(pModifier.getAmount() - ((double)(pAmplifier + 1)*0.1F), -0.75f);
    }
}
