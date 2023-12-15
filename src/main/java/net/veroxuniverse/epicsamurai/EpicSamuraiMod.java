package net.veroxuniverse.epicsamurai;

import com.mojang.logging.LogUtils;
import net.minecraft.client.main.Main;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.veroxuniverse.epicsamurai.client.custom_entities.*;
import net.veroxuniverse.epicsamurai.datagen.loot.ModLootModifiers;
import net.veroxuniverse.epicsamurai.enchantment.ModEnchantments;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;
import net.veroxuniverse.epicsamurai.registry.BlocksRegistry;
import net.veroxuniverse.epicsamurai.registry.CreativeTabRegistry;
import net.veroxuniverse.epicsamurai.registry.ItemsRegistry;
import net.veroxuniverse.epicsamurai.registry.ParticlesInit;
import org.slf4j.Logger;


@Mod(EpicSamuraiMod.MOD_ID)
public class EpicSamuraiMod
{
    public static final String MOD_ID = "epicsamurai";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EpicSamuraiMod()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);

        ModLootModifiers.register();
        ModEnchantments.register();
        ModEntityTypes.register();
        /* // WAIT FOR ARS NOUUVEAU 1.20.2 //
        if(ModList.get().isLoaded("ars_nouveau")) {
            GeckoLib.initialize();
        }
        //MixinExtrasBootstrap.init();
         */
        ItemsRegistry.register();
        BlocksRegistry.register();
        //ParticlesInit.register();
        CreativeTabRegistry.register();
        /* // WAIT FOR 1.20.2 UPDATES //
        if(ModList.get().isLoaded("deeperdarker")) {
            DeeperDarkerCompat.register(modEventBus);
        }
        if(ModList.get().isLoaded("create")) {
            CreateCompat.register(modEventBus);
        }
        if(ModList.get().isLoaded("ars_nouveau")) {
            ArsNouveauCompat.register(modEventBus);
        }
        if(ModList.get().isLoaded("aquaculture")) {
            AquacultureCompat.register(modEventBus);
        }
        if(ModList.get().isLoaded("eldritch_end")) {
            EldritchEndCompat.register(modEventBus);
        }
        if(ModList.get().isLoaded("bloodmagic")) {
            BloodMagicCompat.register(modEventBus);
        }
        */
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    /* // WAIT FOR 1.20.2 UPDATES //
        if(ModList.get().isLoaded("ars_nouveau")) {
            ArsNouveauCompat.registerPerkProviders();
        }

        if(ModList.get().isLoaded("create")) {
            addIsWearingPredicate((player) ->
                    player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof BrassSamuraiArmorItem);
        }

        //ModMessages.register();
     */
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
            EntityRenderers.register(ModEntityTypes.JOROGUMO.get(), JorogumoRenderer::new);
            EntityRenderers.register(ModEntityTypes.FUJIN.get(), FujinRenderer::new);
            EntityRenderers.register(ModEntityTypes.RAIJIN.get(), RaijinRenderer::new);
            EntityRenderers.register(ModEntityTypes.KOMAINU.get(), KomainuRenderer::new);
            EntityRenderers.register(ModEntityTypes.TANUKI.get(), TanukiRenderer::new);
            EntityRenderers.register(ModEntityTypes.KAWAUSO.get(), KawausoRenderer::new);
            EntityRenderers.register(ModEntityTypes.TWOTAILED.get(), TwoTailedRenderer::new);

            EntityRenderers.register(ModEntityTypes.KITSUNE_PROJECTILE.get(), KitsuneProjectileRenderer::new);
            EntityRenderers.register(ModEntityTypes.SHURIKEN.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntityTypes.KUNAI.get(), ThrownItemRenderer::new);
            EntityRenderers.register(ModEntityTypes.KUNAI_NETHERITE.get(), ThrownItemRenderer::new);
        }
    }
}
