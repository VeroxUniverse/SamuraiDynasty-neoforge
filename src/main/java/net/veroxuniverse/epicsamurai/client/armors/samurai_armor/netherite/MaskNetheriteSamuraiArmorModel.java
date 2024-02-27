package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.netherite;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.MaskNetheriteSamuraiArmorItem;

public class MaskNetheriteSamuraiArmorModel extends GeoModel<MaskNetheriteSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(MaskNetheriteSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/mask_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MaskNetheriteSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/netherite_samurai_armor_textures_mask.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MaskNetheriteSamuraiArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
