package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.hair;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.SamuraiHairArmorItem;

public class SamuraiHairArmorModel extends GeoModel<SamuraiHairArmorItem> {
    @Override
    public ResourceLocation  getModelResource(SamuraiHairArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_hair.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SamuraiHairArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/samurai_hair_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SamuraiHairArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
