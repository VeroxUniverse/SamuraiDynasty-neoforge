package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.eldrithcend;

import net.veroxuniverse.epicsamurai.item.armor.EtyriteSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.NeptuniumSamuraiArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class EtyriteSamuraiArmorRenderer extends GeoArmorRenderer<EtyriteSamuraiArmorItem> {
    public EtyriteSamuraiArmorRenderer() {
        super(new EtyriteSamuraiArmorModel());

    }
}
