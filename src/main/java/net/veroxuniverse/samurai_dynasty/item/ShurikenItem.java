package net.veroxuniverse.samurai_dynasty.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.veroxuniverse.samurai_dynasty.entity.custom.ThrownShurikenEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ShurikenItem extends Item implements ProjectileItem {

    public static final int THROW_THRESHOLD_TIME = 10;
    public static final float BASE_DAMAGE = 8.0F;
    public static final float SHOOT_POWER = 2.5F;

    public ShurikenItem(Item.Properties pProperties) {
        super(pProperties);
    }

    public boolean canAttackBlock(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        pPlayer.getCooldowns().addCooldown(this, 10);
        pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.TRIDENT_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!pLevel.isClientSide) {

            float playerYaw = pPlayer.getYHeadRot();
            float playerPitch = pPlayer.getXRot();

            ThrownShurikenEntity shurikenEntity = new ThrownShurikenEntity(pLevel, pPlayer, itemstack);
            shurikenEntity.setPos(pPlayer.getX(), pPlayer.getEyeY() - 0.1, pPlayer.getZ());
            shurikenEntity.shootFromRotation(pPlayer, playerPitch, playerYaw, 0.0F, 3.0F, 1.0F);

            if (pPlayer.getAbilities().instabuild) {
                shurikenEntity.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
            }
            pLevel.addFreshEntity(shurikenEntity);
        }

        pPlayer.awardStat(Stats.ITEM_USED.get(this));
        if (!pPlayer.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, Item.TooltipContext context, @NotNull List<Component> components, @NotNull TooltipFlag flag) {

        components.add(Component.literal("Throwable Item:").withStyle(ChatFormatting.GRAY));
        components.add(Component.literal(" 6 Ranged Damage").withStyle(ChatFormatting.DARK_GREEN));

        super.appendHoverText(stack, context, components, flag);
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack itemStack, Direction direction) {
        ThrownShurikenEntity shurikenEntity = new ThrownShurikenEntity(level, position.x(), position.y(), position.z(), itemStack.copyWithCount(1));
        shurikenEntity.pickup = AbstractArrow.Pickup.ALLOWED;
        return shurikenEntity;
    }
}


