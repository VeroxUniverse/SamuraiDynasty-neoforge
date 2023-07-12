package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.amethyst;

import net.veroxuniverse.epicsamurai.item.armor.MaskAmethystSamuraiArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class MaskAmethystSamuraiArmorRenderer extends GeoArmorRenderer<MaskAmethystSamuraiArmorItem> {
    public MaskAmethystSamuraiArmorRenderer() {
        super(new MaskAmethystSamuraiArmorModel());
    }
}
