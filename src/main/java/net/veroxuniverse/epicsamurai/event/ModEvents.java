package net.veroxuniverse.epicsamurai.event;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
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
            event.put(ModEntityTypes.JOROGUMO.get(), JorogumoEntity.setAttributes());
            event.put(ModEntityTypes.FUJIN.get(), FujinEntity.setAttributes());
            event.put(ModEntityTypes.RAIJIN.get(), RaijinEntity.setAttributes());
            event.put(ModEntityTypes.KOMAINU.get(), KomainuEntity.setAttributes());
            event.put(ModEntityTypes.TANUKI.get(), KomainuEntity.setAttributes());
            event.put(ModEntityTypes.KAWAUSO.get(), KomainuEntity.setAttributes());
            event.put(ModEntityTypes.TWOTAILED.get(), TwoTailedFox.setAttributes());
        }
        @SubscribeEvent
        public static void entitySpawnRestriction(SpawnPlacementRegisterEvent event) {
            event.register(ModEntityTypes.ONI.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
            event.register(ModEntityTypes.ENENRA.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
            event.register(ModEntityTypes.AKANAME.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
            event.register(ModEntityTypes.KITSUNE.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING,
                    Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
            event.register(ModEntityTypes.JOROGUMO.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
            event.register(ModEntityTypes.TANUKI.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
            event.register(ModEntityTypes.KAWAUSO.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
            event.register(ModEntityTypes.TWOTAILED.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
            event.register(ModEntityTypes.KOMAINU.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        }

    }

}
