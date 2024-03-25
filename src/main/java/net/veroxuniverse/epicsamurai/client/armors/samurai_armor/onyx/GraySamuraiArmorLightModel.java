package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.onyx;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.GraySamuraiArmorLightItem;

public class GraySamuraiArmorLightModel extends GeoModel<GraySamuraiArmorLightItem> {
    @Override
    public ResourceLocation  getModelResource(GraySamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_light.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GraySamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/gray_samurai_armor_light_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GraySamuraiArmorLightItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
