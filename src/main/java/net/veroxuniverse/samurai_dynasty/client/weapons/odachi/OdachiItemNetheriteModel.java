package net.veroxuniverse.samurai_dynasty.client.weapons.odachi;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.OdachiNetheriteItem;

public class OdachiItemNetheriteModel extends GeoModel<OdachiNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(OdachiNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/odachi.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OdachiNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/odachi_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OdachiNetheriteItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
