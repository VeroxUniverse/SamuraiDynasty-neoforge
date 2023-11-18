package net.veroxuniverse.epicsamurai.network.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.veroxuniverse.epicsamurai.client.ClientKiData;

import java.util.function.Supplier;

public class KiDataSyncS2CPacket {
    private final int ki;

    public KiDataSyncS2CPacket(int ki) {
        this.ki = ki;
    }

    public KiDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.ki = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(ki);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT!
            ClientKiData.set(ki);
        });
        return true;
    }
}