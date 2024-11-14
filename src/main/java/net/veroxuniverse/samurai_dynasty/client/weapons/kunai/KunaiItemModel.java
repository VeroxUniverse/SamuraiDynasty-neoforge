package net.veroxuniverse.samurai_dynasty.client.weapons.kunai;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.KunaiItem;

public class KunaiItemModel extends GeoModel<KunaiItem> {
    @Override
    public ResourceLocation getModelResource(KunaiItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/kunai.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KunaiItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/kunai.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KunaiItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
