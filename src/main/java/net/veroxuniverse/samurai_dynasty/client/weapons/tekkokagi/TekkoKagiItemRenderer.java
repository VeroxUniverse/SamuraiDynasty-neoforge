package net.veroxuniverse.samurai_dynasty.client.weapons.tekkokagi;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.kamayari.KamayariItemModel;
import net.veroxuniverse.samurai_dynasty.item.KamayariItem;
import net.veroxuniverse.samurai_dynasty.item.TekkoKagiItem;

public class TekkoKagiItemRenderer extends GeoItemRenderer<TekkoKagiItem> {
    public TekkoKagiItemRenderer() {
        super(new TekkoKagiItemModel());

    }
}