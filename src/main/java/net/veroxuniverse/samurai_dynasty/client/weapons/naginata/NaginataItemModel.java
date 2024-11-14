package net.veroxuniverse.samurai_dynasty.client.weapons.naginata;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.KamayariItem;
import net.veroxuniverse.samurai_dynasty.item.NaginataItem;

public class NaginataItemModel extends GeoModel<NaginataItem> {
    @Override
    public ResourceLocation getModelResource(NaginataItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/naginata.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NaginataItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/naginata.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NaginataItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
