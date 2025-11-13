package net.veroxuniverse.samurai_dynasty.item.armor;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.veroxuniverse.samurai_dynasty.item.armor.lib.SamuraiArmorItem;
import net.veroxuniverse.samurai_dynasty.registry.ArmorMaterialsRegistry;

public class SteelSamuraiArmorItem extends SamuraiArmorItem {

    private  ItemStack itemStack;

    public SteelSamuraiArmorItem(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties);
        this.itemStack = new ItemStack(this);
    }

    public String getColorNameFromRGB(int rgbValue) {
        for (DyeColor color : DyeColor.values()) {
            if (color.getTextureDiffuseColor() == rgbValue) {
                return color.getName().toLowerCase();
            }
        }
        return DyeColor.RED.getName().toLowerCase();
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return this.material == ArmorMaterialsRegistry.SAMURAI_STEEL;
    }

    public static int getColor(ItemStack stack)
    {
        var color = stack.get(DataComponents.BASE_COLOR);
        return color != null ? color.getTextureDiffuseColor() : DyeColor.RED.getTextureDiffuseColor();
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

}