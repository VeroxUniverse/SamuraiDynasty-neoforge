package net.veroxuniverse.samurai_dynasty.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class YumiBow extends BowItem {


    public YumiBow(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            ItemStack itemstack = player.getProjectile(pStack);
            if (!itemstack.isEmpty()) {
                int i = this.getUseDuration(pStack, pEntityLiving) - pTimeLeft;
                i = net.neoforged.neoforge.event.EventHooks.onArrowLoose(pStack, pLevel, player, i, !itemstack.isEmpty());
                if (i < 0) return;
                float f = getPowerForTime(i);
                if (!((double)f < 0.1)) {
                    List<ItemStack> list = draw(pStack, itemstack, player);
                    if (pLevel instanceof ServerLevel serverlevel && !list.isEmpty()) {
                        float velocityMultiplier = 4.0F;
                        this.shoot(serverlevel, player, player.getUsedItemHand(), pStack, list, f * velocityMultiplier, 1.0F, f == 1.0F, null);
                    }

                    pLevel.playSound(
                            null,
                            player.getX(),
                            player.getY(),
                            player.getZ(),
                            SoundEvents.ARROW_SHOOT,
                            SoundSource.PLAYERS,
                            1.0F,
                            1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F
                    );
                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    @Override
    protected void shootProjectile(
            LivingEntity p_331372_, Projectile p_332000_, int p_330631_, float p_331251_, float p_331199_, float p_330857_, @Nullable LivingEntity p_331572_
    ) {
        p_332000_.shootFromRotation(p_331372_, p_331372_.getXRot(), p_331372_.getYRot() + p_330857_, 0.0F, p_331251_, p_331199_);
    }

    public static float getPowerForTime(int pCharge) {
        float f = (float)pCharge / 16.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public int getUseDuration(ItemStack pStack, LivingEntity pLivingEntity) {
        return 72000;
    }

    @Override
    public int getDefaultProjectileRange() {
        return 25;
    }

}
