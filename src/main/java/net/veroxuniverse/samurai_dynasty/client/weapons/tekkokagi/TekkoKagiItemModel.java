package net.veroxuniverse.samurai_dynasty.client.weapons.tekkokagi;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.KamayariItem;
import net.veroxuniverse.samurai_dynasty.item.TekkoKagiItem;

public class TekkoKagiItemModel extends GeoModel<TekkoKagiItem> {
    @Override
    public ResourceLocation getModelResource(TekkoKagiItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/tekko_kagi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TekkoKagiItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/tekko_kagi.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TekkoKagiItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
