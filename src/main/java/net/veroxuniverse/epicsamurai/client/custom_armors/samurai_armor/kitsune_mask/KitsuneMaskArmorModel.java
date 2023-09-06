package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.kitsune_mask;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.KitsuneMaskArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class KitsuneMaskArmorModel extends GeoModel<KitsuneMaskArmorItem> {
    @Override
    public ResourceLocation  getModelResource(KitsuneMaskArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/kitsune_mask.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KitsuneMaskArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/kitsune_mask.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KitsuneMaskArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
