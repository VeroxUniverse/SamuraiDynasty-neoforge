package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor;

import net.veroxuniverse.epicsamurai.item.DiamondSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.GoldSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class GoldSamuraiArmorRenderer extends GeoArmorRenderer<GoldSamuraiArmorItem> {
    public GoldSamuraiArmorRenderer() {
        super(new GoldSamuraiArmorModel());

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
