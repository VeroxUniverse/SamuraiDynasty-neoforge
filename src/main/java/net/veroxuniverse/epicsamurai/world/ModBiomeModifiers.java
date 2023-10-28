package net.veroxuniverse.epicsamurai.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;

import java.util.List;

public class ModBiomeModifiers {

    public static final ResourceKey<BiomeModifier> SPAWN_TANUKI = registerKey("spawn_tanuki");
    public static final ResourceKey<BiomeModifier> SPAWN_KOMAINU = registerKey("spawn_komainu");
    public static final ResourceKey<BiomeModifier> SPAWN_KAWAUSO = registerKey("spawn_kawauso");
    public static final ResourceKey<BiomeModifier> SPAWN_KITSUNE = registerKey("spawn_kitsune");
    public static final ResourceKey<BiomeModifier> SPAWN_ONI = registerKey("spawn_oni");
    public static final ResourceKey<BiomeModifier> SPAWN_ENENRA = registerKey("spawn_enenra");
    public static final ResourceKey<BiomeModifier> SPAWN_AKANAME = registerKey("spawn_akaname");
    public static final ResourceKey<BiomeModifier> SPAWN_JOROGUMO = registerKey("spawn_jorogumo");

    public static final ResourceKey<BiomeModifier> SPAWN_TWOTAILED = registerKey("spawn_twotailed");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(SPAWN_TANUKI, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntityTypes.TANUKI.get(), 20, 1, 2))));
        context.register(SPAWN_AKANAME, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                List.of(new MobSpawnSettings.SpawnerData(ModEntityTypes.AKANAME.get(), 20, 2, 4))));
        context.register(SPAWN_ENENRA, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntityTypes.ENENRA.get(), 20, 2, 4))));
        context.register(SPAWN_JOROGUMO, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntityTypes.JOROGUMO.get(), 20, 1, 2))));
        context.register(SPAWN_KAWAUSO, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntityTypes.KAWAUSO.get(), 20, 1, 2))));
        context.register(SPAWN_KITSUNE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntityTypes.KITSUNE.get(), 20, 1, 1))));
        context.register(SPAWN_ONI, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                List.of(new MobSpawnSettings.SpawnerData(ModEntityTypes.ONI.get(), 20, 1, 2))));
        context.register(SPAWN_KOMAINU, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntityTypes.KOMAINU.get(), 20, 2, 4))));
        context.register(SPAWN_TWOTAILED, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(ModEntityTypes.TWOTAILED.get(), 20, 2, 4))));
    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(EpicSamuraiMod.MOD_ID, name));
    }
}