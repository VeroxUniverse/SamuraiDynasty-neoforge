package net.veroxuniverse.samurai_dynasty.client.armors.ninja_armor.diamond;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.DiamondNinjaArmorItem;

public class DiamondNinjaArmorModel extends GeoModel<DiamondNinjaArmorItem> {
    @Override
    public ResourceLocation getModelResource(DiamondNinjaArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/ninja_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DiamondNinjaArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/ninja_diamond_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DiamondNinjaArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
