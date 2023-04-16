package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.GreenSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.RedSamuraiArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GreenSamuraiArmorModel extends AnimatedGeoModel<GreenSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(GreenSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GreenSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/green_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GreenSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
