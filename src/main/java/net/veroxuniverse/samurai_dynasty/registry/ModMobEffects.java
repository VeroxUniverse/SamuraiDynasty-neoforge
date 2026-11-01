package net.veroxuniverse.samurai_dynasty.registry;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.effect.StruckMobEffect;

public class ModMobEffects {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, SamuraiDynastyMod.MOD_ID);

    public static final DeferredHolder<MobEffect, MobEffect> STRUCK = MOB_EFFECTS.register("struck",
            () -> new StruckMobEffect(MobEffectCategory.HARMFUL, 0xB8E8FF));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}