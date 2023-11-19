package net.veroxuniverse.epicsamurai.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.compat.ArsNouveauCompat;
import net.veroxuniverse.epicsamurai.network.ModMessages;
import net.veroxuniverse.epicsamurai.network.packet.KatanaActivateC2SPacket;
import net.veroxuniverse.epicsamurai.particle.BlueFlame;
import net.veroxuniverse.epicsamurai.registry.ParticlesInit;
import net.veroxuniverse.epicsamurai.utils.KeyBinding;
import software.bernie.shadowed.eliotlash.mclib.math.functions.limit.Min;

import static com.hollingsworth.arsnouveau.client.registry.ClientHandler.colorFromArmor;

@Mod.EventBusSubscriber(modid = EpicSamuraiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EpicSamuraiClientMod {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event)
    {
        Minecraft.getInstance().particleEngine.register(ParticlesInit.BLUE_FLAME.get(),BlueFlame.Provider::new);
    }

    @SubscribeEvent
    public static void initItemColors(final RegisterColorHandlersEvent.Item event) {

        if (ModList.get().isLoaded("ars_nouveau")){

            event.register((stack, color) -> color > 0 ? -1 :
                            colorFromArmor(stack),
                    ArsNouveauCompat.MAGE_SAMURAI_BOOTS.get());
            event.register((stack, color) -> color > 0 ? -1 :
                            colorFromArmor(stack),
                    ArsNouveauCompat.MAGE_SAMURAI_CHESTPLATE.get());
            event.register((stack, color) -> color > 0 ? -1 :
                            colorFromArmor(stack),
                    ArsNouveauCompat.MAGE_SAMURAI_HELMET.get());
            event.register((stack, color) -> color > 0 ? -1 :
                            colorFromArmor(stack),
                    ArsNouveauCompat.MAGE_SAMURAI_LEGGINGS.get());

        }

    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {

    }

    @Mod.EventBusSubscriber(modid = EpicSamuraiMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if((Minecraft.getInstance().player != null) && KeyBinding.KATANA_KEY.isDown()) {
                ModMessages.sendToServer(Minecraft.getInstance().player);
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("This is a test message!"));
            }
        }
    }

    @Mod.EventBusSubscriber(modid = EpicSamuraiMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
           event.register(KeyBinding.KATANA_KEY);
        }
    }

}


