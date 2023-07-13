package net.veroxuniverse.epicsamurai.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.veroxuniverse.epicsamurai.config.ModCommonConfigs;

public class ModPlacedFeatures {

    public static final Holder<PlacedFeature> RUBY_ORE_PLACED = PlacementUtils.register("ruby_ore_placed",
            ModConfiguredFeatures.RUBY_ORE, ModOrePlacement.commonOrePlacement(ModCommonConfigs.RUBY_ORE_VEINS_PER_CHUNK.get(), // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(30))));

    public static final Holder<PlacedFeature> JADE_ORE_PLACED = PlacementUtils.register("jade_ore_placed",
            ModConfiguredFeatures.JADE_ORE, ModOrePlacement.commonOrePlacement(ModCommonConfigs.JADE_ORE_VEINS_PER_CHUNK.get(), // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(30))));

    public static final Holder<PlacedFeature> ONYX_ORE_PLACED = PlacementUtils.register("onyx_ore_placed",
            ModConfiguredFeatures.ONYX_ORE, ModOrePlacement.commonOrePlacement(ModCommonConfigs.JADE_ORE_VEINS_PER_CHUNK.get(), // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(30))));

    public static final Holder<PlacedFeature> SILVER_ORE_PLACED = PlacementUtils.register("silver_ore_placed",
            ModConfiguredFeatures.SILVER_ORE, ModOrePlacement.commonOrePlacement(ModCommonConfigs.SILVER_ORE_VEINS_PER_CHUNK.get(), // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(30))));

    public static final Holder<PlacedFeature> AQUAMARINE_ORE_PLACED = PlacementUtils.register("aquamarine_ore_placed",
            ModConfiguredFeatures.AQUAMARINE_ORE, ModOrePlacement.commonOrePlacement(ModCommonConfigs.AQUAMARINE_ORE_VEINS_PER_CHUNK.get(), // VeinsPerChunk
                    HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64), VerticalAnchor.aboveBottom(30))));


}