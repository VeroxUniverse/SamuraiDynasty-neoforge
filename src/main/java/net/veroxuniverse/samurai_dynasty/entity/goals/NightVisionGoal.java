package net.veroxuniverse.samurai_dynasty.entity.goals;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.EnumSet;

public class NightVisionGoal extends Goal {
    private final Mob mob;
    private final double effectRadius;
    private final int effectDuration;
    private final int effectAmplifier;

    public NightVisionGoal(Mob mob, double effectRadius, int effectDuration, int effectAmplifier) {
        this.mob = mob;
        this.effectRadius = effectRadius;
        this.effectDuration = effectDuration;
        this.effectAmplifier = effectAmplifier;
        this.setFlags(EnumSet.of(Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void tick() {
        Level level = mob.level();
        if (level.isClientSide) return;

        for (Player player : level.players()) {
            if (player.distanceTo(mob) <= effectRadius && player.isAlive()) {
                MobEffectInstance nightVision = new MobEffectInstance(MobEffects.NIGHT_VISION, effectDuration, effectAmplifier, true, false);
                player.addEffect(nightVision);
            }
        }
    }
}