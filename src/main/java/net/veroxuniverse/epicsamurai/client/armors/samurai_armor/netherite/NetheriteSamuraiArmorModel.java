package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.netherite;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.NetheriteSamuraiArmorItem;

public class NetheriteSamuraiArmorModel extends GeoModel<NetheriteSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(NetheriteSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/two_sword_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NetheriteSamuraiArmorItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/netherite_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NetheriteSamuraiArmorItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
