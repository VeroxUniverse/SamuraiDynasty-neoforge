package net.veroxuniverse.samurai_dynasty.entity.boss;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public interface DuoBossMob {

    DuoBossPair getDuoPair();

    void performSignatureAttack(LivingEntity target);

    int getSignatureAnimationDuration();

    void setForcedVelocity(Vec3 velocity);

    default boolean isSignatureEffectOngoing() {
        return false;
    }

    default boolean hasForcedSignatureChain() {
        return false;
    }
}