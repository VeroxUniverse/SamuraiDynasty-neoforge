package net.veroxuniverse.samurai_dynasty.client.weapons.tekkokagi;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.kamayari.KamayariItemNetheriteModel;
import net.veroxuniverse.samurai_dynasty.item.KamayariNetheriteItem;
import net.veroxuniverse.samurai_dynasty.item.TekkoKagiNetheriteItem;

public class TekkoKagiItemNetheriteRenderer extends GeoItemRenderer<TekkoKagiNetheriteItem> {
    public TekkoKagiItemNetheriteRenderer() {
        super(new TekkoKagiItemNetheriteModel());

    }
}