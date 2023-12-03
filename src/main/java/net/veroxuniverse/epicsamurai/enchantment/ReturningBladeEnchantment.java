package net.veroxuniverse.epicsamurai.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.MendingEnchantment;
import net.veroxuniverse.epicsamurai.item.KunaiItem;
import net.veroxuniverse.epicsamurai.item.NetheriteKunaiItem;

public class ReturningBladeEnchantment extends Enchantment {

    protected ReturningBladeEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    public int getMinCost(int pEnchantmentLevel) {
        return 20;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return 50;
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.getItem() instanceof KunaiItem || stack.getItem() instanceof NetheriteKunaiItem;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return this.canEnchant(stack);
    }

    public boolean checkCompatibility(Enchantment pEnch) {
        return pEnch instanceof MendingEnchantment ? false : super.checkCompatibility(pEnch);
    }

}
