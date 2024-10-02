package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.steel;

import mod.azure.azurelib.common.api.client.renderer.DyeableGeoArmorRenderer;
import mod.azure.azurelib.common.internal.common.cache.object.GeoBone;
import mod.azure.azurelib.core.object.Color;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;
import net.veroxuniverse.samurai_dynasty.item.armor.SteelSamuraiArmorItem;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class SteelSamuraiArmorRenderer extends DyeableGeoArmorRenderer<SteelSamuraiArmorItem> {

    private ItemStack itemStack;

    public SteelSamuraiArmorRenderer() {
        super(new SteelSamuraiArmorModel());
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    @Override
    public void setupAnim(Entity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }

    @Override
    protected boolean isBoneDyeable(GeoBone bone) {
        List<String> dyeableBones = Arrays.asList(
                "armorHead",
                "armorBody",
                "armorLeftLeg",
                "armorRightLeg",
                "armorLeftBoot",
                "armorRightBoot",
                "armorLeftArm",
                "armorRightArm"
        );

        return dyeableBones.contains(bone.getName());
    }

    @Override
    protected @NotNull Color getColorForBone(GeoBone bone) {
        int color = DyedItemColor.getOrDefault(itemStack, 0xFFFF0000);
        return new Color(color);
    }

}
