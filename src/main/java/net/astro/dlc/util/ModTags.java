package net.astro.dlc.util;

import net.astro.dlc.DLC;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> CHAINSAW_VALID_BLOCKS = tag("chainsaw_valid_blocks");
        public static final TagKey<Block> CHAINSAW_DESTROY_CONDITION_BLOCKS = tag("chainsaw_destroy_condition_blocks");
        public static final TagKey<Block> BAOBAB_LOGS = tag("baobab_logs");
        public static final TagKey<Block> NEEDS_BRONZE_TOOL = tag("needs_bronze_tool");

        // FORGE

        public static final TagKey<Block> WOODEN_BUTTONS = forgeTag("buttons/wooden");
        public static final TagKey<Block> WOODEN_DOOR = forgeTag("doors/wooden");
        public static final TagKey<Block> WOODEN_FENCE_GATES = forgeTag("fence_gates/wooden");
        public static final TagKey<Block> WOODEN_FENCES = forgeTag("fences/wooden");
        public static final TagKey<Block> ALUMINIUM_ORES = forgeTag("ores/aluminium_ores");
        public static final TagKey<Block> TIN_ORES = forgeTag("ores/tin_ores");
        public static final TagKey<Block> WOODEN_PRESSURE_PLATES = forgeTag("pressure_plates/wooden");
        public static final TagKey<Block> WOODEN_SLABS = forgeTag("slabs/wooden");
        public static final TagKey<Block> WOODEN_STAIRS = forgeTag("stairs/wooden");
        public static final TagKey<Block> WOODEN_TRAPDOORS = forgeTag("trapdoors/wooden");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(DLC.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

    }

    public static class Items {
        public static final TagKey<Item> BAOBAB_LOGS = tag("baobab_logs");

        // FORGE

        public static final TagKey<Item> WOODEN_BUTTONS = forgeTag("buttons/wooden");
        public static final TagKey<Item> WOODEN_DOOR = forgeTag("doors/wooden");
        public static final TagKey<Item> WOODEN_FENCE_GATES = forgeTag("fence_gates/wooden");
        public static final TagKey<Item> WOODEN_FENCES = forgeTag("fences/wooden");
        public static final TagKey<Item> ALUMINIUM_ORES = forgeTag("ores/aluminium_ores");
        public static final TagKey<Item> TIN_ORES = forgeTag("ores/tin_ores");
        public static final TagKey<Item> WOODEN_PRESSURE_PLATES = forgeTag("pressure_plates/wooden");
        public static final TagKey<Item> WOODEN_SLABS = forgeTag("slabs/wooden");
        public static final TagKey<Item> WOODEN_STAIRS = forgeTag("stairs/wooden");
        public static final TagKey<Item> WOODEN_TRAPDOORS = forgeTag("trapdoors/wooden");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(DLC.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
