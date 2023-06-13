package net.veroxuniverse.epicsamurai.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;

import java.util.List;

public class ModPlacedFeatures {


    public static final ResourceKey<PlacedFeature> RUBY_PLACED_KEY = createKey("ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> JADE_PLACED_KEY = createKey("jade_ore_placed");
    public static final ResourceKey<PlacedFeature> ONYX_PLACED_KEY = createKey("onyx_ore_placed");
    public static final ResourceKey<PlacedFeature> SILVER_PLACED_KEY = createKey("silver_ore_placed");
    public static final ResourceKey<PlacedFeature> AQUAMARINE_PLACED_KEY = createKey("aquamarine_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);


        register(context, RUBY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RUBY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(2, // veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(30))));

        register(context, JADE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_JADE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(2, // veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(30))));

        register(context, ONYX_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ONXY_ORE_KEY),
                ModOrePlacement.commonOrePlacement(2, // veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(30))));

        register(context, SILVER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(4, // veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(30))));

        register(context, AQUAMARINE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_AQUAMARINE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(2, // veins per chunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-64), VerticalAnchor.absolute(30))));
    }
    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(EpicSamuraiMod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}