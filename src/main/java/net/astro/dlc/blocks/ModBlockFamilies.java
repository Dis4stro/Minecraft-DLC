package net.astro.dlc.blocks;

import com.google.common.collect.Maps;
import net.minecraft.core.Registry;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class ModBlockFamilies {
    private static final Map<Block, BlockFamily> MAP = Maps.newHashMap();
    private static final String RECIPE_GROUP_PREFIX_WOODEN = "wooden";
    private static final String RECIPE_UNLOCKED_BY_HAS_PLANKS = "has_planks";

    public static final BlockFamily BAOBAB_PLANKS = familyBuilder(ModBlocks.BAOBAB_PLANKS.get()).button(ModBlocks.BAOBAB_BUTTON.get()).fence(ModBlocks.BAOBAB_FENCE.get()).fenceGate(ModBlocks.BAOBAB_FENCE_GATE.get()).pressurePlate(ModBlocks.BAOBAB_PRESSURE_PLATE.get()).sign(ModBlocks.BAOBAB_SIGN.get(), ModBlocks.BAOBAB_WALL_SIGN.get()).slab(ModBlocks.BAOBAB_SLAB.get()).stairs(ModBlocks.BAOBAB_STAIRS.get()).door(ModBlocks.BAOBAB_DOOR.get()).trapdoor(ModBlocks.BAOBAB_TRAPDOOR.get()).recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();
    public static final BlockFamily BRONZE_BLOCK = familyBuilder(ModBlocks.BRONZE_BLOCK.get()).slab(ModBlocks.BRONZE_SLAB.get()).stairs(ModBlocks.BRONZE_STAIRS.get()).wall(ModBlocks.BRONZE_WALL.get()).polished(ModBlocks.BRONZE_BRICKS.get()).chiseled(ModBlocks.CHISELES_BRONZE.get()).recipeGroupPrefix(getRegistryName(ModBlocks.BRONZE_BLOCK.get())).recipeUnlockedBy("has_" + getRegistryName(ModBlocks.BRONZE_BLOCK.get())).getFamily();
    public static final BlockFamily BRONZE_BRICKS = familyBuilder(ModBlocks.BRONZE_BRICKS.get()).slab(ModBlocks.BRONZE_BRICK_SLAB.get()).stairs(ModBlocks.BRONZE_BRICK_STAIRS.get()).wall(ModBlocks.BRONZE_BRICK_WALL.get()).polished(ModBlocks.BRONZE_TILES.get()).cracked(ModBlocks.CRACKED_BRONZE_BRICKS.get()).recipeGroupPrefix(getRegistryName(ModBlocks.BRONZE_BLOCK.get())).recipeUnlockedBy("has_" + getRegistryName(ModBlocks.BRONZE_BLOCK.get())).getFamily();
    public static final BlockFamily BRONZE_TILES = familyBuilder(ModBlocks.BRONZE_TILES.get()).slab(ModBlocks.BRONZE_TILE_SLAB.get()).stairs(ModBlocks.BRONZE_TILE_STAIRS.get()).wall(ModBlocks.BRONZE_TILE_WALL.get()).cracked(ModBlocks.CRACKED_BRONZE_TILES.get()).recipeGroupPrefix(getRegistryName(ModBlocks.BRONZE_TILES.get())).recipeUnlockedBy("has_" + getRegistryName(ModBlocks.BRONZE_TILES.get())).getFamily();

    public static final BlockFamily OAK_WOOD = familyBuilder(Blocks.OAK_WOOD).slab(ModBlocks.OAK_WOOD_SLAB.get()).stairs(ModBlocks.OAK_WOOD_STAIRS.get()).fence(ModBlocks.OAK_WOOD_FENCE.get()).fenceGate(ModBlocks.OAK_WOOD_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.OAK_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.OAK_WOOD)).getFamily();
    public static final BlockFamily STRIPPED_OAK_WOOD = familyBuilder(Blocks.STRIPPED_OAK_WOOD).slab(ModBlocks.STRIPPED_OAK_SLAB.get()).stairs(ModBlocks.STRIPPED_OAK_STAIRS.get()).fence(ModBlocks.STRIPPED_OAK_FENCE.get()).fenceGate(ModBlocks.STRIPPED_OAK_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.STRIPPED_OAK_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.STRIPPED_OAK_WOOD)).getFamily();
    public static final BlockFamily BAOBAB_WOOD = familyBuilder(ModBlocks.BAOBAB_WOOD.get()).slab(ModBlocks.BAOBAB_WOOD_SLAB.get()).stairs(ModBlocks.BAOBAB_WOOD_STAIRS.get()).fence(ModBlocks.BAOBAB_WOOD_FENCE.get()).fenceGate(ModBlocks.BAOBAB_WOOD_FENCE_GATE.get()).recipeGroupPrefix(getRegistryName(ModBlocks.BAOBAB_WOOD.get())).recipeUnlockedBy("has_" + getRegistryName(ModBlocks.BAOBAB_WOOD.get())).getFamily();
    public static final BlockFamily STRIPPED_BAOBAB_WOOD = familyBuilder(ModBlocks.STRIPPED_BAOBAB_WOOD.get()).slab(ModBlocks.STRIPPED_BAOBAB_SLAB.get()).stairs(ModBlocks.STRIPPED_BAOBAB_STAIRS.get()).fence(ModBlocks.STRIPPED_BAOBAB_FENCE.get()).fenceGate(ModBlocks.STRIPPED_BAOBAB_FENCE_GATE.get()).recipeGroupPrefix(getRegistryName(ModBlocks.STRIPPED_BAOBAB_WOOD.get())).recipeUnlockedBy("has_" + getRegistryName(ModBlocks.STRIPPED_BAOBAB_WOOD.get())).getFamily();
    public static final BlockFamily BIRCH_WOOD = familyBuilder(Blocks.BIRCH_WOOD).slab(ModBlocks.BIRCH_WOOD_SLAB.get()).stairs(ModBlocks.BIRCH_WOOD_STAIRS.get()).fence(ModBlocks.BIRCH_WOOD_FENCE.get()).fenceGate(ModBlocks.BIRCH_WOOD_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.BIRCH_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.BIRCH_WOOD)).getFamily();
    public static final BlockFamily STRIPPED_BIRCH_WOOD = familyBuilder(Blocks.STRIPPED_BIRCH_WOOD).slab(ModBlocks.STRIPPED_BIRCH_SLAB.get()).stairs(ModBlocks.STRIPPED_BIRCH_STAIRS.get()).fence(ModBlocks.STRIPPED_BIRCH_FENCE.get()).fenceGate(ModBlocks.STRIPPED_BIRCH_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.STRIPPED_BIRCH_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.STRIPPED_BIRCH_WOOD)).getFamily();
    public static final BlockFamily SPRUCE_WOOD = familyBuilder(Blocks.SPRUCE_WOOD).slab(ModBlocks.SPRUCE_WOOD_SLAB.get()).stairs(ModBlocks.SPRUCE_WOOD_STAIRS.get()).fence(ModBlocks.SPRUCE_WOOD_FENCE.get()).fenceGate(ModBlocks.SPRUCE_WOOD_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.SPRUCE_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.SPRUCE_WOOD)).getFamily();
    public static final BlockFamily STRIPPED_SPRUCE_WOOD = familyBuilder(Blocks.STRIPPED_SPRUCE_WOOD).slab(ModBlocks.STRIPPED_SPRUCE_SLAB.get()).stairs(ModBlocks.STRIPPED_SPRUCE_STAIRS.get()).fence(ModBlocks.STRIPPED_SPRUCE_FENCE.get()).fenceGate(ModBlocks.STRIPPED_SPRUCE_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.STRIPPED_SPRUCE_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.STRIPPED_SPRUCE_WOOD)).getFamily();
    public static final BlockFamily DARK_OAK_WOOD = familyBuilder(Blocks.DARK_OAK_WOOD).slab(ModBlocks.DARK_OAK_WOOD_SLAB.get()).stairs(ModBlocks.DARK_OAK_WOOD_STAIRS.get()).fence(ModBlocks.DARK_OAK_WOOD_FENCE.get()).fenceGate(ModBlocks.DARK_OAK_WOOD_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.DARK_OAK_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.DARK_OAK_WOOD)).getFamily();
    public static final BlockFamily STRIPPED_DARK_OAK_WOOD = familyBuilder(Blocks.STRIPPED_DARK_OAK_WOOD).slab(ModBlocks.STRIPPED_DARK_OAK_SLAB.get()).stairs(ModBlocks.STRIPPED_DARK_OAK_STAIRS.get()).fence(ModBlocks.STRIPPED_DARK_OAK_FENCE.get()).fenceGate(ModBlocks.STRIPPED_DARK_OAK_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.STRIPPED_DARK_OAK_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.STRIPPED_DARK_OAK_WOOD)).getFamily();
    public static final BlockFamily ACACIA_WOOD = familyBuilder(Blocks.ACACIA_WOOD).slab(ModBlocks.ACACIA_WOOD_SLAB.get()).stairs(ModBlocks.ACACIA_WOOD_STAIRS.get()).fence(ModBlocks.ACACIA_WOOD_FENCE.get()).fenceGate(ModBlocks.ACACIA_WOOD_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.ACACIA_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.ACACIA_WOOD)).getFamily();
    public static final BlockFamily STRIPPED_ACACIA_WOOD = familyBuilder(Blocks.STRIPPED_ACACIA_WOOD).slab(ModBlocks.STRIPPED_ACACIA_SLAB.get()).stairs(ModBlocks.STRIPPED_ACACIA_STAIRS.get()).fence(ModBlocks.STRIPPED_ACACIA_FENCE.get()).fenceGate(ModBlocks.STRIPPED_ACACIA_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.STRIPPED_ACACIA_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.STRIPPED_ACACIA_WOOD)).getFamily();
    public static final BlockFamily MANGROVE_WOOD = familyBuilder(Blocks.MANGROVE_WOOD).slab(ModBlocks.MANGROVE_WOOD_SLAB.get()).stairs(ModBlocks.MANGROVE_WOOD_STAIRS.get()).fence(ModBlocks.MANGROVE_WOOD_FENCE.get()).fenceGate(ModBlocks.MANGROVE_WOOD_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.MANGROVE_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.MANGROVE_WOOD)).getFamily();
    public static final BlockFamily STRIPPED_MANGROVE_WOOD = familyBuilder(Blocks.STRIPPED_MANGROVE_WOOD).slab(ModBlocks.STRIPPED_MANGROVE_SLAB.get()).stairs(ModBlocks.STRIPPED_MANGROVE_STAIRS.get()).fence(ModBlocks.STRIPPED_MANGROVE_FENCE.get()).fenceGate(ModBlocks.STRIPPED_MANGROVE_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.STRIPPED_MANGROVE_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.STRIPPED_MANGROVE_WOOD)).getFamily();
    public static final BlockFamily JUNGLE_WOOD = familyBuilder(Blocks.JUNGLE_WOOD).slab(ModBlocks.JUNGLE_WOOD_SLAB.get()).stairs(ModBlocks.JUNGLE_WOOD_STAIRS.get()).fence(ModBlocks.JUNGLE_WOOD_FENCE.get()).fenceGate(ModBlocks.JUNGLE_WOOD_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.JUNGLE_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.JUNGLE_WOOD)).getFamily();
    public static final BlockFamily STRIPPED_JUNGLE_WOOD = familyBuilder(Blocks.STRIPPED_JUNGLE_WOOD).slab(ModBlocks.STRIPPED_JUNGLE_SLAB.get()).stairs(ModBlocks.STRIPPED_JUNGLE_STAIRS.get()).fence(ModBlocks.STRIPPED_JUNGLE_FENCE.get()).fenceGate(ModBlocks.STRIPPED_JUNGLE_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.STRIPPED_JUNGLE_WOOD)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.STRIPPED_JUNGLE_WOOD)).getFamily();
    public static final BlockFamily CRIMSON_HYPHAE = familyBuilder(Blocks.CRIMSON_HYPHAE).slab(ModBlocks.CRIMSON_HYPHAE_SLAB.get()).stairs(ModBlocks.CRIMSON_HYPHAE_STAIRS.get()).fence(ModBlocks.CRIMSON_HYPHAE_FENCE.get()).fenceGate(ModBlocks.CRIMSON_HYPHAE_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.CRIMSON_HYPHAE)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.CRIMSON_HYPHAE)).getFamily();
    public static final BlockFamily STRIPPED_CRIMSON_HYPHAE = familyBuilder(Blocks.STRIPPED_CRIMSON_HYPHAE).slab(ModBlocks.STRIPPED_CRIMSON_SLAB.get()).stairs(ModBlocks.STRIPPED_CRIMSON_STAIRS.get()).fence(ModBlocks.STRIPPED_CRIMSON_FENCE.get()).fenceGate(ModBlocks.STRIPPED_CRIMSON_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.STRIPPED_CRIMSON_HYPHAE)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.STRIPPED_CRIMSON_HYPHAE)).getFamily();
    public static final BlockFamily WARPED_HYPHAE = familyBuilder(Blocks.WARPED_HYPHAE).slab(ModBlocks.WARPED_HYPHAE_SLAB.get()).stairs(ModBlocks.WARPED_HYPHAE_STAIRS.get()).fence(ModBlocks.WARPED_HYPHAE_FENCE.get()).fenceGate(ModBlocks.WARPED_HYPHAE_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.WARPED_HYPHAE)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.WARPED_HYPHAE)).getFamily();
    public static final BlockFamily STRIPPED_WARPED_HYPHAE = familyBuilder(Blocks.STRIPPED_WARPED_HYPHAE).slab(ModBlocks.STRIPPED_WARPED_SLAB.get()).stairs(ModBlocks.STRIPPED_WARPED_STAIRS.get()).fence(ModBlocks.STRIPPED_WARPED_FENCE.get()).fenceGate(ModBlocks.STRIPPED_WARPED_FENCE_GATE.get()).recipeGroupPrefix(getMCRegistryName(Blocks.STRIPPED_WARPED_HYPHAE)).recipeUnlockedBy("has_" + getMCRegistryName(Blocks.STRIPPED_WARPED_HYPHAE)).getFamily();

    private static BlockFamily.Builder familyBuilder(Block pBaseBlock) {
        BlockFamily.Builder blockfamily$builder = new BlockFamily.Builder(pBaseBlock);
        BlockFamily blockfamily = MAP.put(pBaseBlock, blockfamily$builder.getFamily());
        if (blockfamily == null) {
            return blockfamily$builder;
        }
        return null;
    }

    private static String getRegistryName(Block block){
        return block.getDescriptionId().replace("block.dlc.", "");
    }
    private static String getMCRegistryName(Block block) {
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
    }
    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }
}
