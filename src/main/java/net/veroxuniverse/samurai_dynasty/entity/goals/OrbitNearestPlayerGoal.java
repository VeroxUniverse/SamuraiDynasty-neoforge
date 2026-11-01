package net.veroxuniverse.samurai_dynasty.entity.goals;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;

import java.util.EnumSet;

public class OrbitNearestPlayerGoal extends Goal {

    private static final double HOVER_OFFSET = 4.0D;
    private static final double BASE_ANGULAR_SPEED = 0.03D;
    private static final double BOB_AMPLITUDE = 1.2D;
    private static final double BOB_SPEED = 2.2D;
    private static final double SEARCH_RANGE = 40.0D;
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

    public OrbitNearestPlayerGoal(Mob mob, double speed, double orbitRadius, double phaseOffset) {
        this.mob = mob;
        this.speed = speed;
        this.baseRadius = orbitRadius;
        this.phaseOffset = phaseOffset;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        return mob.getTarget() == null && findNearestPlayer() != null;
    }

    @Override
    public boolean canContinueToUse() {
        return mob.getTarget() == null && findNearestPlayer() != null;
    }

    private Player findNearestPlayer() {
        return mob.level().getNearestPlayer(mob, SEARCH_RANGE);
    }

    @Override
    public void start() {
        Player player = findNearestPlayer();
        if (player != null) {
            double dx = mob.getX() - player.getX();
            double dz = mob.getZ() - player.getZ();
            this.angle = Math.atan2(dz, dx);
        }
        this.currentRadius = this.baseRadius;
        this.targetRadius = this.baseRadius;
        this.angularDirection = mob.getRandom().nextBoolean() ? 1.0D : -1.0D;
    }

    @Override
    public void tick() {
        Player player = findNearestPlayer();
        if (player == null) {
            return;
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
        double desiredX = player.getX() + Math.cos(effectiveAngle) * currentRadius;
        double desiredZ = player.getZ() + Math.sin(effectiveAngle) * currentRadius;
        double bob = Math.sin(angle * BOB_SPEED) * BOB_AMPLITUDE;
        double desiredY = player.getY() + HOVER_OFFSET + bob;

        mob.getMoveControl().setWantedPosition(desiredX, desiredY, desiredZ, speed);
        mob.getLookControl().setLookAt(player, 30.0F, 30.0F);
    }
}