package net.veroxuniverse.epicsamurai.client.custom_armors.ninja_armor.gold;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.GoldNinjaArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class GoldNinjaArmorModel extends GeoModel<GoldNinjaArmorItem> {
    @Override
    public ResourceLocation getModelResource(GoldNinjaArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/ninja_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GoldNinjaArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/ninja_gold_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GoldNinjaArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
