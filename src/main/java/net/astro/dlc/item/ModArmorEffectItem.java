package net.astro.dlc.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModArmorEffectItem extends ArmorItem {
    private final MobEffectInstance armorEffect;
    private String tooltipPath = "tooltip.dlc.armor_effect.";

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable(this.tooltipPath));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public ModArmorEffectItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, MobEffectInstance pEffect, String tooltipPath,
                              Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
        this.armorEffect = pEffect;
        this.tooltipPath += tooltipPath;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(!level.isClientSide()){
            if(hasFullArmorOn(player)){
                if(hasCorrectArmorOn(player)){
                    boolean hasPlayerEffect = player.hasEffect(this.armorEffect.getEffect());
                    if(!hasPlayerEffect) {
                        player.addEffect(this.armorEffect);
                    }
                }
            }
        }
    }

    private boolean hasFullArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(Player player) {
        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == this.material && leggings.getMaterial() == this.material &&
                chestplate.getMaterial() == this.material && boots.getMaterial() == this.material;
    }
}
