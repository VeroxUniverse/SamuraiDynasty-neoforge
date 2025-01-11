package net.veroxuniverse.samurai_dynasty.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, SamuraiDynastyMod.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLUE_FLAME = PARTICLE_TYPES.register("blue_flame",
            () -> new SimpleParticleType(true));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPIRIT_WOOD_LEAVES = PARTICLE_TYPES.register("spirit_wood_leaves",
            () -> new SimpleParticleType(true));

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPIRIT_BLOSSOM_LEAVES = PARTICLE_TYPES.register("spirit_blossom_leaves",
            () -> new SimpleParticleType(true));



    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
