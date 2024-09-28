package net.veroxuniverse.samurai_dynasty.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.entity.custom.*;

import java.util.function.Supplier;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, SamuraiDynastyMod.MOD_ID);

    static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(name, () -> builder.build(SamuraiDynastyMod.MOD_ID + ":" + name));
    }

    public static final Supplier<EntityType<AkanameEntity>> AKANAME = ENTITY_TYPES
            .register("akaname", () -> EntityType.Builder.of(AkanameEntity::new, MobCategory.MONSTER)
                    .sized(0.8f, 1.8f)
                    .build("akaname"));

    /*
    public static final DeferredHolder<EntityType<?>, EntityType<AkanameEntity>> AKANAME = registerEntity(
            "akaname",
                    EntityType.Builder.<AkanameEntity>of(AkanameEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 1.8f)
                            .setTrackingRange(20)
                            .setShouldReceiveVelocityUpdates(true));

     */

    public static final DeferredHolder<EntityType<?>, EntityType<KitsuneEntity>> KITSUNE = registerEntity(
            "kitsune",
                    EntityType.Builder.of(KitsuneEntity::new, MobCategory.MONSTER)
                            .sized(1.3964844F, 1.6f)
                            .fireImmune()
                            .setShouldReceiveVelocityUpdates(true));


    public static final DeferredHolder<EntityType<?>, EntityType<EnenraEntity>> ENENRA = registerEntity(
            "enenra",
                    EntityType.Builder.of(EnenraEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 1.8f)
                            .setShouldReceiveVelocityUpdates(true));

    public static final DeferredHolder<EntityType<?>, EntityType<OniEntity>> ONI = registerEntity(
            "oni",
                    EntityType.Builder.of(OniEntity::new, MobCategory.MONSTER)
                            .sized(1.8f, 2.6f)
                            .fireImmune()
                            .setShouldReceiveVelocityUpdates(true));

    public static final DeferredHolder<EntityType<?>, EntityType<OnibiEntity>> ONIBI = registerEntity(
            "onibi",
                    EntityType.Builder.of(OnibiEntity::new, MobCategory.MONSTER)
                            .sized(0.2f, 0.8f)
                            .fireImmune()
                            .setShouldReceiveVelocityUpdates(true));

    public static final DeferredHolder<EntityType<?>, EntityType<JorogumoEntity>> JOROGUMO = registerEntity(
            "jorogumo",
                   EntityType.Builder.of(JorogumoEntity::new, MobCategory.MONSTER)
                            .sized(1.8f, 2.0f)
                            .fireImmune()
                           .setShouldReceiveVelocityUpdates(true));

    public static final DeferredHolder<EntityType<?>, EntityType<RaijinEntity>> RAIJIN = registerEntity(
            "raijin",
                    EntityType.Builder.of(RaijinEntity::new, MobCategory.MONSTER)
                            .sized(1.8f, 2.0f)
                            .fireImmune()
                            .setShouldReceiveVelocityUpdates(true));

    public static final DeferredHolder<EntityType<?>, EntityType<FujinEntity>> FUJIN = registerEntity(
            "fujin",
                    EntityType.Builder.of(FujinEntity::new, MobCategory.MONSTER)
                            .sized(1.8f, 2.0f)
                            .fireImmune()
                            .setShouldReceiveVelocityUpdates(true));

    public static final DeferredHolder<EntityType<?>, EntityType<KomainuEntity>> KOMAINU = registerEntity(
           "komainu",
                   EntityType.Builder.of(KomainuEntity::new, MobCategory.CREATURE)
                           .sized(1.0f, 0.8f)
                           .fireImmune()
                           .setShouldReceiveVelocityUpdates(true));

    public static final DeferredHolder<EntityType<?>, EntityType<TanukiEntity>> TANUKI = registerEntity(
            "tanuki",
                    EntityType.Builder.of(TanukiEntity::new, MobCategory.CREATURE)
                            .sized(1.0f, 0.8f)
                            .fireImmune()
                            .setShouldReceiveVelocityUpdates(true));

    public static final DeferredHolder<EntityType<?>, EntityType<TwoTailedFox>> TWOTAILED = registerEntity(
            "twotailed",
                    EntityType.Builder.of(TwoTailedFox::new, MobCategory.CREATURE)
                            .sized(1.0f, 0.8f)
                            .fireImmune()
                            .setShouldReceiveVelocityUpdates(true));

    public static final DeferredHolder<EntityType<?>, EntityType<KawausoEntity>> KAWAUSO = registerEntity(
            "kawauso",
                    EntityType.Builder.of(KawausoEntity::new, MobCategory.CREATURE)
                            .sized(1.0f, 0.8f)
                            .fireImmune()
                            .setShouldReceiveVelocityUpdates(true));

    /*
    public static final DeferredHolder<EntityType<?>, EntityType<ThrownShurikenEntity>> SHURIKEN = registerEntity(
            "shuriken",
                    EntityType.Builder.<ThrownShurikenEntity>of(ThrownShurikenEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(10)
                            .setShouldReceiveVelocityUpdates(true));
     */

    public static final DeferredHolder<EntityType<?>, EntityType<ThrownShurikenEntity>> SHURIKEN = registerEntity(
            "shuriken",
                    EntityType.Builder.<ThrownShurikenEntity>of(ThrownShurikenEntity::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F)
                            .eyeHeight(0.13F)
                            .clientTrackingRange(4)
                            .setShouldReceiveVelocityUpdates(true)
                            .updateInterval(20));

    public static final DeferredHolder<EntityType<?>, EntityType<KunaiEntity>> KUNAI = registerEntity(
            "kunai",
                    EntityType.Builder.<KunaiEntity>of(KunaiEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .setShouldReceiveVelocityUpdates(true));

    public static final DeferredHolder<EntityType<?>, EntityType<NetheriteKunaiEntity>> KUNAI_NETHERITE = registerEntity(
            "kunai_netherite",
                    EntityType.Builder.<NetheriteKunaiEntity>of(NetheriteKunaiEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .setShouldReceiveVelocityUpdates(true));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
