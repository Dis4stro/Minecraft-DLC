package net.astro.dlc.datagen;

import com.google.common.collect.ImmutableList;
import net.astro.dlc.blocks.ModBlockFamilies;
import net.astro.dlc.blocks.ModBlocks;
import net.astro.dlc.item.ModItems;
import net.astro.dlc.util.ModTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    protected static final ImmutableList<ItemLike> ALUMINIUM_SMELTABLES = ImmutableList.of(ModBlocks.ALUMINIUM_ORE.get(), ModBlocks.DEEPSLATE_ALUMINIUM_ORE.get(), ModItems.RAW_ALUMINIUM.get());
    protected static final ImmutableList<ItemLike> TIN_SMELTABLES = ImmutableList.of(ModBlocks.TIN_ORE.get(), ModBlocks.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get());
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        ModBlockFamilies.getAllFamilies().forEach((family) -> {
            generateRecipes(pFinishedRecipeConsumer, family);
        });

        ShapedRecipeBuilder.shaped(ModBlocks.BRONZE_BLOCK.get()).define('B', ModItems.BRONZE_INGOT.get())
                .pattern("BB")
                .pattern("BB")
                .unlockedBy("has_bronze_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.BRONZE_INGOT.get()).build()))
                .save(pFinishedRecipeConsumer);

        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.OAK_SLAB, ModBlocks.OAK_WOOD_SLAB.get(), ModBlocks.STRIPPED_OAK_SLAB.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.OAK_STAIRS, ModBlocks.OAK_WOOD_STAIRS.get(), ModBlocks.STRIPPED_OAK_STAIRS.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.OAK_FENCE, ModBlocks.OAK_WOOD_FENCE.get(), ModBlocks.STRIPPED_OAK_FENCE.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.OAK_FENCE_GATE, ModBlocks.OAK_WOOD_FENCE_GATE.get(), ModBlocks.STRIPPED_OAK_FENCE_GATE.get());

        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.BIRCH_SLAB, ModBlocks.BIRCH_WOOD_SLAB.get(), ModBlocks.STRIPPED_BIRCH_SLAB.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.BIRCH_STAIRS, ModBlocks.BIRCH_WOOD_STAIRS.get(), ModBlocks.STRIPPED_BIRCH_STAIRS.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.BIRCH_FENCE, ModBlocks.BIRCH_WOOD_FENCE.get(), ModBlocks.STRIPPED_BIRCH_FENCE.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.BIRCH_FENCE_GATE, ModBlocks.BIRCH_WOOD_FENCE_GATE.get(), ModBlocks.STRIPPED_BIRCH_FENCE_GATE.get());

        planksBlockFromRaw(pFinishedRecipeConsumer, ModBlocks.BAOBAB_SLAB.get(), ModBlocks.BAOBAB_WOOD_SLAB.get(), ModBlocks.STRIPPED_BAOBAB_SLAB.get());
        planksBlockFromRaw(pFinishedRecipeConsumer, ModBlocks.BAOBAB_STAIRS.get(), ModBlocks.BAOBAB_WOOD_STAIRS.get(), ModBlocks.STRIPPED_BAOBAB_STAIRS.get());
        planksBlockFromRaw(pFinishedRecipeConsumer, ModBlocks.BAOBAB_FENCE.get(), ModBlocks.BAOBAB_WOOD_FENCE.get(), ModBlocks.STRIPPED_BAOBAB_FENCE.get());
        planksBlockFromRaw(pFinishedRecipeConsumer, ModBlocks.BAOBAB_FENCE_GATE.get(), ModBlocks.BAOBAB_WOOD_FENCE_GATE.get(), ModBlocks.STRIPPED_BAOBAB_FENCE_GATE.get());

        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.ACACIA_SLAB, ModBlocks.ACACIA_WOOD_SLAB.get(), ModBlocks.STRIPPED_ACACIA_SLAB.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.ACACIA_STAIRS, ModBlocks.ACACIA_WOOD_STAIRS.get(), ModBlocks.STRIPPED_ACACIA_STAIRS.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.ACACIA_FENCE, ModBlocks.ACACIA_WOOD_FENCE.get(), ModBlocks.STRIPPED_ACACIA_FENCE.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.ACACIA_FENCE_GATE, ModBlocks.ACACIA_WOOD_FENCE_GATE.get(), ModBlocks.STRIPPED_ACACIA_FENCE_GATE.get());

        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.SPRUCE_SLAB, ModBlocks.SPRUCE_WOOD_SLAB.get(), ModBlocks.STRIPPED_SPRUCE_SLAB.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.SPRUCE_STAIRS, ModBlocks.SPRUCE_WOOD_STAIRS.get(), ModBlocks.STRIPPED_SPRUCE_STAIRS.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.SPRUCE_FENCE, ModBlocks.SPRUCE_WOOD_FENCE.get(), ModBlocks.STRIPPED_SPRUCE_FENCE.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.SPRUCE_FENCE_GATE, ModBlocks.SPRUCE_WOOD_FENCE_GATE.get(), ModBlocks.STRIPPED_SPRUCE_FENCE_GATE.get());

        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.MANGROVE_SLAB, ModBlocks.MANGROVE_WOOD_SLAB.get(), ModBlocks.STRIPPED_MANGROVE_SLAB.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.MANGROVE_STAIRS, ModBlocks.MANGROVE_WOOD_STAIRS.get(), ModBlocks.STRIPPED_MANGROVE_STAIRS.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.MANGROVE_FENCE, ModBlocks.MANGROVE_WOOD_FENCE.get(), ModBlocks.STRIPPED_MANGROVE_FENCE.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.MANGROVE_FENCE_GATE, ModBlocks.MANGROVE_WOOD_FENCE_GATE.get(), ModBlocks.STRIPPED_MANGROVE_FENCE_GATE.get());

        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.JUNGLE_SLAB, ModBlocks.JUNGLE_WOOD_SLAB.get(), ModBlocks.STRIPPED_JUNGLE_SLAB.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.JUNGLE_STAIRS, ModBlocks.JUNGLE_WOOD_STAIRS.get(), ModBlocks.STRIPPED_JUNGLE_STAIRS.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.JUNGLE_FENCE, ModBlocks.JUNGLE_WOOD_FENCE.get(), ModBlocks.STRIPPED_JUNGLE_FENCE.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.JUNGLE_FENCE_GATE, ModBlocks.JUNGLE_WOOD_FENCE_GATE.get(), ModBlocks.STRIPPED_JUNGLE_FENCE_GATE.get());

        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.DARK_OAK_SLAB, ModBlocks.DARK_OAK_WOOD_SLAB.get(), ModBlocks.STRIPPED_DARK_OAK_SLAB.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.DARK_OAK_STAIRS, ModBlocks.DARK_OAK_WOOD_STAIRS.get(), ModBlocks.STRIPPED_DARK_OAK_STAIRS.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.DARK_OAK_FENCE, ModBlocks.DARK_OAK_WOOD_FENCE.get(), ModBlocks.STRIPPED_DARK_OAK_FENCE.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.DARK_OAK_FENCE_GATE, ModBlocks.DARK_OAK_WOOD_FENCE_GATE.get(), ModBlocks.STRIPPED_DARK_OAK_FENCE_GATE.get());

        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.CRIMSON_SLAB, ModBlocks.CRIMSON_HYPHAE_SLAB.get(), ModBlocks.STRIPPED_CRIMSON_SLAB.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.CRIMSON_STAIRS, ModBlocks.CRIMSON_HYPHAE_STAIRS.get(), ModBlocks.STRIPPED_CRIMSON_STAIRS.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.CRIMSON_FENCE, ModBlocks.CRIMSON_HYPHAE_FENCE.get(), ModBlocks.STRIPPED_CRIMSON_FENCE.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.CRIMSON_FENCE_GATE, ModBlocks.CRIMSON_HYPHAE_FENCE_GATE.get(), ModBlocks.STRIPPED_CRIMSON_FENCE_GATE.get());

        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.WARPED_SLAB, ModBlocks.WARPED_HYPHAE_SLAB.get(), ModBlocks.STRIPPED_WARPED_SLAB.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.WARPED_STAIRS, ModBlocks.WARPED_HYPHAE_STAIRS.get(), ModBlocks.STRIPPED_WARPED_STAIRS.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.WARPED_FENCE, ModBlocks.WARPED_HYPHAE_FENCE.get(), ModBlocks.STRIPPED_WARPED_FENCE.get());
        MC$planksBlockFromRaw(pFinishedRecipeConsumer, Blocks.WARPED_FENCE_GATE, ModBlocks.WARPED_HYPHAE_FENCE_GATE.get(), ModBlocks.STRIPPED_WARPED_FENCE_GATE.get());

        woodFromLogs(pFinishedRecipeConsumer, ModBlocks.STRIPPED_BAOBAB_WOOD.get(), ModBlocks.STRIPPED_BAOBAB_LOG.get());
        woodFromLogs(pFinishedRecipeConsumer, ModBlocks.BAOBAB_WOOD.get(), ModBlocks.BAOBAB_LOG.get());
        planksFromLog(pFinishedRecipeConsumer, ModBlocks.BAOBAB_PLANKS.get(), ModTags.Items.BAOBAB_LOGS);
        nineBlockStorageRecipesRecipesWithCustomUnpacking(pFinishedRecipeConsumer, ModItems.ALUMINIUM_INGOT.get(), ModBlocks.ALUMINIUM_BLOCK.get(), "aluminium_ingot_from_aluminium_block", "aluminium_ingot");
        nineBlockStorageRecipesRecipesWithCustomUnpacking(pFinishedRecipeConsumer, ModItems.TIN_INGOT.get(), ModBlocks.TIN_BLOCK.get(), "tin_ingot_from_tin_block", "tin_ingot");
        ShapelessRecipeBuilder.shapeless(ModItems.BRONZE_INGOT.get(), 4).requires(ModBlocks.BRONZE_BLOCK.get()).group("bronze_ingot").unlockedBy("has_bronze_block", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.BRONZE_BLOCK.get()).build())).save(pFinishedRecipeConsumer);
        nineBlockStorageRecipes(pFinishedRecipeConsumer, ModItems.RAW_ALUMINIUM.get(), ModBlocks.RAW_ALUMINIUM_BLOCK.get());
        nineBlockStorageRecipes(pFinishedRecipeConsumer, ModItems.RAW_TIN.get(), ModBlocks.RAW_TIN_BLOCK.get());
        nineBlockStorageRecipesWithCustomPacking(pFinishedRecipeConsumer, ModItems.ALUMINIUM_NUGGET.get(), ModItems.ALUMINIUM_INGOT.get(), "aluminium_ingot_from_nuggets", "aluminium_ingot");
        nineBlockStorageRecipesWithCustomPacking(pFinishedRecipeConsumer, ModItems.TIN_NUGGET.get(), ModItems.TIN_INGOT.get(), "tin_ingot_from_nuggets", "tin_ingot");
        nineBlockStorageRecipesWithCustomPacking(pFinishedRecipeConsumer, ModItems.BRONZE_NUGGET.get(), ModItems.BRONZE_INGOT.get(), "bronze_ingot_from_nuggets", "bronze_ingot");
        nineBlockStorageRecipesWithCustomPacking(pFinishedRecipeConsumer, ModItems.COPPER_NUGGET.get(), Items.COPPER_INGOT, "copper_ingot_from_nuggets", "copper_ingot");

        // TOOLS & ARMORS

        ShapedRecipeBuilder.shaped(Items.LEATHER_HORSE_ARMOR).define('L', Items.LEATHER).define('C', ItemTags.WOOL_CARPETS)
                .pattern("  L")
                .pattern("LCL")
                .pattern("LLL")
                .unlockedBy("has_leather", has(Items.LEATHER))
                .unlockedBy("has_wool_carpet", has(ItemTags.WOOL_CARPETS))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(Items.IRON_HORSE_ARMOR).define('I', Items.IRON_INGOT).define('C', ItemTags.WOOL_CARPETS)
                .pattern("  I")
                .pattern("ICI")
                .pattern("III")
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_wool_carpet", has(ItemTags.WOOL_CARPETS))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(Items.GOLDEN_HORSE_ARMOR).define('G', Items.GOLD_INGOT).define('C', ItemTags.WOOL_CARPETS)
                .pattern("  G")
                .pattern("GCG")
                .pattern("GGG")
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .unlockedBy("has_wool_carpet", has(ItemTags.WOOL_CARPETS))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(Items.DIAMOND_HORSE_ARMOR).define('D', Items.DIAMOND).define('C', ItemTags.WOOL_CARPETS)
                .pattern("  D")
                .pattern("DCD")
                .pattern("DDD")
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .unlockedBy("has_wool_carpet", has(ItemTags.WOOL_CARPETS))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.CHAINSAW.get())
                .define('C', Items.CHAIN).define('I', Items.IRON_INGOT).define('A', ModItems.ALUMINIUM_INGOT.get()).define('R', Items.REDSTONE_TORCH)
                .pattern("ICC")
                .pattern("RAA")
                .pattern("ICC")
                .unlockedBy("has_aluminium_ingot", has(ModItems.ALUMINIUM_INGOT.get()))
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_chain", has(Items.CHAIN))
                .unlockedBy("has_redstone_torch", has(Items.REDSTONE_TORCH)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.BRONZE_AXE.get()).define('S', Items.STICK).define('B', ModItems.BRONZE_INGOT.get())
                .pattern("BB")
                .pattern("BS")
                .pattern(" S").unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.BRONZE_HOE.get()).define('S', Items.STICK).define('B', ModItems.BRONZE_INGOT.get())
                .pattern("BB")
                .pattern(" S")
                .pattern(" S").unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.BRONZE_PICKAXE.get()).define('S', Items.STICK).define('B', ModItems.BRONZE_INGOT.get())
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ").unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.BRONZE_SHOVEL.get()).define('S', Items.STICK).define('B', ModItems.BRONZE_INGOT.get())
                .pattern("B")
                .pattern("S")
                .pattern("S").unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.BRONZE_SWORD.get()).define('S', Items.STICK).define('B', ModItems.BRONZE_INGOT.get())
                .pattern("B")
                .pattern("B")
                .pattern("S").unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.BRONZE_HELMET.get()).define('B', ModItems.BRONZE_INGOT.get())
                .pattern("BBB")
                .pattern("B B")
                .unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.BRONZE_CHESTPLATE.get()).define('B', ModItems.BRONZE_INGOT.get())
                .pattern("B B")
                .pattern("BBB")
                .pattern("BBB").unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.BRONZE_LEGGINGS.get()).define('B', ModItems.BRONZE_INGOT.get())
                .pattern("BBB")
                .pattern("B B")
                .pattern("B B").unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.BRONZE_BOOTS.get()).define('B', ModItems.BRONZE_INGOT.get())
                .pattern("B B")
                .pattern("B B").unlockedBy("has_bronze_ingot", has(ModItems.BRONZE_INGOT.get())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModItems.CHAINMAIL_HORSE_ARMOR.get()).define('H', Items.CHAIN).define('C', ItemTags.WOOL_CARPETS)
                .pattern("  H")
                .pattern("HCH")
                .pattern("HHH")
                .unlockedBy("has_chain", has(Items.CHAIN))
                .unlockedBy("has_wool_carpet", has(ItemTags.WOOL_CARPETS))
                .save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(Items.CHAINMAIL_HELMET).define('C', Items.CHAIN)
                .pattern("CCC")
                .pattern("C C").unlockedBy("has_chain", has(Items.CHAIN)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(Items.CHAINMAIL_CHESTPLATE).define('C', Items.CHAIN)
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC").unlockedBy("has_chain", has(Items.CHAIN)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(Items.CHAINMAIL_LEGGINGS).define('C', Items.CHAIN)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C").unlockedBy("has_chain", has(Items.CHAIN)).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(Items.CHAINMAIL_BOOTS).define('C', Items.CHAIN)
                .pattern("C C")
                .pattern("C C").unlockedBy("has_chain", has(Items.CHAIN)).save(pFinishedRecipeConsumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WAXED_COPPER_WALL.get()).requires(ModBlocks.COPPER_WALL.get()).requires(Items.HONEYCOMB).group("waxed_copper_wall").unlockedBy("has_copper_wall", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.COPPER_WALL.get()).build())).save(pFinishedRecipeConsumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WAXED_EXPOSED_COPPER_WALL.get()).requires(ModBlocks.EXPOSED_COPPER_WALL.get()).requires(Items.HONEYCOMB).group("waxed_exposed_copper_wall").unlockedBy("has_exposed_copper_wall", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.EXPOSED_COPPER_WALL.get()).build())).save(pFinishedRecipeConsumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WAXED_WEATHERED_COPPER_WALL.get()).requires(ModBlocks.WEATHERED_COPPER_WALL.get()).requires(Items.HONEYCOMB).group("waxed_weathered_copper_wall").unlockedBy("has_weathered_copper_wall", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.WEATHERED_COPPER_WALL.get()).build())).save(pFinishedRecipeConsumer);
        ShapelessRecipeBuilder.shapeless(ModBlocks.WAXED_OXIDIZED_COPPER_WALL.get()).requires(ModBlocks.OXIDIZED_COPPER_WALL.get()).requires(Items.HONEYCOMB).group("waxed_oxidized_copper_wall").unlockedBy("has_oxidized_copper_wall", inventoryTrigger(ItemPredicate.Builder.item().of(ModBlocks.OXIDIZED_COPPER_WALL.get()).build())).save(pFinishedRecipeConsumer);

        // STONECUTTER

        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.POLISHED_ANDESITE_WALL.get(), Blocks.POLISHED_ANDESITE);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.POLISHED_DIORITE_WALL.get(), Blocks.POLISHED_DIORITE);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.POLISHED_GRANITE_WALL.get(), Blocks.POLISHED_GRANITE);

        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.COPPER_WALL.get(), Blocks.COPPER_BLOCK);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.EXPOSED_COPPER_WALL.get(), Blocks.EXPOSED_COPPER);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.WEATHERED_COPPER_WALL.get(), Blocks.WEATHERED_COPPER);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.OXIDIZED_COPPER_WALL.get(), Blocks.OXIDIZED_COPPER);

        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.WAXED_COPPER_WALL.get(), Blocks.POLISHED_DIORITE);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.WAXED_EXPOSED_COPPER_WALL.get(), Blocks.WAXED_EXPOSED_COPPER);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.WAXED_WEATHERED_COPPER_WALL.get(), Blocks.WAXED_WEATHERED_COPPER);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.WAXED_OXIDIZED_COPPER_WALL.get(), Blocks.WAXED_OXIDIZED_COPPER);

        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_WALL.get(), ModBlocks.BRONZE_BLOCK.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_SLAB.get(), ModBlocks.BRONZE_BLOCK.get(), 2);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_STAIRS.get(), ModBlocks.BRONZE_BLOCK.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_BRICKS.get(), ModBlocks.BRONZE_BLOCK.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_BRICK_SLAB.get(), ModBlocks.BRONZE_BLOCK.get(), 2);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_BRICK_STAIRS.get(), ModBlocks.BRONZE_BLOCK.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_BRICK_WALL.get(), ModBlocks.BRONZE_BLOCK.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_TILES.get(), ModBlocks.BRONZE_BLOCK.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_TILE_SLAB.get(), ModBlocks.BRONZE_BLOCK.get(), 2);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_TILE_STAIRS.get(), ModBlocks.BRONZE_BLOCK.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_TILE_WALL.get(), ModBlocks.BRONZE_BLOCK.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.CHISELES_BRONZE.get(), ModBlocks.BRONZE_BLOCK.get());

        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_BRICK_SLAB.get(), ModBlocks.BRONZE_BRICKS.get(), 2);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_BRICK_STAIRS.get(), ModBlocks.BRONZE_BRICKS.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_BRICK_WALL.get(), ModBlocks.BRONZE_BRICKS.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_TILES.get(), ModBlocks.BRONZE_BRICKS.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_TILE_SLAB.get(), ModBlocks.BRONZE_BRICKS.get(), 2);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_TILE_STAIRS.get(), ModBlocks.BRONZE_BRICKS.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_TILE_WALL.get(), ModBlocks.BRONZE_BRICKS.get());

        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_TILE_SLAB.get(), ModBlocks.BRONZE_TILES.get(), 2);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_TILE_STAIRS.get(), ModBlocks.BRONZE_TILES.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.BRONZE_TILE_WALL.get(), ModBlocks.BRONZE_TILES.get());

        // SMELTING & BLASTING

        oreSmelting(pFinishedRecipeConsumer, ALUMINIUM_SMELTABLES, ModItems.ALUMINIUM_INGOT.get(), 0.7F,200, "aluminium_ingot");
        oreBlasting(pFinishedRecipeConsumer, ALUMINIUM_SMELTABLES, ModItems.ALUMINIUM_INGOT.get(), 0.7F,100, "aluminium_ingot");
        oreSmelting(pFinishedRecipeConsumer, TIN_SMELTABLES, ModItems.TIN_INGOT.get(), 0.5F,200, "tin_ingot");
        oreBlasting(pFinishedRecipeConsumer, TIN_SMELTABLES, ModItems.TIN_INGOT.get(), 0.5F,100, "tin_ingot");
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.BRONZE_PICKAXE.get(), ModItems.BRONZE_SHOVEL.get(), ModItems.BRONZE_AXE.get(), ModItems.BRONZE_HOE.get(), ModItems.BRONZE_SWORD.get(), ModItems.BRONZE_HELMET.get(), ModItems.BRONZE_CHESTPLATE.get(), ModItems.BRONZE_LEGGINGS.get(), ModItems.BRONZE_BOOTS.get(), ModItems.BRONZE_HORSE_ARMOR.get()), ModItems.BRONZE_NUGGET.get(), 0.1F, 200).unlockedBy("has_bronze_pickaxe", has(ModItems.BRONZE_PICKAXE.get())).unlockedBy("has_bronze_shovel", has(ModItems.BRONZE_SHOVEL.get())).unlockedBy("has_bronze_axe", has(ModItems.BRONZE_AXE.get())).unlockedBy("has_bronze_hoe", has(ModItems.BRONZE_HOE.get())).unlockedBy("has_bronze_sword", has(ModItems.BRONZE_SWORD.get())).unlockedBy("has_bronze_helmet", has(ModItems.BRONZE_HELMET.get())).unlockedBy("has_bronze_chestplate", has(ModItems.BRONZE_CHESTPLATE.get())).unlockedBy("has_bronze_leggings", has(ModItems.BRONZE_LEGGINGS.get())).unlockedBy("has_bronze_boots", has(ModItems.BRONZE_BOOTS.get())).unlockedBy("has_bronze_horse_armor", has(ModItems.BRONZE_HORSE_ARMOR.get())).save(pFinishedRecipeConsumer, getSmeltingRecipeName(ModItems.BRONZE_NUGGET.get()));
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(ModItems.BRONZE_PICKAXE.get(), ModItems.BRONZE_SHOVEL.get(), ModItems.BRONZE_AXE.get(), ModItems.BRONZE_HOE.get(), ModItems.BRONZE_SWORD.get(), ModItems.BRONZE_HELMET.get(), ModItems.BRONZE_CHESTPLATE.get(), ModItems.BRONZE_LEGGINGS.get(), ModItems.BRONZE_BOOTS.get(), ModItems.BRONZE_HORSE_ARMOR.get()), ModItems.BRONZE_NUGGET.get(), 0.1F, 100).unlockedBy("has_bronze_pickaxe", has(ModItems.BRONZE_PICKAXE.get())).unlockedBy("has_bronze_shovel", has(ModItems.BRONZE_SHOVEL.get())).unlockedBy("has_bronze_axe", has(ModItems.BRONZE_AXE.get())).unlockedBy("has_bronze_hoe", has(ModItems.BRONZE_HOE.get())).unlockedBy("has_bronze_sword", has(ModItems.BRONZE_SWORD.get())).unlockedBy("has_bronze_helmet", has(ModItems.BRONZE_HELMET.get())).unlockedBy("has_bronze_chestplate", has(ModItems.BRONZE_CHESTPLATE.get())).unlockedBy("has_bronze_leggings", has(ModItems.BRONZE_LEGGINGS.get())).unlockedBy("has_bronze_boots", has(ModItems.BRONZE_BOOTS.get())).unlockedBy("has_bronze_horse_armor", has(ModItems.BRONZE_HORSE_ARMOR.get())).save(pFinishedRecipeConsumer, getBlastingRecipeName(ModItems.BRONZE_NUGGET.get()));

        // SMITHING

        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.COPPER_INGOT), Ingredient.of(ModItems.TIN_INGOT.get()), ModItems.BRONZE_INGOT.get()).unlocks("has_tin_ingot", has(ModItems.TIN_INGOT.get())).save(pFinishedRecipeConsumer, getRegistryName(ModItems.BRONZE_INGOT.get()) + "_smithing");
        UpgradeRecipeBuilder.smithing(Ingredient.of(ModItems.COPPER_NUGGET.get()), Ingredient.of(ModItems.TIN_NUGGET.get()), ModItems.BRONZE_NUGGET.get()).unlocks("has_tin_nugget", has(ModItems.TIN_NUGGET.get())).save(pFinishedRecipeConsumer, getRegistryName(ModItems.BRONZE_NUGGET.get()) + "_smithing");
        UpgradeRecipeBuilder.smithing(Ingredient.of(Items.DIAMOND_HORSE_ARMOR), Ingredient.of(Items.NETHERITE_INGOT), ModItems.NETHERITE_HORSE_ARMOR.get()).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(pFinishedRecipeConsumer, getRegistryName(ModItems.NETHERITE_HORSE_ARMOR.get()) + "_smithing");
    }

    private static void planksBlockFromRaw(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike planks, ItemLike wood, ItemLike stripped){
        ShapelessRecipeBuilder.shapeless(planks, 4).requires(wood).group(getMCRegistryName(wood.asItem())).unlockedBy("has_ " + getRegistryName(wood.asItem()), inventoryTrigger(ItemPredicate.Builder.item().of(wood).build())).save(pFinishedRecipeConsumer, getRegistryName(planks.asItem()) + "_from_" + getRegistryName(wood.asItem()));
        ShapelessRecipeBuilder.shapeless(planks, 4).requires(stripped).group(getMCRegistryName(stripped.asItem())).unlockedBy("has_ " + getRegistryName(stripped.asItem()), inventoryTrigger(ItemPredicate.Builder.item().of(stripped).build())).save(pFinishedRecipeConsumer, getRegistryName(planks.asItem()) + "_from_" + getRegistryName(stripped.asItem()));
    }
    private static void MC$planksBlockFromRaw(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike planks, ItemLike wood, ItemLike stripped){
        ShapelessRecipeBuilder.shapeless(planks, 4).requires(wood).group(getRegistryName(wood.asItem())).unlockedBy("has_ " + getRegistryName(wood.asItem()), inventoryTrigger(ItemPredicate.Builder.item().of(wood).build())).save(pFinishedRecipeConsumer, getMCRegistryName(planks.asItem()) + "_from_" + getRegistryName(wood.asItem()));
        ShapelessRecipeBuilder.shapeless(planks, 4).requires(stripped).group(getRegistryName(stripped.asItem())).unlockedBy("has_ " + getRegistryName(stripped.asItem()), inventoryTrigger(ItemPredicate.Builder.item().of(stripped).build())).save(pFinishedRecipeConsumer, getMCRegistryName(planks.asItem()) + "_from_" + getRegistryName(stripped.asItem()));
    }
    private static String getRegistryName(Item item){
        String fullName = item.getDescriptionId();
        return fullName.contains("block") ?
                item.getDescriptionId().replace("block.dlc.", "")
                :
                item.getDescriptionId().replace("item.dlc.", "") ;
    }
    private static String getMCRegistryName(Item item) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }


}
