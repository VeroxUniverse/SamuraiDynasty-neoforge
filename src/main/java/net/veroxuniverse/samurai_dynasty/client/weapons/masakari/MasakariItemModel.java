package net.veroxuniverse.samurai_dynasty.client.weapons.masakari;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.MasakariItem;

public class MasakariItemModel extends GeoModel<MasakariItem> {
    @Override
    public ResourceLocation getModelResource(MasakariItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/masakari.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MasakariItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/masakari.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MasakariItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
