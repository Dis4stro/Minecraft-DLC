package net.astro.dlc;

import com.mojang.logging.LogUtils;
import net.astro.dlc.blocks.ModBlocks;
import net.astro.dlc.effect.ModEffects;
import net.astro.dlc.entity.ModBlockEntities;
import net.astro.dlc.entity.ModWoodTypes;
import net.astro.dlc.item.ModItems;
import net.astro.dlc.networking.ModNetworking;
import net.astro.dlc.painting.ModPainting;
import net.astro.dlc.potions.ModPotions;
import net.astro.dlc.sound.ModSounds;
import net.astro.dlc.util.ModBrewingRecipe;
import net.astro.dlc.world.biomemods.ModBiomeModifiers;
import net.astro.dlc.world.feature.ModPlacedFeatures;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DLC.MOD_ID)
public class DLC
{
    public static final String MOD_ID = "dlc";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DLC() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModPainting.register(eventBus);
        ModSounds.register(eventBus);

        ModEffects.register(eventBus);
        ModPotions.register(eventBus);

        ModBlockEntities.register(eventBus);

        ModBiomeModifiers.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        // eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LEVITATION_DANDELION.getId(), ModBlocks.POTTED_MATURE_DANDELION);

            Sheets.addWoodType(ModWoodTypes.BAOBAB);

            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.SNOWBALL, ModPotions.FROSTBITE_POTION.get())); // UTILIZZA CRISTALLO DI GHIACCIO AL POSTO DELLA PALLA DI NEVE
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.FROSTBITE_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.FREEZING_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.FROSTBITE_POTION.get(), Items.REDSTONE, ModPotions.MEDIUM_FROSTBITE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.FROSTBITE_POTION.get(), Items.FERMENTED_SPIDER_EYE, Potions.SLOWNESS));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.MEDIUM_FROSTBITE_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.MEDIUM_FREEZING_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.MEDIUM_FROSTBITE_POTION.get(), Items.REDSTONE, ModPotions.LONG_FROSTBITE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.MEDIUM_FROSTBITE_POTION.get(), Items.FERMENTED_SPIDER_EYE, Potions.LONG_SLOWNESS));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.LONG_FROSTBITE_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.LONG_FREEZING_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.LONG_FROSTBITE_POTION.get(), Items.REDSTONE, ModPotions.LONG_FROSTBITE_POTION.get())); // RISULTATO: POZIONE DI NAUSEA/CECITA'
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.LONG_FROSTBITE_POTION.get(), Items.FERMENTED_SPIDER_EYE, Potions.LONG_SLOWNESS));

            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.FREEZING_POTION.get(), Blocks.GLOWSTONE.asItem(), ModPotions.INTENSE_FREEZING_POTION.get())); // UTILIZZA POLVERE DI GLOWSTONE DELLA DIMENSIONE DI GHIACCIO
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.FREEZING_POTION.get(), Items.REDSTONE, ModPotions.MEDIUM_FREEZING_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.MEDIUM_FREEZING_POTION.get(), Blocks.GLOWSTONE.asItem(), ModPotions.MEDIUM_INTENSE_FREEZING_POTION.get())); // UTILIZZA BLOCCO DI GLOWSTONE (o qualcos altro di più greve) DELLA DIMENSIONE DI GHIACCIO
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.MEDIUM_FREEZING_POTION.get(), Items.REDSTONE, ModPotions.LONG_FREEZING_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.LONG_FREEZING_POTION.get(), Blocks.GLOWSTONE.asItem(), ModPotions.LONG_INTENSE_FREEZING_POTION.get())); // UTILIZZA GEMMA DEL GHIACCIO
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.LONG_FREEZING_POTION.get(), Items.REDSTONE, ModPotions.LONG_FREEZING_POTION.get())); // RISULTATO: POZIONE DI NAUSEA/CECITA'

            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.INTENSE_FREEZING_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.FREEZING_POTION.get())); // RISULTATO: POZIONE DI NAUSEA/CECITA' / UTILIZZA GEMMA DEL GHIACCIO
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.INTENSE_FREEZING_POTION.get(), Items.REDSTONE, ModPotions.MEDIUM_INTENSE_FREEZING_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.INTENSE_FREEZING_POTION.get(), Items.FERMENTED_SPIDER_EYE, Potions.STRONG_SLOWNESS));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.MEDIUM_INTENSE_FREEZING_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.MEDIUM_FREEZING_POTION.get())); // RISULTATO: POZIONE DI NAUSEA/CECITA' / UTILIZZA GEMMA DEL GHIACCIO
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.MEDIUM_INTENSE_FREEZING_POTION.get(), Items.REDSTONE, ModPotions.LONG_FROSTBITE_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.MEDIUM_INTENSE_FREEZING_POTION.get(), Items.FERMENTED_SPIDER_EYE, Potions.LONG_SLOWNESS));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.LONG_INTENSE_FREEZING_POTION.get(), Items.GLOWSTONE_DUST, ModPotions.LONG_FREEZING_POTION.get())); // RISULTATO: POZIONE DI NAUSEA/CECITA' / UTILIZZA GEMMA DEL GHIACCIO
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.LONG_INTENSE_FREEZING_POTION.get(), Items.REDSTONE, ModPotions.LONG_FROSTBITE_POTION.get())); // RISULTATO: POZIONE DI NAUSEA/CECITA'
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.LONG_INTENSE_FREEZING_POTION.get(), Items.FERMENTED_SPIDER_EYE, Potions.LONG_SLOWNESS));

            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.ARROW, ModPotions.BAD_OMEN.get())); // UTILIZZA ANIMA DI VEX (droppato dai vex)
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.BAD_OMEN.get(), Items.GLOWSTONE_DUST, ModPotions.JINX.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.BAD_OMEN.get(), Items.EMERALD, ModPotions.INFINITE_BAD_OMEN.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.INFINITE_BAD_OMEN.get(), Items.GLOWSTONE_DUST, ModPotions.INFINITE_JINX.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.INFINITE_BAD_OMEN.get(), Items.EMERALD, ModPotions.INFINITE_BAD_OMEN.get())); // RISULTATO: POZIONE DI NAUSEA/CECITA'

            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.JINX.get(), Items.GLOWSTONE_DUST, ModPotions.CURSE.get())); // UTILIZZARE UN OGGETTO IMPORTANTE PER GLI ILLAGER
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.JINX.get(), Items.EMERALD, ModPotions.INFINITE_JINX.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.INFINITE_JINX.get(), Items.GLOWSTONE_DUST, ModPotions.INFINITE_CURSE.get())); // UTILIZZARE UN OGGETTO IMPORTANTE PER GLI ILLAGER
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.INFINITE_JINX.get(), Items.EMERALD, ModPotions.INFINITE_BAD_OMEN.get())); // RISULTATO: POZIONE DI NAUSEA/CECITA'
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.CURSE.get(), Items.EMERALD, ModPotions.INFINITE_CURSE.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.INFINITE_CURSE.get(), Items.EMERALD, ModPotions.INFINITE_BAD_OMEN.get())); // RISULTATO: POZIONE DI NAUSEA/CECITA'

            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.NETHERITE_SCRAP, ModPotions.HASTE.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.HASTE.get(), Items.GLOWSTONE_DUST, ModPotions.STRONG_HASTE.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.HASTE.get(), Items.REDSTONE, ModPotions.LONG_HASTE.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.LONG_HASTE.get(), Items.REDSTONE, ModPotions.LONG_HASTE.get())); // RISULTATO: POZIONE DI NAUSEA/CECITA'
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.HASTE.get(), Items.FERMENTED_SPIDER_EYE, ModPotions.MINING_FATIGUE.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.LONG_HASTE.get(), Items.FERMENTED_SPIDER_EYE, ModPotions.LONG_MINING_FATIGUE.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.STRONG_HASTE.get(), Items.FERMENTED_SPIDER_EYE, ModPotions.STRONG_MINING_FATIGUE.get()));

            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(Potions.AWKWARD, Items.PRISMARINE_SHARD, ModPotions.MINING_FATIGUE.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.MINING_FATIGUE.get(), Items.GLOWSTONE_DUST, ModPotions.STRONG_MINING_FATIGUE.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.MINING_FATIGUE.get(), Items.REDSTONE, ModPotions.LONG_MINING_FATIGUE.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.LONG_MINING_FATIGUE.get(), Items.REDSTONE, ModPotions.LONG_MINING_FATIGUE.get())); // RISULTATO: POZIONE DI NAUSEA/CECITA'
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.MINING_FATIGUE.get(), Items.FERMENTED_SPIDER_EYE, ModPotions.HASTE.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.LONG_MINING_FATIGUE.get(), Items.FERMENTED_SPIDER_EYE, ModPotions.LONG_HASTE.get()));
            BrewingRecipeRegistry.addRecipe(new ModBrewingRecipe(ModPotions.STRONG_MINING_FATIGUE.get(), Items.FERMENTED_SPIDER_EYE, ModPotions.STRONG_HASTE.get()));

        });

        ModNetworking.register();
    }

    private void clientSetup(final FMLClientSetupEvent event){
        WoodType.register(ModWoodTypes.BAOBAB);
        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
    }

    /*private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.MATURE_DANDELION.getId(), ModBlocks.POTTED_MATURE_DANDELION);
            Sheets.addWoodType(ModWoodTypes.BAOBAB);
        });
    }*/
}
