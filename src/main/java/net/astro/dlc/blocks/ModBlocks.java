package net.astro.dlc.blocks;

import net.astro.dlc.DLC;
import net.astro.dlc.blocks.crops.TomatoPlantBlock;
import net.astro.dlc.blocks.flowers.LevitationDandelion;
import net.astro.dlc.blocks.strippableblocks.StrippableFence;
import net.astro.dlc.blocks.strippableblocks.StrippableFenceGate;
import net.astro.dlc.blocks.strippableblocks.StrippableSlab;
import net.astro.dlc.blocks.strippableblocks.StrippableStairs;
import net.astro.dlc.entity.ModWoodTypes;
import net.astro.dlc.item.ModCreativeModeTab;
import net.astro.dlc.item.ModItems;
import net.astro.dlc.world.feature.tree.BaobabTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.*;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DLC.MOD_ID);

    public static final RegistryObject<Block> ALUMINIUM_BLOCK = registerBlock("aluminium_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ALUMINIUM_ORE = registerBlock("aluminium_ore", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BAOBAB_BUTTON = registerBlock("baobab_button", () ->
            new WoodButtonBlock(BlockBehaviour.Properties.copy(ACACIA_BUTTON)),
            ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> BAOBAB_DOOR = registerBlock("baobab_door", () ->
                    new DoorBlock(BlockBehaviour.Properties.copy(ACACIA_DOOR)),
            ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> BAOBAB_FENCE = registerBlock("baobab_fence", () ->
                    new FenceBlock(BlockBehaviour.Properties.copy(ACACIA_DOOR)) {
                        @Override
                        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                        @Override
                        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                        @Override
                        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
                    },
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> BAOBAB_FENCE_GATE = registerBlock("baobab_fence_gate", () ->
                    new FenceGateBlock(BlockBehaviour.Properties.copy(ACACIA_DOOR)){
                        @Override
                        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                        @Override
                        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                        @Override
                        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
                    },
            ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> BAOBAB_LEAVES = registerBlock("baobab_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties.copy(ACACIA_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_BAOBAB_LOG = registerBlock("stripped_baobab_log", () ->
                    new ModFlammableRotatedPillarBlock(null, BlockBehaviour.Properties.copy(STRIPPED_ACACIA_LOG)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BAOBAB_LOG = registerBlock("baobab_log", () ->
            new ModFlammableRotatedPillarBlock(STRIPPED_BAOBAB_LOG.get(), BlockBehaviour.Properties.copy(ACACIA_LOG)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BAOBAB_PLANKS = registerBlock("baobab_planks", () ->
            new Block(BlockBehaviour.Properties.copy(ACACIA_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 20; }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 5; }
            }, ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BAOBAB_PRESSURE_PLATE = registerBlock("baobab_pressure_plate", () ->
                    new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.copy(ACACIA_PRESSURE_PLATE)),
            ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> BAOBAB_SAPLING = registerBlock("baobab_sapling", () ->
            new SaplingBlock(new BaobabTreeGrower(), BlockBehaviour.Properties.copy(ACACIA_SAPLING)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> BAOBAB_SIGN = registerBlockWithoutBlockItem("baobab_sign", () ->
            new ModStandingSignBlock(BlockBehaviour.Properties.copy(ACACIA_SIGN), ModWoodTypes.BAOBAB));
    public static final RegistryObject<Block> BAOBAB_SLAB = registerBlock("baobab_slab", () ->
                    new SlabBlock(BlockBehaviour.Properties.copy(ACACIA_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BAOBAB_STAIRS = registerBlock("baobab_stairs", () ->
            new StairBlock(() -> ModBlocks.BAOBAB_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ACACIA_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BAOBAB_TRAPDOOR = registerBlock("baobab_trapdoor", () ->
                    new TrapDoorBlock(BlockBehaviour.Properties.copy(ACACIA_TRAPDOOR)),
            ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> BAOBAB_WALL_SIGN = registerBlockWithoutBlockItem("baobab_wall_sign", () ->
            new ModWallSignBlock(BlockBehaviour.Properties.copy(ACACIA_WALL_SIGN), ModWoodTypes.BAOBAB));
    public static final RegistryObject<Block> STRIPPED_BAOBAB_WOOD = registerBlock("stripped_baobab_wood", () ->
                    new ModFlammableRotatedPillarBlock(null, BlockBehaviour.Properties.copy(STRIPPED_ACACIA_WOOD)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BAOBAB_WOOD = registerBlock("baobab_wood", () ->
            new ModFlammableRotatedPillarBlock(STRIPPED_BAOBAB_WOOD.get(), BlockBehaviour.Properties.copy(ACACIA_WOOD)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BRONZE_BLOCK = registerBlock("bronze_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BRONZE_BRICKS = registerBlock("bronze_bricks", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> BRONZE_BRICK_SLAB = registerBlock("bronze_brick_slab", () ->
                    new SlabBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BRONZE_BRICK_STAIRS = registerBlock("bronze_brick_stairs", () ->
            new StairBlock(() -> ModBlocks.BRONZE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BRONZE_BRICK_WALL = registerBlock("bronze_brick_wall", () ->
                    new WallBlock(BlockBehaviour.Properties.copy(COPPER_BLOCK)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> BRONZE_SLAB = registerBlock("bronze_slab", () ->
                    new SlabBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BRONZE_STAIRS = registerBlock("bronze_stairs", () ->
                    new StairBlock(() -> ModBlocks.BRONZE_BLOCK.get().defaultBlockState(),
                            BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BRONZE_TILES = registerBlock("bronze_tiles", () ->
                    new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BRONZE_TILE_SLAB = registerBlock("bronze_tile_slab", () ->
                    new SlabBlock(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BRONZE_TILE_STAIRS = registerBlock("bronze_tile_stairs", () ->
            new StairBlock(() -> ModBlocks.BRONZE_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> BRONZE_TILE_WALL = registerBlock("bronze_tile_wall", () ->
            new WallBlock(BlockBehaviour.Properties.copy(COPPER_BLOCK)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> BRONZE_WALL = registerBlock("bronze_wall", () ->
            new WallBlock(BlockBehaviour.Properties.copy(COPPER_BLOCK)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> CHISELES_BRONZE = registerBlock("chiseled_bronze", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> COPPER_WALL = registerBlock("copper_wall", () ->
            new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(COPPER_BLOCK)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> CRACKED_BRONZE_BRICKS = registerBlock("cracked_bronze_bricks", () ->
                    new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CRACKED_BRONZE_TILES = registerBlock("cracked_bronze_tiles", () ->
                    new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEEPSLATE_ALUMINIUM_ORE = registerBlock("deepslate_aluminium_ore", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", () ->
                    new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> EXPOSED_COPPER_WALL = registerBlock("exposed_copper_wall", () ->
                    new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(EXPOSED_COPPER)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> LEVITATION_DANDELION = registerBlock("levitation_dandelion", () ->
            new LevitationDandelion(MobEffects.LEVITATION, 4, BlockBehaviour.Properties.copy(DANDELION).noOcclusion()),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> OXIDIZED_COPPER_WALL = registerBlock("oxidized_copper_wall", () ->
                    new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(OXIDIZED_COPPER)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> POLISHED_ANDESITE_WALL = registerBlock("polished_andesite_wall", () ->
                    new WallBlock(BlockBehaviour.Properties.copy(ANDESITE)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> POLISHED_DIORITE_WALL = registerBlock("polished_diorite_wall", () ->
                    new WallBlock(BlockBehaviour.Properties.copy(DIORITE)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> POLISHED_GRANITE_WALL = registerBlock("polished_granite_wall", () ->
                    new WallBlock(BlockBehaviour.Properties.copy(GRANITE)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> POTTED_MATURE_DANDELION = registerBlockWithoutBlockItem("potted_mature_dandelion", () ->
            new FlowerPotBlock(null, ModBlocks.LEVITATION_DANDELION, BlockBehaviour.Properties.copy(POTTED_DANDELION).noOcclusion()));
    public static final RegistryObject<Block> RAW_ALUMINIUM_BLOCK = registerBlock("raw_aluminium_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5.5f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> TOMATO_PLANT = registerBlockWithoutBlockItem("tomato", () ->
            new TomatoPlantBlock(BlockBehaviour.Properties.copy(WHEAT).noOcclusion()));
    public static final RegistryObject<Block> WAXED_COPPER_WALL = registerBlock("waxed_copper_wall", () ->
            new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.copy(COPPER_BLOCK)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_WALL = registerBlock("waxed_exposed_copper_wall", () ->
            new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.copy(EXPOSED_COPPER)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> WAXED_OXIDIZED_COPPER_WALL = registerBlock("waxed_oxidized_copper_wall", () ->
            new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.copy(OXIDIZED_COPPER)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> WAXED_WEATHERED_COPPER_WALL = registerBlock("waxed_weathered_copper_wall", () ->
            new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(WEATHERED_COPPER)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> WEATHERED_COPPER_WALL = registerBlock("weathered_copper_wall", () ->
            new WeatheringCopperWallBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.copy(WEATHERED_COPPER)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);

    // Families
    // ATTENZIONE: DICHIARA PRIMA GLI STRIPPED, POI I WOODS

    /** 1: OAK_WOOD **/
    public static final RegistryObject<Block> STRIPPED_OAK_SLAB = registerBlock("stripped_oak_slab", () ->
                    new SlabBlock(BlockBehaviour.Properties.copy(OAK_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_OAK_STAIRS = registerBlock("stripped_oak_stairs", () ->
            new StairBlock(STRIPPED_OAK_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(OAK_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_OAK_FENCE = registerBlock("stripped_oak_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.copy(OAK_FENCE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_OAK_FENCE_GATE = registerBlock("stripped_oak_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.copy(OAK_FENCE_GATE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> OAK_WOOD_SLAB = registerBlock("oak_wood_slab", () ->
                    new StrippableSlab(ModBlocks.STRIPPED_OAK_SLAB.get(), BlockBehaviour.Properties.copy(OAK_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> OAK_WOOD_STAIRS = registerBlock("oak_wood_stairs", () ->
            new StrippableStairs(ModBlocks.STRIPPED_OAK_STAIRS.get(), OAK_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(OAK_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> OAK_WOOD_FENCE = registerBlock("oak_wood_fence", () ->
            new StrippableFence(ModBlocks.STRIPPED_OAK_FENCE.get(), BlockBehaviour.Properties.copy(OAK_FENCE)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> OAK_WOOD_FENCE_GATE = registerBlock("oak_wood_fence_gate", () ->
            new StrippableFenceGate(ModBlocks.STRIPPED_OAK_FENCE_GATE.get(), BlockBehaviour.Properties.copy(OAK_FENCE)),
            ModCreativeModeTab.DLC_TAB_REDSTONE);

    /** 2: BAOBAB_WOOD **/

    public static final RegistryObject<Block> STRIPPED_BAOBAB_SLAB = registerBlock("stripped_baobab_slab", () ->
                    new SlabBlock(BlockBehaviour.Properties.copy(BAOBAB_SLAB.get())),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_BAOBAB_STAIRS = registerBlock("stripped_baobab_stairs", () ->
            new StairBlock(() -> ModBlocks.STRIPPED_BAOBAB_WOOD.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(BAOBAB_STAIRS.get())), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_BAOBAB_FENCE = registerBlock("stripped_baobab_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.copy(BAOBAB_FENCE.get()))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_BAOBAB_FENCE_GATE = registerBlock("stripped_baobab_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.copy(BAOBAB_FENCE_GATE.get()))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> BAOBAB_WOOD_SLAB = registerBlock("baobab_wood_slab", () ->
                    new StrippableSlab(ModBlocks.STRIPPED_BAOBAB_SLAB.get(), BlockBehaviour.Properties.copy(BAOBAB_SLAB.get())),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BAOBAB_WOOD_STAIRS = registerBlock("baobab_wood_stairs", () ->
            new StrippableStairs(ModBlocks.STRIPPED_BAOBAB_STAIRS.get(), () -> ModBlocks.BAOBAB_WOOD.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(BAOBAB_STAIRS.get())), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BAOBAB_WOOD_FENCE = registerBlock("baobab_wood_fence", () ->
                    new StrippableFence(ModBlocks.STRIPPED_BAOBAB_FENCE.get(), BlockBehaviour.Properties.copy(BAOBAB_FENCE.get())),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> BAOBAB_WOOD_FENCE_GATE = registerBlock("baobab_wood_fence_gate", () ->
                    new StrippableFenceGate(ModBlocks.STRIPPED_BAOBAB_FENCE_GATE.get(), BlockBehaviour.Properties.copy(BAOBAB_FENCE_GATE.get())),
            ModCreativeModeTab.DLC_TAB_REDSTONE);

    /** 3: BIRCH_WOOD **/

    public static final RegistryObject<Block> STRIPPED_BIRCH_SLAB = registerBlock("stripped_birch_slab", () ->
                    new SlabBlock(BlockBehaviour.Properties.copy(BIRCH_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_BIRCH_STAIRS = registerBlock("stripped_birch_stairs", () ->
            new StairBlock(STRIPPED_BIRCH_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(BIRCH_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_BIRCH_FENCE = registerBlock("stripped_birch_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.copy(BIRCH_FENCE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_BIRCH_FENCE_GATE = registerBlock("stripped_birch_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.copy(BIRCH_FENCE_GATE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> BIRCH_WOOD_SLAB = registerBlock("birch_wood_slab", () ->
                    new StrippableSlab(ModBlocks.STRIPPED_BIRCH_SLAB.get(), BlockBehaviour.Properties.copy(BIRCH_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BIRCH_WOOD_STAIRS = registerBlock("birch_wood_stairs", () ->
            new StrippableStairs(ModBlocks.STRIPPED_BIRCH_STAIRS.get(), BIRCH_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(BIRCH_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BIRCH_WOOD_FENCE = registerBlock("birch_wood_fence", () ->
                    new StrippableFence(ModBlocks.STRIPPED_BIRCH_FENCE.get(), BlockBehaviour.Properties.copy(BIRCH_FENCE)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> BIRCH_WOOD_FENCE_GATE = registerBlock("birch_wood_fence_gate", () ->
                    new StrippableFenceGate(ModBlocks.STRIPPED_BIRCH_FENCE_GATE.get(), BlockBehaviour.Properties.copy(BIRCH_FENCE_GATE)),
            ModCreativeModeTab.DLC_TAB_REDSTONE);

    /** 4: SPRUCE_WOOD **/

    public static final RegistryObject<Block> STRIPPED_SPRUCE_SLAB = registerBlock("stripped_spruce_slab", () ->
                    new SlabBlock(BlockBehaviour.Properties.copy(SPRUCE_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_SPRUCE_STAIRS = registerBlock("stripped_spruce_stairs", () ->
            new StairBlock(STRIPPED_SPRUCE_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(SPRUCE_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_SPRUCE_FENCE = registerBlock("stripped_spruce_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.copy(SPRUCE_FENCE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_SPRUCE_FENCE_GATE = registerBlock("stripped_spruce_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.copy(SPRUCE_FENCE_GATE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> SPRUCE_WOOD_SLAB = registerBlock("spruce_wood_slab", () ->
                    new StrippableSlab(ModBlocks.STRIPPED_SPRUCE_SLAB.get(), BlockBehaviour.Properties.copy(SPRUCE_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SPRUCE_WOOD_STAIRS = registerBlock("spruce_wood_stairs", () ->
            new StrippableStairs(ModBlocks.STRIPPED_SPRUCE_STAIRS.get(), SPRUCE_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(SPRUCE_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> SPRUCE_WOOD_FENCE = registerBlock("spruce_wood_fence", () ->
                    new StrippableFence(ModBlocks.STRIPPED_SPRUCE_FENCE.get(), BlockBehaviour.Properties.copy(SPRUCE_FENCE)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> SPRUCE_WOOD_FENCE_GATE = registerBlock("spruce_wood_fence_gate", () ->
                    new StrippableFenceGate(ModBlocks.STRIPPED_SPRUCE_FENCE_GATE.get(), BlockBehaviour.Properties.copy(SPRUCE_FENCE_GATE)),
            ModCreativeModeTab.DLC_TAB_REDSTONE);

    /** 5: JUNGLE_WOOD **/

    public static final RegistryObject<Block> STRIPPED_JUNGLE_SLAB = registerBlock("stripped_jungle_slab", () ->
                    new SlabBlock(BlockBehaviour.Properties.copy(JUNGLE_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_JUNGLE_STAIRS = registerBlock("stripped_jungle_stairs", () ->
            new StairBlock(STRIPPED_JUNGLE_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(JUNGLE_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_JUNGLE_FENCE = registerBlock("stripped_jungle_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.copy(JUNGLE_FENCE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_JUNGLE_FENCE_GATE = registerBlock("stripped_jungle_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.copy(JUNGLE_FENCE_GATE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> JUNGLE_WOOD_SLAB = registerBlock("jungle_wood_slab", () ->
                    new StrippableSlab(ModBlocks.STRIPPED_JUNGLE_SLAB.get(), BlockBehaviour.Properties.copy(JUNGLE_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> JUNGLE_WOOD_STAIRS = registerBlock("jungle_wood_stairs", () ->
            new StrippableStairs(ModBlocks.STRIPPED_JUNGLE_STAIRS.get(), JUNGLE_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(JUNGLE_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> JUNGLE_WOOD_FENCE = registerBlock("jungle_wood_fence", () ->
                    new StrippableFence(ModBlocks.STRIPPED_JUNGLE_FENCE.get(), BlockBehaviour.Properties.copy(JUNGLE_FENCE)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> JUNGLE_WOOD_FENCE_GATE = registerBlock("jungle_wood_fence_gate", () ->
                    new StrippableFenceGate(ModBlocks.STRIPPED_JUNGLE_FENCE_GATE.get(), BlockBehaviour.Properties.copy(JUNGLE_FENCE_GATE)),
            ModCreativeModeTab.DLC_TAB_REDSTONE);


    /** 6: DARK_OAK_WOOD **/

    public static final RegistryObject<Block> STRIPPED_DARK_OAK_SLAB = registerBlock("stripped_dark_oak_slab", () ->
                    new SlabBlock(BlockBehaviour.Properties.copy(DARK_OAK_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_DARK_OAK_STAIRS = registerBlock("stripped_dark_oak_stairs", () ->
            new StairBlock(STRIPPED_DARK_OAK_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(DARK_OAK_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_DARK_OAK_FENCE = registerBlock("stripped_dark_oak_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.copy(DARK_OAK_FENCE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_DARK_OAK_FENCE_GATE = registerBlock("stripped_dark_oak_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.copy(DARK_OAK_FENCE_GATE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> DARK_OAK_WOOD_SLAB = registerBlock("dark_oak_wood_slab", () ->
                    new StrippableSlab(ModBlocks.STRIPPED_DARK_OAK_SLAB.get(), BlockBehaviour.Properties.copy(DARK_OAK_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DARK_OAK_WOOD_STAIRS = registerBlock("dark_oak_wood_stairs", () ->
            new StrippableStairs(ModBlocks.STRIPPED_DARK_OAK_STAIRS.get(), DARK_OAK_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(DARK_OAK_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DARK_OAK_WOOD_FENCE = registerBlock("dark_oak_wood_fence", () ->
                    new StrippableFence(ModBlocks.STRIPPED_DARK_OAK_FENCE.get(), BlockBehaviour.Properties.copy(DARK_OAK_FENCE)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> DARK_OAK_WOOD_FENCE_GATE = registerBlock("dark_oak_wood_fence_gate", () ->
                    new StrippableFenceGate(ModBlocks.STRIPPED_DARK_OAK_FENCE_GATE.get(), BlockBehaviour.Properties.copy(DARK_OAK_FENCE_GATE)),
            ModCreativeModeTab.DLC_TAB_REDSTONE);

    /** 7: ACACIA_WOOD **/

    public static final RegistryObject<Block> STRIPPED_ACACIA_SLAB = registerBlock("stripped_acacia_slab", () ->
                    new SlabBlock(BlockBehaviour.Properties.copy(ACACIA_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_ACACIA_STAIRS = registerBlock("stripped_acacia_stairs", () ->
            new StairBlock(STRIPPED_ACACIA_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(ACACIA_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_ACACIA_FENCE = registerBlock("stripped_acacia_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.copy(ACACIA_FENCE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_ACACIA_FENCE_GATE = registerBlock("stripped_acacia_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.copy(ACACIA_FENCE_GATE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> ACACIA_WOOD_SLAB = registerBlock("acacia_wood_slab", () ->
                    new StrippableSlab(ModBlocks.STRIPPED_ACACIA_SLAB.get(), BlockBehaviour.Properties.copy(ACACIA_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ACACIA_WOOD_STAIRS = registerBlock("acacia_wood_stairs", () ->
            new StrippableStairs(ModBlocks.STRIPPED_ACACIA_STAIRS.get(), ACACIA_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(ACACIA_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ACACIA_WOOD_FENCE = registerBlock("acacia_wood_fence", () ->
                    new StrippableFence(ModBlocks.STRIPPED_ACACIA_FENCE.get(), BlockBehaviour.Properties.copy(ACACIA_FENCE)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> ACACIA_WOOD_FENCE_GATE = registerBlock("acacia_wood_fence_gate", () ->
                    new StrippableFenceGate(ModBlocks.STRIPPED_ACACIA_FENCE_GATE.get(), BlockBehaviour.Properties.copy(ACACIA_FENCE_GATE)),
            ModCreativeModeTab.DLC_TAB_REDSTONE);

    /** 8: MANGROVE_WOOD **/

    public static final RegistryObject<Block> STRIPPED_MANGROVE_SLAB = registerBlock("stripped_mangrove_slab", () ->
                    new SlabBlock(BlockBehaviour.Properties.copy(MANGROVE_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_MANGROVE_STAIRS = registerBlock("stripped_mangrove_stairs", () ->
            new StairBlock(STRIPPED_MANGROVE_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(MANGROVE_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_MANGROVE_FENCE = registerBlock("stripped_mangrove_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.copy(MANGROVE_FENCE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_MANGROVE_FENCE_GATE = registerBlock("stripped_mangrove_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.copy(MANGROVE_FENCE_GATE))
            {
                @Override public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return true; }
                @Override public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 60; }
                @Override public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) { return 30; }
            }, ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> MANGROVE_WOOD_SLAB = registerBlock("mangrove_wood_slab", () ->
                    new StrippableSlab(ModBlocks.STRIPPED_MANGROVE_SLAB.get(), BlockBehaviour.Properties.copy(MANGROVE_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MANGROVE_WOOD_STAIRS = registerBlock("mangrove_wood_stairs", () ->
            new StrippableStairs(ModBlocks.STRIPPED_MANGROVE_STAIRS.get(), MANGROVE_WOOD::defaultBlockState,
                    BlockBehaviour.Properties.copy(MANGROVE_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> MANGROVE_WOOD_FENCE = registerBlock("mangrove_wood_fence", () ->
                    new StrippableFence(ModBlocks.STRIPPED_MANGROVE_FENCE.get(), BlockBehaviour.Properties.copy(MANGROVE_FENCE)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> MANGROVE_WOOD_FENCE_GATE = registerBlock("mangrove_wood_fence_gate", () ->
                    new StrippableFenceGate(ModBlocks.STRIPPED_MANGROVE_FENCE_GATE.get(), BlockBehaviour.Properties.copy(MANGROVE_FENCE_GATE)),
            ModCreativeModeTab.DLC_TAB_REDSTONE);

/** 9: CRIMSON_HYPHAE **/

public static final RegistryObject<Block> STRIPPED_CRIMSON_SLAB = registerBlock("stripped_crimson_slab", () ->
                new SlabBlock(BlockBehaviour.Properties.copy(CRIMSON_SLAB)),
        ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_CRIMSON_STAIRS = registerBlock("stripped_crimson_stairs", () ->
            new StairBlock(STRIPPED_WARPED_HYPHAE::defaultBlockState,
                    BlockBehaviour.Properties.copy(CRIMSON_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_CRIMSON_FENCE = registerBlock("stripped_crimson_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.copy(CRIMSON_FENCE)), ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_CRIMSON_FENCE_GATE = registerBlock("stripped_crimson_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.copy(CRIMSON_FENCE_GATE)), ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> CRIMSON_HYPHAE_SLAB = registerBlock("crimson_hyphae_slab", () ->
                    new StrippableSlab(ModBlocks.STRIPPED_CRIMSON_SLAB.get(), BlockBehaviour.Properties.copy(CRIMSON_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CRIMSON_HYPHAE_STAIRS = registerBlock("crimson_hyphae_stairs", () ->
            new StrippableStairs(ModBlocks.STRIPPED_CRIMSON_STAIRS.get(), CRIMSON_HYPHAE::defaultBlockState,
                    BlockBehaviour.Properties.copy(CRIMSON_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> CRIMSON_HYPHAE_FENCE = registerBlock("crimson_hyphae_fence", () ->
                    new StrippableFence(ModBlocks.STRIPPED_CRIMSON_FENCE.get(), BlockBehaviour.Properties.copy(CRIMSON_FENCE)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> CRIMSON_HYPHAE_FENCE_GATE = registerBlock("crimson_hyphae_fence_gate", () ->
                    new StrippableFenceGate(ModBlocks.STRIPPED_CRIMSON_FENCE_GATE.get(), BlockBehaviour.Properties.copy(CRIMSON_FENCE_GATE)),
            ModCreativeModeTab.DLC_TAB_REDSTONE);

    /** 9: WARPED_HYPHAE **/

    public static final RegistryObject<Block> STRIPPED_WARPED_SLAB = registerBlock("stripped_warped_slab", () ->
                    new SlabBlock(BlockBehaviour.Properties.copy(WARPED_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_WARPED_STAIRS = registerBlock("stripped_warped_stairs", () ->
            new StairBlock(STRIPPED_WARPED_HYPHAE::defaultBlockState,
                    BlockBehaviour.Properties.copy(WARPED_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_WARPED_FENCE = registerBlock("stripped_warped_fence", () ->
            new FenceBlock(BlockBehaviour.Properties.copy(WARPED_FENCE)), ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_WARPED_FENCE_GATE = registerBlock("stripped_warped_fence_gate", () ->
            new FenceGateBlock(BlockBehaviour.Properties.copy(WARPED_FENCE_GATE)), ModCreativeModeTab.DLC_TAB_REDSTONE);
    public static final RegistryObject<Block> WARPED_HYPHAE_SLAB = registerBlock("warped_hyphae_slab", () ->
                    new StrippableSlab(ModBlocks.STRIPPED_WARPED_SLAB.get(), BlockBehaviour.Properties.copy(WARPED_SLAB)),
            ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> WARPED_HYPHAE_STAIRS = registerBlock("warped_hyphae_stairs", () ->
            new StrippableStairs(ModBlocks.STRIPPED_WARPED_STAIRS.get(), WARPED_HYPHAE::defaultBlockState,
                    BlockBehaviour.Properties.copy(WARPED_STAIRS)), ModCreativeModeTab.DLC_TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> WARPED_HYPHAE_FENCE = registerBlock("warped_hyphae_fence", () ->
                    new StrippableFence(ModBlocks.STRIPPED_WARPED_FENCE.get(), BlockBehaviour.Properties.copy(WARPED_FENCE)),
            ModCreativeModeTab.DLC_TAB_DECORATIONS);
    public static final RegistryObject<Block> WARPED_HYPHAE_FENCE_GATE = registerBlock("warped_hyphae_fence_gate", () ->
                    new StrippableFenceGate(ModBlocks.STRIPPED_WARPED_FENCE_GATE.get(), BlockBehaviour.Properties.copy(WARPED_FENCE_GATE)),
            ModCreativeModeTab.DLC_TAB_REDSTONE);

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
