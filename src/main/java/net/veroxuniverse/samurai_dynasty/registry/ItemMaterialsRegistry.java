package net.veroxuniverse.samurai_dynasty.registry;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class ItemMaterialsRegistry implements Tier {

    public static final Tier STEEL = new SimpleTier(
            BlockTags.NEEDS_DIAMOND_TOOL,1561, 12.0f, 5.0f, 12,
            () -> Ingredient.of(ItemsRegistry.STEEL_INGOT.get()));

    public static final Tier NETHERITE = new SimpleTier(
            BlockTags.NEEDS_DIAMOND_TOOL,2561, 12.0f, 5.0f, 25,
            () -> Ingredient.of(Items.NETHERITE_INGOT));

    int uses;
    float damage;
    float speed;
    int enchantmentValue;
    TagKey<Block> incorrectBlocksForDrops;
    Supplier<Ingredient> repairIngredient;

    public ItemMaterialsRegistry(int uses, float damage, float speed, int enchantmentValue, TagKey<Block> incorrectBlocksForDrops, Supplier<Ingredient> repairIngredient) {
        this.uses = uses;
        this.damage = damage;
        this.speed = speed;
        this.enchantmentValue = enchantmentValue;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

}