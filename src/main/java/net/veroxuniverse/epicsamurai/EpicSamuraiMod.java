package net.veroxuniverse.epicsamurai;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.veroxuniverse.epicsamurai.client.custom_entities.*;
import net.veroxuniverse.epicsamurai.compat.DeeperDarkerCompat;
import net.veroxuniverse.epicsamurai.enchantment.ModEnchantments;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;
import net.veroxuniverse.epicsamurai.registry.BlocksRegistry;
import net.veroxuniverse.epicsamurai.registry.ItemsRegistry;
import net.veroxuniverse.epicsamurai.registry.ParticlesInit;
import net.veroxuniverse.epicsamurai.world.feature.ModConfiguredFeatures;
import net.veroxuniverse.epicsamurai.world.feature.ModPlacedFeatures;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;


@Mod(EpicSamuraiMod.MOD_ID)
public class EpicSamuraiMod
{
    public static final String MOD_ID = "epicsamurai";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EpicSamuraiMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEntityTypes.register(modEventBus);
        GeckoLib.initialize();

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        ItemsRegistry.register(modEventBus);
        BlocksRegistry.register(modEventBus);
        ParticlesInit.register(modEventBus);

        ModEnchantments.ENCHANTMENTS.register(modEventBus);

        if(ModList.get().isLoaded("deeperdarker")) {
            DeeperDarkerCompat.register(modEventBus);
        }

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }



    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

            EntityRenderers.register(ModEntityTypes.AKANAME.get(), AkanameRenderer::new);
            EntityRenderers.register(ModEntityTypes.ENENRA.get(), EnenraRenderer::new);
            EntityRenderers.register(ModEntityTypes.ONI.get(), OniRenderer::new);
            EntityRenderers.register(ModEntityTypes.ONIBI.get(), OnibiRenderer::new);
            EntityRenderers.register(ModEntityTypes.KITSUNE.get(), KitsuneRenderer::new);
            EntityRenderers.register(ModEntityTypes.KITSUNE_PROJECTILE.get(), KitsuneProjectileRenderer::new);

            EntityRenderers.register(ModEntityTypes.SHURIKEN.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntityTypes.KUNAI.get(), ThrownItemRenderer::new);

        }
    }
}
