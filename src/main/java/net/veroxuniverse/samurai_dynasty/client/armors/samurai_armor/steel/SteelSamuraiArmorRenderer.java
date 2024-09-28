package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.steel;

import mod.azure.azurelib.common.api.client.renderer.DyeableGeoArmorRenderer;
import mod.azure.azurelib.common.internal.common.cache.object.GeoBone;
import mod.azure.azurelib.core.object.Color;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.veroxuniverse.samurai_dynasty.item.armor.SteelSamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.registry.ArmorMaterialsRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SteelSamuraiArmorRenderer extends DyeableGeoArmorRenderer<SteelSamuraiArmorItem> {
    public SteelSamuraiArmorRenderer() {
        super(new SteelSamuraiArmorModel());
    }

    @Override
    public void setupAnim(Entity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }

    @Override
    protected boolean isBoneDyeable(GeoBone bone) {
        Set<String> dyeableBones = new HashSet<>();
        dyeableBones.add("armorHead");
        dyeableBones.add("armorBody");
        dyeableBones.add("armorLeftLeg");
        dyeableBones.add("armorRightLeg");
        dyeableBones.add("armorLeftBoot");
        dyeableBones.add("armorRightBoot");
        dyeableBones.add("armorLeftArm");
        dyeableBones.add("armorRightArm");

        return dyeableBones.contains(bone.getName());
    }

    private final Holder<ArmorMaterial> armorMaterialHolder = ArmorMaterialsRegistry.SAMURAI_STEEL;
    private final Item.Properties properties = new Item.Properties();
    private final DyeColor armorColor = DyeColor.RED;

    private Map<SteelSamuraiArmorItem.Type, SteelSamuraiArmorItem> armorSetMap = createArmorSetMap();

    private Map<SteelSamuraiArmorItem.Type, SteelSamuraiArmorItem> createArmorSetMap() {
        Map<SteelSamuraiArmorItem.Type, SteelSamuraiArmorItem> armorSet = new HashMap<>();

        armorSet.put(SteelSamuraiArmorItem.Type.HELMET, new SteelSamuraiArmorItem(armorMaterialHolder, SteelSamuraiArmorItem.Type.HELMET, properties, armorColor));
        armorSet.put(SteelSamuraiArmorItem.Type.CHESTPLATE, new SteelSamuraiArmorItem(armorMaterialHolder, SteelSamuraiArmorItem.Type.CHESTPLATE, properties, armorColor));
        armorSet.put(SteelSamuraiArmorItem.Type.LEGGINGS, new SteelSamuraiArmorItem(armorMaterialHolder, SteelSamuraiArmorItem.Type.LEGGINGS, properties, armorColor));
        armorSet.put(SteelSamuraiArmorItem.Type.BOOTS, new SteelSamuraiArmorItem(armorMaterialHolder, SteelSamuraiArmorItem.Type.BOOTS, properties, armorColor));

        return armorSet;
    }

    @Override
    protected @NotNull Color getColorForBone(GeoBone bone) {

        for (SteelSamuraiArmorItem armorItem : armorSetMap.values()) {
            DyeColor color = armorItem.getColor();
            if (color != null) {
                return Color.ofOpaque(color.getTextColor());
            }
        }
        return Color.ofOpaque(0xFF0000);
    }

}
