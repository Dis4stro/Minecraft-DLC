package net.astro.dlc.capabilities;

import net.minecraft.nbt.CompoundTag;

public class PlayerFreezeState {
    private boolean isFrozen;

    public boolean getIsFrozen(){
        return isFrozen;
    }

    public void setIsFrozen(boolean pFrozen){
        this.isFrozen = pFrozen;
    }

    public void copyFrom(PlayerFreezeState source){
        this.isFrozen = source.isFrozen;
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putBoolean("is_frozen", isFrozen);
    }

    public void loadNBTData(CompoundTag nbt){
        this.isFrozen = nbt.getBoolean("is_frozen");
    }
}
