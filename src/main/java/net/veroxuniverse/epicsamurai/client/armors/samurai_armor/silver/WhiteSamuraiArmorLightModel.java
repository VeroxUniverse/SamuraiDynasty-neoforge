package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.silver;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.WhiteSamuraiArmorLightItem;

public class WhiteSamuraiArmorLightModel extends GeoModel<WhiteSamuraiArmorLightItem> {
    @Override
    public ResourceLocation  getModelResource(WhiteSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_light.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WhiteSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/white_samurai_armor_light_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WhiteSamuraiArmorLightItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
