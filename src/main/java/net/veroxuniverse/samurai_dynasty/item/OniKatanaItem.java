package net.veroxuniverse.samurai_dynasty.item;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.veroxuniverse.samurai_dynasty.entity.custom.KunaiEntity;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OniKatanaItem extends SwordItem {

    public OniKatanaItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown() && stack.getItem() == ItemsRegistry.KATANA_ONI.get()) {
            components.add(Component.literal("§8Hold [§7Shift§8] for Summary"));
            components.add(Component.literal(""));
            components.add(Component.literal("§7Applies §bFlames§7 on hit.").withStyle(ChatFormatting.GRAY));
            components.add(Component.literal("§7Applies §bSlowness§7 on hit.").withStyle(ChatFormatting.GRAY));
            components.add(Component.literal(""));
            components.add(Component.literal("§7Ability [§eRight-Click§7]"));
            components.add(Component.literal("§7Applies §bFire Resistance§7.").withStyle(ChatFormatting.GRAY));
        } else if (stack.getItem() == ItemsRegistry.KATANA_ONI.get()) {
            components.add(Component.literal("§8Hold [§7Shift§8] for Summary"));
        }

        super.appendHoverText(stack, context, components, flag);
    }

    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (pHand == InteractionHand.MAIN_HAND) {
            pPlayer.getCooldowns().addCooldown(this, 600);
            pLevel.playSound((Player)null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.ENCHANTMENT_TABLE_USE, SoundSource.NEUTRAL, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 0.8F));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 400, 0, false, false, false), pPlayer);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, pLevel.isClientSide());
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 1), player);
            livingEntity.igniteForSeconds(10);
        }

        return super.onLeftClickEntity(stack, player, entity);
    }

}
