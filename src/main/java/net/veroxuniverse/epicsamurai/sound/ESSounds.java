package net.veroxuniverse.epicsamurai.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;

public class ESSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<SoundEvent> GUN_RELOAD = registerSoundEvents("gun_reload");
    public static final RegistryObject<SoundEvent> GUN_RELOAD_DROP = registerSoundEvents("gun_reload_drop");
    public static final RegistryObject<SoundEvent> GUN_SHOOT = registerSoundEvents("gun_shoot");
    public static final RegistryObject<SoundEvent> GUN_HIT = registerSoundEvents("gun_hit");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name){
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(EpicSamuraiMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
