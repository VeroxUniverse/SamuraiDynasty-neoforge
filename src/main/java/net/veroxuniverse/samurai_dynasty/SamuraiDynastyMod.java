package net.veroxuniverse.samurai_dynasty;

import com.mojang.logging.LogUtils;
import mod.azure.azurelib.AzureLib;
import mod.azure.azurelib.common.render.armor.AzArmorRendererRegistry;
import mod.azure.azurelib.common.render.item.AzItemRendererRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
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
import net.veroxuniverse.samurai_dynasty.client.armors.kimono.KimonoArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.ninja_armor.netherite.NetheriteNinjaArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.ninja_armor.steel.SteelNinjaArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.master.MasterSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.netherite.NetheriteSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.ronin.RoninSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.steel.SteelSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.straw_hat.StrawHatArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.steel_armor.SteelArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.entities.*;
import net.veroxuniverse.samurai_dynasty.client.projectiles.ThrownShurikenRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.kabutowari.KabutowariItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.kabutowari.KabutowariItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.kamayari.KamayariItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.kamayari.KamayariItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.katana.KatanaItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.katana.KatanaItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.kunai.KunaiItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.kunai.KunaiItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.masakari.MasakariItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.masakari.MasakariItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.nagamaki.NagamakiItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.nagamaki.NagamakiItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.naginata.NaginataItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.naginata.NaginataItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.odachi.OdachiItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.odachi.OdachiItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.tekkokagi.TekkoKagiItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.tekkokagi.TekkoKagiItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.tetsubo.TetsuboItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.tetsubo.TetsuboItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.tonbukiri.TonbukiriItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.tonbukiri.TonbukiriItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.wakizashi.WakizashiItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.wakizashi.WakizashiItemRenderer;
import net.veroxuniverse.samurai_dynasty.curios.layers.KitsuneMaskRenderer;
import net.veroxuniverse.samurai_dynasty.curios.layers.OniMaskRenderer;
import net.veroxuniverse.samurai_dynasty.datagen.loot.ModLootCodec;
import net.veroxuniverse.samurai_dynasty.entity.ModEntityTypes;
import net.veroxuniverse.samurai_dynasty.particle.ModParticles;
import net.veroxuniverse.samurai_dynasty.registry.ArmorMaterialsRegistry;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;
import net.veroxuniverse.samurai_dynasty.registry.CreativeTabRegistry;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;
import net.veroxuniverse.samurai_dynasty.utils.ModItemProperties;
import net.veroxuniverse.samurai_dynasty.worldgen.biomes.ModSurfaceRuleData;
import net.veroxuniverse.samurai_dynasty.worldgen.biomes.SpiritBlossomForestRegion;
import net.veroxuniverse.samurai_dynasty.worldgen.biomes.SpiritWoodForestRegion;
import net.veroxuniverse.samurai_dynasty.worldgen.features.ModTreeConfiguredFeatures;
import net.veroxuniverse.samurai_dynasty.worldgen.features.ModTreePlacedFeatures;
import net.veroxuniverse.samurai_dynasty.worldgen.features.decorators.ModDecoratorTypes;
import org.slf4j.Logger;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
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
        ItemsRegistry.registerBuilding(modEventBus);
        BlocksRegistry.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        ArmorMaterialsRegistry.register(modEventBus);
        ModParticles.register(modEventBus);
        ModLootCodec.register(modEventBus);
        ModTreeConfiguredFeatures.register();
        ModTreePlacedFeatures.register();
        ModDecoratorTypes.register(modEventBus);

        CreativeTabRegistry.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        LOGGER.info("HELLO FROM COMMON SETUP");

        event.enqueueWork(() -> {

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(BlocksRegistry.SPIDER_LILLY.getId(), BlocksRegistry.POTTED_SPIDER_LILLY);

            Regions.register(new SpiritWoodForestRegion(ResourceLocation.fromNamespaceAndPath(MOD_ID,"maple_forest"),2));
            Regions.register(new SpiritBlossomForestRegion(ResourceLocation.fromNamespaceAndPath(MOD_ID,"sakura_forest"),2));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRuleData.makeRules());

        });

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            LOGGER.info("HELLO FROM CLIENT SETUP");

            AzItemRendererRegistry.register(KabutowariItemRenderer::new, ItemsRegistry.KABUTOWARI.get());
            AzItemRendererRegistry.register(KabutowariItemNetheriteRenderer::new, ItemsRegistry.KABUTOWARI_NETHERITE.get());

            AzItemRendererRegistry.register(KamayariItemRenderer::new, ItemsRegistry.KAMAYARI.get());
            AzItemRendererRegistry.register(KamayariItemNetheriteRenderer::new, ItemsRegistry.KAMAYARI_NETHERITE.get());

            AzItemRendererRegistry.register(KatanaItemRenderer::new, ItemsRegistry.KATANA.get());
            AzItemRendererRegistry.register(KatanaItemNetheriteRenderer::new, ItemsRegistry.KATANA_NETHERITE.get());

            AzItemRendererRegistry.register(KunaiItemRenderer::new, ItemsRegistry.KUNAI.get());
            AzItemRendererRegistry.register(KunaiItemNetheriteRenderer::new, ItemsRegistry.KUNAI_NETHERITE.get());

            AzItemRendererRegistry.register(MasakariItemRenderer::new, ItemsRegistry.MASAKARI.get());
            AzItemRendererRegistry.register(MasakariItemNetheriteRenderer::new, ItemsRegistry.MASAKARI_NETHERITE.get());

            AzItemRendererRegistry.register(NagamakiItemRenderer::new, ItemsRegistry.NAGAMAKI.get());
            AzItemRendererRegistry.register(NagamakiItemNetheriteRenderer::new, ItemsRegistry.NAGAMAKI_NETHERITE.get());

            AzItemRendererRegistry.register(NaginataItemRenderer::new, ItemsRegistry.NAGINATA.get());
            AzItemRendererRegistry.register(NaginataItemNetheriteRenderer::new, ItemsRegistry.NAGINATA_NETHERITE.get());

            AzItemRendererRegistry.register(OdachiItemRenderer::new, ItemsRegistry.ODACHI.get());
            AzItemRendererRegistry.register(OdachiItemNetheriteRenderer::new, ItemsRegistry.ODACHI_NETHERITE.get());

            AzItemRendererRegistry.register(TekkoKagiItemRenderer::new, ItemsRegistry.SHUKO.get());
            AzItemRendererRegistry.register(TekkoKagiItemNetheriteRenderer::new, ItemsRegistry.SHUKO_NETHERITE.get());

            AzItemRendererRegistry.register(TetsuboItemRenderer::new, ItemsRegistry.TETSUBO.get());
            AzItemRendererRegistry.register(TetsuboItemNetheriteRenderer::new, ItemsRegistry.TETSUBO_NETHERITE.get());

            AzItemRendererRegistry.register(TonbukiriItemRenderer::new, ItemsRegistry.TONBUKIRI.get());
            AzItemRendererRegistry.register(TonbukiriItemNetheriteRenderer::new, ItemsRegistry.TONBUKIRI_NETHERITE.get());

            AzItemRendererRegistry.register(WakizashiItemRenderer::new, ItemsRegistry.WAKIZASHI.get());
            AzItemRendererRegistry.register(WakizashiItemNetheriteRenderer::new, ItemsRegistry.WAKIZASHI_NETHERITE.get());

            AzArmorRendererRegistry.register(KimonoArmorRenderer::new,
                    ItemsRegistry.KIMONO.get());

            AzArmorRendererRegistry.register(RoninSamuraiArmorRenderer::new,
                    ItemsRegistry.LIGHT_SAMURAI_HELMET.get(),
                    ItemsRegistry.LIGHT_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.LIGHT_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.LIGHT_SAMURAI_BOOTS.get());

            AzArmorRendererRegistry.register(MasterSamuraiArmorRenderer::new,
                    ItemsRegistry.MASTER_SAMURAI_HELMET.get(),
                    ItemsRegistry.MASTER_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.MASTER_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.MASTER_SAMURAI_BOOTS.get());

            AzArmorRendererRegistry.register(NetheriteNinjaArmorRenderer::new,
                    ItemsRegistry.NETHERITE_NINJA_HELMET.get(),
                    ItemsRegistry.NETHERITE_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.NETHERITE_NINJA_BOOTS.get());

            AzArmorRendererRegistry.register(NetheriteSamuraiArmorRenderer::new,
                    ItemsRegistry.NETHERITE_SAMURAI_HELMET.get(),
                    ItemsRegistry.NETHERITE_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.NETHERITE_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.NETHERITE_SAMURAI_BOOTS.get());

            AzArmorRendererRegistry.register(SteelNinjaArmorRenderer::new,
                    ItemsRegistry.STEEL_NINJA_HELMET.get(),
                    ItemsRegistry.STEEL_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.STEEL_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.STEEL_NINJA_BOOTS.get());

            AzArmorRendererRegistry.register(SteelSamuraiArmorRenderer::new,
                    ItemsRegistry.STEEL_SAMURAI_HELMET.get(),
                    ItemsRegistry.STEEL_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.STEEL_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.STEEL_SAMURAI_BOOTS.get());

            AzArmorRendererRegistry.register(SteelArmorRenderer::new,
                    ItemsRegistry.STEEL_HELMET.get(),
                    ItemsRegistry.STEEL_CHESTPLATE.get(),
                    ItemsRegistry.STEEL_LEGGINGS.get(),
                    ItemsRegistry.STEEL_BOOTS.get());

            AzArmorRendererRegistry.register(StrawHatArmorRenderer::new,
                    ItemsRegistry.STRAW_HAT.get());

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

            ModItemProperties.addCustomItemProperties();

        }
    }

}
