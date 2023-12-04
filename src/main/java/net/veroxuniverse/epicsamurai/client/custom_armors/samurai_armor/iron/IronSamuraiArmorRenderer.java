package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.iron;

import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.IronSamuraiArmorItem;

public class IronSamuraiArmorRenderer extends GeoArmorRenderer<IronSamuraiArmorItem> {
    public IronSamuraiArmorRenderer() {
        super(new IronSamuraiArmorModel());

    }
}
