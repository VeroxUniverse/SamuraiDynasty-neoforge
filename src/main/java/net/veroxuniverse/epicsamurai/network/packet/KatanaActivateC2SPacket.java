package net.veroxuniverse.epicsamurai.network.packet;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.network.NetworkEvent;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.ClientKiData;

import java.util.function.Supplier;

public class KatanaActivateC2SPacket {
    private static final String MESSAGE_ACTIVATE_KATANA = "message." + EpicSamuraiMod.MOD_ID + ".activate_katana";
    private static final String MESSAGE_NO_KI = "message." + EpicSamuraiMod.MOD_ID + ".no_ki";

    public KatanaActivateC2SPacket() {

    }

    public KatanaActivateC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            if (player != null) {
                ServerLevel level = player.serverLevel();

                if (ClientKiData.getPlayerKi() > 0) {
                    // Notify the player that the katana is active
                    player.sendSystemMessage(Component.translatable(MESSAGE_ACTIVATE_KATANA).withStyle(ChatFormatting.DARK_AQUA));
                    // play sound
                    level.playSound(player, player.getOnPos(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.PLAYERS,
                            0.5F, level.random.nextFloat() * 0.1F + 0.9F);

                } else {
                    // Notify the player that the ki level is null!
                    player.sendSystemMessage(Component.translatable(MESSAGE_NO_KI).withStyle(ChatFormatting.RED));
                    // Output the current ki level
                }
            }
        });
        return true;
    }

}