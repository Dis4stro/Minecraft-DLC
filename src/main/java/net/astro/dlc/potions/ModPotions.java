package net.astro.dlc.potions;

import net.astro.dlc.DLC;
import net.astro.dlc.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, DLC.MOD_ID);

    public static final RegistryObject<Potion> FROSTBITE_POTION = POTIONS.register("frostbite", () ->
            new Potion(new MobEffectInstance(ModEffects.FREEZING.get(), 400,0)));
    public static final RegistryObject<Potion> MEDIUM_FROSTBITE_POTION = POTIONS.register("medium_frostbite", () ->
            new Potion(new MobEffectInstance(ModEffects.FREEZING.get(), 1200,0)));
    public static final RegistryObject<Potion> LONG_FROSTBITE_POTION = POTIONS.register("long_frostbite", () ->
            new Potion(new MobEffectInstance(ModEffects.FREEZING.get(), 4200,0)));
    public static final RegistryObject<Potion> FREEZING_POTION = POTIONS.register("freezing_potion", () ->
            new Potion(new MobEffectInstance(ModEffects.FREEZING.get(), 300,1)));
    public static final RegistryObject<Potion> MEDIUM_FREEZING_POTION = POTIONS.register("medium_freezing_potion", () ->
            new Potion(new MobEffectInstance(ModEffects.FREEZING.get(), 900,1)));
    public static final RegistryObject<Potion> LONG_FREEZING_POTION = POTIONS.register("long_freezing_potion", () ->
            new Potion(new MobEffectInstance(ModEffects.FREEZING.get(), 3150,1)));
    public static final RegistryObject<Potion> INTENSE_FREEZING_POTION = POTIONS.register("intense_freezing_potion", () ->
            new Potion(new MobEffectInstance(ModEffects.FREEZING.get(), 200,3)));
    public static final RegistryObject<Potion> MEDIUM_INTENSE_FREEZING_POTION = POTIONS.register("medium_intense_freezing_potion", () ->
            new Potion(new MobEffectInstance(ModEffects.FREEZING.get(), 400,3)));
    public static final RegistryObject<Potion> LONG_INTENSE_FREEZING_POTION = POTIONS.register("long_intense_freezing_potion", () ->
            new Potion(new MobEffectInstance(ModEffects.FREEZING.get(), 1400,3)));

    public static final RegistryObject<Potion> BAD_OMEN = POTIONS.register("bad_omen", () ->
            new Potion(new MobEffectInstance(MobEffects.BAD_OMEN, 2400,0)));
    public static final RegistryObject<Potion> INFINITE_BAD_OMEN = POTIONS.register("infinite_bad_omen", () ->
            new Potion(new MobEffectInstance(MobEffects.BAD_OMEN, 24000,0)));
    public static final RegistryObject<Potion> JINX = POTIONS.register("jinx", () ->
            new Potion(new MobEffectInstance(MobEffects.BAD_OMEN, 2400,2)));
    public static final RegistryObject<Potion> INFINITE_JINX = POTIONS.register("infinite_jinx", () ->
            new Potion(new MobEffectInstance(MobEffects.BAD_OMEN, 24000,2)));
    public static final RegistryObject<Potion> CURSE = POTIONS.register("curse", () ->
            new Potion(new MobEffectInstance(MobEffects.BAD_OMEN, 2400,4)));
    public static final RegistryObject<Potion> INFINITE_CURSE = POTIONS.register("infinite_curse", () ->
            new Potion(new MobEffectInstance(MobEffects.BAD_OMEN, 24000,4)));

    public static final RegistryObject<Potion> HASTE = POTIONS.register("haste", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 3600,1)));
    public static final RegistryObject<Potion> LONG_HASTE = POTIONS.register("long_haste", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 9600,1)));
    public static final RegistryObject<Potion> STRONG_HASTE = POTIONS.register("strong_haste", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 1200,3)));

    public static final RegistryObject<Potion> MINING_FATIGUE = POTIONS.register("mining_fatigue", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3600,1)));
    public static final RegistryObject<Potion> LONG_MINING_FATIGUE = POTIONS.register("long_mining_fatigue", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 9600,1)));
    public static final RegistryObject<Potion> STRONG_MINING_FATIGUE = POTIONS.register("strong_mining_fatigue", () ->
            new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1200,2)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
