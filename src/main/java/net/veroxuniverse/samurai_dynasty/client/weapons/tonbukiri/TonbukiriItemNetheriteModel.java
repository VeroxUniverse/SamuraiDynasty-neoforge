package net.veroxuniverse.samurai_dynasty.client.weapons.tonbukiri;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.TonbukiriNetheriteItem;

public class TonbukiriItemNetheriteModel extends GeoModel<TonbukiriNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(TonbukiriNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/tonbukiri.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TonbukiriNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/tonbukiri_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TonbukiriNetheriteItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}