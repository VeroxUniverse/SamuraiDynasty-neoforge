package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.straw_hat;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.MaskStrawHatArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.StrawHatArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class MaskStrawHatArmorModel extends GeoModel<MaskStrawHatArmorItem> {
    @Override
    public ResourceLocation  getModelResource(MaskStrawHatArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/straw_hat_mask.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MaskStrawHatArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/mask_straw_hat_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MaskStrawHatArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
