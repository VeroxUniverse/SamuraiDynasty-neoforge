package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.onyx;

import net.veroxuniverse.epicsamurai.item.armor.GraySamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class GraySamuraiArmorRenderer extends GeoArmorRenderer<GraySamuraiArmorItem> {
    public GraySamuraiArmorRenderer() {
        super(new GraySamuraiArmorModel());

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
