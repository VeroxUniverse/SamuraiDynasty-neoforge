package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.diamond;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.DiamondSamuraiArmorLightItem;

public class DiamondSamuraiArmorLightModel extends GeoModel<DiamondSamuraiArmorLightItem> {
    @Override
    public ResourceLocation  getModelResource(DiamondSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_light.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DiamondSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/diamond_samurai_armor_light_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DiamondSamuraiArmorLightItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
