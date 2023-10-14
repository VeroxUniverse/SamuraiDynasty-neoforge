package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.KomainuEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class KomainuModel extends GeoModel<KomainuEntity> {

    @Override
    public ResourceLocation getModelResource(KomainuEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/komainu.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KomainuEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/komainu.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KomainuEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/komainu.animation.json");
    }

    @Override
    public void setCustomAnimations(KomainuEntity animatable, long instanceId, AnimationState<KomainuEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}