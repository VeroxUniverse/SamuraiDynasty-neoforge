package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.ars_nouveau;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.MageSamuraiArmorItem;
import software.bernie.ars_nouveau.geckolib.model.GeoModel;

public class MageSamuraiArmorModel extends GeoModel<MageSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(MageSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/two_sword_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MageSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/mage_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MageSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }


}