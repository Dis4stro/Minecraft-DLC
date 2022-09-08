package net.astro.dlc.util;

import net.astro.dlc.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CopperWeatheringMap {
    private static final Map<Block, Block> INCREASES = new HashMap<>();
    private static final Map<Block, Block> DECREASES = new HashMap<>();
    private static final Map<Block, Block> WAXED = new HashMap<>();
    private static final Map<Block, Block> UNWAXED = new HashMap<>();

    public static void put(Block block, @Nullable Block oxidized, Block waxed) {
        if (oxidized != null) {
            INCREASES.put(block, oxidized);
            DECREASES.put(oxidized, block);
        }
        WAXED.put(block, waxed);
        UNWAXED.put(waxed, block);
    }

    public static Optional<Block> nextBlock(Block block) {
        return Optional.ofNullable(INCREASES.get(block));
    }
    public static Optional<Block> previousBlock(Block block) {
        return Optional.ofNullable(DECREASES.get(block));
    }
    public static Optional<Block> waxedBlock(Block block) {
        return Optional.ofNullable(WAXED.get(block));
    }
    public static Optional<Block> unwaxedBlock(Block block) {
        return Optional.ofNullable(UNWAXED.get(block));
    }

    public static Block getOriginalStage(Block block) {
        Block result = block;
        for (Optional<Block> b = previousBlock(block); b.isPresent(); b = previousBlock(b.get())) {
            result = b.get();
        }
        return result;
    }

    static {
        // Prima, Dopo, Waxed
        put(ModBlocks.COPPER_WALL.get(), ModBlocks.EXPOSED_COPPER_WALL.get(), ModBlocks.WAXED_COPPER_WALL.get());
        put(ModBlocks.EXPOSED_COPPER_WALL.get(), ModBlocks.WEATHERED_COPPER_WALL.get(), ModBlocks.WAXED_EXPOSED_COPPER_WALL.get());
        put(ModBlocks.WEATHERED_COPPER_WALL.get(), ModBlocks.OXIDIZED_COPPER_WALL.get(), ModBlocks.WAXED_WEATHERED_COPPER_WALL.get());
        put(ModBlocks.OXIDIZED_COPPER_WALL.get(), null, ModBlocks.WAXED_OXIDIZED_COPPER_WALL.get());
    }
}
