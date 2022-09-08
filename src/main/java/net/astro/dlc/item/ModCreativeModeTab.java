package net.astro.dlc.item;

import net.astro.dlc.blocks.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {

    public static final CreativeModeTab DLC_TAB_BUILDING_BLOCKS = new CreativeModeTab("dlc_building_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.BRONZE_BRICKS.get());
        }
    };

    public static final CreativeModeTab DLC_TAB_DECORATIONS = new CreativeModeTab("dlc_decorations") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.LEVITATION_DANDELION.get());
        }
    };

    public static final CreativeModeTab DLC_TAB_REDSTONE = new CreativeModeTab("dlc_redstone") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.OAK_WOOD_FENCE_GATE.get());
        }
    };

    public static final CreativeModeTab DLC_TAB_MISC = new CreativeModeTab("dlc_misc") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.FLAMMABLE_DUST.get());
        }
    };

    public static final CreativeModeTab DLC_TAB_FOODS = new CreativeModeTab("dlc_foods") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MATURE_TOMATO.get());
        }
    };

    public static final CreativeModeTab DLC_TAB_TOOLS = new CreativeModeTab("dlc_tools") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BRONZE_PICKAXE.get());
        }
    };

    public static final CreativeModeTab DLC_TAB_COMBAT = new CreativeModeTab("dlc_combat") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.BRONZE_SWORD.get());
        }
    };
}
