package net.astro.dlc.datagen;

import net.astro.dlc.DLC;
import net.astro.dlc.blocks.ModBlocks;
import net.astro.dlc.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, DLC.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.ALUMINIUM_INGOT.get());
        simpleItem(ModItems.ALUMINIUM_NUGGET.get());
        simpleItem(ModItems.BRONZE_INGOT.get());
        simpleItem(ModItems.BRONZE_NUGGET.get());
        handheldItem(ModItems.CHAINSAW.get());
        simpleItem(ModItems.COPPER_NUGGET.get());
        simpleItem(ModItems.FLAMMABLE_DUST.get());
        simpleItem(ModItems.RAW_ALUMINIUM.get());
        simpleItem(ModItems.RAW_TIN.get());
        simpleItem(ModItems.TIN_INGOT.get());
        simpleItem(ModItems.TIN_NUGGET.get());

        handheldItem(ModItems.BRONZE_AXE.get());
        handheldItem(ModItems.BRONZE_HOE.get());
        handheldItem(ModItems.BRONZE_PICKAXE.get());
        handheldItem(ModItems.BRONZE_SHOVEL.get());
        handheldItem(ModItems.BRONZE_SWORD.get());

        simpleItem(ModItems.BRONZE_HELMET.get());
        simpleItem(ModItems.BRONZE_CHESTPLATE.get());
        simpleItem(ModItems.BRONZE_LEGGINGS.get());
        simpleItem(ModItems.BRONZE_BOOTS.get());
        simpleItem(ModItems.BRONZE_HORSE_ARMOR.get());

        simpleItem(ModItems.CHAINMAIL_HORSE_ARMOR.get());

        simpleItem(ModItems.NETHERITE_HORSE_ARMOR.get());

        simpleItem(ModItems.MATURE_TOMATO.get());
        simpleItem(ModItems.HALF_MATURE_TOMATO.get());
        simpleItem(ModItems.UNRIPE_TOMATO.get());
        simpleItem(ModItems.BAOBAB_FRUIT.get());

        simpleItem(ModItems.TOMATO_SEEDS.get());

        simpleItem(ModItems.BAOBAB_SIGN.get());
        simpleItem(ModItems.ENDER_DRAGON_MUSIC_DISC.get());
        simpleItem(ModItems.ICE_MUSIC_DISC.get());
        simpleItem(ModItems.LUSH_MUSIC_DISC.get());

        //////

        block(ModBlocks.ALUMINIUM_BLOCK.get());
        block(ModBlocks.ALUMINIUM_ORE.get());
        inventoryRender(ModBlocks.BAOBAB_BUTTON.get());
        itemLikeBlock(ModBlocks.BAOBAB_DOOR.get());
        inventoryRender(ModBlocks.BAOBAB_FENCE.get());
        block(ModBlocks.BAOBAB_FENCE_GATE.get());
        block(ModBlocks.BAOBAB_LEAVES.get());
        block(ModBlocks.BAOBAB_LOG.get());
        block(ModBlocks.BAOBAB_PLANKS.get());
        block(ModBlocks.BAOBAB_PRESSURE_PLATE.get());
        itemLikeBlock(ModBlocks.BAOBAB_SAPLING.get());
        block(ModBlocks.BAOBAB_SLAB.get());
        block(ModBlocks.BAOBAB_STAIRS.get());
        trapdoor(ModBlocks.BAOBAB_TRAPDOOR.get());
        block(ModBlocks.BAOBAB_WOOD.get());
        block(ModBlocks.BRONZE_BLOCK.get());
        block(ModBlocks.BRONZE_BRICKS.get());
        block(ModBlocks.BRONZE_BRICK_SLAB.get());
        block(ModBlocks.BRONZE_BRICK_STAIRS.get());
        inventoryRender(ModBlocks.BRONZE_BRICK_WALL.get());
        block(ModBlocks.BRONZE_SLAB.get());
        block(ModBlocks.BRONZE_STAIRS.get());
        block(ModBlocks.BRONZE_TILES.get());
        block(ModBlocks.BRONZE_TILE_SLAB.get());
        block(ModBlocks.BRONZE_TILE_STAIRS.get());
        inventoryRender(ModBlocks.BRONZE_TILE_WALL.get());
        inventoryRender(ModBlocks.BRONZE_WALL.get());
        block(ModBlocks.CHISELES_BRONZE.get());
        inventoryRender(ModBlocks.COPPER_WALL.get());
        block(ModBlocks.CRACKED_BRONZE_BRICKS.get());
        block(ModBlocks.CRACKED_BRONZE_TILES.get());
        block(ModBlocks.DEEPSLATE_ALUMINIUM_ORE.get());
        block(ModBlocks.DEEPSLATE_TIN_ORE.get());
        inventoryRender(ModBlocks.EXPOSED_COPPER_WALL.get());
        itemLikeBlock(ModBlocks.LEVITATION_DANDELION.get());
        inventoryRender(ModBlocks.OXIDIZED_COPPER_WALL.get());
        inventoryRender(ModBlocks.POLISHED_ANDESITE_WALL.get());
        inventoryRender(ModBlocks.POLISHED_DIORITE_WALL.get());
        inventoryRender(ModBlocks.POLISHED_GRANITE_WALL.get());
        block(ModBlocks.RAW_ALUMINIUM_BLOCK.get());
        block(ModBlocks.RAW_TIN_BLOCK.get());
        block(ModBlocks.STRIPPED_BAOBAB_LOG.get());
        block(ModBlocks.STRIPPED_BAOBAB_WOOD.get());
        block(ModBlocks.TIN_BLOCK.get());
        block(ModBlocks.TIN_ORE.get());
        waxedCopper(ModBlocks.WAXED_COPPER_WALL.get(), ModBlocks.COPPER_WALL.get());
        waxedCopper(ModBlocks.WAXED_EXPOSED_COPPER_WALL.get(), ModBlocks.EXPOSED_COPPER_WALL.get());
        waxedCopper(ModBlocks.WAXED_OXIDIZED_COPPER_WALL.get(), ModBlocks.OXIDIZED_COPPER_WALL.get());
        waxedCopper(ModBlocks.WAXED_WEATHERED_COPPER_WALL.get(), ModBlocks.WEATHERED_COPPER_WALL.get());
        inventoryRender(ModBlocks.WEATHERED_COPPER_WALL.get());

        // Families

        block(ModBlocks.OAK_WOOD_SLAB.get());
        block(ModBlocks.OAK_WOOD_STAIRS.get());
        inventoryRender(ModBlocks.OAK_WOOD_FENCE.get());
        block(ModBlocks.OAK_WOOD_FENCE_GATE.get());

        block(ModBlocks.STRIPPED_OAK_SLAB.get());
        block(ModBlocks.STRIPPED_OAK_STAIRS.get());
        inventoryRender(ModBlocks.STRIPPED_OAK_FENCE.get());
        block(ModBlocks.STRIPPED_OAK_FENCE_GATE.get());

        block(ModBlocks.BAOBAB_WOOD_SLAB.get());
        block(ModBlocks.BAOBAB_WOOD_STAIRS.get());
        inventoryRender(ModBlocks.BAOBAB_WOOD_FENCE.get());
        block(ModBlocks.BAOBAB_WOOD_FENCE_GATE.get());

        block(ModBlocks.STRIPPED_BAOBAB_SLAB.get());
        block(ModBlocks.STRIPPED_BAOBAB_STAIRS.get());
        inventoryRender(ModBlocks.STRIPPED_BAOBAB_FENCE.get());
        block(ModBlocks.STRIPPED_BAOBAB_FENCE_GATE.get());

        block(ModBlocks.BIRCH_WOOD_SLAB.get());
        block(ModBlocks.BIRCH_WOOD_STAIRS.get());
        inventoryRender(ModBlocks.BIRCH_WOOD_FENCE.get());
        block(ModBlocks.BIRCH_WOOD_FENCE_GATE.get());

        block(ModBlocks.STRIPPED_BIRCH_SLAB.get());
        block(ModBlocks.STRIPPED_BIRCH_STAIRS.get());
        inventoryRender(ModBlocks.STRIPPED_BIRCH_FENCE.get());
        block(ModBlocks.STRIPPED_BIRCH_FENCE_GATE.get());

        block(ModBlocks.SPRUCE_WOOD_SLAB.get());
        block(ModBlocks.SPRUCE_WOOD_STAIRS.get());
        inventoryRender(ModBlocks.SPRUCE_WOOD_FENCE.get());
        block(ModBlocks.SPRUCE_WOOD_FENCE_GATE.get());

        block(ModBlocks.STRIPPED_SPRUCE_SLAB.get());
        block(ModBlocks.STRIPPED_SPRUCE_STAIRS.get());
        inventoryRender(ModBlocks.STRIPPED_SPRUCE_FENCE.get());
        block(ModBlocks.STRIPPED_SPRUCE_FENCE_GATE.get());

        block(ModBlocks.DARK_OAK_WOOD_SLAB.get());
        block(ModBlocks.DARK_OAK_WOOD_STAIRS.get());
        inventoryRender(ModBlocks.DARK_OAK_WOOD_FENCE.get());
        block(ModBlocks.DARK_OAK_WOOD_FENCE_GATE.get());

        block(ModBlocks.STRIPPED_DARK_OAK_SLAB.get());
        block(ModBlocks.STRIPPED_DARK_OAK_STAIRS.get());
        inventoryRender(ModBlocks.STRIPPED_DARK_OAK_FENCE.get());
        block(ModBlocks.STRIPPED_DARK_OAK_FENCE_GATE.get());

        block(ModBlocks.ACACIA_WOOD_SLAB.get());
        block(ModBlocks.ACACIA_WOOD_STAIRS.get());
        inventoryRender(ModBlocks.ACACIA_WOOD_FENCE.get());
        block(ModBlocks.ACACIA_WOOD_FENCE_GATE.get());

        block(ModBlocks.STRIPPED_ACACIA_SLAB.get());
        block(ModBlocks.STRIPPED_ACACIA_STAIRS.get());
        inventoryRender(ModBlocks.STRIPPED_ACACIA_FENCE.get());
        block(ModBlocks.STRIPPED_ACACIA_FENCE_GATE.get());

        block(ModBlocks.JUNGLE_WOOD_SLAB.get());
        block(ModBlocks.JUNGLE_WOOD_STAIRS.get());
        inventoryRender(ModBlocks.JUNGLE_WOOD_FENCE.get());
        block(ModBlocks.JUNGLE_WOOD_FENCE_GATE.get());

        block(ModBlocks.STRIPPED_JUNGLE_SLAB.get());
        block(ModBlocks.STRIPPED_JUNGLE_STAIRS.get());
        inventoryRender(ModBlocks.STRIPPED_JUNGLE_FENCE.get());
        block(ModBlocks.STRIPPED_JUNGLE_FENCE_GATE.get());

        block(ModBlocks.MANGROVE_WOOD_SLAB.get());
        block(ModBlocks.MANGROVE_WOOD_STAIRS.get());
        inventoryRender(ModBlocks.MANGROVE_WOOD_FENCE.get());
        block(ModBlocks.MANGROVE_WOOD_FENCE_GATE.get());

        block(ModBlocks.STRIPPED_MANGROVE_SLAB.get());
        block(ModBlocks.STRIPPED_MANGROVE_STAIRS.get());
        inventoryRender(ModBlocks.STRIPPED_MANGROVE_FENCE.get());
        block(ModBlocks.STRIPPED_MANGROVE_FENCE_GATE.get());

        block(ModBlocks.CRIMSON_HYPHAE_SLAB.get());
        block(ModBlocks.CRIMSON_HYPHAE_STAIRS.get());
        inventoryRender(ModBlocks.CRIMSON_HYPHAE_FENCE.get());
        block(ModBlocks.CRIMSON_HYPHAE_FENCE_GATE.get());

        block(ModBlocks.STRIPPED_CRIMSON_SLAB.get());
        block(ModBlocks.STRIPPED_CRIMSON_STAIRS.get());
        inventoryRender(ModBlocks.STRIPPED_CRIMSON_FENCE.get());
        block(ModBlocks.STRIPPED_CRIMSON_FENCE_GATE.get());

        block(ModBlocks.WARPED_HYPHAE_SLAB.get());
        block(ModBlocks.WARPED_HYPHAE_STAIRS.get());
        inventoryRender(ModBlocks.WARPED_HYPHAE_FENCE.get());
        block(ModBlocks.WARPED_HYPHAE_FENCE_GATE.get());

        block(ModBlocks.STRIPPED_WARPED_SLAB.get());
        block(ModBlocks.STRIPPED_WARPED_STAIRS.get());
        inventoryRender(ModBlocks.STRIPPED_WARPED_FENCE.get());
        block(ModBlocks.STRIPPED_WARPED_FENCE_GATE.get());
    }

    private ItemModelBuilder simpleItem(Item item) {
        return withExistingParent(item.getDescriptionId().replace("item.dlc.","").replace("block.dlc.", ""),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DLC.MOD_ID, "item/" + item.getDescriptionId().replace("item.dlc.","").replace("block.dlc.", "")));
    }

    private ItemModelBuilder handheldItem(Item item) {
        return withExistingParent(item.getDescriptionId().replace("item.dlc.",""),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(DLC.MOD_ID, "item/" + item.getDescriptionId().replace("item.dlc.","")));
    }

    private ItemModelBuilder block(Block block) {
        return withExistingParent(block.getDescriptionId().replace("block.dlc.", ""), DLC.MOD_ID + ":block/" + block.getDescriptionId().replace("block.dlc.", ""));
    }

    private ItemModelBuilder itemLikeBlock(Block block) {
        return withExistingParent(block.getDescriptionId().replace("block.dlc.",""),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DLC.MOD_ID, "block/" + block.getDescriptionId().replace("block.dlc.","")));
    }

    private ItemModelBuilder inventoryRender(Block block) {
        return withExistingParent(block.getDescriptionId().replace("block.dlc.", ""), DLC.MOD_ID + ":block/" + block.getDescriptionId().replace("block.dlc.", "") + "_inventory");
    }

    private ItemModelBuilder trapdoor(Block block) {
        return withExistingParent(block.getDescriptionId().replace("block.dlc.", ""), DLC.MOD_ID + ":block/" + block.getDescriptionId().replace("block.dlc.", "") + "_bottom");
    }

    private ItemModelBuilder waxedCopper(Block block, Block unwaxed) {
        return withExistingParent(block.getDescriptionId().replace("block.dlc.", ""), DLC.MOD_ID + ":block/" + unwaxed.getDescriptionId().replace("block.dlc.", "") + "_inventory");
    }
}
