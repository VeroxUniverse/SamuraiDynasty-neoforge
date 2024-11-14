package net.veroxuniverse.samurai_dynasty.client.weapons.masakari;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.MasakariNetheriteItem;

public class MasakariItemNetheriteModel extends GeoModel<MasakariNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(MasakariNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/masakari.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MasakariNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/masakari_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MasakariNetheriteItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
