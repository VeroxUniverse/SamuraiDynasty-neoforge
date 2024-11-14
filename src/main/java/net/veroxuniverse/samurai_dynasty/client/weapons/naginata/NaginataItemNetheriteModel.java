package net.veroxuniverse.samurai_dynasty.client.weapons.naginata;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.NaginataNetheriteItem;

public class NaginataItemNetheriteModel extends GeoModel<NaginataNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(NaginataNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/naginata.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NaginataNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/naginata_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NaginataNetheriteItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
