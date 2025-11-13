package net.veroxuniverse.samurai_dynasty.item.armor.lib;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class SamuraiArmorItem extends ArmorItem{

    public SamuraiArmorItem(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return true;
    }


    @Override
    public int getEnchantmentValue() {
        return this.material.value().enchantmentValue();
    }
    
}