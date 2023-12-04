package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.gold;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.GoldSamuraiArmorItem;

public class GoldSamuraiArmorModel extends GeoModel<GoldSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(GoldSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_new.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GoldSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/gold_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GoldSamuraiArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
