package net.veroxuniverse.samurai_dynasty.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.veroxuniverse.samurai_dynasty.datagen.enchantment.ModEnchantments;
import net.veroxuniverse.samurai_dynasty.entity.custom.NetheriteKunaiEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NetheriteKunaiItem extends SwordItem implements ProjectileItem {

    public static final float BASE_DAMAGE = 8.0F;

    public NetheriteKunaiItem(Tier tier, Properties properties) {
        super(tier, properties);
    }
    public int getUseDuration(ItemStack pStack) {
        return 300;
    }

    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pPlayer.getCooldowns().addCooldown(this, 20);
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.TRIDENT_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {
            NetheriteKunaiEntity netheriteKunaiEntity = new NetheriteKunaiEntity(pLevel, pPlayer);
            netheriteKunaiEntity.setItem(itemstack);
            netheriteKunaiEntity.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 2.5F, 2.0F);
            pLevel.addFreshEntity(netheriteKunaiEntity);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            if (EnchantmentHelper.getItemEnchantmentLevel((Holder<Enchantment>) ModEnchantments.RETURNING_BLADE, itemstack) > 0) {
                itemstack.hurtAndBreak(0, pPlayer, (EquipmentSlot.MAINHAND));
                //itemstack.shrink(1);
            } else {
                itemstack.hurtAndBreak(156, pPlayer, (EquipmentSlot.MAINHAND));
            }
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, Item.TooltipContext context, @NotNull List<Component> components, @NotNull TooltipFlag flag) {

        int sharpnessLvl = EnchantmentHelper.getItemEnchantmentLevel((Holder<Enchantment>) Enchantments.SHARPNESS, stack);

        components.add(Component.literal("Throwable Item:").withStyle(ChatFormatting.GRAY));
        components.add(Component.literal(" " + (sharpnessLvl * 0.5 + 8) + " Ranged Damage").withStyle(ChatFormatting.DARK_GREEN));

        super.appendHoverText(stack, context, components, flag);
    }

    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (EquipmentSlot.MAINHAND));
        return true;
    }


    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        if ((double)pState.getDestroySpeed(pLevel, pPos) != 0.0D) {
            pStack.hurtAndBreak(2, pEntityLiving, (EquipmentSlot.MAINHAND));
        }

        return true;
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        NetheriteKunaiEntity kunaiEntity = new NetheriteKunaiEntity(level, position.x(), position.y(), position.z(), itemStack.copyWithCount(1));
        return kunaiEntity;
    }
}


