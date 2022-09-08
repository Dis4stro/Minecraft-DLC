package net.astro.dlc.blocks.crops;

import com.google.common.base.Suppliers;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import net.astro.dlc.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.function.Supplier;

public interface LeaveCrop extends ChangeOverTimeBlock<LeaveCrop.LeaveState> {
    Supplier<BiMap<Block, Block>> NEXT_BY_BLOCK = Suppliers.memoize(() -> {
        return ImmutableBiMap.<Block, Block>builder()
                .put(ModBlocks.ALUMINIUM_BLOCK.get(), ModBlocks.ALUMINIUM_ORE.get()).build(); // leva .build()
                /*.put(ModBlocks.BAOBAB_LEAVES_1.get(), ModBlocks.BUDDING_BAOBAB_LEAVES.get())
                .put(ModBlocks.BUDDING_BAOBAB_LEAVES.get(), ModBlocks.FLOWERING_BAOBAB_LEAVES.get())
                .put(ModBlocks.FLOWERING_BAOBAB_LEAVES.get(), ModBlocks.FRUITY_BAOBAB_LEAVES.get()).build();*/
    });
    Supplier<BiMap<Block, Block>> PREVIOUS_BY_BLOCK = Suppliers.memoize(() -> {
        return NEXT_BY_BLOCK.get().inverse();
    });


    static Optional<Block> getPrevious(Block pBlock) {
        return Optional.ofNullable(PREVIOUS_BY_BLOCK.get().get(pBlock));
    }

    static Block getFirst(Block pBlock) {
        Block block = pBlock;

        for(Block block1 = PREVIOUS_BY_BLOCK.get().get(pBlock); block1 != null; block1 = PREVIOUS_BY_BLOCK.get().get(block1)) {
            block = block1;
        }
        return block;
    }

    static Optional<BlockState> getPrevious(BlockState pState) {
        return getPrevious(pState.getBlock()).map((block) -> {
            return block.withPropertiesOf(pState);
        });
    }

    static Optional<Block> getNext(Block pBlock) {
        return Optional.ofNullable(NEXT_BY_BLOCK.get().get(pBlock));
    }

    static BlockState getFirst(BlockState pState) {
        return getFirst(pState.getBlock()).withPropertiesOf(pState);
    }

    default Optional<BlockState> getNext(BlockState pState) {
        return getNext(pState.getBlock()).map((block) -> {
            return block.withPropertiesOf(pState);
        });
    }

    default float getChanceModifier() {
        return this.getAge() == LeaveCrop.LeaveState.UNAFFECTED ? 0.75F : 1.0F;
    }

    public static enum LeaveState {
        UNAFFECTED,
        BUDDING,
        FLOWERING,
        FRUITY;
    }
}
