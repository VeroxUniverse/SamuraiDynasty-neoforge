package net.veroxuniverse.samurai_dynasty.client.weapons.kabutowari;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.KabutowariItem;
import net.veroxuniverse.samurai_dynasty.item.KatanaItem;

public class KabutowariItemModel extends GeoModel<KabutowariItem> {
    @Override
    public ResourceLocation getModelResource(KabutowariItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "geo/kabutowari.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KabutowariItem object) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/weapon/kabutowari.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KabutowariItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
