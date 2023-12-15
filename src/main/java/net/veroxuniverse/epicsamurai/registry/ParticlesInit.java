package net.veroxuniverse.epicsamurai.registry;

import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;

public class ParticlesInit {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, EpicSamuraiMod.MOD_ID);


    public static final SimpleParticleType BLUE_FLAME = register("blue_flame", true);

    private static SimpleParticleType register(String name, boolean b) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, name, new SimpleParticleType(b));
    }


    public static void register() {
        PARTICLE_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
