package net.veroxuniverse.samurai_dynasty.entity.goals;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.EnumSet;

public class HealPlayerGoal extends Goal {
    private final Mob mob;
    private final double healRadius;
    private final int healAmount;
    private final int healCooldown;
    private int cooldownCounter;
    private int particleDuration;
    private static final int PARTICLE_LIFETIME = 100;
    private Player targetPlayer;


    public HealPlayerGoal(Mob mob, double healRadius, int healAmount, int healCooldown) {
        this.mob = mob;
        this.healRadius = healRadius;
        this.healAmount = healAmount;
        this.healCooldown = healCooldown;
        this.cooldownCounter = 0;
        this.particleDuration = 0;
        this.setFlags(EnumSet.of(Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public boolean canContinueToUse() {
        return particleDuration > 0;
    }

    @Override
    public void tick() {
        Level level = mob.level();
        if (level.isClientSide) return;

        for (Player player : level.players()) {
            if (player.distanceTo(mob) <= healRadius && player.isAlive()) {
                if (cooldownCounter <= 0 && player.getHealth() < player.getMaxHealth()) {
                    player.heal(healAmount);

                    targetPlayer = player;
                    particleDuration = PARTICLE_LIFETIME;
                    cooldownCounter = healCooldown;
                    break;
                }
            }
        }

        if (particleDuration > 0 && targetPlayer != null) {
            for (int i = 0; i < 5; i++) {
                double offsetX = (Math.random() - 0.5) * 0.5;
                double offsetZ = (Math.random() - 0.5) * 0.5;

                level.addParticle(ParticleTypes.HEART,
                        targetPlayer.getX() + offsetX,
                        targetPlayer.getY() + 0.5,
                        targetPlayer.getZ() + offsetZ,
                        0, 0, 0);
            }
            particleDuration--;
        }

        if (cooldownCounter > 0) {
            cooldownCounter--;
        }
    }
}