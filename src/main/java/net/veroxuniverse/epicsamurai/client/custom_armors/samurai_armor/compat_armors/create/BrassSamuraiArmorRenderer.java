package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.create;

import net.veroxuniverse.epicsamurai.item.armor.BrassSamuraiArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BrassSamuraiArmorRenderer extends GeoArmorRenderer<BrassSamuraiArmorItem> {
    public BrassSamuraiArmorRenderer() {
        super(new BrassSamuraiArmorModel());

    }
}
