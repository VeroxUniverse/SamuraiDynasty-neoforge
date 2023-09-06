package net.veroxuniverse.epicsamurai.client.custom_armors.ninja_armor.iron;

import net.veroxuniverse.epicsamurai.item.armor.IronNinjaArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class IronNinjaArmorRenderer extends GeoArmorRenderer<IronNinjaArmorItem> {
    public IronNinjaArmorRenderer() {
        super(new IronNinjaArmorModel());

    }
}