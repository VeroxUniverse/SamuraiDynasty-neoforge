package net.veroxuniverse.samurai_dynasty.client.weapons.katana;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.item.KatanaItem;

public class KatanaItemRenderer extends GeoItemRenderer<KatanaItem> {
    public KatanaItemRenderer() {
        super(new KatanaItemModel());

    }
}