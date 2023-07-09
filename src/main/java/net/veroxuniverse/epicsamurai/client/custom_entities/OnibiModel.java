package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.OnibiEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class OnibiModel extends GeoModel<OnibiEntity> {
    @Override
    public ResourceLocation getModelResource(OnibiEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/spirit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OnibiEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/spirit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OnibiEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/spirit.animation.json");
    }

    @Override
    public void setCustomAnimations(OnibiEntity animatable, long instanceId, AnimationState<OnibiEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }

}