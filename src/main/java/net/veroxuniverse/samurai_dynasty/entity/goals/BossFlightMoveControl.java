package net.veroxuniverse.samurai_dynasty.entity.goals;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.phys.Vec3;

public class BossFlightMoveControl extends MoveControl {

    private static final double BASE_SPEED_PER_TICK = 0.5D;

    public BossFlightMoveControl(Mob mob) {
        super(mob);
    }

    public void haltMovement() {
        this.operation = Operation.WAIT;
    }

    @Override
    public void tick() {
        if (this.operation != Operation.MOVE_TO) {
            return;
        }

        double dx = this.wantedX - mob.getX();
        double dy = this.wantedY - mob.getY();
        double dz = this.wantedZ - mob.getZ();
        double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);

        if (dist < 0.05D) {
            return;
        }

        double speedPerTick = this.speedModifier * BASE_SPEED_PER_TICK;
        Vec3 desired = new Vec3(dx / dist, dy / dist, dz / dist).scale(speedPerTick);
        Vec3 current = mob.getDeltaMovement();
        mob.setDeltaMovement(current.add(desired.subtract(current).scale(0.2D)));
    }
}