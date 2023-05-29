package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.jade;

import net.veroxuniverse.epicsamurai.item.armor.GreenSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class GreenSamuraiArmorRenderer extends GeoArmorRenderer<GreenSamuraiArmorItem> {
    public GreenSamuraiArmorRenderer() {
        super(new GreenSamuraiArmorModel());

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
