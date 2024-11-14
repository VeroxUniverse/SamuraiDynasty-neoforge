package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.master;

import mod.azure.azurelib.common.api.client.renderer.GeoArmorRenderer;
import net.veroxuniverse.samurai_dynasty.item.armor.MasterSamuraiArmorItem;

public class MasterSamuraiArmorRenderer extends GeoArmorRenderer<MasterSamuraiArmorItem> {

    public MasterSamuraiArmorRenderer() {
        super(new MasterSamuraiArmorModel());
    }

}
