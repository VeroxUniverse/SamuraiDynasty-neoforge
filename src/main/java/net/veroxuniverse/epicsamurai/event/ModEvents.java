package net.veroxuniverse.epicsamurai.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;
import net.veroxuniverse.epicsamurai.entity.custom.*;

public class ModEvents {

    @Mod.EventBusSubscriber(modid = EpicSamuraiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.AKANAME.get(), AkanameEntity.setAttributes());
            event.put(ModEntityTypes.ENENRA.get(), EnenraEntity.setAttributes());
            event.put(ModEntityTypes.ONI.get(), OniEntity.setAttributes());
            event.put(ModEntityTypes.KITSUNE.get(), KitsuneEntity.setAttributes());
            event.put(ModEntityTypes.ONIBI.get(), OnibiEntity.setAttributes());
        }

    }

}
