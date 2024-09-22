package net.veroxuniverse.samurai_dynasty.registry;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.function.Function;

public class ModParticleTypes {

    public static final SimpleParticleType BLUE_FLAME = register("blue_flame", false);


    public static final Codec<ParticleOptions> CODEC = BuiltInRegistries.PARTICLE_TYPE
            .byNameCodec()
            .dispatch("type", ParticleOptions::getType, ParticleType::codec);
    public static final StreamCodec<RegistryFriendlyByteBuf, ParticleOptions> STREAM_CODEC = ByteBufCodecs.registry(Registries.PARTICLE_TYPE)
            .dispatch(ParticleOptions::getType, ParticleType::streamCodec);

    private static net.minecraft.core.particles.SimpleParticleType register(String pKey, boolean pOverrideLimiter) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, pKey, new SimpleParticleType(pOverrideLimiter));
    }

    private static <T extends ParticleOptions> ParticleType<T> register(
            String string,
            boolean b,
            final Function<ParticleType<T>, MapCodec<T>> mapCodecFunction,
            final Function<ParticleType<T>, StreamCodec<? super RegistryFriendlyByteBuf, T>> codecFunction
    ) {
        return Registry.register(BuiltInRegistries.PARTICLE_TYPE, string, new ParticleType<T>(b) {
            @Override
            public MapCodec<T> codec() {
                return mapCodecFunction.apply(this);
            }

            @Override
            public StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec() {
                return codecFunction.apply(this);
            }
        });
    }

}
