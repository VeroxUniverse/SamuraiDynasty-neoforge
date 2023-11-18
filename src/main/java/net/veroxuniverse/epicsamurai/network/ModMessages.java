package net.veroxuniverse.epicsamurai.network;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.network.packet.KatanaActivateC2SPacket;
import net.veroxuniverse.epicsamurai.network.packet.KiDataSyncS2CPacket;

public class ModMessages {
    public static final SimpleChannel INSTANCE =  NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(EpicSamuraiMod.MOD_ID, "messages"))
            .networkProtocolVersion(() -> "1.0")
            .clientAcceptedVersions(s -> true)
            .serverAcceptedVersions(s -> true)
            .simpleChannel();

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {

        INSTANCE.messageBuilder(KatanaActivateC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(KatanaActivateC2SPacket::new)
                .encoder(KatanaActivateC2SPacket::toBytes)
                .consumerMainThread(KatanaActivateC2SPacket::handle)
                .add();


        INSTANCE.messageBuilder(KiDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(KiDataSyncS2CPacket::new)
                .encoder(KiDataSyncS2CPacket::toBytes)
                .consumerMainThread(KiDataSyncS2CPacket::handle)
                .add();

    }

    public static void sendToServer(LocalPlayer player) {
        if (player != null) {
            INSTANCE.sendToServer(new KatanaActivateC2SPacket());
        }
    }

    public static void sendToClient(ServerPlayer player, FriendlyByteBuf buf) {
        if (player != null) {
            INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new KiDataSyncS2CPacket(buf));
        }
    }

}