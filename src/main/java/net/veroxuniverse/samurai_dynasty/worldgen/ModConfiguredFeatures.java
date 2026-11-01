package net.veroxuniverse.samurai_dynasty.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;
import net.veroxuniverse.samurai_dynasty.utils.ModTags;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPIDER_LILLY_KEY = registerKey("spider_lilly");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TWISTTHORN_PETALS_KEY = registerKey("twistthorn_petals");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOSS_KEY = registerKey("moss");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        register(context, SPIDER_LILLY_KEY, Feature.FLOWER, new RandomPatchConfiguration(42, 6, 2,
                PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BlocksRegistry.SPIDER_LILLY.get())),
                        BlockPredicate.allOf(
                                BlockPredicate.matchesBlocks(Blocks.AIR),
                                BlockPredicate.matchesTag(new BlockPos(0, -1, 0), ModTags.SPIRIT_VALID_GROUND)
                        ))));

        register(context, TWISTTHORN_PETALS_KEY, Feature.FLOWER, new RandomPatchConfiguration(42, 6, 1,
                PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(BlocksRegistry.TWISTTHORN_PETALS.get())),
                        BlockPredicate.allOf(
                                BlockPredicate.matchesBlocks(Blocks.AIR),
                                BlockPredicate.matchesTag(new BlockPos(0, -1, 0), ModTags.SPIRIT_VALID_GROUND)
                        ))));

        register(context, MOSS_KEY, Feature.FLOWER, new RandomPatchConfiguration(42, 6, 1,
                PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.MOSS_CARPET)),
                        BlockPredicate.allOf(
                                BlockPredicate.matchesBlocks(Blocks.AIR),
                                BlockPredicate.matchesTag(new BlockPos(0, -1, 0), ModTags.SPIRIT_VALID_GROUND)
                        ))));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}