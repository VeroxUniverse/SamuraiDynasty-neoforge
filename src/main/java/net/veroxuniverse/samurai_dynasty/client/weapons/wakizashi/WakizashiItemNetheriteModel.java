package net.veroxuniverse.samurai_dynasty.client.weapons.wakizashi;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.KatanaNetheriteItem;
import net.veroxuniverse.samurai_dynasty.item.WakizashiNetheriteItem;

public class WakizashiItemNetheriteModel extends GeoModel<WakizashiNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(WakizashiNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/wakizashi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WakizashiNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/katana_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WakizashiNetheriteItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
