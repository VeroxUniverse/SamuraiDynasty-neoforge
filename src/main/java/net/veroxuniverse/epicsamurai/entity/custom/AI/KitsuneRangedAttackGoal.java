package net.veroxuniverse.epicsamurai.entity.custom.AI;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.veroxuniverse.epicsamurai.entity.custom.KitsuneProjectileEntity;

import java.util.EnumSet;

public class KitsuneRangedAttackGoal extends Goal {

    protected final PathfinderMob pMob;
    private int attackTime;
    private LivingEntity pTarget;

    public KitsuneRangedAttackGoal(PathfinderMob pMob) {
        this.pMob = pMob;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
    }

    public boolean canUse() {
        LivingEntity livingentity = this.pMob.getTarget();
        if (livingentity != null && livingentity.isAlive()) {
            return this.pMob.level.getDifficulty() != Difficulty.PEACEFUL;
        } else {
            return false;
        }
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        if (this.pMob.level.getDifficulty() != Difficulty.PEACEFUL) {
            --this.attackTime;
            LivingEntity livingentity = this.pMob.getTarget();
            if (livingentity != null) {
                this.pMob.getLookControl().setLookAt(livingentity, 180.0F, 180.0F);
                double d0 = this.pMob.distanceTo(livingentity);
                if (d0 >= 16.0D) {
                    if (this.attackTime <= 0) {
                        this.attackTime = 20 + this.pMob.getRandom().nextInt(10) * 20 / 2;
                        this.pMob.level.addFreshEntity(new KitsuneProjectileEntity(this.pMob.level, this.pMob, livingentity, this.pMob.getDirection().getAxis()));
                        this.pMob.playSound(SoundEvents.SHULKER_SHOOT, 2.0F, 1.0F);
                    }
                } else {
                    this.pMob.setTarget(pTarget);
                }

                super.tick();
            }
        }
    }
}
