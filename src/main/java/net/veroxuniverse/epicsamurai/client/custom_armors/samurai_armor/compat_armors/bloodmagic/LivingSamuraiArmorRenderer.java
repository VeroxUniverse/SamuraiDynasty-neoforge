package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.bloodmagic;

import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.aquaculture.NeptuniumSamuraiArmorModel;
import net.veroxuniverse.epicsamurai.item.armor.LivingSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.armor.NeptuniumSamuraiArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class LivingSamuraiArmorRenderer extends GeoArmorRenderer<LivingSamuraiArmorItem> {
    public LivingSamuraiArmorRenderer() {
        super(new LivingSamuraiArmorModel());

    }
}
