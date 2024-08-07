package net.veroxuniverse.samurai_dynasty.client.armors.ninja_armor.gold;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.GoldNinjaArmorItem;

public class GoldNinjaArmorModel extends GeoModel<GoldNinjaArmorItem> {
    @Override
    public ResourceLocation getModelResource(GoldNinjaArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/ninja_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GoldNinjaArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/ninja_gold_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GoldNinjaArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
