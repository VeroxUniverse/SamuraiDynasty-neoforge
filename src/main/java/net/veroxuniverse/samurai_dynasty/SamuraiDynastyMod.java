package net.veroxuniverse.samurai_dynasty;

import com.mojang.logging.LogUtils;
import mod.azure.azurelib.render.armor.AzArmorRendererRegistry;
import mod.azure.azurelib.render.item.AzItemRendererRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.veroxuniverse.samurai_dynasty.client.armors.kimono.KimonoArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.ninja_armor.diamond.DiamondNinjaArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.ninja_armor.gold.GoldNinjaArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.ninja_armor.iron.IronNinjaArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.ninja_armor.netherite.NetheriteNinjaArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.ninja_armor.steel.SteelNinjaArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.amethyst.AmethystSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.aquamarine.BlueSamuraiArmorLightRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.aquamarine.BlueSamuraiArmorMasterRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.aquamarine.BlueSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.aquaculture.NeptuniumSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.ars_nouveau.MageSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.bloodmagic.LivingSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.create.BrassSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.deeperdarker.SculkSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.eldrithcend.EtyriteSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.forbidden_and_arcanus.DracoSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.forbidden_and_arcanus.TyrSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.diamond.DiamondSamuraiArmorLightRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.diamond.DiamondSamuraiArmorMasterRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.diamond.DiamondSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.gold.GoldSamuraiArmorLightRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.gold.GoldSamuraiArmorMasterRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.gold.GoldSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.iron.IronSamuraiArmorLightRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.iron.IronSamuraiArmorMasterRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.iron.IronSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.jade.GreenSamuraiArmorLightRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.jade.GreenSamuraiArmorMasterRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.jade.GreenSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.netherite.NetheriteSamuraiArmorLightRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.netherite.NetheriteSamuraiArmorMasterRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.netherite.NetheriteSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.onyx.GraySamuraiArmorLightRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.onyx.GraySamuraiArmorMasterRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.onyx.GraySamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.quartz.QuartzSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.ruby.RedSamuraiArmorLightRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.ruby.RedSamuraiArmorMasterRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.ruby.RedSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.silver.WhiteSamuraiArmorLightRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.silver.WhiteSamuraiArmorMasterRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.silver.WhiteSamuraiArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.armors.steel_armor.SteelArmorRenderer;
import net.veroxuniverse.samurai_dynasty.client.entities.*;
import net.veroxuniverse.samurai_dynasty.client.projectiles.ThrownShurikenRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.kamayari.KamayariItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.kamayari.KamayariItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.odachi.OdachiItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.odachi.OdachiItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.tetsubo.TetsuboItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.tetsubo.TetsuboItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.tonbukiri.TonbukiriItemNetheriteRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.tonbukiri.TonbukiriItemRenderer;
import net.veroxuniverse.samurai_dynasty.compat.*;
import net.veroxuniverse.samurai_dynasty.curios.layers.KitsuneMaskRenderer;
import net.veroxuniverse.samurai_dynasty.curios.layers.OniMaskRenderer;
import net.veroxuniverse.samurai_dynasty.datagen.loot.ModLootModifiers;
import net.veroxuniverse.samurai_dynasty.enchantment.ModEnchantments;
import net.veroxuniverse.samurai_dynasty.entity.ModEntityTypes;
import net.veroxuniverse.samurai_dynasty.item.KamayariItem;
import net.veroxuniverse.samurai_dynasty.item.KamayariNetheriteItem;
import net.veroxuniverse.samurai_dynasty.item.armor.BrassSamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.item.armor.MageSamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;
import net.veroxuniverse.samurai_dynasty.registry.CreativeTabRegistry;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;
import net.veroxuniverse.samurai_dynasty.registry.ParticlesInit;
import net.veroxuniverse.samurai_dynasty.sound.ESSounds;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import static com.simibubi.create.content.equipment.goggles.GogglesItem.addIsWearingPredicate;


