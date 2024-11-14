package net.veroxuniverse.samurai_dynasty.client.weapons.nagamaki;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.KamayariItem;
import net.veroxuniverse.samurai_dynasty.item.NagamakiItem;

public class NagamakiItemModel extends GeoModel<NagamakiItem> {
    @Override
    public ResourceLocation getModelResource(NagamakiItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/nagamaki.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NagamakiItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/nagamaki.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NagamakiItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
