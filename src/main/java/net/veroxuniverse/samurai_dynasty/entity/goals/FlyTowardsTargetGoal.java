package net.veroxuniverse.samurai_dynasty.entity.goals;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class FlyTowardsTargetGoal extends Goal {

    private static final double HOVER_OFFSET = 4.0D;
    private static final double BASE_ANGULAR_SPEED = 0.03D;
    private static final double BOB_AMPLITUDE = 1.2D;
    private static final double BOB_SPEED = 2.2D;
    private static final double SMOOTHING = 0.12D;

    private static final double RADIUS_VARIATION = 4.0D;
    private static final double RADIUS_LERP = 0.01D;

    private final Mob mob;
    private final double speed;
    private final double baseRadius;
    private final double phaseOffset;

    private double angle;
    private double angularDirection = 1.0D;
    private double currentRadius;
    private double targetRadius;
    private Vec3 smoothedTargetPos;

    public FlyTowardsTargetGoal(Mob mob, double speed, double orbitRadius) {
        this(mob, speed, orbitRadius, 0.0D);
    }

    public FlyTowardsTargetGoal(Mob mob, double speed, double orbitRadius, double phaseOffset) {
        this.mob = mob;
        this.speed = speed;
        this.baseRadius = orbitRadius;
        this.phaseOffset = phaseOffset;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        LivingEntity target = mob.getTarget();
        return target != null && target.isAlive();
    }

    @Override
    public void start() {
        LivingEntity target = mob.getTarget();
        if (target != null) {
            double dx = mob.getX() - target.getX();
            double dz = mob.getZ() - target.getZ();
            this.angle = Math.atan2(dz, dx);
            this.smoothedTargetPos = target.position();
        }
        this.currentRadius = this.baseRadius;
        this.targetRadius = this.baseRadius;
        this.angularDirection = mob.getRandom().nextBoolean() ? 1.0D : -1.0D;
    }

    @Override
    public void tick() {
        LivingEntity target = mob.getTarget();
        if (target == null) {
            return;
        }

        Vec3 actualPos = target.position();
        if (this.smoothedTargetPos == null) {
            this.smoothedTargetPos = actualPos;
        } else {
            this.smoothedTargetPos = this.smoothedTargetPos.lerp(actualPos, SMOOTHING);
        }

        if (mob.getRandom().nextInt(90) == 0) {
            this.targetRadius = this.baseRadius + (mob.getRandom().nextDouble() - 0.5D) * 2.0D * RADIUS_VARIATION;
        }
        if (mob.getRandom().nextInt(140) == 0) {
            this.angularDirection = -this.angularDirection;
        }
        this.currentRadius = Mth.lerp(RADIUS_LERP, this.currentRadius, this.targetRadius);

        this.angle += BASE_ANGULAR_SPEED * angularDirection;

        double effectiveAngle = angle + phaseOffset;
        double desiredX = this.smoothedTargetPos.x + Math.cos(effectiveAngle) * currentRadius;
        double desiredZ = this.smoothedTargetPos.z + Math.sin(effectiveAngle) * currentRadius;
        double bob = Math.sin(angle * BOB_SPEED) * BOB_AMPLITUDE;
        double desiredY = this.smoothedTargetPos.y + HOVER_OFFSET + bob;

        mob.getMoveControl().setWantedPosition(desiredX, desiredY, desiredZ, speed);
        mob.getLookControl().setLookAt(target, 30.0F, 30.0F);
    }
}