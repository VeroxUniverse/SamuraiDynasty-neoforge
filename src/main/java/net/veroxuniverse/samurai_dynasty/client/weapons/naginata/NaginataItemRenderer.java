package net.veroxuniverse.samurai_dynasty.client.weapons.naginata;

import mod.azure.azurelib.common.api.client.renderer.GeoItemRenderer;
import net.veroxuniverse.samurai_dynasty.client.weapons.kamayari.KamayariItemModel;
import net.veroxuniverse.samurai_dynasty.item.KamayariItem;
import net.veroxuniverse.samurai_dynasty.item.NaginataItem;

public class NaginataItemRenderer extends GeoItemRenderer<NaginataItem> {
    public NaginataItemRenderer() {
        super(new NaginataItemModel());

    }
}