package net.astro.dlc.capabilities;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerFreezeStateProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<PlayerFreezeState> PLAYER_FREEZE_STATE = CapabilityManager.get(new CapabilityToken<PlayerFreezeState>() { });

    private PlayerFreezeState isFrozen = null;
    private final LazyOptional<PlayerFreezeState> optional = LazyOptional.of(this::createPlayerThirst);

    private PlayerFreezeState createPlayerThirst() {
        if(this.isFrozen == null) {
            this.isFrozen = new PlayerFreezeState();
        }
        return this.isFrozen;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == PLAYER_FREEZE_STATE) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createPlayerThirst().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createPlayerThirst().loadNBTData(nbt);
    }
}
