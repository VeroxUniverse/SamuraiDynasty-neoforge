package net.veroxuniverse.samurai_dynasty.item.ranged;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;

import java.util.function.Predicate;

public abstract class GunItemBase extends ProjectileWeaponItem {
    public static final Predicate<ItemStack> BULLET_ONLY = (itemStack) -> {
        return itemStack.is(ItemsRegistry.BULLET.get());
    };
    public static final Predicate<ItemStack> BULLET_OR_FIREWORK = BULLET_ONLY.or((itemStack) -> {
        return itemStack.is(Items.FIREWORK_ROCKET);
    });

    public GunItemBase(Item.Properties pProperties) {
        super(pProperties);
    }

    public int getEnchantmentValue() {
        return 1;
    }

}