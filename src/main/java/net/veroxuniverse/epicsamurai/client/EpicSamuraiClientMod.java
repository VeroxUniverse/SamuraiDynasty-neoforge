package net.veroxuniverse.epicsamurai.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.amethyst.AmethystSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.aquamarine.BlueSamuraiArmorRenderer;
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
import net.veroxuniverse.epicsamurai.particle.BlueFlame;
import net.veroxuniverse.epicsamurai.registry.ParticlesInit;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = EpicSamuraiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EpicSamuraiClientMod {
    @SubscribeEvent
    public static void registerParticleFactories(final RegisterParticleProvidersEvent event)
    {
        Minecraft.getInstance().particleEngine.register(ParticlesInit.BLUE_FLAME.get(),BlueFlame.Provider::new);
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
    }

}


