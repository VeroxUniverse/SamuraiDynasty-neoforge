package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.oni_mask;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.OniMaskArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class OniMaskArmorModel extends GeoModel<OniMaskArmorItem> {
    @Override
    public ResourceLocation  getModelResource(OniMaskArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/oni_mask.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OniMaskArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/oni_mask.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OniMaskArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
