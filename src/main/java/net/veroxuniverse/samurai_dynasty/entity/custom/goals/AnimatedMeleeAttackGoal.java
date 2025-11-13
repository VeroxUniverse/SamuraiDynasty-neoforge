package net.veroxuniverse.samurai_dynasty.entity.custom.goals;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

import java.util.function.BiConsumer;

public class AnimatedMeleeAttackGoal<T extends PathfinderMob> extends MeleeAttackGoal {
    private final T mob;
    private final BiConsumer<T, LivingEntity> animationCallback;

    public AnimatedMeleeAttackGoal(T mob, double speedModifier, boolean followEvenIfNotSeen, BiConsumer<T, LivingEntity> animationCallback) {
        super(mob, speedModifier, followEvenIfNotSeen);
        this.mob = mob;
        this.animationCallback = animationCallback;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
        double reach = this.getAttackReachSqr(enemy);

        if (distToEnemySqr <= reach && this.getTicksUntilNextAttack() <= 0) {
            this.resetAttackCooldown();

            if (animationCallback != null) {
                animationCallback.accept(mob, enemy);
            }

            mob.doHurtTarget(enemy);
        }
    }
}