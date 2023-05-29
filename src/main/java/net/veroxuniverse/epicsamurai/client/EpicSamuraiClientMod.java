package net.veroxuniverse.epicsamurai.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.amethyst.AmethystSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.aquamarine.BlueSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.ars_nouveau.MageSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.deeperdarker.SculkSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.diamond.DiamondSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.gold.GoldSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.iron.IronSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.jade.GreenSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.netherite.NetheriteSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.oni_mask.OniMaskArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.onyx.GraySamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.quartz.QuartzSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.ruby.RedSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.silver.WhiteSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.straw_hat.StrawHatArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.steel_armor.SteelArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.*;
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
        GeoArmorRenderer.registerArmorRenderer(OniMaskArmorItem.class, OniMaskArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(SteelArmorItem.class, SteelArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(AmethystSamuraiArmorItem.class, AmethystSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(QuartzSamuraiArmorItem.class, QuartzSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(SculkSamuraiArmorItem.class, SculkSamuraiArmorRenderer::new);
        GeoArmorRenderer.registerArmorRenderer(MageSamuraiArmorItem.class, MageSamuraiArmorRenderer::new);
    }
}

