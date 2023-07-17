package net.veroxuniverse.epicsamurai.world.feature;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.config.ModCommonConfigs;
import net.veroxuniverse.epicsamurai.registry.BlocksRegistry;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RUBY_ORE_KEY = registerKey("ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ONXY_ORE_KEY = registerKey("onyx_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_JADE_ORE_KEY = registerKey("jade_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_AQUAMARINE_ORE_KEY = registerKey("aquamarine_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldRubyOres = List.of(OreConfiguration.target(stoneReplaceables,
                        BlocksRegistry.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlocksRegistry.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubyOres, 9));



        List<OreConfiguration.TargetBlockState> overworldSilverOres = List.of(OreConfiguration.target(stoneReplaceables,
                        BlocksRegistry.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlocksRegistry.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));


        if (ModCommonConfigs.SILVER_ORE_VEIN_SIZE.get() > 0) {
            register(context, OVERWORLD_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSilverOres, ModCommonConfigs.SILVER_ORE_VEIN_SIZE.get()));
        }


        List<OreConfiguration.TargetBlockState> overworldJadeOres = List.of(OreConfiguration.target(stoneReplaceables,
                        BlocksRegistry.JADE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlocksRegistry.DEEPSLATE_JADE_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_JADE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldJadeOres, 9));



        List<OreConfiguration.TargetBlockState> overworldOnyxOres = List.of(OreConfiguration.target(stoneReplaceables,
                        BlocksRegistry.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlocksRegistry.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_ONXY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOnyxOres, 9));



        List<OreConfiguration.TargetBlockState> overworldAquamarineOres = List.of(OreConfiguration.target(stoneReplaceables,
                        BlocksRegistry.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlocksRegistry.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_AQUAMARINE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAquamarineOres, 9));

    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(EpicSamuraiMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
