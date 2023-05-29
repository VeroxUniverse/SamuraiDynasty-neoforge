package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.silver;

import net.veroxuniverse.epicsamurai.item.armor.WhiteSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class WhiteSamuraiArmorRenderer extends GeoArmorRenderer<WhiteSamuraiArmorItem> {
    public WhiteSamuraiArmorRenderer() {
        super(new WhiteSamuraiArmorModel());

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
