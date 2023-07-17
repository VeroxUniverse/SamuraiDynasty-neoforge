package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.ars_nouveau;

import net.veroxuniverse.epicsamurai.item.armor.MageSamuraiArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MageSamuraiArmorRenderer extends GeoArmorRenderer<MageSamuraiArmorItem> {
    public MageSamuraiArmorRenderer() {
        super(new MageSamuraiArmorModel());
    }
}

