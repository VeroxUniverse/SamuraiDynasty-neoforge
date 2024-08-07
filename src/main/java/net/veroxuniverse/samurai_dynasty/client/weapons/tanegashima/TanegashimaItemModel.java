package net.veroxuniverse.samurai_dynasty.client.weapons.tanegashima;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.ranged.GunItem;

public class TanegashimaItemModel extends GeoModel<GunItem> {
    @Override
    public ResourceLocation getModelResource(GunItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/tanegashima.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GunItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/weapon/tanegashima.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GunItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/tanegashima.animation.json");
    }

}
