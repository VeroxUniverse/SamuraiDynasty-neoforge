package net.veroxuniverse.samurai_dynasty.client.weapons.tekkokagi;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.KamayariNetheriteItem;
import net.veroxuniverse.samurai_dynasty.item.TekkoKagiNetheriteItem;

public class TekkoKagiItemNetheriteModel extends GeoModel<TekkoKagiNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(TekkoKagiNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/tekko_kagi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TekkoKagiNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/tekko_kagi_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TekkoKagiNetheriteItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
