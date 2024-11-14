package net.veroxuniverse.samurai_dynasty.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class YumiBow extends BowItem {


    public YumiBow(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player) {
            int charge = this.getUseDuration(stack, entity) - timeLeft;
            float power = getPowerForTime(charge);

            if (power >= 0.1) {
                ArrowItem arrowItem = (ArrowItem) Items.ARROW;
                AbstractArrow arrow = arrowItem.createArrow(level, stack, player, null);
                arrow.setBaseDamage(arrow.getBaseDamage() + 4.0);

                arrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, power * 3.0F, 1.0F);
                level.addFreshEntity(arrow);

                level.playSound(
                        null,
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        SoundEvents.ARROW_SHOOT,
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + power * 0.5F
                );

                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pLivingEntity) {
        return 126000;
    }

}
