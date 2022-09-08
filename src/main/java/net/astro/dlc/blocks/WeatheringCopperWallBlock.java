package net.astro.dlc.blocks;

import net.astro.dlc.util.CopperWeatheringMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class WeatheringCopperWallBlock extends WallBlock implements WeatheringCopper {
    private final WeatheringCopper.WeatherState weatherState;

    public WeatheringCopperWallBlock(WeatheringCopper.WeatherState weatherState, Properties properties) {
        super(properties);
        this.weatherState = weatherState;
    }

    @Override
    public @NotNull InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack stack = pPlayer.getItemInHand(pHand);
        if (stack.getItem() == Items.HONEYCOMB) {
            Optional<Block> block = CopperWeatheringMap.waxedBlock(pState.getBlock());
            if (block.isPresent()) {
                pLevel.setBlock(pPos, block.map(new_block -> new_block.withPropertiesOf(pState)).get(), 11);
                pLevel.levelEvent(pPlayer, 3003, pPos, 0);
                if(!pPlayer.getAbilities().instabuild){
                    stack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public @NotNull Optional<BlockState> getNext(BlockState state) {
        return CopperWeatheringMap.nextBlock(state.getBlock()).map((block) -> block.withPropertiesOf(state));
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource random) {
        this.onRandomTick(blockState, serverLevel, blockPos, random);
    }

    public boolean isRandomlyTicking(BlockState state) {
        return CopperWeatheringMap.nextBlock(state.getBlock()).isPresent();
    }

    @Override
    public @NotNull WeatherState getAge() {
        return this.weatherState;
    }
}