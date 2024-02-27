package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.diamond;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.DiamondSamuraiArmorItem;

public class DiamondSamuraiArmorModel extends GeoModel<DiamondSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(DiamondSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_new.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DiamondSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/diamond_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DiamondSamuraiArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
