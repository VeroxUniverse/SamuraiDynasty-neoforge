package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.aquamarine;

import net.veroxuniverse.epicsamurai.item.armor.BlueSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class BlueSamuraiArmorRenderer extends GeoArmorRenderer<BlueSamuraiArmorItem> {
    public BlueSamuraiArmorRenderer() {
        super(new BlueSamuraiArmorModel());

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
