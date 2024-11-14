package net.veroxuniverse.samurai_dynasty.client.weapons.wakizashi;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.KatanaItem;
import net.veroxuniverse.samurai_dynasty.item.WakizashiItem;

public class WakizashiItemModel extends GeoModel<WakizashiItem> {
    @Override
    public ResourceLocation getModelResource(WakizashiItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/wakizashi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WakizashiItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/katana.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WakizashiItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
