package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.OniEntity;
import net.veroxuniverse.epicsamurai.entity.custom.OnibiEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class OnibiModel extends AnimatedGeoModel<OnibiEntity> {
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

    @SuppressWarnings({ "unchecked" })
    @Override
    public void setLivingAnimations(OnibiEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");


        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 120F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 120F));
        }
    }

}