package net.astro.dlc.item.battery.batteries;

import net.minecraft.world.item.Item;

public class MasterBattery extends Item {
    // Currently not in use
    private final int maxEnergy;

    public MasterBattery(Properties pProperties, MasterBattery.BatteryProperties pBatteryProperties) {
        super(pProperties);
        this.maxEnergy = pBatteryProperties.maxEnergy;
    }

    public static class BatteryProperties{
        int maxEnergy;

        public MasterBattery.BatteryProperties energy(int pMaxEnergy){
            this.maxEnergy = pMaxEnergy;
            return this;
        }
    }
}
