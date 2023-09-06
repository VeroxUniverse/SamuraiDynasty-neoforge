package net.veroxuniverse.epicsamurai.client.custom_armors.ninja_armor.netherite;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.NetheriteNinjaArmorItem;
import software.bernie.geckolib.model.GeoModel;

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
        return null;
        //return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/samurai_armor_animation.json");
    }

}
