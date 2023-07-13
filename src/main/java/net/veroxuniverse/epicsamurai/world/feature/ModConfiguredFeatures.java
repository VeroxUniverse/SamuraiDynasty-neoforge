package net.veroxuniverse.epicsamurai.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.veroxuniverse.epicsamurai.config.ModCommonConfigs;
import net.veroxuniverse.epicsamurai.registry.BlocksRegistry;

import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_RUBY_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlocksRegistry.RUBY_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlocksRegistry.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> RUBY_ORE = FeatureUtils.register("ruby_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_RUBY_ORES, ModCommonConfigs.RUBY_ORE_VEIN_SIZE.get()));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_JADE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlocksRegistry.JADE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlocksRegistry.DEEPSLATE_JADE_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> JADE_ORE = FeatureUtils.register("jade_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_JADE_ORES, ModCommonConfigs.JADE_ORE_VEIN_SIZE.get()));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_ONYX_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlocksRegistry.ONYX_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlocksRegistry.DEEPSLATE_ONYX_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ONYX_ORE = FeatureUtils.register("onyx_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_ONYX_ORES, ModCommonConfigs.ONYX_ORE_VEIN_SIZE.get()));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_AQUAMARINE_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlocksRegistry.AQUAMARINE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlocksRegistry.DEEPSLATE_AQUAMARINE_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> AQUAMARINE_ORE = FeatureUtils.register("aquamarine_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_AQUAMARINE_ORES, ModCommonConfigs.AQUAMARINE_ORE_VEIN_SIZE.get()));

    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_SILVER_ORES = List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlocksRegistry.SILVER_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlocksRegistry.DEEPSLATE_SILVER_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> SILVER_ORE = FeatureUtils.register("silver_ore",
            Feature.ORE, new OreConfiguration(OVERWORLD_SILVER_ORES, ModCommonConfigs.SILVER_ORE_VEIN_SIZE.get()));


}
