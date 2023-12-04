package net.veroxuniverse.epicsamurai.client.custom_armors.steel_armor;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.SteelArmorItem;

public class SteelArmorModel extends GeoModel<SteelArmorItem> {
    @Override
    public ResourceLocation  getModelResource(SteelArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/steel_armor_new.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SteelArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/steel_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SteelArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
