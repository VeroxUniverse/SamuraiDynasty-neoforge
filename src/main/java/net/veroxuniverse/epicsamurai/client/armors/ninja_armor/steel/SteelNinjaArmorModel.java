package net.veroxuniverse.epicsamurai.client.armors.ninja_armor.steel;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.SteelNinjaArmorItem;

public class SteelNinjaArmorModel extends GeoModel<SteelNinjaArmorItem> {
    @Override
    public ResourceLocation getModelResource(SteelNinjaArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/ninja_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SteelNinjaArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/ninja_steel_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SteelNinjaArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
