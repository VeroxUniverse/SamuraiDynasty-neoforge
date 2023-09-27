package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.ars_nouveau;

import com.hollingsworth.arsnouveau.client.renderer.tile.GenericModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.item.armor.MageSamuraiArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MageSamuraiArmorRenderer extends GeoArmorRenderer<MageSamuraiArmorItem> {
    public MageSamuraiArmorRenderer() {
        super(new MageSamuraiArmorModel());
    }

    @Override
    public ResourceLocation getTextureLocation(MageSamuraiArmorItem instance) {
        if(model instanceof GenericModel<MageSamuraiArmorItem> genericModel){
            return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/ars_nouveau/ars_samurai_armor_textures_" + instance.getColor(getCurrentStack()) + ".png");
        }

        return super.getTextureLocation(instance);
    }

}



