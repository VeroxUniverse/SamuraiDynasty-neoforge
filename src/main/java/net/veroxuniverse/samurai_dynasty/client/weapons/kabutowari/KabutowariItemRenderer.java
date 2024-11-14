package net.veroxuniverse.samurai_dynasty.client.weapons.kabutowari;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.katana.KatanaItemModel;
import net.veroxuniverse.samurai_dynasty.item.KabutowariItem;
import net.veroxuniverse.samurai_dynasty.item.KatanaItem;

public class KabutowariItemRenderer extends GeoItemRenderer<KabutowariItem> {
    public KabutowariItemRenderer() {
        super(new KabutowariItemModel());

    }
}