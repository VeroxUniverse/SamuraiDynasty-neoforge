package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.gold;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.GoldSamuraiArmorLightItem;

public class GoldSamuraiArmorLightModel extends GeoModel<GoldSamuraiArmorLightItem> {
    @Override
    public ResourceLocation  getModelResource(GoldSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_light.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GoldSamuraiArmorLightItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/gold_samurai_armor_light_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GoldSamuraiArmorLightItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
