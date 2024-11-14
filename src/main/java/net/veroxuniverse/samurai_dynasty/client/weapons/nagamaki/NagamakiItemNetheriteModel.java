package net.veroxuniverse.samurai_dynasty.client.weapons.nagamaki;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.NagamakiNetheriteItem;

public class NagamakiItemNetheriteModel extends GeoModel<NagamakiNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(NagamakiNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/nagamaki.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NagamakiNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/nagamaki_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NagamakiNetheriteItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
