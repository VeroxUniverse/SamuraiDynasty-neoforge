package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.jade;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.GreenSamuraiArmorLightItem;

public class GreenSamuraiArmorLightModel extends GeoModel<GreenSamuraiArmorLightItem> {
    @Override
    public ResourceLocation  getModelResource(GreenSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_light.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GreenSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/green_samurai_armor_light_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GreenSamuraiArmorLightItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
