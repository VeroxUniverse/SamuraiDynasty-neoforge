package net.veroxuniverse.epicsamurai.client.custom_armors.ninja_armor.iron;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.IronNinjaArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class IronNinjaArmorModel extends GeoModel<IronNinjaArmorItem> {
    @Override
    public ResourceLocation getModelResource(IronNinjaArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/ninja_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IronNinjaArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/ninja_iron_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IronNinjaArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
