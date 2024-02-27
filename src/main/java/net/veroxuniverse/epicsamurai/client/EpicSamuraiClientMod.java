package net.veroxuniverse.epicsamurai.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.compat.ArsNouveauCompat;
import net.veroxuniverse.epicsamurai.curios.model.OniMaskModel;
import net.veroxuniverse.epicsamurai.particle.BlueFlame;
import net.veroxuniverse.epicsamurai.registry.ParticlesInit;

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
    public static void registerRenderers(final EntityRenderersEvent event) {

    }

    @SubscribeEvent
    public static void registerLayerRenderers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(OniMaskModel.LAYER_LOCATION, OniMaskModel::createBodyLayer);
    }


}


