package net.astro.dlc.world.feature.tree;

import net.astro.dlc.world.feature.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BaobabTreeGrower extends AbstractMegaTreeGrower {
    // SAPLING 1X1
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource pRandom, boolean pLargeHive) {
        return null;
    }
    // SAPLING 2X2
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource pRandom) {
        return ModConfiguredFeatures.BAOBAB_TREE;
    }


}
