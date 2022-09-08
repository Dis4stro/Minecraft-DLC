package net.astro.dlc.datagen;

import net.astro.dlc.DLC;
import net.astro.dlc.blocks.ModBlocks;
import net.astro.dlc.blocks.crops.TomatoPlantBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class ModBlockStatesProvider extends BlockStateProvider {
    public ModBlockStatesProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, DLC.MOD_ID, exFileHelper);
    }

    private String blockName(Block block, boolean minecraftFolder){
        String target = minecraftFolder ? "block.minecraft." : "block.dlc.";
        return block.getDescriptionId().replace(target, "");
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.ALUMINIUM_BLOCK.get());
        simpleBlock(ModBlocks.ALUMINIUM_ORE.get());
        buttonBlock((ButtonBlock) ModBlocks.BAOBAB_BUTTON.get(), blockTexture(ModBlocks.BAOBAB_PLANKS.get()));
        doorBlockWithRenderType((DoorBlock) ModBlocks.BAOBAB_DOOR.get(), new ResourceLocation(DLC.MOD_ID, "block/baobab_door_bottom"), new ResourceLocation(DLC.MOD_ID, "block/baobab_door_top"), "translucent");
        fenceBlock((FenceBlock) ModBlocks.BAOBAB_FENCE.get(), blockTexture(ModBlocks.BAOBAB_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.BAOBAB_FENCE_GATE.get(), blockTexture(ModBlocks.BAOBAB_PLANKS.get()));
        simpleBlock(ModBlocks.BAOBAB_LEAVES.get(), cubeAllWithRenderType(ModBlocks.BAOBAB_LEAVES.get(), "cutout"));
        logBlock((RotatedPillarBlock) ModBlocks.BAOBAB_LOG.get());
        simpleBlock(ModBlocks.BAOBAB_PLANKS.get());
        pressurePlateBlock((PressurePlateBlock) ModBlocks.BAOBAB_PRESSURE_PLATE.get(), blockTexture(ModBlocks.BAOBAB_PLANKS.get()));
        simpleBlock(ModBlocks.BAOBAB_SAPLING.get(), crossWithRenderType(ModBlocks.BAOBAB_SAPLING.get(), "cutout"));
        signBlock((StandingSignBlock) ModBlocks.BAOBAB_SIGN.get(), (WallSignBlock) ModBlocks.BAOBAB_WALL_SIGN.get(), blockTexture(ModBlocks.BAOBAB_PLANKS.get()));
        slabBlock((SlabBlock) ModBlocks.BAOBAB_SLAB.get(), blockTexture(ModBlocks.BAOBAB_PLANKS.get()), blockTexture(ModBlocks.BAOBAB_PLANKS.get()));
        stairsBlock((StairBlock) ModBlocks.BAOBAB_STAIRS.get(), blockTexture(ModBlocks.BAOBAB_PLANKS.get()));
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.BAOBAB_TRAPDOOR.get(), blockTexture(ModBlocks.BAOBAB_TRAPDOOR.get()),true, "translucent");
        axisBlock((RotatedPillarBlock) ModBlocks.BAOBAB_WOOD.get(), blockTexture(ModBlocks.BAOBAB_LOG.get()), blockTexture(ModBlocks.BAOBAB_LOG.get()));
        simpleBlock(ModBlocks.BRONZE_BLOCK.get());
        simpleBlock(ModBlocks.BRONZE_BRICKS.get());
        slabBlock((SlabBlock) ModBlocks.BRONZE_BRICK_SLAB.get(), blockTexture(ModBlocks.BRONZE_BRICKS.get()), blockTexture(ModBlocks.BRONZE_BRICKS.get()));
        stairsBlock((StairBlock) ModBlocks.BRONZE_BRICK_STAIRS.get(), blockTexture(ModBlocks.BRONZE_BRICKS.get()));
        wallBlock((WallBlock) ModBlocks.BRONZE_BRICK_WALL.get(), blockTexture(ModBlocks.BRONZE_BRICKS.get()));
        slabBlock((SlabBlock) ModBlocks.BRONZE_SLAB.get(), blockTexture(ModBlocks.BRONZE_BLOCK.get()), blockTexture(ModBlocks.BRONZE_BLOCK.get()));
        stairsBlock((StairBlock) ModBlocks.BRONZE_STAIRS.get(), blockTexture(ModBlocks.BRONZE_BLOCK.get()));
        simpleBlock(ModBlocks.BRONZE_TILES.get());
        slabBlock((SlabBlock) ModBlocks.BRONZE_TILE_SLAB.get(), blockTexture(ModBlocks.BRONZE_TILES.get()), blockTexture(ModBlocks.BRONZE_TILES.get()));
        stairsBlock((StairBlock) ModBlocks.BRONZE_TILE_STAIRS.get(), blockTexture(ModBlocks.BRONZE_TILES.get()));
        wallBlock((WallBlock) ModBlocks.BRONZE_TILE_WALL.get(), blockTexture(ModBlocks.BRONZE_TILES.get()));
        wallBlock((WallBlock) ModBlocks.BRONZE_WALL.get(), blockTexture(ModBlocks.BRONZE_BLOCK.get()));
        simpleBlock(ModBlocks.CHISELES_BRONZE.get());
        wallBlock((WallBlock) ModBlocks.COPPER_WALL.get(), blockTexture(Blocks.COPPER_BLOCK));
        simpleBlock(ModBlocks.CRACKED_BRONZE_BRICKS.get());
        simpleBlock(ModBlocks.CRACKED_BRONZE_TILES.get());
        simpleBlock(ModBlocks.DEEPSLATE_ALUMINIUM_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_TIN_ORE.get());
        wallBlock((WallBlock) ModBlocks.EXPOSED_COPPER_WALL.get(), blockTexture(Blocks.EXPOSED_COPPER));
        simpleBlock(ModBlocks.LEVITATION_DANDELION.get(), crossWithRenderType(ModBlocks.LEVITATION_DANDELION.get(), "cutout"));
        wallBlock((WallBlock) ModBlocks.OXIDIZED_COPPER_WALL.get(), blockTexture(Blocks.OXIDIZED_COPPER));
        wallBlock((WallBlock)ModBlocks.POLISHED_ANDESITE_WALL.get(), blockTexture(Blocks.POLISHED_ANDESITE));
        wallBlock((WallBlock)ModBlocks.POLISHED_DIORITE_WALL.get(), blockTexture(Blocks.POLISHED_DIORITE));
        wallBlock((WallBlock)ModBlocks.POLISHED_GRANITE_WALL.get(), blockTexture(Blocks.POLISHED_GRANITE));
        simpleBlock(ModBlocks.POTTED_MATURE_DANDELION.get(), flowerPotCross(blockName(ModBlocks.POTTED_MATURE_DANDELION.get(), false), ModBlocks.LEVITATION_DANDELION.get()));
        simpleBlock(ModBlocks.RAW_ALUMINIUM_BLOCK.get());
        simpleBlock(ModBlocks.RAW_TIN_BLOCK.get());
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_BAOBAB_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_BAOBAB_WOOD.get(), blockTexture(ModBlocks.STRIPPED_BAOBAB_LOG.get()), blockTexture(ModBlocks.STRIPPED_BAOBAB_LOG.get()));
        simpleBlock(ModBlocks.TIN_BLOCK.get());
        simpleBlock(ModBlocks.TIN_ORE.get());
        makeCrop((TomatoPlantBlock) ModBlocks.TOMATO_PLANT.get(), "tomato_stage", "tomato_stage");
        wallBlock((WallBlock) ModBlocks.WAXED_COPPER_WALL.get(), blockTexture(Blocks.COPPER_BLOCK));
        wallBlock((WallBlock)ModBlocks.WAXED_EXPOSED_COPPER_WALL.get(), blockTexture(Blocks.EXPOSED_COPPER));
        wallBlock((WallBlock)ModBlocks.WAXED_OXIDIZED_COPPER_WALL.get(), blockTexture(Blocks.OXIDIZED_COPPER));
        wallBlock((WallBlock)ModBlocks.WAXED_WEATHERED_COPPER_WALL.get(), blockTexture(Blocks.WEATHERED_COPPER));
        wallBlock((WallBlock) ModBlocks.WEATHERED_COPPER_WALL.get(), blockTexture(Blocks.WEATHERED_COPPER));

        // Families

        slabBlock((SlabBlock) ModBlocks.OAK_WOOD_SLAB.get(), blockTexture(Blocks.OAK_WOOD), blockTexture(Blocks.OAK_LOG));
        stairsBlock((StairBlock) ModBlocks.OAK_WOOD_STAIRS.get(), blockTexture(Blocks.OAK_LOG));
        fenceBlock((FenceBlock) ModBlocks.OAK_WOOD_FENCE.get(), blockTexture(Blocks.OAK_LOG));
        fenceGateBlock((FenceGateBlock) ModBlocks.OAK_WOOD_FENCE_GATE.get(), blockTexture(Blocks.OAK_LOG));

        slabBlock((SlabBlock) ModBlocks.STRIPPED_OAK_SLAB.get(), blockTexture(Blocks.STRIPPED_OAK_WOOD), blockTexture(Blocks.STRIPPED_OAK_LOG));
        stairsBlock((StairBlock) ModBlocks.STRIPPED_OAK_STAIRS.get(), blockTexture(Blocks.STRIPPED_OAK_LOG));
        fenceBlock((FenceBlock)ModBlocks.STRIPPED_OAK_FENCE.get(), blockTexture(Blocks.STRIPPED_OAK_LOG));
        fenceGateBlock((FenceGateBlock)ModBlocks.STRIPPED_OAK_FENCE_GATE.get(), blockTexture(Blocks.STRIPPED_OAK_LOG));

        slabBlock((SlabBlock) ModBlocks.BAOBAB_WOOD_SLAB.get(), blockTexture(ModBlocks.BAOBAB_WOOD.get()), blockTexture(ModBlocks.BAOBAB_LOG.get()));
        stairsBlock((StairBlock) ModBlocks.BAOBAB_WOOD_STAIRS.get(), blockTexture(ModBlocks.BAOBAB_LOG.get()));
        fenceBlock((FenceBlock) ModBlocks.BAOBAB_WOOD_FENCE.get(), blockTexture(ModBlocks.BAOBAB_LOG.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.BAOBAB_WOOD_FENCE_GATE.get(), blockTexture(ModBlocks.BAOBAB_LOG.get()));

        slabBlock((SlabBlock) ModBlocks.STRIPPED_BAOBAB_SLAB.get(), blockTexture(ModBlocks.STRIPPED_BAOBAB_WOOD.get()), blockTexture(ModBlocks.STRIPPED_BAOBAB_LOG.get()));
        stairsBlock((StairBlock) ModBlocks.STRIPPED_BAOBAB_STAIRS.get(), blockTexture(ModBlocks.STRIPPED_BAOBAB_LOG.get()));
        fenceBlock((FenceBlock)ModBlocks.STRIPPED_BAOBAB_FENCE.get(), blockTexture(ModBlocks.STRIPPED_BAOBAB_LOG.get()));
        fenceGateBlock((FenceGateBlock)ModBlocks.STRIPPED_BAOBAB_FENCE_GATE.get(), blockTexture(ModBlocks.STRIPPED_BAOBAB_LOG.get()));

        slabBlock((SlabBlock) ModBlocks.BIRCH_WOOD_SLAB.get(), blockTexture(Blocks.BIRCH_WOOD), blockTexture(Blocks.BIRCH_LOG));
        stairsBlock((StairBlock) ModBlocks.BIRCH_WOOD_STAIRS.get(), blockTexture(Blocks.BIRCH_LOG));
        fenceBlock((FenceBlock) ModBlocks.BIRCH_WOOD_FENCE.get(), blockTexture(Blocks.BIRCH_LOG));
        fenceGateBlock((FenceGateBlock) ModBlocks.BIRCH_WOOD_FENCE_GATE.get(), blockTexture(Blocks.BIRCH_LOG));

        slabBlock((SlabBlock) ModBlocks.STRIPPED_BIRCH_SLAB.get(), blockTexture(Blocks.STRIPPED_BIRCH_WOOD), blockTexture(Blocks.STRIPPED_BIRCH_LOG));
        stairsBlock((StairBlock) ModBlocks.STRIPPED_BIRCH_STAIRS.get(), blockTexture(Blocks.STRIPPED_BIRCH_LOG));
        fenceBlock((FenceBlock)ModBlocks.STRIPPED_BIRCH_FENCE.get(), blockTexture(Blocks.STRIPPED_BIRCH_LOG));
        fenceGateBlock((FenceGateBlock)ModBlocks.STRIPPED_BIRCH_FENCE_GATE.get(), blockTexture(Blocks.STRIPPED_BIRCH_LOG));

        slabBlock((SlabBlock) ModBlocks.SPRUCE_WOOD_SLAB.get(), blockTexture(Blocks.SPRUCE_WOOD), blockTexture(Blocks.SPRUCE_LOG));
        stairsBlock((StairBlock) ModBlocks.SPRUCE_WOOD_STAIRS.get(), blockTexture(Blocks.SPRUCE_LOG));
        fenceBlock((FenceBlock) ModBlocks.SPRUCE_WOOD_FENCE.get(), blockTexture(Blocks.SPRUCE_LOG));
        fenceGateBlock((FenceGateBlock) ModBlocks.SPRUCE_WOOD_FENCE_GATE.get(), blockTexture(Blocks.SPRUCE_LOG));

        slabBlock((SlabBlock) ModBlocks.STRIPPED_SPRUCE_SLAB.get(), blockTexture(Blocks.STRIPPED_SPRUCE_WOOD), blockTexture(Blocks.STRIPPED_SPRUCE_LOG));
        stairsBlock((StairBlock) ModBlocks.STRIPPED_SPRUCE_STAIRS.get(), blockTexture(Blocks.STRIPPED_SPRUCE_LOG));
        fenceBlock((FenceBlock)ModBlocks.STRIPPED_SPRUCE_FENCE.get(), blockTexture(Blocks.STRIPPED_SPRUCE_LOG));
        fenceGateBlock((FenceGateBlock)ModBlocks.STRIPPED_SPRUCE_FENCE_GATE.get(), blockTexture(Blocks.STRIPPED_SPRUCE_LOG));

        slabBlock((SlabBlock) ModBlocks.DARK_OAK_WOOD_SLAB.get(), blockTexture(Blocks.DARK_OAK_WOOD), blockTexture(Blocks.DARK_OAK_LOG));
        stairsBlock((StairBlock) ModBlocks.DARK_OAK_WOOD_STAIRS.get(), blockTexture(Blocks.DARK_OAK_LOG));
        fenceBlock((FenceBlock) ModBlocks.DARK_OAK_WOOD_FENCE.get(), blockTexture(Blocks.DARK_OAK_LOG));
        fenceGateBlock((FenceGateBlock) ModBlocks.DARK_OAK_WOOD_FENCE_GATE.get(), blockTexture(Blocks.DARK_OAK_LOG));

        slabBlock((SlabBlock) ModBlocks.STRIPPED_DARK_OAK_SLAB.get(), blockTexture(Blocks.STRIPPED_DARK_OAK_WOOD), blockTexture(Blocks.STRIPPED_DARK_OAK_LOG));
        stairsBlock((StairBlock) ModBlocks.STRIPPED_DARK_OAK_STAIRS.get(), blockTexture(Blocks.STRIPPED_DARK_OAK_LOG));
        fenceBlock((FenceBlock)ModBlocks.STRIPPED_DARK_OAK_FENCE.get(), blockTexture(Blocks.STRIPPED_DARK_OAK_LOG));
        fenceGateBlock((FenceGateBlock)ModBlocks.STRIPPED_DARK_OAK_FENCE_GATE.get(), blockTexture(Blocks.STRIPPED_DARK_OAK_LOG));

        slabBlock((SlabBlock) ModBlocks.JUNGLE_WOOD_SLAB.get(), blockTexture(Blocks.JUNGLE_WOOD), blockTexture(Blocks.JUNGLE_LOG));
        stairsBlock((StairBlock) ModBlocks.JUNGLE_WOOD_STAIRS.get(), blockTexture(Blocks.JUNGLE_LOG));
        fenceBlock((FenceBlock) ModBlocks.JUNGLE_WOOD_FENCE.get(), blockTexture(Blocks.JUNGLE_LOG));
        fenceGateBlock((FenceGateBlock) ModBlocks.JUNGLE_WOOD_FENCE_GATE.get(), blockTexture(Blocks.JUNGLE_LOG));

        slabBlock((SlabBlock) ModBlocks.STRIPPED_JUNGLE_SLAB.get(), blockTexture(Blocks.STRIPPED_JUNGLE_WOOD), blockTexture(Blocks.STRIPPED_JUNGLE_LOG));
        stairsBlock((StairBlock) ModBlocks.STRIPPED_JUNGLE_STAIRS.get(), blockTexture(Blocks.STRIPPED_JUNGLE_LOG));
        fenceBlock((FenceBlock)ModBlocks.STRIPPED_JUNGLE_FENCE.get(), blockTexture(Blocks.STRIPPED_JUNGLE_LOG));
        fenceGateBlock((FenceGateBlock)ModBlocks.STRIPPED_JUNGLE_FENCE_GATE.get(), blockTexture(Blocks.STRIPPED_JUNGLE_LOG));

        slabBlock((SlabBlock) ModBlocks.ACACIA_WOOD_SLAB.get(), blockTexture(Blocks.ACACIA_WOOD), blockTexture(Blocks.ACACIA_LOG));
        stairsBlock((StairBlock) ModBlocks.ACACIA_WOOD_STAIRS.get(), blockTexture(Blocks.ACACIA_LOG));
        fenceBlock((FenceBlock) ModBlocks.ACACIA_WOOD_FENCE.get(), blockTexture(Blocks.ACACIA_LOG));
        fenceGateBlock((FenceGateBlock) ModBlocks.ACACIA_WOOD_FENCE_GATE.get(), blockTexture(Blocks.ACACIA_LOG));

        slabBlock((SlabBlock) ModBlocks.STRIPPED_ACACIA_SLAB.get(), blockTexture(Blocks.STRIPPED_ACACIA_WOOD), blockTexture(Blocks.STRIPPED_ACACIA_LOG));
        stairsBlock((StairBlock) ModBlocks.STRIPPED_ACACIA_STAIRS.get(), blockTexture(Blocks.STRIPPED_ACACIA_LOG));
        fenceBlock((FenceBlock)ModBlocks.STRIPPED_ACACIA_FENCE.get(), blockTexture(Blocks.STRIPPED_ACACIA_LOG));
        fenceGateBlock((FenceGateBlock)ModBlocks.STRIPPED_ACACIA_FENCE_GATE.get(), blockTexture(Blocks.STRIPPED_ACACIA_LOG));

        slabBlock((SlabBlock) ModBlocks.MANGROVE_WOOD_SLAB.get(), blockTexture(Blocks.MANGROVE_WOOD), blockTexture(Blocks.MANGROVE_LOG));
        stairsBlock((StairBlock) ModBlocks.MANGROVE_WOOD_STAIRS.get(), blockTexture(Blocks.MANGROVE_LOG));
        fenceBlock((FenceBlock) ModBlocks.MANGROVE_WOOD_FENCE.get(), blockTexture(Blocks.MANGROVE_LOG));
        fenceGateBlock((FenceGateBlock) ModBlocks.MANGROVE_WOOD_FENCE_GATE.get(), blockTexture(Blocks.MANGROVE_LOG));

        slabBlock((SlabBlock) ModBlocks.STRIPPED_MANGROVE_SLAB.get(), blockTexture(Blocks.STRIPPED_MANGROVE_WOOD), blockTexture(Blocks.STRIPPED_MANGROVE_LOG));
        stairsBlock((StairBlock) ModBlocks.STRIPPED_MANGROVE_STAIRS.get(), blockTexture(Blocks.STRIPPED_MANGROVE_LOG));
        fenceBlock((FenceBlock)ModBlocks.STRIPPED_MANGROVE_FENCE.get(), blockTexture(Blocks.STRIPPED_MANGROVE_LOG));
        fenceGateBlock((FenceGateBlock)ModBlocks.STRIPPED_MANGROVE_FENCE_GATE.get(), blockTexture(Blocks.STRIPPED_MANGROVE_LOG));

        slabBlock((SlabBlock) ModBlocks.CRIMSON_HYPHAE_SLAB.get(), blockTexture(Blocks.CRIMSON_HYPHAE), blockTexture(Blocks.CRIMSON_STEM));
        stairsBlock((StairBlock) ModBlocks.CRIMSON_HYPHAE_STAIRS.get(), blockTexture(Blocks.CRIMSON_STEM));
        fenceBlock((FenceBlock) ModBlocks.CRIMSON_HYPHAE_FENCE.get(), blockTexture(Blocks.CRIMSON_STEM));
        fenceGateBlock((FenceGateBlock) ModBlocks.CRIMSON_HYPHAE_FENCE_GATE.get(), blockTexture(Blocks.CRIMSON_STEM));

        slabBlock((SlabBlock) ModBlocks.STRIPPED_CRIMSON_SLAB.get(), blockTexture(Blocks.STRIPPED_CRIMSON_HYPHAE), blockTexture(Blocks.STRIPPED_CRIMSON_STEM));
        stairsBlock((StairBlock) ModBlocks.STRIPPED_CRIMSON_STAIRS.get(), blockTexture(Blocks.STRIPPED_CRIMSON_STEM));
        fenceBlock((FenceBlock)ModBlocks.STRIPPED_CRIMSON_FENCE.get(), blockTexture(Blocks.STRIPPED_CRIMSON_STEM));
        fenceGateBlock((FenceGateBlock)ModBlocks.STRIPPED_CRIMSON_FENCE_GATE.get(), blockTexture(Blocks.STRIPPED_CRIMSON_STEM));

        slabBlock((SlabBlock) ModBlocks.WARPED_HYPHAE_SLAB.get(), blockTexture(Blocks.WARPED_HYPHAE), blockTexture(Blocks.WARPED_STEM));
        stairsBlock((StairBlock) ModBlocks.WARPED_HYPHAE_STAIRS.get(), blockTexture(Blocks.WARPED_STEM));
        fenceBlock((FenceBlock) ModBlocks.WARPED_HYPHAE_FENCE.get(), blockTexture(Blocks.WARPED_STEM));
        fenceGateBlock((FenceGateBlock) ModBlocks.WARPED_HYPHAE_FENCE_GATE.get(), blockTexture(Blocks.WARPED_STEM));

        slabBlock((SlabBlock) ModBlocks.STRIPPED_WARPED_SLAB.get(), blockTexture(Blocks.STRIPPED_WARPED_HYPHAE), blockTexture(Blocks.STRIPPED_WARPED_STEM));
        stairsBlock((StairBlock) ModBlocks.STRIPPED_WARPED_STAIRS.get(), blockTexture(Blocks.STRIPPED_WARPED_STEM));
        fenceBlock((FenceBlock)ModBlocks.STRIPPED_WARPED_FENCE.get(), blockTexture(Blocks.STRIPPED_WARPED_STEM));
        fenceGateBlock((FenceGateBlock)ModBlocks.STRIPPED_WARPED_FENCE_GATE.get(), blockTexture(Blocks.STRIPPED_WARPED_STEM));

        // inventory render jsons
        // Walls
        inventoryWall(ModBlocks.BRONZE_BRICK_WALL.get(), ModBlocks.BRONZE_BRICKS.get());
        inventoryWall(ModBlocks.BRONZE_TILE_WALL.get(), ModBlocks.BRONZE_TILES.get());
        inventoryWall(ModBlocks.BRONZE_WALL.get(), ModBlocks.BRONZE_BLOCK.get());
        inventoryWallMCMaterial(ModBlocks.COPPER_WALL.get(), Blocks.COPPER_BLOCK);
        inventoryWallMCMaterial(ModBlocks.EXPOSED_COPPER_WALL.get(), Blocks.EXPOSED_COPPER);
        inventoryWallMCMaterial(ModBlocks.OXIDIZED_COPPER_WALL.get(), Blocks.OXIDIZED_COPPER);
        inventoryWallMCMaterial(ModBlocks.POLISHED_ANDESITE_WALL.get(), Blocks.POLISHED_ANDESITE);
        inventoryWallMCMaterial(ModBlocks.POLISHED_DIORITE_WALL.get(), Blocks.POLISHED_DIORITE);
        inventoryWallMCMaterial(ModBlocks.POLISHED_GRANITE_WALL.get(), Blocks.POLISHED_GRANITE);
        inventoryWallMCMaterial(ModBlocks.WEATHERED_COPPER_WALL.get(), Blocks.WEATHERED_COPPER);

        // Buttons
        inventoryButton(ModBlocks.BAOBAB_BUTTON.get(), ModBlocks.BAOBAB_PLANKS.get());

        // Fences
        inventoryFence(ModBlocks.BAOBAB_FENCE.get(), ModBlocks.BAOBAB_PLANKS.get());
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_ACACIA_FENCE.get(), Blocks.STRIPPED_ACACIA_LOG);
        inventoryFence(ModBlocks.STRIPPED_BAOBAB_FENCE.get(), ModBlocks.STRIPPED_BAOBAB_LOG.get());
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_BIRCH_FENCE.get(), Blocks.STRIPPED_BIRCH_LOG);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_DARK_OAK_FENCE.get(), Blocks.STRIPPED_DARK_OAK_LOG);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_JUNGLE_FENCE.get(), Blocks.STRIPPED_JUNGLE_LOG);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_MANGROVE_FENCE.get(), Blocks.STRIPPED_MANGROVE_LOG);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_SPRUCE_FENCE.get(), Blocks.STRIPPED_SPRUCE_LOG);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_CRIMSON_FENCE.get(), Blocks.STRIPPED_CRIMSON_STEM);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_WARPED_FENCE.get(), Blocks.STRIPPED_WARPED_STEM);

        // Families/Fence

        inventoryFenceMCMaterial(ModBlocks.OAK_WOOD_FENCE.get(), Blocks.OAK_LOG);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_OAK_FENCE.get(), Blocks.STRIPPED_OAK_LOG);

        inventoryFence(ModBlocks.BAOBAB_WOOD_FENCE.get(), ModBlocks.BAOBAB_LOG.get());
        inventoryFence(ModBlocks.STRIPPED_BAOBAB_FENCE.get(), ModBlocks.STRIPPED_BAOBAB_LOG.get());

        inventoryFenceMCMaterial(ModBlocks.BIRCH_WOOD_FENCE.get(), Blocks.BIRCH_LOG);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_BIRCH_FENCE.get(), Blocks.STRIPPED_BIRCH_LOG);

        inventoryFenceMCMaterial(ModBlocks.SPRUCE_WOOD_FENCE.get(), Blocks.SPRUCE_LOG);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_SPRUCE_FENCE.get(), Blocks.STRIPPED_SPRUCE_LOG);

        inventoryFenceMCMaterial(ModBlocks.DARK_OAK_WOOD_FENCE.get(), Blocks.DARK_OAK_LOG);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_DARK_OAK_FENCE.get(), Blocks.STRIPPED_DARK_OAK_LOG);

        inventoryFenceMCMaterial(ModBlocks.JUNGLE_WOOD_FENCE.get(), Blocks.JUNGLE_LOG);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_JUNGLE_FENCE.get(), Blocks.STRIPPED_JUNGLE_LOG);

        inventoryFenceMCMaterial(ModBlocks.ACACIA_WOOD_FENCE.get(), Blocks.ACACIA_LOG);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_ACACIA_FENCE.get(), Blocks.STRIPPED_ACACIA_LOG);

        inventoryFenceMCMaterial(ModBlocks.MANGROVE_WOOD_FENCE.get(), Blocks.MANGROVE_LOG);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_MANGROVE_FENCE.get(), Blocks.STRIPPED_MANGROVE_LOG);

        inventoryFenceMCMaterial(ModBlocks.CRIMSON_HYPHAE_FENCE.get(), Blocks.CRIMSON_STEM);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_CRIMSON_FENCE.get(), Blocks.STRIPPED_CRIMSON_STEM);

        inventoryFenceMCMaterial(ModBlocks.WARPED_HYPHAE_FENCE.get(), Blocks.WARPED_STEM);
        inventoryFenceMCMaterial(ModBlocks.STRIPPED_WARPED_FENCE.get(), Blocks.STRIPPED_WARPED_STEM);
    }

    public ModelFile flowerPotCross(String name, Block flower) {
        return models().withExistingParent(name, "flower_pot_cross").texture("plant", "block/" + blockName(flower, false)).renderType("cutout");
    }

    public ModelFile crossWithRenderType(Block block, String renderType) {
        return models().cross(blockName(block, false), blockTexture(block)).renderType(renderType);
    }

    public ModelFile cubeAllWithRenderType(Block block, String renderType) {
        return models().cubeAll(blockName(block, false), blockTexture(block)).renderType(renderType);
    }

    public ModelFile inventoryWall(Block block, Block material) {
        return models().withExistingParent(blockName(block, false) + "_inventory", "wall_inventory")
                .texture("wall", "block/" + blockName(material, false));
    }
    public ModelFile inventoryWallMCMaterial(Block block, Block material) {
        return models().withExistingParent(blockName(block, false) + "_inventory", "wall_inventory")
                .texture("wall", "minecraft:block/" + blockName(material, true));
    }
    public ModelFile inventoryButton(Block block, Block material) {
        return models().withExistingParent(blockName(block, false) + "_inventory", "button_inventory")
                .texture("texture", "block/" + blockName(material, false));
    }
    public ModelFile inventoryButtonMCMaterial(Block block, Block material) {
        return models().withExistingParent(blockName(block, false) + "_inventory", "button_inventory")
                .texture("texture", "minecraft:block/" + blockName(material, true));
    }
    public ModelFile inventoryFence(Block block, Block material) {
        return models().withExistingParent(blockName(block, false) + "_inventory", "fence_inventory")
                .texture("texture", "block/" + blockName(material, false));
    }
    public ModelFile inventoryFenceMCMaterial(Block block, Block material) {
        return models().withExistingParent(blockName(block, false) + "_inventory", "fence_inventory")
                .texture("texture", "minecraft:block/" + blockName(material, true));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }


    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(block.getAgeProperty()),
                new ResourceLocation(DLC.MOD_ID, "block/" + textureName + state.getValue(block.getAgeProperty()))).renderType("cutout"));

        return models;
    }
}
