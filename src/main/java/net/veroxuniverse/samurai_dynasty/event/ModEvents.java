package net.veroxuniverse.samurai_dynasty.event;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.ModEntityTypes;
import net.veroxuniverse.samurai_dynasty.entity.custom.*;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;

public class ModEvents {

    @EventBusSubscriber(modid = SamuraiDynastyMod.MOD_ID)
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
            event.put(ModEntityTypes.TANUKI.get(), TanukiEntity.setAttributes());
            event.put(ModEntityTypes.KAWAUSO.get(), KawausoEntity.setAttributes());
            event.put(ModEntityTypes.TWOTAILED.get(), TwoTailedFox.setAttributes());
        }

        @SubscribeEvent
        public static void entitySpawnRestriction(RegisterSpawnPlacementsEvent event) {
            event.register(ModEntityTypes.ONI.get(),
                    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    ModEvents::checkCustomNightSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);

            event.register(ModEntityTypes.ENENRA.get(),
                    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    ModEvents::checkCustomNightSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);

            event.register(ModEntityTypes.AKANAME.get(),
                    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    ModEvents::checkCustomNightSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);

            event.register(ModEntityTypes.KITSUNE.get(),
                    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    ModEvents::checkCustomNightSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);

            event.register(ModEntityTypes.JOROGUMO.get(),
                    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    ModEvents::checkCustomNightSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);

            event.register(ModEntityTypes.TANUKI.get(),
                    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);

            event.register(ModEntityTypes.KAWAUSO.get(),
                    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);

            event.register(ModEntityTypes.TWOTAILED.get(),
                    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);

            event.register(ModEntityTypes.KOMAINU.get(),
                    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);
        }
    }

    public static boolean checkCustomNightSpawnRules(
            EntityType<? extends Monster> entityType,
            LevelAccessor level,
            MobSpawnType spawnType,
            BlockPos pos,
            RandomSource random) {

        boolean isNightTime = false;
        if (level instanceof Level realLevel) {
            isNightTime = realLevel.isNight();
        } else if (level instanceof ServerLevelAccessor serverLevel) {
            isNightTime = serverLevel.getLevel().isNight();
        }

        int surfaceY = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, pos.getX(), pos.getZ());
        boolean isAtSurface = pos.getY() >= surfaceY - 1;

        boolean vanillaMonsterRules = Monster.checkAnyLightMonsterSpawnRules(entityType, level, spawnType, pos, random);

        return isNightTime && isAtSurface && vanillaMonsterRules;
    }
}