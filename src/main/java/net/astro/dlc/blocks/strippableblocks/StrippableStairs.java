package net.astro.dlc.blocks.strippableblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class StrippableStairs extends StairBlock {
    private final Block stripped;
    public StrippableStairs(Block stripped, Supplier<BlockState> state, Properties properties) {
        super(state, properties);
        this.stripped = stripped;
    }
    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            return stripped.defaultBlockState()
                    .setValue(FACING, state.getValue(FACING))
                    .setValue(HALF, state.getValue(HALF))
                    .setValue(SHAPE, state.getValue(SHAPE))
                    .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
        }
        return super.getToolModifiedState(state, context, toolAction,simulate);
    }

    @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
    @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
}
