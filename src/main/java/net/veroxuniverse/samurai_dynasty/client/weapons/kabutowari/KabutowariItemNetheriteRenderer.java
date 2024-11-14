package net.veroxuniverse.samurai_dynasty.client.weapons.kabutowari;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.katana.KatanaItemNetheriteModel;
import net.veroxuniverse.samurai_dynasty.item.KabutowariNetheriteItem;
import net.veroxuniverse.samurai_dynasty.item.KatanaNetheriteItem;

public class KabutowariItemNetheriteRenderer extends GeoItemRenderer<KabutowariNetheriteItem> {
    public KabutowariItemNetheriteRenderer() {
        super(new KabutowariItemNetheriteModel());

    }
}