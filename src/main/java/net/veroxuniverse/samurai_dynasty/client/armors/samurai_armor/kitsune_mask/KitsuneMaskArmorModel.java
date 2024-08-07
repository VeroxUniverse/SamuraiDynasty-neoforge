package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.kitsune_mask;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.KitsuneMaskArmorItem;

public class KitsuneMaskArmorModel extends GeoModel<KitsuneMaskArmorItem> {
    @Override
    public ResourceLocation  getModelResource(KitsuneMaskArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/kitsune_mask.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KitsuneMaskArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/kitsune_mask.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KitsuneMaskArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
