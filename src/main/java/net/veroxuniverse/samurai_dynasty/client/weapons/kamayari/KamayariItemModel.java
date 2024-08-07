package net.veroxuniverse.samurai_dynasty.client.weapons.kamayari;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.KamayariItem;

public class KamayariItemModel extends GeoModel<KamayariItem> {
    @Override
    public ResourceLocation getModelResource(KamayariItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/kamayari.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KamayariItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/weapon/kamayari.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KamayariItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
