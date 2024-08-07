package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.ruby;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.RedSamuraiArmorMasterItem;

public class RedSamuraiArmorMasterModel extends GeoModel<RedSamuraiArmorMasterItem> {
    @Override
    public ResourceLocation  getModelResource(RedSamuraiArmorMasterItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/samurai_armor_master.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RedSamuraiArmorMasterItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/red_samurai_armor_master_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RedSamuraiArmorMasterItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
