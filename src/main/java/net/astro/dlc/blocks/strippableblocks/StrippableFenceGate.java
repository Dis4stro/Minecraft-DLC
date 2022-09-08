package net.astro.dlc.blocks.strippableblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

public class StrippableFenceGate extends FenceGateBlock {
    private final Block stripped;

    public StrippableFenceGate(Block stripped, Properties properties) {
        super(properties);
        this.stripped = stripped;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            return stripped.defaultBlockState()
                    .setValue(FACING, state.getValue(FACING))
                    .setValue(IN_WALL, state.getValue(IN_WALL))
                    .setValue(OPEN, state.getValue(OPEN))
                    .setValue(POWERED, state.getValue(POWERED));
        }
        return super.getToolModifiedState(state, context, toolAction,simulate);
    }

    @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
    @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
}
