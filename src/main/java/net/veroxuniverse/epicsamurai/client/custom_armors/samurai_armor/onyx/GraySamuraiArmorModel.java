package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.onyx;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.GraySamuraiArmorItem;

public class GraySamuraiArmorModel extends GeoModel<GraySamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(GraySamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_new.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GraySamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/gray_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GraySamuraiArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
