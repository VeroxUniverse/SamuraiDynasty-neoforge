package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.kitsune_mask;

import net.veroxuniverse.epicsamurai.item.armor.KitsuneMaskArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class KitsuneMaskArmorRenderer extends GeoArmorRenderer<KitsuneMaskArmorItem> {

    public KitsuneMaskArmorRenderer() {
        super(new KitsuneMaskArmorModel());
    }

}
