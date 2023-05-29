package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.amethyst;

import net.veroxuniverse.epicsamurai.item.armor.AmethystSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class AmethystSamuraiArmorRenderer extends GeoArmorRenderer<AmethystSamuraiArmorItem> {
    public AmethystSamuraiArmorRenderer() {
        super(new AmethystSamuraiArmorModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";

    }
}
