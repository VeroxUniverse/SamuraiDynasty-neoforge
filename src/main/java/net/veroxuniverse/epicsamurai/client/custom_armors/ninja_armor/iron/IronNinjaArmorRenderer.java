package net.veroxuniverse.epicsamurai.client.custom_armors.ninja_armor.iron;

import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.IronNinjaArmorItem;

public class IronNinjaArmorRenderer extends GeoArmorRenderer<IronNinjaArmorItem> {
    public IronNinjaArmorRenderer() {
        super(new IronNinjaArmorModel());

    }
}