package net.veroxuniverse.epicsamurai.world;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.world.worldgen.ModEntityGeneration;
import net.veroxuniverse.epicsamurai.world.worldgen.ModOreGeneration;

@Mod.EventBusSubscriber(modid = EpicSamuraiMod.MOD_ID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
        ModEntityGeneration.onEntitySpawn(event);

    }
}
