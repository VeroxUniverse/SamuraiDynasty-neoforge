package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.quartz;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.QuartzSamuraiArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class QuartzSamuraiArmorModel extends GeoModel<QuartzSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(QuartzSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_new.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(QuartzSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/quartz_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(QuartzSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
