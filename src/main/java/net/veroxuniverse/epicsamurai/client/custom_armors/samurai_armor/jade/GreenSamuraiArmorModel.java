package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.jade;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.GreenSamuraiArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class GreenSamuraiArmorModel extends GeoModel<GreenSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(GreenSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_new.geo.json");
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
