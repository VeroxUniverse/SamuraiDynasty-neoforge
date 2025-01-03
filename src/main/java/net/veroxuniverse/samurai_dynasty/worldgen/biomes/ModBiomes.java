package net.veroxuniverse.samurai_dynasty.worldgen.biomes;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

public class ModBiomes {

    public static final ResourceKey<Biome> MAPLE_FOREST = register("maple_forest");

    private static ResourceKey<Biome> register(String name){
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, name));
    }
}
