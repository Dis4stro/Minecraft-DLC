package net.astro.dlc.networking.packet;

import net.astro.dlc.client.ClientData;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class FreezeDataSyncS2CPacket {
    private final boolean hasFreezeEffect;

    public FreezeDataSyncS2CPacket(boolean hasFreezeEffect){
        this.hasFreezeEffect = hasFreezeEffect;
    }

    public FreezeDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.hasFreezeEffect = buf.readBoolean();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBoolean(hasFreezeEffect);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {

            // QUI SONO NEL CLIENT
            ClientData.setIsFrozen(hasFreezeEffect);
        });
        return true;
    }
}
