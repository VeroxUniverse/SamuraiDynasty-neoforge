package net.veroxuniverse.epicsamurai.client;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.particle.BlueFlame;
import net.veroxuniverse.epicsamurai.registry.ParticlesInit;

@Mod.EventBusSubscriber(modid = EpicSamuraiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EpicSamuraiClientMod {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event)
    {
        Minecraft.getInstance().particleEngine.register(ParticlesInit.BLUE_FLAME,BlueFlame.Provider::new);
    }

    @SubscribeEvent
    public static void initItemColors(final RegisterColorHandlersEvent.Item event) {

        /*
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
         */

    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {

    }


}


