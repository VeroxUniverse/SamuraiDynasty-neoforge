package net.veroxuniverse.epicsamurai.client.armors.samurai_armor.netherite;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.NetheriteSamuraiArmorMasterItem;

public class NetheriteSamuraiArmorMasterModel extends GeoModel<NetheriteSamuraiArmorMasterItem> {
    @Override
    public ResourceLocation  getModelResource(NetheriteSamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "geo/samurai_armor_master.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NetheriteSamuraiArmorMasterItem object) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/armor/netherite_samurai_armor_master_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NetheriteSamuraiArmorMasterItem animatable) {
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "animations/empty.animation.json");
    }

}
