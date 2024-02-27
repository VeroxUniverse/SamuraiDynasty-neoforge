package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.aquamarine;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.BlueSamuraiArmorItem;
public class BlueSamuraiArmorModel extends GeoModel<BlueSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(BlueSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_new.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlueSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/blue_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlueSamuraiArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
