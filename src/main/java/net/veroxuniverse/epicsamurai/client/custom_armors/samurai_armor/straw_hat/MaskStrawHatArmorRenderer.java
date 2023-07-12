package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.straw_hat;

import net.veroxuniverse.epicsamurai.item.armor.MaskStrawHatArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.StrawHatArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MaskStrawHatArmorRenderer extends GeoArmorRenderer<MaskStrawHatArmorItem> {
    public MaskStrawHatArmorRenderer() {
        super(new MaskStrawHatArmorModel());

    }
}
