package net.veroxuniverse.samurai_dynasty.client.weapons.katana;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.KatanaNetheriteItem;

public class KatanaItemNetheriteModel extends GeoModel<KatanaNetheriteItem> {
    @Override
    public ResourceLocation getModelResource(KatanaNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/katana.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KatanaNetheriteItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/katana_netherite.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KatanaNetheriteItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
