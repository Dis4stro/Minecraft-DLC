package net.astro.dlc.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties MATURE_TOMATO = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.45F).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 50, 1), 0.35F).alwaysEat().build();
    public static final FoodProperties HALF_MATURE_TOMATO = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
    public static final FoodProperties UNRIPE_TOMATO = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.15F).fast().build();
    public static final FoodProperties BAOBAB_FRUIT = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 0.5F).alwaysEat().build();
}
