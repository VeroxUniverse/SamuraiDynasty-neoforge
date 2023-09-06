package net.veroxuniverse.epicsamurai.client.custom_armors.ninja_armor.steel;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.SteelNinjaArmorItem;
import software.bernie.geckolib.model.GeoModel;

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
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
