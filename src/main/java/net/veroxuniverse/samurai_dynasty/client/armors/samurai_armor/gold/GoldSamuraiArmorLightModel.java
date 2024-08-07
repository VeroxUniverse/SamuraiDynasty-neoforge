package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.gold;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.GoldSamuraiArmorLightItem;

public class GoldSamuraiArmorLightModel extends GeoModel<GoldSamuraiArmorLightItem> {
    @Override
    public ResourceLocation  getModelResource(GoldSamuraiArmorLightItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_light.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GoldSamuraiArmorLightItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/gold_samurai_armor_light_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GoldSamuraiArmorLightItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
