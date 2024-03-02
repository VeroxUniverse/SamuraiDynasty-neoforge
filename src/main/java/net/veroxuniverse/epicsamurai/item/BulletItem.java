package net.veroxuniverse.epicsamurai.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.veroxuniverse.epicsamurai.entity.custom.BulletEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BulletItem extends Item {
    public BulletItem(Properties pProperties) {
        super(pProperties);
    }

    public static BulletEntity createBullet(Level worldIn, ItemStack stack, LivingEntity shooter, float damage) {
        return new BulletEntity(worldIn, shooter, damage){};
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> components, @NotNull TooltipFlag flag) {

        components.add(Component.literal("Ammunition:").withStyle(ChatFormatting.GRAY));
        components.add(Component.literal(" 28 Ranged Damage").withStyle(ChatFormatting.DARK_GREEN));

        super.appendHoverText(stack, level, components, flag);
    }

}
