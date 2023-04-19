package net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor;

import net.veroxuniverse.epicsamurai.item.GoldSamuraiArmorItem;
import net.veroxuniverse.epicsamurai.item.IronSamuraiArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class IronSamuraiArmorRenderer extends GeoArmorRenderer<IronSamuraiArmorItem> {
    public IronSamuraiArmorRenderer() {
        super(new IronSamuraiArmorModel());

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
