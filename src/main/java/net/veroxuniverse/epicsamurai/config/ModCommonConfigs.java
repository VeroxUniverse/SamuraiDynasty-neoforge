package net.veroxuniverse.epicsamurai.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;

import java.io.File;

public class ModCommonConfigs {

    private static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec.ConfigValue<Integer> RUBY_ORE_VEINS_PER_CHUNK;
    public static ForgeConfigSpec.ConfigValue<Integer> RUBY_ORE_VEIN_SIZE;
    public static ForgeConfigSpec.ConfigValue<Integer> JADE_ORE_VEINS_PER_CHUNK;
    public static ForgeConfigSpec.ConfigValue<Integer> JADE_ORE_VEIN_SIZE;
    public static ForgeConfigSpec.ConfigValue<Integer> ONYX_ORE_VEINS_PER_CHUNK;
    public static ForgeConfigSpec.ConfigValue<Integer> ONYX_ORE_VEIN_SIZE;
    public static ForgeConfigSpec.ConfigValue<Integer> SILVER_ORE_VEINS_PER_CHUNK;
    public static ForgeConfigSpec.ConfigValue<Integer> SILVER_ORE_VEIN_SIZE;
    public static ForgeConfigSpec.ConfigValue<Integer> AQUAMARINE_ORE_VEINS_PER_CHUNK;
    public static ForgeConfigSpec.ConfigValue<Integer> AQUAMARINE_ORE_VEIN_SIZE;

    private static CommentedFileConfig fileConfig;

    public ModCommonConfigs(){
        fileConfig = CommentedFileConfig
                .builder(new File(FMLPaths.CONFIGDIR.get().toString(), EpicSamuraiMod.MOD_ID + "-common.toml")).sync()
                .autosave().build();

        fileConfig.load();
        initConfig();
        ForgeConfigSpec spec = builder.build();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, spec, fileConfig.getFile().getName());
        spec.setConfig(fileConfig);
    }


    private void initConfig(){

        builder.comment("Config for EpicSamurai Mod").push("epicsamurai_mod_configuration");

        RUBY_ORE_VEINS_PER_CHUNK = builder
                .comment("How many Ruby Ore Veins spawn per chunk!")
                .defineInRange("Veins Per Chunk", 2, 2, 10);
        RUBY_ORE_VEIN_SIZE = builder
                .comment("How many Ruby Ore Blocks spawn in one Vein!")
                .defineInRange("Vein Size", 5, 1, 20);

        JADE_ORE_VEINS_PER_CHUNK = builder
                .comment("How many Jade Ore Veins spawn per chunk!")
                .defineInRange("Veins Per Chunk", 2, 2, 10);
        JADE_ORE_VEIN_SIZE = builder
                .comment("How many Jade Ore Blocks spawn in one Vein!")
                .defineInRange("Vein Size", 5, 1, 20);

        ONYX_ORE_VEINS_PER_CHUNK = builder
                .comment("How many Onyx Ore Veins spawn per chunk!")
                .defineInRange("Veins Per Chunk", 2, 2, 10);
        ONYX_ORE_VEIN_SIZE = builder
                .comment("How many Onyx Ore Blocks spawn in one Vein!")
                .defineInRange("Vein Size", 5, 1, 20);

        SILVER_ORE_VEINS_PER_CHUNK = builder
                .comment("How many Silver Ore Veins spawn per chunk!")
                .defineInRange("Veins Per Chunk", 4, 2, 10);
        SILVER_ORE_VEIN_SIZE = builder
                .comment("How many Silver Ore Blocks spawn in one Vein!")
                .defineInRange("Vein Size", 9, 1, 20);

        AQUAMARINE_ORE_VEINS_PER_CHUNK = builder
                .comment("How many Aquamarine Ore Veins spawn per chunk!")
                .defineInRange("Veins Per Chunk", 2, 2, 10);
        AQUAMARINE_ORE_VEIN_SIZE = builder
                .comment("How many Aquamarine Ore Blocks spawn in one Vein!")
                .defineInRange("Vein Size", 5, 1, 20);

        builder.pop();
        builder.build();
    }

}
