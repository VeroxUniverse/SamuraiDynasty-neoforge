package net.veroxuniverse.samurai_dynasty;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.logging.LogUtils;
import mod.azure.azurelib.common.internal.common.AzureLib;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.veroxuniverse.samurai_dynasty.client.entities.*;
import net.veroxuniverse.samurai_dynasty.client.projectiles.ThrownShurikenRenderer;
import net.veroxuniverse.samurai_dynasty.curios.layers.KitsuneMaskRenderer;
import net.veroxuniverse.samurai_dynasty.curios.layers.OniMaskRenderer;
import net.veroxuniverse.samurai_dynasty.entity.ModEntityTypes;
import net.veroxuniverse.samurai_dynasty.particle.ModParticles;
import net.veroxuniverse.samurai_dynasty.registry.ArmorMaterialsRegistry;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;
import net.veroxuniverse.samurai_dynasty.registry.CreativeTabRegistry;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;


@Mod(SamuraiDynastyMod.MOD_ID)
public class SamuraiDynastyMod
{
    public static final String MOD_ID = "samurai_dynasty";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SamuraiDynastyMod(IEventBus modEventBus, ModContainer modContainer)
    {

        modEventBus.addListener(this::commonSetup);
        //MixinExtrasBootstrap.init();

        AzureLib.initialize();
        ItemsRegistry.register(modEventBus);
        BlocksRegistry.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        ArmorMaterialsRegistry.register(modEventBus);
        ModParticles.register(modEventBus);

        CreativeTabRegistry.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            LOGGER.info("HELLO FROM CLIENT SETUP");
            EntityRenderers.register(ModEntityTypes.AKANAME.get(), AkanameRenderer::new);
            EntityRenderers.register(ModEntityTypes.ENENRA.get(), EnenraRenderer::new);
            EntityRenderers.register(ModEntityTypes.ONI.get(), OniRenderer::new);
            EntityRenderers.register(ModEntityTypes.ONIBI.get(), OnibiRenderer::new);
            EntityRenderers.register(ModEntityTypes.KITSUNE.get(), KitsuneRenderer::new);
            EntityRenderers.register(ModEntityTypes.JOROGUMO.get(), JorogumoRenderer::new);
            EntityRenderers.register(ModEntityTypes.FUJIN.get(), FujinRenderer::new);
            EntityRenderers.register(ModEntityTypes.RAIJIN.get(), RaijinRenderer::new);
            EntityRenderers.register(ModEntityTypes.KOMAINU.get(), KomainuRenderer::new);
            EntityRenderers.register(ModEntityTypes.TANUKI.get(), TanukiRenderer::new);
            EntityRenderers.register(ModEntityTypes.KAWAUSO.get(), KawausoRenderer::new);
            EntityRenderers.register(ModEntityTypes.TWOTAILED.get(), TwoTailedRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHURIKEN.get(), ThrownShurikenRenderer::new);

            EntityRenderers.register(ModEntityTypes.KUNAI.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntityTypes.KUNAI_NETHERITE.get(), ThrownItemRenderer::new);

            CuriosRendererRegistry.register(ItemsRegistry.ONI_MASK.get(), OniMaskRenderer::new);
            //CuriosRendererRegistry.register(ItemsRegistry.ONI_MASK_RED.get(), OniMaskRedRenderer::new);
            //CuriosRendererRegistry.register(ItemsRegistry.ONI_MASK_WHITE.get(), OniMaskWhiteRenderer::new);
            CuriosRendererRegistry.register(ItemsRegistry.KITSUNE_MASK.get(), KitsuneMaskRenderer::new);

        }
    }

}
