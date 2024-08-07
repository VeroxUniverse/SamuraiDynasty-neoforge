package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.aquamarine;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.BlueSamuraiArmorLightItem;

public class BlueSamuraiArmorLightModel extends GeoModel<BlueSamuraiArmorLightItem> {
    @Override
    public ResourceLocation  getModelResource(BlueSamuraiArmorLightItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_light.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlueSamuraiArmorLightItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/blue_samurai_armor_light_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlueSamuraiArmorLightItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
