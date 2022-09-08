package net.astro.dlc.effect;

import net.astro.dlc.DLC;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.UUID;

public class ModEffects {

    public static final String FREEZING_SLOW_UUID = "4ffdbfb6-256e-11ed-861d-0242ac120002";
    public static final String FREEZING_ATTACK_SPEED_UUID = "47c063ad-8722-4658-a7aa-2ef41e2d6a10";
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, DLC.MOD_ID);

    public static final RegistryObject<MobEffect> FREEZING = MOB_EFFECTS.register("freeze",
            () -> (new FreezingEffect(MobEffectCategory.HARMFUL, -6697729))
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, FREEZING_SLOW_UUID, -0.4f, AttributeModifier.Operation.MULTIPLY_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_SPEED, FREEZING_ATTACK_SPEED_UUID, -0.15f, AttributeModifier.Operation.MULTIPLY_TOTAL));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
