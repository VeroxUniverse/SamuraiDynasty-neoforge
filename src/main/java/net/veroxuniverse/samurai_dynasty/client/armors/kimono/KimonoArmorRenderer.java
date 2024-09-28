package net.veroxuniverse.samurai_dynasty.client.armors.kimono;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import net.veroxuniverse.samurai_dynasty.item.armor.KimonoArmorItem;

public class KimonoArmorRenderer extends GeoArmorRenderer<KimonoArmorItem> {
    public KimonoArmorRenderer() {
        super(new KimonoArmorModel());

    }
}