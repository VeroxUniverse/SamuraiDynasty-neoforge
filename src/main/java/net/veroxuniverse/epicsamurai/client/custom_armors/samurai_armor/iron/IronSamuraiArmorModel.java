package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.iron;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.IronSamuraiArmorItem;

public class IronSamuraiArmorModel extends GeoModel<IronSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(IronSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_new.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IronSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/iron_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IronSamuraiArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
