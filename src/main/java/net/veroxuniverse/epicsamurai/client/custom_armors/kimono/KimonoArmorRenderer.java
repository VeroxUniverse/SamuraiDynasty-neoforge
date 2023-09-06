package net.veroxuniverse.epicsamurai.client.custom_armors.kimono;

import net.veroxuniverse.epicsamurai.item.armor.KimonoArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class KimonoArmorRenderer extends GeoArmorRenderer<KimonoArmorItem> {
    public KimonoArmorRenderer() {
        super(new KimonoArmorModel());

    }
}