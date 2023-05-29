package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.onyx;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.GraySamuraiArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GraySamuraiArmorModel extends AnimatedGeoModel<GraySamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(GraySamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GraySamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/gray_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GraySamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
