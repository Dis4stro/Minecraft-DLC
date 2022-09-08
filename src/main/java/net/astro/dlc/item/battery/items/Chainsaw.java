package net.astro.dlc.item.battery.items;

import net.astro.dlc.item.battery.BatteryItem;
import net.astro.dlc.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chainsaw extends BatteryItem {

    public Chainsaw(Properties pProperties, BatteryProperties pBatteryProperties) {
        super(pProperties, pBatteryProperties);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos initPos, Player player) {

        Level level = player.getLevel();
        ItemStack stack = player.getItemInHand(player.getUsedItemHand());

        final int SURR_SIZE = 8;

        int durability = stack.getMaxDamage() - stack.getDamageValue();
        boolean drop = !player.getAbilities().instabuild;

        BlockPos[] surroundingBlocks = new BlockPos[SURR_SIZE];
        BlockPos[] surroundingBlocks2 = new BlockPos[SURR_SIZE];
        BlockPos[] upperBlocks = new BlockPos[64];
        BlockPos[] destroyedBlocks = new BlockPos[512];

        BlockPos checkPos;
        BlockPos checkPos2;
        BlockPos startingPos;

        boolean maxHeight = false;
        boolean foundHeightBlock;

        int nextUpper;
        int nextDestroyedID = 0;
        int nextSurr;
        int nextSurr2;

        int upK, rightK;

        int i, j, k, l, m;
        int currentHeight = 0;

        if(isValuableBlock(level, initPos)){
            while(!maxHeight) {
                Arrays.fill(upperBlocks, initPos);
                nextUpper = 0;
                nextSurr = 0;
                nextSurr2 = 0;
                if (++currentHeight != 1) {
                    foundHeightBlock = false;
                    for (i = 0; i < nextDestroyedID; i++) {
                        for(j = 0; j < 9; j++){
                            checkPos = isValuableBlock(level, getSurroundingPos(destroyedBlocks[i].above(1), j))
                                    && canDestroy(level, getSurroundingPos(destroyedBlocks[i].above(1), j))
                                    ? getSurroundingPos(destroyedBlocks[i].above(1), j) : initPos;
                            if(checkPos != initPos){
                                if(!isPosContained(checkPos, upperBlocks)) {
                                    upperBlocks[nextUpper++] = checkPos;
                                    foundHeightBlock = true;
                                }
                            }
                        }
                    }
                    if (!foundHeightBlock) {
                        maxHeight = true;
                    }
                } else {
                    upperBlocks[nextUpper++] = initPos;
                }
                Arrays.fill(destroyedBlocks, initPos);
                nextDestroyedID = 0;
                if (!maxHeight) {
                    for (i = 0; i < nextUpper; i++) {
                        if(!isValuableBlock(level, upperBlocks[i])){
                            continue;
                        }
                        startingPos = upperBlocks[i];
                        if(durability > 0) {
                            level.destroyBlock(startingPos, drop);
                            durability = consumeChainsaw(player, durability);
                            destroyedBlocks[nextDestroyedID++] = startingPos;
                        }
                        for(j = 0; j < 9; j++){
                            if(j == 4){
                                continue;
                            }
                            checkPos = isValuableBlock(level, getSurroundingPos(startingPos, j)) && canDestroy(level, getSurroundingPos(startingPos, j))
                                    ? getSurroundingPos(startingPos, j) : initPos;
                            if(checkPos != initPos){
                                if(durability > 0) {
                                    level.destroyBlock(checkPos, drop);
                                    durability = consumeChainsaw(player, durability);
                                    destroyedBlocks[nextDestroyedID++] = checkPos;
                                    surroundingBlocks[nextSurr++] = checkPos;
                                }
                            }
                        }
                        while(nextSurr != 0){
                            for(j = 0; j < nextSurr; j++){
                                for(k = 0; k < 9; k++){
                                    if(k == 4){
                                        continue;
                                    }
                                    checkPos = isValuableBlock(level, getSurroundingPos(surroundingBlocks[j], k)) && canDestroy(level, getSurroundingPos(surroundingBlocks[j], k))
                                            ? getSurroundingPos(surroundingBlocks[j], k) : initPos;
                                    if(checkPos != initPos){
                                        if(nextSurr2 == SURR_SIZE){
                                            while(nextSurr2 == SURR_SIZE) {
                                                for (l = 0; l < nextSurr2; l++) {
                                                    upK = 0;
                                                    rightK = 0;
                                                    for (m = 0; m < 9; m++) {
                                                        if(m == 4){
                                                            continue;
                                                        }
                                                        checkPos2 = isValuableBlock(level, getSurroundingPos(surroundingBlocks2[l], m)) && canDestroy(level, getSurroundingPos(surroundingBlocks2[l], m))
                                                                ? getSurroundingPos(surroundingBlocks2[l], m) : initPos;
                                                        if (checkPos2 != initPos) {
                                                            if(durability > 0) {
                                                                level.destroyBlock(checkPos2, drop);
                                                                durability = consumeChainsaw(player, durability);
                                                                destroyedBlocks[nextDestroyedID++] = checkPos2;
                                                            }
                                                            upK = switch (m) {
                                                                case 1 -> 1;
                                                                case 7 -> -1;
                                                                default -> upK;
                                                            };
                                                            rightK = switch (m) {
                                                                case 4 -> 1;
                                                                case 6 -> -1;
                                                                default -> rightK;
                                                            };
                                                        }
                                                    }
                                                    if (upK == 0 && rightK == 0) {
                                                        surroundingBlocks2[l] = initPos;
                                                        for(m = l+1; m < nextSurr2; m++){
                                                            surroundingBlocks2[m-1] = surroundingBlocks2[m];
                                                            surroundingBlocks2[m] = initPos;
                                                        }
                                                        nextSurr2--;
                                                    } else if (upK == 0) {
                                                        surroundingBlocks2[l] = surroundingBlocks2[l].west(rightK * 2);
                                                        if(durability > 0) {
                                                            level.destroyBlock(surroundingBlocks2[l], drop);
                                                            durability = consumeChainsaw(player, durability);
                                                            destroyedBlocks[nextDestroyedID++] = surroundingBlocks2[l];
                                                        }
                                                    } else if (rightK == 0) {
                                                        surroundingBlocks2[l] = surroundingBlocks2[l].north(upK * 2);
                                                        if(durability > 0) {
                                                            level.destroyBlock(surroundingBlocks2[l], drop);
                                                            durability = consumeChainsaw(player, durability);
                                                            destroyedBlocks[nextDestroyedID++] = surroundingBlocks2[l];
                                                        }
                                                    } else {
                                                        surroundingBlocks2[l] = surroundingBlocks2[l].north(upK).west(rightK);
                                                        if(durability > 0) {
                                                            level.destroyBlock(surroundingBlocks2[l], drop);
                                                            durability = consumeChainsaw(player, durability);
                                                            destroyedBlocks[nextDestroyedID++] = surroundingBlocks2[l];
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if(isValuableBlock(level, checkPos) && canDestroy(level, checkPos)) {
                                            if(durability > 0) {
                                                level.destroyBlock(checkPos, drop);
                                                durability = consumeChainsaw(player, durability);
                                                destroyedBlocks[nextDestroyedID++] = checkPos;
                                                surroundingBlocks2[nextSurr2++] = checkPos;
                                            }
                                        }
                                    }
                                }
                            }
                            Arrays.fill(surroundingBlocks, initPos);
                            for(j = 0; j < nextSurr2; j++){
                                surroundingBlocks[j] = surroundingBlocks2[j];
                            }
                            Arrays.fill(surroundingBlocks2, initPos);
                            nextSurr = nextSurr2;
                            nextSurr2 = 0;
                        }
                    }
                }
            }
        } else {
            if(level.getBlockState(initPos).isSuffocating(level, initPos)) {
                stack.hurtAndBreak(1, player, player1 -> player1.broadcastBreakEvent(player1.getUsedItemHand()));
                if (!player.getAbilities().instabuild && durability > 1) {
                    player.displayClientMessage(Component.translatable("display.dlc.chainsaw.damaged", (stack.getMaxDamage() - stack.getDamageValue()),
                            stack.getMaxDamage()), true);
                }
            }
        }
        return false;
    }

    private static boolean isValuableBlock(Level level, BlockPos pos) {
        return level.getBlockState(pos).is(ModTags.Blocks.CHAINSAW_VALID_BLOCKS);
    }
    private static boolean canDestroy(Level level, BlockPos pos) {
        return level.getBlockState(pos.below(1)).is(ModTags.Blocks.CHAINSAW_DESTROY_CONDITION_BLOCKS) ||
                level.getBlockState(pos.above(1)).is(ModTags.Blocks.CHAINSAW_DESTROY_CONDITION_BLOCKS) ||
                isValuableBlock(level, pos.above(1));
    }
    private static boolean isPosContained(BlockPos pos, BlockPos[] positions){
        List<BlockPos> posList = new ArrayList<>(Arrays.asList(positions));
        return posList.contains(pos);
    }
    private static BlockPos getSurroundingPos(BlockPos centralPos, int directionID){
        return switch (directionID) {
            case 0 -> centralPos.north(1).west(1);
            case 1 -> centralPos.north(1);
            case 2 -> centralPos.north(1).east(1);
            case 3 -> centralPos.west(1);
            case 5 -> centralPos.east(1);
            case 6 -> centralPos.south(1).west(1);
            case 7 -> centralPos.south(1);
            case 8 -> centralPos.south(1).east(1);
            default -> centralPos;
        };
    }

    private int consumeChainsaw(Player player, int durability){
        if(!player.getAbilities().instabuild) {
            ItemStack stack = player.getItemInHand(player.getUsedItemHand());
            if (getEnergy(stack) > 0) {
                if (!player.getAbilities().instabuild) {
                    decreaseEnergy(player, stack, 1);
                    displayCurrentEnergy(player);
                }
            } else {
                stack.hurtAndBreak(1, player, player1 -> player1.broadcastBreakEvent(player1.getUsedItemHand()));
                if (durability > 1) {
                    player.displayClientMessage(Component.translatable("display.dlc.chainsaw.damaged", (stack.getMaxDamage() - stack.getDamageValue()),
                            stack.getMaxDamage()), true);
                }
                return (durability - 1);
            }
        }
        return durability;
    }
}
