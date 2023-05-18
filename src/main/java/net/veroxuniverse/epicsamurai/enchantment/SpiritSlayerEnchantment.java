package net.veroxuniverse.epicsamurai.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class SpiritSlayerEnchantment extends Enchantment {

    protected SpiritSlayerEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    protected boolean checkCompatibility(Enchantment other) {
        return super.checkCompatibility(other) && other != Enchantments.BANE_OF_ARTHROPODS && other != Enchantments.SMITE;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

}
