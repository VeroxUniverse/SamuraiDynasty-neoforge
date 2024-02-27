package net.veroxuniverse.epicsamurai.client.armors.ninja_armor.diamond;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.DiamondNinjaArmorItem;

public class DiamondNinjaArmorModel extends GeoModel<DiamondNinjaArmorItem> {
    @Override
    public ResourceLocation getModelResource(DiamondNinjaArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/ninja_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DiamondNinjaArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/ninja_diamond_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DiamondNinjaArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
