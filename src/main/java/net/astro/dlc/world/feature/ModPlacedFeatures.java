package net.astro.dlc.world.feature;

import net.astro.dlc.DLC;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DLC.MOD_ID);
    /* 4 */
    public static final RegistryObject<PlacedFeature> BAOBAB_PLACED = PLACED_FEATURES.register("baobab_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.BAOBAB_SPAWN, VegetationPlacements.treePlacement(
                    RarityFilter.onAverageOnceEvery(4))));
    public static final RegistryObject<PlacedFeature> TAIGA_MATURE_DANDELION_PLACED = PLACED_FEATURES.register("taiga_mature_dandelion_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.MATURE_DANDELION, List.of(RarityFilter.onAverageOnceEvery(10), // 10 (GENERA OGNI TOT CHUNK)
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
    public static final RegistryObject<PlacedFeature> SNOWY_MATURE_DANDELION_PLACED = PLACED_FEATURES.register("snowy_mature_dandelion_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.MATURE_DANDELION, List.of(RarityFilter.onAverageOnceEvery(4), // 10 (GENERA OGNI TOT CHUNK)
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> UNIFORM_ALUMINIUM_ORE = PLACED_FEATURES.register("uniform_aluminium_ore",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.ALUMINIUM_ORE, ModOrePlacement.commonOrePlacement(10, // Vene per chunk
                    HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(193)))));
    public static final RegistryObject<PlacedFeature> TRIANGLE_ALUMINIUM_ORE = PLACED_FEATURES.register("triangle_aluminium_ore",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.SMALL_ALUMINIUM_ORE, ModOrePlacement.commonOrePlacement(9, // Vene per chunk
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(46)))));

    public static final RegistryObject<PlacedFeature> UNIFORM_TIN_ORE = PLACED_FEATURES.register("uniform_tin_ore",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.SMALL_TIN_ORE, ModOrePlacement.commonOrePlacement(10, // Vene per chunk
                    HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(80)))));
    public static final RegistryObject<PlacedFeature> TRIANGLE_TIN_ORE = PLACED_FEATURES.register("triangle_tin_ore",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.TIN_ORE, ModOrePlacement.commonOrePlacement(10, // Vene per chunk
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));

    public static void register(IEventBus eventBus){
        PLACED_FEATURES.register(eventBus);
    }
}
