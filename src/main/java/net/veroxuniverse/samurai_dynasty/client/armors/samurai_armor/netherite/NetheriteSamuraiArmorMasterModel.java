package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.netherite;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.NetheriteSamuraiArmorMasterItem;

public class NetheriteSamuraiArmorMasterModel extends GeoModel<NetheriteSamuraiArmorMasterItem> {
    @Override
    public ResourceLocation  getModelResource(NetheriteSamuraiArmorMasterItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_master.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NetheriteSamuraiArmorMasterItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/netherite_samurai_armor_master_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NetheriteSamuraiArmorMasterItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
