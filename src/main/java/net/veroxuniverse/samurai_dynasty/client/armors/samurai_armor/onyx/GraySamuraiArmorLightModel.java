package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.onyx;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.GraySamuraiArmorLightItem;

public class GraySamuraiArmorLightModel extends GeoModel<GraySamuraiArmorLightItem> {
    @Override
    public ResourceLocation  getModelResource(GraySamuraiArmorLightItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_light.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GraySamuraiArmorLightItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/gray_samurai_armor_light_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GraySamuraiArmorLightItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
