package net.astro.dlc.item;

import net.astro.dlc.DLC;
import net.astro.dlc.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModTiers {
    public static final TagKey<Block> BRONZE_TIER_TAG = ModTags.Blocks.NEEDS_BRONZE_TOOL;

    public static final Tier BRONZE;

    static {
        BRONZE = TierSortingRegistry.registerTier(new ForgeTier(2, 650, 7.5f, 4.0f, 16,
                BRONZE_TIER_TAG, () -> Ingredient.of(ModItems.BRONZE_INGOT.get())),
                new ResourceLocation(DLC.MOD_ID, "bronze"),
                List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
    }

}
