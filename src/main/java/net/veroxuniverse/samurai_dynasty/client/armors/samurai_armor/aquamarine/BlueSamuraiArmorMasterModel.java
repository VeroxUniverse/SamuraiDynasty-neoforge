package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.aquamarine;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.BlueSamuraiArmorMasterItem;

public class BlueSamuraiArmorMasterModel extends GeoModel<BlueSamuraiArmorMasterItem> {
    @Override
    public ResourceLocation  getModelResource(BlueSamuraiArmorMasterItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_master.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BlueSamuraiArmorMasterItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/blue_samurai_armor_master_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BlueSamuraiArmorMasterItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
