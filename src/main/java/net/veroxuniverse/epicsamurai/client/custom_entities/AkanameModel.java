package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.AkanameEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class AkanameModel extends GeoModel<AkanameEntity> {
    @Override
    public ResourceLocation getModelResource(AkanameEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/akaname.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AkanameEntity object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/entity/akaname.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AkanameEntity animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/akaname.animation.json");
    }

    @Override
    public void setCustomAnimations(AkanameEntity animatable, long instanceId, AnimationState<AkanameEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}