package net.veroxuniverse.samurai_dynasty.entity.goals;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;
import net.veroxuniverse.samurai_dynasty.entity.boss.DuoBossMob;
import net.veroxuniverse.samurai_dynasty.entity.boss.DuoBossPair;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class DuoBossAttackGoal<T extends Mob & DuoBossMob> extends Goal {

    private static final int DASH_DURATION = 18;
    private static final int TURN_COOLDOWN = 50;
    private static final int TURN_COOLDOWN_PHASE_TWO = 80;
    private static final double DASH_SPEED_PER_TICK = 1.8D;
    private static final double DASH_TURN_RATE = 0.3D;
    private static final double USE_RANGE_SQ = 30.0D * 30.0D;

    private enum Pattern {DASH, SIGNATURE}

    private final T mob;
    private final Set<UUID> hitThisDash = new HashSet<>();

    private Pattern chosenPattern;
    private int stateTimer;
    private LivingEntity target;
    private Vec3 dashVelocity = Vec3.ZERO;

    public DuoBossAttackGoal(T mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        LivingEntity currentTarget = mob.getTarget();
        if (currentTarget == null || !currentTarget.isAlive()) {
            return false;
        }
        DuoBossPair pair = mob.getDuoPair();
        return pair.isTurn(mob) && mob.distanceToSqr(currentTarget) <= USE_RANGE_SQ;
    }

    @Override
    public boolean canContinueToUse() {
        if (target == null || !target.isAlive()) {
            return false;
        }
        if (chosenPattern == Pattern.SIGNATURE) {
            return stateTimer > 0 || mob.isSignatureEffectOngoing();
        }
        return stateTimer > 0;
    }

    @Override
    public void start() {
        this.target = mob.getTarget();
        this.hitThisDash.clear();
        this.chosenPattern = mob.hasForcedSignatureChain() ? Pattern.SIGNATURE
                : (mob.getRandom().nextBoolean() ? Pattern.DASH : Pattern.SIGNATURE);

        if (chosenPattern == Pattern.DASH) {
            this.stateTimer = DASH_DURATION;

            double dx = target.getX() - mob.getX();
            double dy = (target.getY() + target.getBbHeight() * 0.5D) - (mob.getY() + mob.getBbHeight() * 0.5D);
            double dz = target.getZ() - mob.getZ();
            double len = Math.sqrt(dx * dx + dy * dy + dz * dz);
            if (len < 0.001D) {
                len = 1.0D;
            }
            this.dashVelocity = new Vec3(dx / len, dy / len, dz / len).scale(DASH_SPEED_PER_TICK);

            float snapYaw = (float) (Mth.atan2(dz, dx) * (180D / Math.PI)) - 90.0F;
            mob.setYRot(snapYaw);
            mob.setYHeadRot(snapYaw);
            mob.yBodyRot = snapYaw;
            mob.yRotO = snapYaw;

            mob.level().playSound(null, mob.getX(), mob.getY(), mob.getZ(),
                    SoundEvents.PHANTOM_SWOOP, SoundSource.HOSTILE, 1.5F, 0.7F);
        } else {
            this.stateTimer = mob.getSignatureAnimationDuration();
            mob.performSignatureAttack(target);
        }
    }

    @Override
    public void tick() {
        if (target != null) {
            mob.getLookControl().setLookAt(target, 30.0F, 30.0F);
        }

        if (chosenPattern == Pattern.DASH) {
            if (target != null && target.isAlive()) {
                double dx = target.getX() - mob.getX();
                double dy = (target.getY() + target.getBbHeight() * 0.5D) - (mob.getY() + mob.getBbHeight() * 0.5D);
                double dz = target.getZ() - mob.getZ();
                double len = Math.sqrt(dx * dx + dy * dy + dz * dz);
                if (len > 0.001D) {
                    Vec3 desiredDir = new Vec3(dx / len, dy / len, dz / len);
                    Vec3 currentDir = this.dashVelocity.lengthSqr() > 0.0001D ? this.dashVelocity.normalize() : desiredDir;
                    Vec3 blendedDir = currentDir.add(desiredDir.subtract(currentDir).scale(DASH_TURN_RATE)).normalize();
                    this.dashVelocity = blendedDir.scale(DASH_SPEED_PER_TICK);

                    float snapYaw = (float) (Mth.atan2(blendedDir.z, blendedDir.x) * (180D / Math.PI)) - 90.0F;
                    mob.setYRot(snapYaw);
                    mob.setYHeadRot(snapYaw);
                    mob.yBodyRot = snapYaw;
                }
            }

            mob.setForcedVelocity(dashVelocity);

            if (mob.level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.CLOUD,
                        mob.getX(), mob.getY() + mob.getBbHeight() * 0.5D, mob.getZ(),
                        4, 0.2D, 0.2D, 0.2D, 0.01D);
            }

            for (LivingEntity nearby : mob.level().getEntitiesOfClass(LivingEntity.class,
                    mob.getBoundingBox().inflate(1.2D),
                    e -> e != mob && e.isAlive() && !(e instanceof DuoBossMob))) {
                if (hitThisDash.add(nearby.getUUID())) {
                    mob.doHurtTarget(nearby);
                    Vec3 knockback = dashVelocity.normalize().scale(2.2D);
                    nearby.setDeltaMovement(nearby.getDeltaMovement().add(knockback.x, 0.5D, knockback.z));
                    nearby.hurtMarked = true;

                    if (mob.level() instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ParticleTypes.SWEEP_ATTACK,
                                nearby.getX(), nearby.getY() + nearby.getBbHeight() * 0.5D, nearby.getZ(),
                                1, 0.0D, 0.0D, 0.0D, 0.0D);
                    }
                    mob.level().playSound(null, nearby.getX(), nearby.getY(), nearby.getZ(),
                            SoundEvents.PLAYER_ATTACK_STRONG, SoundSource.HOSTILE, 1.2F, 0.9F);
                }
            }
        }

        if (stateTimer > 0) {
            stateTimer--;
        }
    }

    @Override
    public void stop() {
        LivingEntity partner = mob.getDuoPair().getPartner(mob);
        boolean anyPhaseTwo = mob.getHealth() <= mob.getMaxHealth() * 0.5D
                || (partner != null && partner.getHealth() <= partner.getMaxHealth() * 0.5D);
        int cooldown = anyPhaseTwo ? TURN_COOLDOWN_PHASE_TWO : TURN_COOLDOWN;
        mob.getDuoPair().passTurn(mob, cooldown);
        this.target = null;
        this.dashVelocity = Vec3.ZERO;
    }
}