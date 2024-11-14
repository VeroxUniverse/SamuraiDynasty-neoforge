package net.veroxuniverse.samurai_dynasty.client.weapons.katana;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.KatanaItem;

public class KatanaItemModel extends GeoModel<KatanaItem> {
    @Override
    public ResourceLocation getModelResource(KatanaItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/katana.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KatanaItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/katana.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KatanaItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
