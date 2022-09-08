package net.astro.dlc.item;

import net.astro.dlc.DLC;
import net.astro.dlc.blocks.ModBlocks;
import net.astro.dlc.item.battery.BatteryItem;
import net.astro.dlc.item.battery.items.Chainsaw;
import net.astro.dlc.item.fuels.FlammableDust;
import net.astro.dlc.sound.ModSounds;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DLC.MOD_ID);

    // https://www.gmpe.it/node/137 ELEMENTI UTILIZZATI DALL'UOMO

    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)));
    public static final RegistryObject<Item> ALUMINIUM_NUGGET = ITEMS.register("aluminium_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)));
    public static final RegistryObject<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)));
    public static final RegistryObject<Item> BRONZE_NUGGET = ITEMS.register("bronze_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)));
    public static final RegistryObject<Item> CHAINSAW = ITEMS.register("chainsaw",
            () -> new Chainsaw(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_TOOLS).durability(25),
                    new BatteryItem.BatteryProperties().energy(275)));
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)));
    public static final RegistryObject<Item> FLAMMABLE_DUST = ITEMS.register("flammable_dust",
            () -> new FlammableDust(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)));
    public static final RegistryObject<Item> RAW_ALUMINIUM = ITEMS.register("raw_aluminium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)));
    public static final RegistryObject<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)));
    public static final RegistryObject<Item> TIN_NUGGET = ITEMS.register("tin_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)));

    /////////////////////

    public static final RegistryObject<Item> BRONZE_AXE = ITEMS.register("bronze_axe",
            () -> new AxeItem(ModTiers.BRONZE, 4.0f, -3.15f,
                    new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_TOOLS)));
    public static final RegistryObject<Item> BRONZE_HOE = ITEMS.register("bronze_hoe",
            () -> new HoeItem(ModTiers.BRONZE, -4, -1,
                    new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_TOOLS)));
    public static final RegistryObject<Item> BRONZE_PICKAXE = ITEMS.register("bronze_pickaxe",
            () -> new PickaxeItem(ModTiers.BRONZE, -2, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_TOOLS)));
    public static final RegistryObject<Item> BRONZE_SHOVEL = ITEMS.register("bronze_shovel",
            () -> new ShovelItem(ModTiers.BRONZE, -1, -3,
                    new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_TOOLS)));
    public static final RegistryObject<Item> BRONZE_SWORD = ITEMS.register("bronze_sword",
            () -> new SwordItem(ModTiers.BRONZE, 0, -2.5f,
                    new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_COMBAT)));

    /////////////////////

    public static final RegistryObject<Item> BRONZE_HELMET = ITEMS.register("bronze_helmet",
            () -> new ModArmorEffectItem(ModArmorMaterial.BRONZE, EquipmentSlot.HEAD,
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 0),
                    "bronze", new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_COMBAT)));
    public static final RegistryObject<Item> BRONZE_CHESTPLATE = ITEMS.register("bronze_chestplate",
            () -> new ModArmorEffectItem(ModArmorMaterial.BRONZE, EquipmentSlot.CHEST,
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 0),
                    "bronze", new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_COMBAT)));
    public static final RegistryObject<Item> BRONZE_LEGGINGS = ITEMS.register("bronze_leggings",
            () -> new ModArmorEffectItem(ModArmorMaterial.BRONZE, EquipmentSlot.LEGS,
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 0),
                    "bronze", new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_COMBAT)));
    public static final RegistryObject<Item> BRONZE_BOOTS = ITEMS.register("bronze_boots",
            () -> new ModArmorEffectItem(ModArmorMaterial.BRONZE, EquipmentSlot.FEET,
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20, 0),
                    "bronze", new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_COMBAT)));
    public static final RegistryObject<Item> BRONZE_HORSE_ARMOR = ITEMS.register("bronze_horse_armor",
            () -> new HorseArmorItem(5, "bronze", new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DLC_TAB_MISC)));
    public static final RegistryObject<Item> CHAINMAIL_HORSE_ARMOR = ITEMS.register("chainmail_horse_armor",
            () -> new HorseArmorItem(4, "chainmail", new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DLC_TAB_MISC)));
    public static final RegistryObject<Item> NETHERITE_HORSE_ARMOR = ITEMS.register("netherite_horse_armor",
            () -> new HorseArmorItem(11, "netherite", new Item.Properties().stacksTo(1).tab(ModCreativeModeTab.DLC_TAB_MISC)));


    /////////////////////

    public static final RegistryObject<Item> BAOBAB_FRUIT = ITEMS.register("baobab_fruit",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_FOODS).food(ModFoods.BAOBAB_FRUIT)));
    public static final RegistryObject<Item> HALF_MATURE_TOMATO = ITEMS.register("half_mature_tomato",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_FOODS).food(ModFoods.HALF_MATURE_TOMATO)));
    public static final RegistryObject<Item> MATURE_TOMATO = ITEMS.register("mature_tomato",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_FOODS).food(ModFoods.MATURE_TOMATO)));
    public static final RegistryObject<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOMATO_PLANT.get(),
                    new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)));
    public static final RegistryObject<Item> UNRIPE_TOMATO = ITEMS.register("unripe_tomato",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_FOODS).food(ModFoods.UNRIPE_TOMATO)));

    /////////////////////

    public static final RegistryObject<Item> BAOBAB_SIGN = ITEMS.register("baobab_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_DECORATIONS).stacksTo(16),
                    ModBlocks.BAOBAB_SIGN.get(), ModBlocks.BAOBAB_WALL_SIGN.get()));
    public static final RegistryObject<Item> ENDER_DRAGON_MUSIC_DISC = ITEMS.register("music_disc_ender_dragon",
            () -> new RecordItem(18, ModSounds.ENDER_DRAGON_DISC, new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)
                    .stacksTo(1).rarity(Rarity.EPIC), (166)*20));
    public static final RegistryObject<Item> ICE_MUSIC_DISC = ITEMS.register("music_disc_ice",
            () -> new RecordItem(16, ModSounds.ICE_DISC, new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)
                    .stacksTo(1).rarity(Rarity.RARE), (150)*20));
    public static final RegistryObject<Item> LUSH_MUSIC_DISC = ITEMS.register("music_disc_lush",
            () -> new RecordItem(18, ModSounds.LUSH_DISC, new Item.Properties().tab(ModCreativeModeTab.DLC_TAB_MISC)
                    .stacksTo(1).rarity(Rarity.RARE), (98)*20));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
