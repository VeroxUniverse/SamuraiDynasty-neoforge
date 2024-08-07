package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.ars_nouveau;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.MageSamuraiArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class MageSamuraiArmorModel extends GeoModel<MageSamuraiArmorItem> {
    @Override
    public ResourceLocation getModelResource(MageSamuraiArmorItem object) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "geo/two_sword_samurai_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MageSamuraiArmorItem object) {
        return null;
        //return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/armor/mage_samurai_armor_textures.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MageSamuraiArmorItem animatable) {
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "animations/empty.animation.json");
    }


}