package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.diamond;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.DiamondSamuraiArmorMasterItem;

public class DiamondSamuraiArmorMasterModel extends GeoModel<DiamondSamuraiArmorMasterItem> {
    @Override
    public ResourceLocation  getModelResource(DiamondSamuraiArmorMasterItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_master.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DiamondSamuraiArmorMasterItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/diamond_samurai_armor_master_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DiamondSamuraiArmorMasterItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