@Mod(SamuraiDynastyMod.MOD_ID)
public class SamuraiDynastyMod
{
    public static final String MOD_ID = "samurai_dynasty";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SamuraiDynastyMod()
    {


        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLootModifiers.register(modEventBus);
        ModEnchantments.register(modEventBus);

        ModEntityTypes.register(modEventBus);
        if(ModList.get().isLoaded("ars_nouveau")) {
            GeckoLib.initialize();
        }
        //MixinExtrasBootstrap.init();

        ItemsRegistry.register(modEventBus);
        BlocksRegistry.register(modEventBus);
        ParticlesInit.register(modEventBus);

        CreativeTabRegistry.register(modEventBus);


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
        if(ModList.get().isLoaded("forbidden_arcanus")) {
            ForbiddenCompat.register(modEventBus);
        }

        ESSounds.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {


        if(ModList.get().isLoaded("ars_nouveau")) {
            ArsNouveauCompat.registerPerkProviders();
        }

        if(ModList.get().isLoaded("create")) {
            addIsWearingPredicate((player) ->
                    player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof BrassSamuraiArmorItem);
        }

        //ModMessages.register();

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            CuriosRendererRegistry.register(ItemsRegistry.ONI_MASK.get(), OniMaskRenderer::new);
            //CuriosRendererRegistry.register(ItemsRegistry.ONI_MASK_RED.get(), OniMaskRedRenderer::new);
            //CuriosRendererRegistry.register(ItemsRegistry.ONI_MASK_WHITE.get(), OniMaskWhiteRenderer::new);
            CuriosRendererRegistry.register(ItemsRegistry.KITSUNE_MASK.get(), KitsuneMaskRenderer::new);


            AzItemRendererRegistry.register(KamayariItemRenderer::new, ItemsRegistry.KAMAYARI.get());
            AzItemRendererRegistry.register(KamayariItemNetheriteRenderer::new, ItemsRegistry.KAMAYARI_NETHERITE.get());

            AzItemRendererRegistry.register(OdachiItemRenderer::new, ItemsRegistry.ODACHI.get());
            AzItemRendererRegistry.register(OdachiItemNetheriteRenderer::new, ItemsRegistry.ODACHI_NETHERITE.get());

            AzItemRendererRegistry.register(TetsuboItemRenderer::new, ItemsRegistry.TETSUBO.get());
            AzItemRendererRegistry.register(TetsuboItemNetheriteRenderer::new, ItemsRegistry.TETSUBO_NETHERITE.get());

            AzItemRendererRegistry.register(TonbukiriItemRenderer::new, ItemsRegistry.TONBUKIRI.get());
            AzItemRendererRegistry.register(TonbukiriItemNetheriteRenderer::new, ItemsRegistry.TONBUKIRI_NETHERITE.get());

            AzArmorRendererRegistry.register(AmethystSamuraiArmorRenderer::new,
                    ItemsRegistry.AMETHYST_SAMURAI_HELMET.get(),
                    ItemsRegistry.AMETHYST_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.AMETHYST_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.AMETHYST_SAMURAI_BOOTS.get());

            AzArmorRendererRegistry.register(BlueSamuraiArmorRenderer::new,
                    ItemsRegistry.BLUE_SAMURAI_HELMET.get(),
                    ItemsRegistry.BLUE_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.BLUE_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.BLUE_SAMURAI_BOOTS.get());
            AzArmorRendererRegistry.register(BlueSamuraiArmorLightRenderer::new,
                    ItemsRegistry.BLUE_SAMURAI_HELMET_LIGHT.get(),
                    ItemsRegistry.BLUE_SAMURAI_CHESTPLATE_LIGHT.get(),
                    ItemsRegistry.BLUE_SAMURAI_LEGGINGS_LIGHT.get(),
                    ItemsRegistry.BLUE_SAMURAI_BOOTS_LIGHT.get());
            AzArmorRendererRegistry.register(BlueSamuraiArmorMasterRenderer::new,
                    ItemsRegistry.BLUE_SAMURAI_HELMET_MASTER.get(),
                    ItemsRegistry.BLUE_SAMURAI_CHESTPLATE_MASTER.get(),
                    ItemsRegistry.BLUE_SAMURAI_LEGGINGS_MASTER.get(),
                    ItemsRegistry.BLUE_SAMURAI_BOOTS_MASTER.get());

            AzArmorRendererRegistry.register(DiamondNinjaArmorRenderer::new,
                    ItemsRegistry.DIAMOND_NINJA_HELMET.get(),
                    ItemsRegistry.DIAMOND_NINJA_CHESTPLATE.get(),
                    ItemsRegistry.DIAMOND_NINJA_BOOTS.get());
            AzArmorRendererRegistry.register(DiamondSamuraiArmorRenderer::new,
                    ItemsRegistry.DIAMOND_SAMURAI_HELMET.get(),
                    ItemsRegistry.DIAMOND_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.DIAMOND_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.DIAMOND_SAMURAI_BOOTS.get());
            AzArmorRendererRegistry.register(DiamondSamuraiArmorLightRenderer::new,
                    ItemsRegistry.DIAMOND_SAMURAI_HELMET_LIGHT.get(),
                    ItemsRegistry.DIAMOND_SAMURAI_CHESTPLATE_LIGHT.get(),
                    ItemsRegistry.DIAMOND_SAMURAI_LEGGINGS_LIGHT.get(),
                    ItemsRegistry.DIAMOND_SAMURAI_BOOTS_LIGHT.get());
            AzArmorRendererRegistry.register(DiamondSamuraiArmorMasterRenderer::new,
                    ItemsRegistry.DIAMOND_SAMURAI_HELMET_MASTER.get(),
                    ItemsRegistry.DIAMOND_SAMURAI_CHESTPLATE_MASTER.get(),
                    ItemsRegistry.DIAMOND_SAMURAI_LEGGINGS_MASTER.get(),
                    ItemsRegistry.DIAMOND_SAMURAI_BOOTS_MASTER.get());

            AzArmorRendererRegistry.register(GoldNinjaArmorRenderer::new,
                    ItemsRegistry.GOLD_NINJA_HELMET.get(),
                    ItemsRegistry.GOLD_NINJA_CHESTPLATE.get(),
                    ItemsRegistry.GOLD_NINJA_BOOTS.get());
            AzArmorRendererRegistry.register(GoldSamuraiArmorRenderer::new,
                    ItemsRegistry.GOLD_SAMURAI_HELMET.get(),
                    ItemsRegistry.GOLD_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.GOLD_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.GOLD_SAMURAI_BOOTS.get());
            AzArmorRendererRegistry.register(GoldSamuraiArmorLightRenderer::new,
                    ItemsRegistry.GOLD_SAMURAI_HELMET_LIGHT.get(),
                    ItemsRegistry.GOLD_SAMURAI_CHESTPLATE_LIGHT.get(),
                    ItemsRegistry.GOLD_SAMURAI_LEGGINGS_LIGHT.get(),
                    ItemsRegistry.GOLD_SAMURAI_BOOTS_LIGHT.get());
            AzArmorRendererRegistry.register(GoldSamuraiArmorMasterRenderer::new,
                    ItemsRegistry.GOLD_SAMURAI_HELMET_MASTER.get(),
                    ItemsRegistry.GOLD_SAMURAI_CHESTPLATE_MASTER.get(),
                    ItemsRegistry.GOLD_SAMURAI_LEGGINGS_MASTER.get(),
                    ItemsRegistry.GOLD_SAMURAI_BOOTS_MASTER.get());

            AzArmorRendererRegistry.register(GraySamuraiArmorRenderer::new,
                    ItemsRegistry.GRAY_SAMURAI_HELMET.get(),
                    ItemsRegistry.GRAY_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.GRAY_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.GRAY_SAMURAI_BOOTS.get());
            AzArmorRendererRegistry.register(GraySamuraiArmorLightRenderer::new,
                    ItemsRegistry.GRAY_SAMURAI_HELMET_LIGHT.get(),
                    ItemsRegistry.GRAY_SAMURAI_CHESTPLATE_LIGHT.get(),
                    ItemsRegistry.GRAY_SAMURAI_LEGGINGS_LIGHT.get(),
                    ItemsRegistry.GRAY_SAMURAI_BOOTS_LIGHT.get());
            AzArmorRendererRegistry.register(GraySamuraiArmorMasterRenderer::new,
                    ItemsRegistry.GRAY_SAMURAI_HELMET_MASTER.get(),
                    ItemsRegistry.GRAY_SAMURAI_CHESTPLATE_MASTER.get(),
                    ItemsRegistry.GRAY_SAMURAI_LEGGINGS_MASTER.get(),
                    ItemsRegistry.GRAY_SAMURAI_BOOTS_MASTER.get());

            AzArmorRendererRegistry.register(GreenSamuraiArmorRenderer::new,
                    ItemsRegistry.GREEN_SAMURAI_HELMET.get(),
                    ItemsRegistry.GREEN_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.GREEN_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.GREEN_SAMURAI_BOOTS.get());
            AzArmorRendererRegistry.register(GreenSamuraiArmorLightRenderer::new,
                    ItemsRegistry.GREEN_SAMURAI_HELMET_LIGHT.get(),
                    ItemsRegistry.GREEN_SAMURAI_CHESTPLATE_LIGHT.get(),
                    ItemsRegistry.GREEN_SAMURAI_LEGGINGS_LIGHT.get(),
                    ItemsRegistry.GREEN_SAMURAI_BOOTS_LIGHT.get());
            AzArmorRendererRegistry.register(GreenSamuraiArmorMasterRenderer::new,
                    ItemsRegistry.GREEN_SAMURAI_HELMET_MASTER.get(),
                    ItemsRegistry.GREEN_SAMURAI_CHESTPLATE_MASTER.get(),
                    ItemsRegistry.GREEN_SAMURAI_LEGGINGS_MASTER.get(),
                    ItemsRegistry.GREEN_SAMURAI_BOOTS_MASTER.get());

            AzArmorRendererRegistry.register(IronNinjaArmorRenderer::new,
                    ItemsRegistry.IRON_NINJA_HELMET.get(),
                    ItemsRegistry.IRON_NINJA_CHESTPLATE.get(),
                    ItemsRegistry.NINJA_LEGGINGS.get(),
                    ItemsRegistry.IRON_NINJA_BOOTS.get());
            AzArmorRendererRegistry.register(IronSamuraiArmorRenderer::new,
                    ItemsRegistry.IRON_SAMURAI_HELMET.get(),
                    ItemsRegistry.IRON_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.IRON_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.IRON_SAMURAI_BOOTS.get());
            AzArmorRendererRegistry.register(IronSamuraiArmorLightRenderer::new,
                    ItemsRegistry.IRON_SAMURAI_HELMET_LIGHT.get(),
                    ItemsRegistry.IRON_SAMURAI_CHESTPLATE_LIGHT.get(),
                    ItemsRegistry.IRON_SAMURAI_LEGGINGS_LIGHT.get(),
                    ItemsRegistry.IRON_SAMURAI_BOOTS_LIGHT.get());
            AzArmorRendererRegistry.register(IronSamuraiArmorMasterRenderer::new,
                    ItemsRegistry.IRON_SAMURAI_HELMET_MASTER.get(),
                    ItemsRegistry.IRON_SAMURAI_CHESTPLATE_MASTER.get(),
                    ItemsRegistry.IRON_SAMURAI_LEGGINGS_MASTER.get(),
                    ItemsRegistry.IRON_SAMURAI_BOOTS_MASTER.get());

            AzArmorRendererRegistry.register(KimonoArmorRenderer::new,
                    ItemsRegistry.KIMONO.get());

            AzArmorRendererRegistry.register(NetheriteNinjaArmorRenderer::new,
                    ItemsRegistry.NETHERITE_NINJA_HELMET.get(),
                    ItemsRegistry.NETHERITE_NINJA_CHESTPLATE.get(),
                    ItemsRegistry.NETHERITE_NINJA_BOOTS.get());
            AzArmorRendererRegistry.register(NetheriteSamuraiArmorRenderer::new,
                    ItemsRegistry.NETHERITE_SAMURAI_HELMET.get(),
                    ItemsRegistry.NETHERITE_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.NETHERITE_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.NETHERITE_SAMURAI_BOOTS.get());
            AzArmorRendererRegistry.register(NetheriteSamuraiArmorLightRenderer::new,
                    ItemsRegistry.NETHERITE_SAMURAI_HELMET_LIGHT.get(),
                    ItemsRegistry.NETHERITE_SAMURAI_CHESTPLATE_LIGHT.get(),
                    ItemsRegistry.NETHERITE_SAMURAI_LEGGINGS_LIGHT.get(),
                    ItemsRegistry.NETHERITE_SAMURAI_BOOTS_LIGHT.get());
            AzArmorRendererRegistry.register(NetheriteSamuraiArmorMasterRenderer::new,
                    ItemsRegistry.NETHERITE_SAMURAI_HELMET_MASTER.get(),
                    ItemsRegistry.NETHERITE_SAMURAI_CHESTPLATE_MASTER.get(),
                    ItemsRegistry.NETHERITE_SAMURAI_LEGGINGS_MASTER.get(),
                    ItemsRegistry.NETHERITE_SAMURAI_BOOTS_MASTER.get());

            AzArmorRendererRegistry.register(QuartzSamuraiArmorRenderer::new,
                    ItemsRegistry.QUARTZ_SAMURAI_HELMET.get(),
                    ItemsRegistry.QUARTZ_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.QUARTZ_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.QUARTZ_SAMURAI_BOOTS.get());

            AzArmorRendererRegistry.register(RedSamuraiArmorRenderer::new,
                    ItemsRegistry.RED_SAMURAI_HELMET.get(),
                    ItemsRegistry.RED_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.RED_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.RED_SAMURAI_BOOTS.get());
            AzArmorRendererRegistry.register(RedSamuraiArmorLightRenderer::new,
                    ItemsRegistry.RED_SAMURAI_HELMET_LIGHT.get(),
                    ItemsRegistry.RED_SAMURAI_CHESTPLATE_LIGHT.get(),
                    ItemsRegistry.RED_SAMURAI_LEGGINGS_LIGHT.get(),
                    ItemsRegistry.RED_SAMURAI_BOOTS_LIGHT.get());
            AzArmorRendererRegistry.register(RedSamuraiArmorMasterRenderer::new,
                    ItemsRegistry.RED_SAMURAI_HELMET_MASTER.get(),
                    ItemsRegistry.RED_SAMURAI_CHESTPLATE_MASTER.get(),
                    ItemsRegistry.RED_SAMURAI_LEGGINGS_MASTER.get(),
                    ItemsRegistry.RED_SAMURAI_BOOTS_MASTER.get());

            AzArmorRendererRegistry.register(SteelArmorRenderer::new,
                    ItemsRegistry.STEEL_HELMET.get(),
                    ItemsRegistry.STEEL_CHESTPLATE.get(),
                    ItemsRegistry.STEEL_LEGGINGS.get(),
                    ItemsRegistry.STEEL_BOOTS.get());
            AzArmorRendererRegistry.register(SteelNinjaArmorRenderer::new,
                    ItemsRegistry.STEEL_NINJA_HELMET.get(),
                    ItemsRegistry.STEEL_NINJA_CHESTPLATE.get(),
                    ItemsRegistry.STEEL_NINJA_BOOTS.get());

            AzArmorRendererRegistry.register(WhiteSamuraiArmorRenderer::new,
                    ItemsRegistry.WHITE_SAMURAI_HELMET.get(),
                    ItemsRegistry.WHITE_SAMURAI_CHESTPLATE.get(),
                    ItemsRegistry.WHITE_SAMURAI_LEGGINGS.get(),
                    ItemsRegistry.WHITE_SAMURAI_BOOTS.get());
            AzArmorRendererRegistry.register(WhiteSamuraiArmorLightRenderer::new,
                    ItemsRegistry.WHITE_SAMURAI_HELMET_LIGHT.get(),
                    ItemsRegistry.WHITE_SAMURAI_CHESTPLATE_LIGHT.get(),
                    ItemsRegistry.WHITE_SAMURAI_LEGGINGS_LIGHT.get(),
                    ItemsRegistry.WHITE_SAMURAI_BOOTS_LIGHT.get());
            AzArmorRendererRegistry.register(WhiteSamuraiArmorMasterRenderer::new,
                    ItemsRegistry.WHITE_SAMURAI_HELMET_MASTER.get(),
                    ItemsRegistry.WHITE_SAMURAI_CHESTPLATE_MASTER.get(),
                    ItemsRegistry.WHITE_SAMURAI_LEGGINGS_MASTER.get(),
                    ItemsRegistry.WHITE_SAMURAI_BOOTS_MASTER.get());
            
            if(ModList.get().isLoaded("deeperdarker")) {
                AzArmorRendererRegistry.register(SculkSamuraiArmorRenderer::new,
                        DeeperDarkerCompat.SCULK_SAMURAI_HELMET.get(),
                        DeeperDarkerCompat.SCULK_SAMURAI_CHESTPLATE.get(),
                        DeeperDarkerCompat.SCULK_SAMURAI_LEGGINGS.get(),
                        DeeperDarkerCompat.SCULK_SAMURAI_BOOTS.get());
            }
            if(ModList.get().isLoaded("create")) {
                AzArmorRendererRegistry.register(BrassSamuraiArmorRenderer::new,
                        CreateCompat.BRASS_SAMURAI_HELMET.get(),
                        CreateCompat.BRASS_SAMURAI_CHESTPLATE.get(),
                        CreateCompat.BRASS_SAMURAI_LEGGINGS.get(),
                        CreateCompat.BRASS_SAMURAI_BOOTS.get());
            }
            if(ModList.get().isLoaded("ars_nouveau")) {
                AzArmorRendererRegistry.register(MageSamuraiArmorRenderer::new,
                        ArsNouveauCompat.MAGE_SAMURAI_HELMET.get(),
                        ArsNouveauCompat.MAGE_SAMURAI_CHESTPLATE.get(),
                        ArsNouveauCompat.MAGE_SAMURAI_LEGGINGS.get(),
                        ArsNouveauCompat.MAGE_SAMURAI_BOOTS.get());
            }
            if(ModList.get().isLoaded("aquaculture")) {
                AzArmorRendererRegistry.register(NeptuniumSamuraiArmorRenderer::new,
                        AquacultureCompat.NEPTUNIUM_SAMURAI_HELMET.get(),
                        AquacultureCompat.NEPTUNIUM_SAMURAI_CHESTPLATE.get(),
                        AquacultureCompat.NEPTUNIUM_SAMURAI_LEGGINGS.get(),
                        AquacultureCompat.NEPTUNIUM_SAMURAI_BOOTS.get());
            }
            if(ModList.get().isLoaded("eldritch_end")) {
                AzArmorRendererRegistry.register(TyrSamuraiArmorRenderer::new,
                        EldritchEndCompat.ETYRITE_SAMURAI_HELMET.get(),
                        EldritchEndCompat.ETYRITE_SAMURAI_CHESTPLATE.get(),
                        EldritchEndCompat.ETYRITE_SAMURAI_LEGGINGS.get(),
                        EldritchEndCompat.ETYRITE_SAMURAI_BOOTS.get());
            }
            if(ModList.get().isLoaded("bloodmagic")) {
                AzArmorRendererRegistry.register(LivingSamuraiArmorRenderer::new,
                        BloodMagicCompat.LIVING_SAMURAI_HELMET.get(),
                        BloodMagicCompat.LIVING_SAMURAI_CHESTPLATE.get(),
                        BloodMagicCompat.LIVING_SAMURAI_LEGGINGS.get(),
                        BloodMagicCompat.LIVING_SAMURAI_BOOTS.get());
            }
            if(ModList.get().isLoaded("forbidden_arcanus")) {
                AzArmorRendererRegistry.register(DracoSamuraiArmorRenderer::new,
                        ForbiddenCompat.DRACO_SAMURAI_HELMET.get(),
                        ForbiddenCompat.DRACO_SAMURAI_CHESTPLATE.get(),
                        ForbiddenCompat.DRACO_SAMURAI_LEGGINGS.get(),
                        ForbiddenCompat.DRACO_SAMURAI_BOOTS.get());
                AzArmorRendererRegistry.register(TyrSamuraiArmorRenderer::new,
                        ForbiddenCompat.TYR_SAMURAI_HELMET.get(),
                        ForbiddenCompat.TYR_SAMURAI_CHESTPLATE.get(),
                        ForbiddenCompat.TYR_SAMURAI_LEGGINGS.get(),
                        ForbiddenCompat.TYR_SAMURAI_BOOTS.get());
            }

        }
    }

}
