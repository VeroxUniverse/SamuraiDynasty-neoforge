package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor;

import net.veroxuniverse.epicsamurai.item.DiamondSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.NetheriteSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class DiamondSamuraiArmorRenderer extends GeoArmorRenderer<DiamondSamuraiArmorItem> {
    public DiamondSamuraiArmorRenderer() {
        super(new DiamondSamuraiArmorModel());

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
