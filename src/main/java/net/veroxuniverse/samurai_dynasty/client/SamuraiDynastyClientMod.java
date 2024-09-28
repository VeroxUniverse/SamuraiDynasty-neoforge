package net.veroxuniverse.samurai_dynasty.client;

import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.curios.model.KitsuneMaskModel;
import net.veroxuniverse.samurai_dynasty.curios.model.OniMaskModel;
import net.veroxuniverse.samurai_dynasty.particle.BlueFlame;
import net.veroxuniverse.samurai_dynasty.particle.ModParticles;
import net.veroxuniverse.samurai_dynasty.registry.ModParticleTypes;

@EventBusSubscriber(modid = SamuraiDynastyMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SamuraiDynastyClientMod {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event)
    {
        Minecraft.getInstance().particleEngine.register(ModParticles.BLUE_FLAME.get(), BlueFlame.Provider::new);
    }

    @SubscribeEvent
    public static void registerLayerRenderers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(OniMaskModel.LAYER_LOCATION, OniMaskModel::createBodyLayer);
        event.registerLayerDefinition(KitsuneMaskModel.LAYER_LOCATION, KitsuneMaskModel::createBodyLayer);
    }


}


