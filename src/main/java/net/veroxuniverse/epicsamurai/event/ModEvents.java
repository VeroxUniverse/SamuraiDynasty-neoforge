package net.veroxuniverse.epicsamurai.event;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;
import net.veroxuniverse.epicsamurai.entity.custom.*;
import net.veroxuniverse.epicsamurai.network.FriendlyByteBufs;
import net.veroxuniverse.epicsamurai.network.ModMessages;
import net.veroxuniverse.epicsamurai.network.packet.KiDataSyncS2CPacket;
import net.veroxuniverse.epicsamurai.reiki.PlayerKi;
import net.veroxuniverse.epicsamurai.reiki.PlayerKiProvider;
import net.veroxuniverse.epicsamurai.utils.KeyBinding;

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


    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerKiProvider.PLAYER_KI).isPresent()) {
                event.addCapability(new ResourceLocation(EpicSamuraiMod.MOD_ID, "properties"), new PlayerKiProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerKiProvider.PLAYER_KI).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerKiProvider.PLAYER_KI).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerKi.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            event.player.getCapability(PlayerKiProvider.PLAYER_KI).ifPresent(ki -> {
                if(ki.getKi() >= 0 && event.player.getRandom().nextFloat() < 0.005f) { // Once Every 10 Seconds on Avg
                    ki.addKi(10);
                    event.player.sendSystemMessage(Component.literal("Added Ki"));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if(!event.getLevel().isClientSide()) {
            if(event.getEntity() instanceof ServerPlayer player) {
                FriendlyByteBuf buf = FriendlyByteBufs.create();
                buf.writeBoolean(KeyBinding.KATANA_KEY.isDown());
                player.getCapability(PlayerKiProvider.PLAYER_KI).ifPresent(ki -> {
                    ModMessages.sendToClient(player, buf);
                });
            }
        }
    }

}
