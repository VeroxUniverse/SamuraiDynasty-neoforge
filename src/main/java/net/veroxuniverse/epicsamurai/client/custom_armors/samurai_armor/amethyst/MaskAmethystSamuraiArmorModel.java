package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.amethyst;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.MaskAmethystSamuraiArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class MaskAmethystSamuraiArmorModel extends GeoModel<MaskAmethystSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(MaskAmethystSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/mask_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MaskAmethystSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/amethyst_samurai_armor_textures_mask.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MaskAmethystSamuraiArmorItem animatable) {
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
