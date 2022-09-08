package net.astro.dlc.world.feature;

import net.astro.dlc.blocks.ModBlocks;
import net.astro.dlc.world.feature.trunkplacer.BaobabTrunkPlacer;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ModConfiguredFeatures {
    /** 1. ConfiguredFeature -> 2. PlacedFeature -> 3. ConfiguredFeature -> 4. PlacedFeature **/
    /* 1 */
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> BAOBAB_TREE =
            FeatureUtils.register("baobab", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.BAOBAB_LOG.get()),
                    new BaobabTrunkPlacer(14, 5,10), // CLASSE FORMA TRONCO
                    BlockStateProvider.simple(ModBlocks.BAOBAB_LEAVES.get()),
                    new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2), // CLASSE FORMA FOGLIE
                    new TwoLayersFeatureSize(1,0,2)).build());

    /* 2 */
    public static final Holder<PlacedFeature> BAOBAB_CHECKED = PlacementUtils.register("baobab_checked", BAOBAB_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.BAOBAB_SAPLING.get()));

    /* 3 */
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BAOBAB_SPAWN
            = FeatureUtils.register("baobab_spawn", Feature.RANDOM_SELECTOR,
            new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(BAOBAB_CHECKED, 0.1F)), BAOBAB_CHECKED));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> MATURE_DANDELION =
            FeatureUtils.register("flower_mature_dandelion", Feature.FLOWER,
                    new RandomPatchConfiguration(16, 6, 4,
                            PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LEVITATION_DANDELION.get())))));

    // ores
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_ALUMINIUM_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ALUMINIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ALUMINIUM_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ALUMINIUM_ORE = FeatureUtils.register("aluminium_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_ALUMINIUM_ORES, 6));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SMALL_ALUMINIUM_ORE = FeatureUtils.register("small_aluminium_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_ALUMINIUM_ORES, 4));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_TIN_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TIN_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> TIN_ORE = FeatureUtils.register("tin_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_TIN_ORES, 10));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SMALL_TIN_ORE = FeatureUtils.register("small_tin_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_TIN_ORES, 4));
}

