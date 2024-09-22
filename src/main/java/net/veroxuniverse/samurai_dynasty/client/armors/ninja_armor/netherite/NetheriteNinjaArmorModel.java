package net.veroxuniverse.samurai_dynasty.client.armors.ninja_armor.netherite;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.NetheriteNinjaArmorItem;

public class NetheriteNinjaArmorModel extends GeoModel<NetheriteNinjaArmorItem> {
    @Override
    public ResourceLocation getModelResource(NetheriteNinjaArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/ninja_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NetheriteNinjaArmorItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/armor/ninja_netherite_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NetheriteNinjaArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
