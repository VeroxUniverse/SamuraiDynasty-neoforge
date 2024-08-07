package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.iron;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.IronSamuraiArmorMasterItem;

public class IronSamuraiArmorMasterModel extends GeoModel<IronSamuraiArmorMasterItem> {
    @Override
    public ResourceLocation  getModelResource(IronSamuraiArmorMasterItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_master.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IronSamuraiArmorMasterItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/iron_samurai_armor_master_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IronSamuraiArmorMasterItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
