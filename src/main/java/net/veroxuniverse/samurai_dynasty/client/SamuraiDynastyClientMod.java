package net.veroxuniverse.samurai_dynasty.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.client.entities.*;
import net.veroxuniverse.samurai_dynasty.client.projectiles.ThrownShurikenRenderer;
import net.veroxuniverse.samurai_dynasty.compat.ArsNouveauCompat;
import net.veroxuniverse.samurai_dynasty.curios.model.KitsuneMaskModel;
import net.veroxuniverse.samurai_dynasty.curios.model.OniMaskModel;
import net.veroxuniverse.samurai_dynasty.entity.ModEntityTypes;
import net.veroxuniverse.samurai_dynasty.particle.BlueFlame;
import net.veroxuniverse.samurai_dynasty.registry.ParticlesInit;

import static com.hollingsworth.arsnouveau.client.registry.ClientHandler.colorFromArmor;

@Mod.EventBusSubscriber(modid = SamuraiDynastyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SamuraiDynastyClientMod {
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
        event.registerEntityRenderer(ModEntityTypes.AKANAME.get(), AkanameRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.ENENRA.get(), EnenraRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.ONI.get(), OniRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.ONIBI.get(), OnibiRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.KITSUNE.get(), KitsuneRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.JOROGUMO.get(), JorogumoRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.KOMAINU.get(), KomainuRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.TANUKI.get(), TanukiRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.KAWAUSO.get(), KawausoRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.TWOTAILED.get(), TwoTailedRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.SHURIKEN.get(), ThrownShurikenRenderer::new);

        event.registerEntityRenderer(ModEntityTypes.KITSUNE_PROJECTILE.get(), KitsuneProjectileRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.KUNAI.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.KUNAI_NETHERITE.get(), ThrownItemRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerRenderers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(OniMaskModel.LAYER_LOCATION, OniMaskModel::createBodyLayer);
        event.registerLayerDefinition(KitsuneMaskModel.LAYER_LOCATION, KitsuneMaskModel::createBodyLayer);
    }


}


