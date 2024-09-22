package net.veroxuniverse.samurai_dynasty.client.armors.ninja_armor.steel;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.SteelNinjaArmorItem;

public class SteelNinjaArmorModel extends GeoModel<SteelNinjaArmorItem> {
    @Override
    public ResourceLocation getModelResource(SteelNinjaArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/ninja_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SteelNinjaArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/armor/ninja_steel_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SteelNinjaArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
