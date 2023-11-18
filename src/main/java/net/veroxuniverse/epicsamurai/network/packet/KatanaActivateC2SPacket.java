package net.veroxuniverse.epicsamurai.network.packet;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.network.NetworkEvent;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;

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

                if (hasWaterAroundThem(player, level, 2)) {
                    // Notify the player that water has been drunk
                    player.sendSystemMessage(Component.translatable(MESSAGE_ACTIVATE_KATANA).withStyle(ChatFormatting.DARK_AQUA));
                    // play the drinking sound
                    level.playSound(null, player.getOnPos(), SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS,
                            0.5F, level.random.nextFloat() * 0.1F + 0.9F);

                    // increase the water level / thirst level of player
                    // Output the current thirst level

                } else {
                    // Notify the player that there is no water around!
                    player.sendSystemMessage(Component.translatable(MESSAGE_NO_KI).withStyle(ChatFormatting.RED));
                    // Output the current thirst level
                }
            }
        });
        return true;
    }

    public static boolean hasWaterAroundThem(ServerPlayer player, ServerLevel level, int size) {
        return level.getBlockStates(player.getBoundingBox().inflate(size))
                .filter(state -> state.is(Blocks.WATER)).toArray().length > 0;
    }
}