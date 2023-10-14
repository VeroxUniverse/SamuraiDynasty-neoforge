package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.AkanameEntity;
import net.veroxuniverse.epicsamurai.entity.custom.KawausoEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class KawausoModel extends GeoModel<KawausoEntity> {
    @Override
    public ResourceLocation getModelResource(KawausoEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/kawauso.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KawausoEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/kawauso.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KawausoEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/kawauso.animation.json");
    }

    @Override
    public void setCustomAnimations(KawausoEntity animatable, long instanceId, AnimationState<KawausoEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}