package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.compat_armors.create;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.BrassSamuraiArmorItem;

public class BrassSamuraiArmorModel extends GeoModel<BrassSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(BrassSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/create_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BrassSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/goggle_create_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BrassSamuraiArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
