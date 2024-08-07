package net.veroxuniverse.samurai_dynasty.client.weapons.tonbukiri;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.TonbukiriItem;

public class TonbukiriItemModel extends GeoModel<TonbukiriItem> {
    @Override
    public ResourceLocation getModelResource(TonbukiriItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/tonbukiri.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TonbukiriItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/weapon/tonbukiri.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TonbukiriItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
