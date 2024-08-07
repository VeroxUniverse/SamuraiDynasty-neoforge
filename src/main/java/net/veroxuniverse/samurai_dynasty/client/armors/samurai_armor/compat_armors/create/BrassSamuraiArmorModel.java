package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.create;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.BrassSamuraiArmorItem;

public class BrassSamuraiArmorModel extends GeoModel<BrassSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(BrassSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/create_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BrassSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/goggle_create_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BrassSamuraiArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
