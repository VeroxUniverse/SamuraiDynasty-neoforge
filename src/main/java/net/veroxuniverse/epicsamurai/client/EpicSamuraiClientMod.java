package net.veroxuniverse.epicsamurai.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.*;
import net.veroxuniverse.epicsamurai.item.*;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = EpicSamuraiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EpicSamuraiClientMod {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
    }

    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        GeoArmorRenderer.registerArmorRenderer(RedSamuraiArmorItem.class, RedSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(BlueSamuraiArmorItem.class, BlueSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(GreenSamuraiArmorItem.class, GreenSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(GraySamuraiArmorItem.class, GraySamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(WhiteSamuraiArmorItem.class, WhiteSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(IronSamuraiArmorItem.class, IronSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(GoldSamuraiArmorItem.class, GoldSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(DiamondSamuraiArmorItem.class, DiamondSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(NetheriteSamuraiArmorItem.class, NetheriteSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(StrawHatArmorItem.class, StrawHatArmorRenderer::new);
    }
}

