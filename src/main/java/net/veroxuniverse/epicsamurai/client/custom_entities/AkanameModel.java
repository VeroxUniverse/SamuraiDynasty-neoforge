package net.veroxuniverse.epicsamurai.client.custom_entities;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.AkanameEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class AkanameModel extends AnimatedGeoModel<AkanameEntity> {
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

    @SuppressWarnings({ "unchecked" })
    @Override
    public void setLivingAnimations(AkanameEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");


        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}