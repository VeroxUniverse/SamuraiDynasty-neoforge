package net.veroxuniverse.samurai_dynasty.entity.boss;

import net.minecraft.world.entity.LivingEntity;

public class DuoBossPair {

    private LivingEntity first;
    private LivingEntity second;
    private LivingEntity activeAttacker;
    private int turnCooldown;
    private long lastTickTime = -1L;
    private boolean phaseTwoSpecialInUse = false;

    public boolean isPhaseTwoSpecialInUse() {
        return this.phaseTwoSpecialInUse;
    }

    public void setPhaseTwoSpecialInUse(boolean inUse) {
        this.phaseTwoSpecialInUse = inUse;
    }

    private LivingEntity pendingComboTarget;
    private boolean comboConsumed = true;

    public void signalAirborneTarget(LivingEntity target) {
        this.pendingComboTarget = target;
        this.comboConsumed = false;
    }

    public LivingEntity takeComboTarget() {
        if (this.comboConsumed || this.pendingComboTarget == null || !this.pendingComboTarget.isAlive()) {
            return null;
        }
        this.comboConsumed = true;
        LivingEntity result = this.pendingComboTarget;
        this.pendingComboTarget = null;
        return result;
    }

    public void link(LivingEntity a, LivingEntity b) {
        this.first = a;
        this.second = b;
        this.activeAttacker = a;
        this.turnCooldown = 0;
    }

    public boolean isLinked() {
        return first != null && second != null && first.isAlive() && second.isAlive();
    }

    public LivingEntity getPartner(LivingEntity self) {
        if (first == self) {
            return second;
        }
        if (second == self) {
            return first;
        }
        return null;
    }

    public boolean isTurn(LivingEntity self) {
        if (!isLinked()) {
            return true;
        }
        return activeAttacker == self && turnCooldown <= 0;
    }

    public void passTurn(LivingEntity self, int delayTicks) {
        LivingEntity partner = getPartner(self);
        if (partner != null) {
            this.activeAttacker = partner;
        }
        this.turnCooldown = delayTicks;
    }

    public void tick(long gameTime) {
        if (gameTime == lastTickTime) {
            return;
        }
        lastTickTime = gameTime;
        if (turnCooldown > 0) {
            turnCooldown--;
        }
    }
}