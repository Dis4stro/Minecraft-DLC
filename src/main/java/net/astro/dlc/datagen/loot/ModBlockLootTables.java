package net.astro.dlc.datagen.loot;

import net.astro.dlc.blocks.ModBlocks;
import net.astro.dlc.item.ModItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {

    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    protected static LootTable.Builder createTomatoDrops(Block pCropBlock, Item pMatureCropItem, Item pHalfMatureCropItem, Item pUnripeCropItem, Item pSeedsItem, LootItemCondition.Builder pDropMatureCropCondition, LootItemCondition.Builder pDropHalfMatureCropCondition, LootItemCondition.Builder pDropUnripeCropCondition) {

        return applyExplosionDecay(pCropBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pMatureCropItem).when(pDropMatureCropCondition)))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(pHalfMatureCropItem).when(pDropHalfMatureCropCondition)))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(pUnripeCropItem).when(pDropUnripeCropCondition)))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(pSeedsItem)))
                .withPool(LootPool.lootPool().when(pDropHalfMatureCropCondition).add(LootItem.lootTableItem(pSeedsItem).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.3F, 3))))
                .withPool(LootPool.lootPool().when(pDropMatureCropCondition).add(LootItem.lootTableItem(pSeedsItem).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3)))));
    }

    @Override
    protected void addTables() {
        this.dropSelf(ModBlocks.ALUMINIUM_BLOCK.get());
        this.add(ModBlocks.ALUMINIUM_ORE.get(), (block) -> createOreDrop(ModBlocks.ALUMINIUM_ORE.get(), ModItems.RAW_ALUMINIUM.get()));
        this.dropSelf(ModBlocks.BAOBAB_BUTTON.get());
        this.add(ModBlocks.BAOBAB_DOOR.get(), BlockLoot::createDoorTable);
        this.dropSelf(ModBlocks.BAOBAB_FENCE.get());
        this.dropSelf(ModBlocks.BAOBAB_FENCE_GATE.get());
        this.add(ModBlocks.BAOBAB_LEAVES.get(), (block) -> createLeavesDrops(ModBlocks.BAOBAB_LEAVES.get(), ModBlocks.BAOBAB_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(applyExplosionCondition(ModBlocks.BAOBAB_LEAVES.get(), LootItem.lootTableItem(ModItems.BAOBAB_FRUIT.get()))).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.025F, 0.35F, 0.4F, 0.5F))));
        this.dropSelf(ModBlocks.BAOBAB_LOG.get());
        this.dropSelf(ModBlocks.BAOBAB_PLANKS.get());
        this.dropSelf(ModBlocks.BAOBAB_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.BAOBAB_SAPLING.get());
        this.dropSelf(ModBlocks.BAOBAB_SIGN.get());
        this.add(ModBlocks.BAOBAB_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.BAOBAB_STAIRS.get());
        this.dropSelf(ModBlocks.BAOBAB_TRAPDOOR.get());
        this.dropSelf(ModBlocks.BAOBAB_WALL_SIGN.get());
        this.dropSelf(ModBlocks.BAOBAB_WOOD.get());
        this.dropSelf(ModBlocks.BRONZE_BLOCK.get());
        this.dropSelf(ModBlocks.BRONZE_BRICKS.get());
        this.add(ModBlocks.BRONZE_BRICK_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.BRONZE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.BRONZE_BRICK_WALL.get());
        this.add(ModBlocks.BRONZE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.BRONZE_STAIRS.get());
        this.dropSelf(ModBlocks.BRONZE_TILES.get());
        this.add(ModBlocks.BRONZE_TILE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.BRONZE_TILE_STAIRS.get());
        this.dropSelf(ModBlocks.BRONZE_TILE_WALL.get());
        this.dropSelf(ModBlocks.BRONZE_WALL.get());
        this.dropSelf(ModBlocks.CHISELES_BRONZE.get());
        this.dropSelf(ModBlocks.COPPER_WALL.get());
        this.dropSelf(ModBlocks.CRACKED_BRONZE_BRICKS.get());
        this.dropSelf(ModBlocks.CRACKED_BRONZE_TILES.get());
        this.add(ModBlocks.DEEPSLATE_ALUMINIUM_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_ALUMINIUM_ORE.get(), ModItems.RAW_ALUMINIUM.get()));
        this.add(ModBlocks.DEEPSLATE_TIN_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get()));
        this.dropSelf(ModBlocks.EXPOSED_COPPER_WALL.get());
        this.dropSelf(ModBlocks.LEVITATION_DANDELION.get());
        this.dropSelf(ModBlocks.OXIDIZED_COPPER_WALL.get());
        this.dropSelf(ModBlocks.POLISHED_ANDESITE_WALL.get());
        this.dropSelf(ModBlocks.POLISHED_DIORITE_WALL.get());
        this.dropSelf(ModBlocks.POLISHED_GRANITE_WALL.get());
        this.dropPottedContents(ModBlocks.POTTED_MATURE_DANDELION.get());
        this.dropSelf(ModBlocks.RAW_ALUMINIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_TIN_BLOCK.get());
        this.dropSelf(ModBlocks.STRIPPED_ACACIA_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_ACACIA_FENCE_GATE.get());
        this.dropSelf(ModBlocks.STRIPPED_BAOBAB_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_BAOBAB_FENCE_GATE.get());
        this.dropSelf(ModBlocks.STRIPPED_BAOBAB_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_BAOBAB_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_BIRCH_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_BIRCH_FENCE_GATE.get());
        this.dropSelf(ModBlocks.STRIPPED_DARK_OAK_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_DARK_OAK_FENCE_GATE.get());
        this.dropSelf(ModBlocks.STRIPPED_JUNGLE_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_JUNGLE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.STRIPPED_MANGROVE_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_MANGROVE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.STRIPPED_SPRUCE_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_SPRUCE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.TIN_BLOCK.get());
        this.add(ModBlocks.TIN_ORE.get(), (block) -> createOreDrop(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get()));

        LootItemCondition.Builder lootitemcondition$mature = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_PLANT.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        LootItemCondition.Builder lootitemcondition$half_mature = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_PLANT.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 6));
        LootItemCondition.Builder lootitemcondition$unripe = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_PLANT.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 5));

        this.add(ModBlocks.TOMATO_PLANT.get(), createTomatoDrops(ModBlocks.TOMATO_PLANT.get(), ModItems.MATURE_TOMATO.get(), ModItems.HALF_MATURE_TOMATO.get(), ModItems.UNRIPE_TOMATO.get(), ModItems.TOMATO_SEEDS.get(), lootitemcondition$mature, lootitemcondition$half_mature, lootitemcondition$unripe));
        this.dropSelf(ModBlocks.WAXED_COPPER_WALL.get());
        this.dropSelf(ModBlocks.WAXED_EXPOSED_COPPER_WALL.get());
        this.dropSelf(ModBlocks.WAXED_OXIDIZED_COPPER_WALL.get());
        this.dropSelf(ModBlocks.WAXED_WEATHERED_COPPER_WALL.get());
        this.dropSelf(ModBlocks.WEATHERED_COPPER_WALL.get());

        // Families

        this.add(ModBlocks.OAK_WOOD_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.OAK_WOOD_STAIRS.get());
        this.dropSelf(ModBlocks.OAK_WOOD_FENCE.get());
        this.dropSelf(ModBlocks.OAK_WOOD_FENCE_GATE.get());

        this.add(ModBlocks.STRIPPED_OAK_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.STRIPPED_OAK_STAIRS.get());
        this.dropSelf(ModBlocks.STRIPPED_OAK_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_OAK_FENCE_GATE.get());

        this.add(ModBlocks.BAOBAB_WOOD_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.BAOBAB_WOOD_STAIRS.get());
        this.dropSelf(ModBlocks.BAOBAB_WOOD_FENCE.get());
        this.dropSelf(ModBlocks.BAOBAB_WOOD_FENCE_GATE.get());

        this.add(ModBlocks.STRIPPED_BAOBAB_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.STRIPPED_BAOBAB_STAIRS.get());
        this.dropSelf(ModBlocks.STRIPPED_BAOBAB_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_BAOBAB_FENCE_GATE.get());

        this.add(ModBlocks.BIRCH_WOOD_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.BIRCH_WOOD_STAIRS.get());
        this.dropSelf(ModBlocks.BIRCH_WOOD_FENCE.get());
        this.dropSelf(ModBlocks.BIRCH_WOOD_FENCE_GATE.get());

        this.add(ModBlocks.STRIPPED_BIRCH_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.STRIPPED_BIRCH_STAIRS.get());
        this.dropSelf(ModBlocks.STRIPPED_BIRCH_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_BIRCH_FENCE_GATE.get());

        this.add(ModBlocks.SPRUCE_WOOD_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.SPRUCE_WOOD_STAIRS.get());
        this.dropSelf(ModBlocks.SPRUCE_WOOD_FENCE.get());
        this.dropSelf(ModBlocks.SPRUCE_WOOD_FENCE_GATE.get());

        this.add(ModBlocks.STRIPPED_SPRUCE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.STRIPPED_SPRUCE_STAIRS.get());
        this.dropSelf(ModBlocks.STRIPPED_SPRUCE_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_SPRUCE_FENCE_GATE.get());

        this.add(ModBlocks.DARK_OAK_WOOD_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.DARK_OAK_WOOD_STAIRS.get());
        this.dropSelf(ModBlocks.DARK_OAK_WOOD_FENCE.get());
        this.dropSelf(ModBlocks.DARK_OAK_WOOD_FENCE_GATE.get());

        this.add(ModBlocks.STRIPPED_DARK_OAK_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.STRIPPED_DARK_OAK_STAIRS.get());
        this.dropSelf(ModBlocks.STRIPPED_DARK_OAK_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_DARK_OAK_FENCE_GATE.get());

        this.add(ModBlocks.ACACIA_WOOD_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.ACACIA_WOOD_STAIRS.get());
        this.dropSelf(ModBlocks.ACACIA_WOOD_FENCE.get());
        this.dropSelf(ModBlocks.ACACIA_WOOD_FENCE_GATE.get());

        this.add(ModBlocks.STRIPPED_ACACIA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.STRIPPED_ACACIA_STAIRS.get());
        this.dropSelf(ModBlocks.STRIPPED_ACACIA_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_ACACIA_FENCE_GATE.get());

        this.add(ModBlocks.MANGROVE_WOOD_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.MANGROVE_WOOD_STAIRS.get());
        this.dropSelf(ModBlocks.MANGROVE_WOOD_FENCE.get());
        this.dropSelf(ModBlocks.MANGROVE_WOOD_FENCE_GATE.get());

        this.add(ModBlocks.STRIPPED_MANGROVE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.STRIPPED_MANGROVE_STAIRS.get());
        this.dropSelf(ModBlocks.STRIPPED_MANGROVE_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_MANGROVE_FENCE_GATE.get());

        this.add(ModBlocks.JUNGLE_WOOD_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.JUNGLE_WOOD_STAIRS.get());
        this.dropSelf(ModBlocks.JUNGLE_WOOD_FENCE.get());
        this.dropSelf(ModBlocks.JUNGLE_WOOD_FENCE_GATE.get());

        this.add(ModBlocks.STRIPPED_JUNGLE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.STRIPPED_JUNGLE_STAIRS.get());
        this.dropSelf(ModBlocks.STRIPPED_JUNGLE_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_JUNGLE_FENCE_GATE.get());

        this.add(ModBlocks.CRIMSON_HYPHAE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.CRIMSON_HYPHAE_STAIRS.get());
        this.dropSelf(ModBlocks.CRIMSON_HYPHAE_FENCE.get());
        this.dropSelf(ModBlocks.CRIMSON_HYPHAE_FENCE_GATE.get());

        this.add(ModBlocks.STRIPPED_CRIMSON_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.STRIPPED_CRIMSON_STAIRS.get());
        this.dropSelf(ModBlocks.STRIPPED_CRIMSON_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_CRIMSON_FENCE_GATE.get());

        this.add(ModBlocks.WARPED_HYPHAE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.WARPED_HYPHAE_STAIRS.get());
        this.dropSelf(ModBlocks.WARPED_HYPHAE_FENCE.get());
        this.dropSelf(ModBlocks.WARPED_HYPHAE_FENCE_GATE.get());

        this.add(ModBlocks.STRIPPED_WARPED_SLAB.get(), BlockLoot::createSlabItemTable);
        this.dropSelf(ModBlocks.STRIPPED_WARPED_STAIRS.get());
        this.dropSelf(ModBlocks.STRIPPED_WARPED_FENCE.get());
        this.dropSelf(ModBlocks.STRIPPED_WARPED_FENCE_GATE.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
