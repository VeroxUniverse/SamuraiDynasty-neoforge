package net.veroxuniverse.epicsamurai.client.custom_armors.ninja_armor.netherite;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.NetheriteNinjaArmorItem;

public class NetheriteNinjaArmorModel extends GeoModel<NetheriteNinjaArmorItem> {
    @Override
    public ResourceLocation getModelResource(NetheriteNinjaArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/ninja_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NetheriteNinjaArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/ninja_netherite_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NetheriteNinjaArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
