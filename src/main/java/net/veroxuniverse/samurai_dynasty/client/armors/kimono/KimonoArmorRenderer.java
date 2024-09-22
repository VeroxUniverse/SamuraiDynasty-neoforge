package net.veroxuniverse.samurai_dynasty.client.armors.kimono;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.item.armor.KimonoArmorItem;

public class KimonoArmorRenderer extends GeoItemRenderer<KimonoArmorItem> {
    public KimonoArmorRenderer() {
        super(new KimonoArmorModel());

    }
}