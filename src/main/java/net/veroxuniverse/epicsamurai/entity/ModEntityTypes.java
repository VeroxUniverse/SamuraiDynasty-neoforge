package net.veroxuniverse.epicsamurai.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.*;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<EntityType<AkanameEntity>> AKANAME =
            ENTITY_TYPES.register("akaname",
                    () -> EntityType.Builder.of(AkanameEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 1.8f)
                            .build(new ResourceLocation(EpicSamuraiMod.MOD_ID, "akaname").toString()));

    public static final RegistryObject<EntityType<KitsuneEntity>> KITSUNE =
            ENTITY_TYPES.register("kitsune",
                    () -> EntityType.Builder.of(KitsuneEntity::new, MobCategory.MONSTER)
                            .sized(1.3964844F, 1.6f)
                            .fireImmune()
                            .build(new ResourceLocation(EpicSamuraiMod.MOD_ID, "kitsune").toString()));


    public static final RegistryObject<EntityType<EnenraEntity>> ENENRA =
            ENTITY_TYPES.register("enenra",
                    () -> EntityType.Builder.of(EnenraEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 1.8f)
                            .build(new ResourceLocation(EpicSamuraiMod.MOD_ID, "enenra").toString()));

    public static final RegistryObject<EntityType<OniEntity>> ONI =
            ENTITY_TYPES.register("oni",
                    () -> EntityType.Builder.of(OniEntity::new, MobCategory.MONSTER)
                            .sized(1.8f, 2.6f)
                            .fireImmune()
                            .build(new ResourceLocation(EpicSamuraiMod.MOD_ID, "oni").toString()));

    public static final RegistryObject<EntityType<OnibiEntity>> ONIBI =
            ENTITY_TYPES.register("onibi",
                    () -> EntityType.Builder.of(OnibiEntity::new, MobCategory.MONSTER)
                            .sized(0.2f, 0.8f)
                            .fireImmune()
                            .build(new ResourceLocation(EpicSamuraiMod.MOD_ID, "onibi").toString()));

    public static final RegistryObject<EntityType<JorogumoEntity>> JOROGUMO =
            ENTITY_TYPES.register("jorogumo",
                    () -> EntityType.Builder.of(JorogumoEntity::new, MobCategory.MONSTER)
                            .sized(1.8f, 2.0f)
                            .fireImmune()
                            .build(new ResourceLocation(EpicSamuraiMod.MOD_ID, "jorogumo").toString()));

    public static final RegistryObject<EntityType<RaijinEntity>> RAIJIN =
            ENTITY_TYPES.register("raijin",
                    () -> EntityType.Builder.of(RaijinEntity::new, MobCategory.MONSTER)
                            .sized(1.8f, 2.0f)
                            .fireImmune()
                            .build(new ResourceLocation(EpicSamuraiMod.MOD_ID, "raijin").toString()));

    public static final RegistryObject<EntityType<FujinEntity>> FUJIN =
            ENTITY_TYPES.register("fujin",
                    () -> EntityType.Builder.of(FujinEntity::new, MobCategory.MONSTER)
                            .sized(1.8f, 2.0f)
                            .fireImmune()
                            .build(new ResourceLocation(EpicSamuraiMod.MOD_ID, "fujin").toString()));

    public static final RegistryObject<EntityType<ShurikenEntity>> SHURIKEN =
            ENTITY_TYPES.register("shuriken",
                    () -> EntityType.Builder.<ShurikenEntity>of(ShurikenEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(10)
                            .build(new ResourceLocation(EpicSamuraiMod.MOD_ID, "shuriken").toString()));

    public static final RegistryObject<EntityType<KunaiEntity>> KUNAI =
            ENTITY_TYPES.register("kunai",
                    () -> EntityType.Builder.<KunaiEntity>of(KunaiEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build(new ResourceLocation(EpicSamuraiMod.MOD_ID, "kunai").toString()));

    public static final RegistryObject<EntityType<KitsuneProjectileEntity>> KITSUNE_PROJECTILE =
            ENTITY_TYPES.register("kitsune_projectile",
                    () -> EntityType.Builder.<KitsuneProjectileEntity>of(KitsuneProjectileEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build(new ResourceLocation(EpicSamuraiMod.MOD_ID, "kitsune_projectile").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
