package net.veroxuniverse.epicsamurai.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class DemonSlayerEnchantment extends Enchantment {

    protected DemonSlayerEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    protected boolean checkCompatibility(Enchantment other) {
        return super.checkCompatibility(other) && other != Enchantments.BANE_OF_ARTHROPODS && other != Enchantments.SMITE;
    }

    public int getMaxLevel() {
        return 1;
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 15 + (pEnchantmentLevel - 1) * 9;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return super.getMinCost(pEnchantmentLevel) + 50;
    }

    public boolean canEnchant(ItemStack pStack) {
        return canApplyAtEnchantingTable(pStack);
    }

    public boolean isTradeable() {
        return true;
    }

    public boolean isAllowedOnBooks() {
        return true;
    }

}
