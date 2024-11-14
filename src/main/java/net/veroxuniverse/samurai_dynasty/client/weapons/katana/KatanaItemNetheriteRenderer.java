package net.veroxuniverse.samurai_dynasty.client.weapons.katana;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.item.KatanaNetheriteItem;

public class KatanaItemNetheriteRenderer extends GeoItemRenderer<KatanaNetheriteItem> {
    public KatanaItemNetheriteRenderer() {
        super(new KatanaItemNetheriteModel());

    }
}