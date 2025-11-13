package net.veroxuniverse.samurai_dynasty.entity.goals;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

import java.util.function.BiConsumer;

public class AnimatedMeleeAttackGoal<T extends PathfinderMob> extends MeleeAttackGoal {

    private final T mobTyped;
    private final BiConsumer<T, LivingEntity> animationCallback;

    public AnimatedMeleeAttackGoal(T mob, double speedModifier, boolean followEvenIfNotSeen, BiConsumer<T, LivingEntity> animationCallback) {
        super(mob, speedModifier, followEvenIfNotSeen);
        this.mobTyped = mob;
        this.animationCallback = animationCallback;
    }

    @Override
    protected void checkAndPerformAttack(LivingEntity target) {
        if (this.canPerformAttack(target)) {
            this.resetAttackCooldown();

            if (animationCallback != null) {
                animationCallback.accept(mobTyped, target);
            }

            this.mob.swing(InteractionHand.MAIN_HAND);
            this.mob.doHurtTarget(target);
        }
    }
}
