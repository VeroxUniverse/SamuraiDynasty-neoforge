package net.veroxuniverse.samurai_dynasty.client.weapons.kunai;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.NetheriteKunaiItem;

public class KunaiItemNetheriteModel extends GeoModel<NetheriteKunaiItem> {
    @Override
    public ResourceLocation getModelResource(NetheriteKunaiItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/kunai.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NetheriteKunaiItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/kunai_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NetheriteKunaiItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
