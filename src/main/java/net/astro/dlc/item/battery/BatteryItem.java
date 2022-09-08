package net.astro.dlc.item.battery;

import net.astro.dlc.item.battery.batteries.MasterBattery;
import net.astro.dlc.sound.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.DecimalFormat;
import java.util.List;

public class BatteryItem extends Item {

    private final int maxEnergy;
    private static final int MIN_ENERGY = 0;
    private static final String ENERGY_NBT_TAG = "energy";
    private MasterBattery BATTERY;

    public BatteryItem(Properties pProperties, BatteryProperties pBatteryProperties) {
        super(pProperties);
        this.maxEnergy = pBatteryProperties.maxEnergy;
    }

    public int getMaxEnergy(){
        return this.maxEnergy;
    }

    public int getMinEnergy(){
        return MIN_ENERGY;
    }

    public float getBatteryPercent(ItemStack pStack){
        float batteryPercent = ((float)getEnergy(pStack)/(float)getMaxEnergy())*100;
        batteryPercent = Math.round(batteryPercent*100);
        return batteryPercent/100;
    }

    public String getBatteryPercentAsString(ItemStack pStack){
        float batteryPercent = ((float)getEnergy(pStack)/(float)getMaxEnergy())*100;
        DecimalFormat df = new DecimalFormat("##0.00");
        return df.format(batteryPercent) + "%";
    }

    public void increaseEnergy(ItemStack itemStack, int amount){
        CompoundTag nbt = itemStack.hasTag() ? itemStack.getTag() : new CompoundTag();
        assert nbt != null;
        nbt.putInt(ENERGY_NBT_TAG, Math.min(nbt.getInt(ENERGY_NBT_TAG) + amount, this.maxEnergy));
        itemStack.setTag(nbt);
    }

    public void decreaseEnergy(Player player, ItemStack itemStack, int amount){
        CompoundTag nbt = itemStack.hasTag() ? itemStack.getTag() : new CompoundTag();
        assert nbt != null;
        nbt.putInt(ENERGY_NBT_TAG, Math.max(nbt.getInt(ENERGY_NBT_TAG) - amount, MIN_ENERGY));
        itemStack.setTag(nbt);
        tryToPlaySound(player, itemStack);
    }

    public void setEnergy(ItemStack itemStack, int newEnergyValue){
        if(newEnergyValue > 0) {
            CompoundTag nbt = itemStack.hasTag() ? itemStack.getTag() : new CompoundTag();
            assert nbt != null;
            nbt.putInt(ENERGY_NBT_TAG, Math.min(newEnergyValue, this.maxEnergy));
            itemStack.setTag(nbt);
        }
    }

    public int getEnergy(ItemStack itemStack){
        if (itemStack.hasTag()) {
            assert itemStack.getTag() != null;
            return itemStack.getTag().getInt(ENERGY_NBT_TAG);
        } else {
            return 0;
        }
    }

    private boolean shouldDisplayDamage(ItemStack pStack){
        if(pStack.getMaxDamage() > 0){
            return this.getEnergy(pStack) <= 0;
        } else {
            return false;
        }
    }

    private void tryToPlaySound(Player player, ItemStack pStack){
        if(getEnergy(pStack) == 0){
            player.getLevel().playSound(player, player.getX(), player.getY(), player.getZ(), ModSounds.BATTERY_DIED.get(),
                    SoundSource.BLOCKS, 1f, 1f);
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        if(pStack.hasTag()){
            assert pStack.getTag() != null;
            if(pStack.getTag().contains(ENERGY_NBT_TAG)){
                pTooltipComponents.add(Component.translatable("tooltip.dlc.battery_item.energy", getBatteryPercentAsString(pStack))
                        .setStyle(Style.EMPTY.applyFormat(getDisplayColor(pStack))));
            }
        }
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public void onCraftedBy(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull Player pPlayer) {
        super.onCraftedBy(pStack, pLevel, pPlayer);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        if(pStack.hasTag()){
            assert pStack.getTag() != null;
            if(!pStack.getTag().contains(ENERGY_NBT_TAG)){
                setEnergy(pStack, this.maxEnergy);
            }
        } else {
            setEnergy(pStack, this.maxEnergy);
        }
        return this.getEnergy(pStack) != 0;
    }

    @Override
    public boolean isBarVisible(@NotNull ItemStack pStack) {
        if(shouldDisplayDamage(pStack)){
            return pStack.isDamaged();
        } else {
            return this.getEnergy(pStack) < this.getMaxEnergy();
        }
    }

    @Override
    public int getBarWidth(@NotNull ItemStack pStack) {
        if(shouldDisplayDamage(pStack)) {
            return Math.round(13.0F - (float) pStack.getDamageValue() * 13.0F / (float) this.getMaxDamage(pStack));
        } else {
            return Math.round(13.0F - (float)(this.getMaxEnergy() - this.getEnergy(pStack)) * 13.0F / (float)this.getMaxEnergy());
        }
    }

    @Override
    public int getBarColor(@NotNull ItemStack pStack) {
        float f;
        if(shouldDisplayDamage(pStack)){
            f = Math.max(0.0F, ((float)this.getMaxDamage(pStack) - (float)pStack.getDamageValue()) / this.getMaxDamage(pStack));
        } else {
            f = Math.max(0.0F, ((float)this.getMaxEnergy() - (float)(this.getMaxEnergy() - this.getEnergy(pStack))) / this.getMaxEnergy());
        }
        return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack pStack, @NotNull BlockState pState) {
        return 2.5f;
    }

    public void displayCurrentEnergy(Player player){
        ItemStack stack = player.getItemInHand(player.getUsedItemHand());
        player.displayClientMessage(Component.translatable("tooltip.dlc.battery_item.energy", getBatteryPercentAsString(stack))
                .setStyle(Style.EMPTY.applyFormat(getDisplayColor(stack))), true);
    }

    public ChatFormatting getDisplayColor(ItemStack pStack){
        float batteryPercent = getBatteryPercent(pStack);
        if(batteryPercent >= 5){
            if(batteryPercent >= 15){
                if(batteryPercent >= 30){
                    if(batteryPercent >= 50){
                        if(batteryPercent >= 75){
                            return ChatFormatting.DARK_GREEN;
                        } else {
                            return ChatFormatting.GREEN;
                        }
                    } else {
                        return ChatFormatting.YELLOW;
                    }
                } else {
                    return ChatFormatting.GOLD;
                }
            } else {
                return ChatFormatting.RED;
            }
        } else {
            return ChatFormatting.DARK_RED;
        }
    }

    public static class BatteryProperties{
        int maxEnergy;

        public BatteryItem.BatteryProperties energy(int pMaxEnergy){
            this.maxEnergy = pMaxEnergy;
            return this;
        }
    }
}
