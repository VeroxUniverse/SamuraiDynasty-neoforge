package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.ars_nouveau;

import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.item.armor.MageSamuraiArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MageSamuraiArmorRenderer extends GeoArmorRenderer<MageSamuraiArmorItem> {
    public MageSamuraiArmorRenderer() {
        super(new MageSamuraiArmorModel());
    }

    @Override
    public ResourceLocation getTextureLocation(MageSamuraiArmorItem instance) {
        /*

        if(model instanceof GenericModel<MageSamuraiArmorItem> genericModel){
            return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/models/armor/ars_nouveau/ars_samurai_armor_textures_" + instance.getColor(getCurrentStack()) + ".png");
        }

        return super.getTextureLocation(instance);

         */
        return new ResourceLocation(SamuraiDynastyMod.MOD_ID, "textures/models/armor/ars_nouveau/ars_samurai_armor_textures_" + instance.getColor(getCurrentStack()) + ".png");
    }

}



