package net.veroxuniverse.epicsamurai.entity;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.AkanameEntity;
import net.veroxuniverse.epicsamurai.entity.custom.EnenraEntity;
import net.veroxuniverse.epicsamurai.entity.custom.ShurikenEntity;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EpicSamuraiMod.MOD_ID);

    public static final RegistryObject<EntityType<AkanameEntity>> AKANAME =
            ENTITY_TYPES.register("akaname",
                    () -> EntityType.Builder.of(AkanameEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 1.8f)
                            .build(new ResourceLocation(EpicSamuraiMod.MOD_ID, "akaname").toString()));

    public static final RegistryObject<EntityType<EnenraEntity>> ENENRA =
            ENTITY_TYPES.register("enenra",
                    () -> EntityType.Builder.of(EnenraEntity::new, MobCategory.MONSTER)
                            .sized(0.8f, 1.8f)
                            .build(new ResourceLocation(EpicSamuraiMod.MOD_ID, "enenra").toString()));

    /*

    public static final RegistryObject<EntityType<ShurikenEntity>> SHURIKEN =
            ENTITY_TYPES.register("shuriken",
                    () -> EntityType.Builder.of(ShurikenEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(10));

    */

    public static final EntityType<ShurikenEntity> SHURIKEN = register(
            "shuriken", EntityType.Builder.<ShurikenEntity>of(ShurikenEntity::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10));

    private static <T extends Entity> EntityType<T> register(String pKey, EntityType.Builder<T> pBuilder) {
        return Registry.register(Registry.ENTITY_TYPE, pKey, pBuilder.build(pKey));
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
