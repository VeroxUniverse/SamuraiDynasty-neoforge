package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.forbidden_and_arcanus;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.TyrSamuraiArmorItem;

public class TyrSamuraiArmorModel extends GeoModel<TyrSamuraiArmorItem> {
    @Override
    public ResourceLocation  getModelResource(TyrSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/two_sword_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TyrSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/tyr_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TyrSamuraiArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }

}
