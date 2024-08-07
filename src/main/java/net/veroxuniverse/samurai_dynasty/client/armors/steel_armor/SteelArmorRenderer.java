package net.veroxuniverse.samurai_dynasty.client.armors.steel_armor;

import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.veroxuniverse.samurai_dynasty.item.armor.SteelArmorItem;

public class SteelArmorRenderer extends GeoArmorRenderer<SteelArmorItem> {
    public SteelArmorRenderer() {
        super(new SteelArmorModel());

    }
}
