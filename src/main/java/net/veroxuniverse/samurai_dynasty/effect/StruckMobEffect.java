package net.veroxuniverse.samurai_dynasty.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

public class StruckMobEffect extends MobEffect {

    private static final ResourceLocation SLOW_MODIFIER_ID =
            ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "struck_slow");
    private static final double SLOW_AMOUNT = -0.35D;
    private static final float TICK_DAMAGE = 2.0F;

    public StruckMobEffect(MobEffectCategory category, int color) {
        super(category, color);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, SLOW_MODIFIER_ID,
                SLOW_AMOUNT, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        entity.hurt(entity.damageSources().magic(), TICK_DAMAGE + amplifier);

        if (entity.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK,
                    entity.getX(), entity.getY() + entity.getBbHeight() * 0.5D, entity.getZ(),
                    6, 0.3D, 0.4D, 0.3D, 0.02D);
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 20 == 0;
    }

    @Override
    public boolean isBeneficial() {
        return false;
    }
}