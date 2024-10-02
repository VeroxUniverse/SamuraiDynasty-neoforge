package net.veroxuniverse.samurai_dynasty.client.weapons.odachi;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.item.OdachiItem;

public class OdachiItemRenderer extends GeoItemRenderer<OdachiItem> {
    public OdachiItemRenderer() {
        super(new OdachiItemModel());

    }
}