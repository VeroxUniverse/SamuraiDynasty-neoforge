package net.veroxuniverse.epicsamurai.entity.custom;

import com.google.common.base.MoreObjects;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;
import net.veroxuniverse.epicsamurai.registry.ParticlesInit;
import org.jetbrains.annotations.NotNull;

import static net.neoforged.neoforge.event.EventHooks.onProjectileImpact;

public class KitsuneProjectileEntity extends AbstractHurtingProjectile {

    public KitsuneProjectileEntity(EntityType<? extends AbstractHurtingProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.noPhysics = true;
    }

    public KitsuneProjectileEntity(Level pLevel, LivingEntity pShooter, double pOffsetX, double pOffsetY, double pOffsetZ) {
        super(ModEntityTypes.KITSUNE_PROJECTILE.get(), pShooter, pOffsetX, pOffsetY, pOffsetZ, pLevel);
        this.noPhysics = true;
    }

    public KitsuneProjectileEntity(Level pLevel, double pX, double pY, double pZ, double pOffsetX, double pOffsetY, double pOffsetZ) {
        super(ModEntityTypes.KITSUNE_PROJECTILE.get(), pX, pY, pZ, pOffsetX, pOffsetY, pOffsetZ, pLevel);
        this.noPhysics = true;
    }

    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (!this.level().isClientSide) {
            Entity entity = pResult.getEntity();
            Entity entity1 = this.getOwner();
            LivingEntity livingentity = entity1 instanceof LivingEntity ? (LivingEntity)entity1 : null;
            boolean flag = entity.hurt(damageSources().mobProjectile(this, livingentity), 4.0F);
            if (flag) {
                assert livingentity != null;
                this.doEnchantDamageEffects(livingentity, entity);
                if (entity instanceof LivingEntity) {
                    ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 4), MoreObjects.firstNonNull(entity1, this));
                    ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 0), MoreObjects.firstNonNull(entity1, this));
                }
            }
        }
    }

    protected void onHitBlock(@NotNull BlockHitResult pResult) {
        super.onHitBlock(pResult);
        BlockPos blockpos = pResult.getBlockPos().relative(pResult.getDirection());
        OnibiEntity spawnOnibi = ModEntityTypes.ONIBI.get().create(level());
        double random = Math.random();
        if (this.level().isEmptyBlock(blockpos)) {
            if (random <= 0.5) {
                if (spawnOnibi != null) {
                    spawnOnibi.setPos(Vec3.atCenterOf(blockpos));
                    level().addFreshEntity(spawnOnibi);
                }
            }
        }
        if (!this.level().isClientSide) {
            this.playSound(SoundEvents.SHULKER_BULLET_HIT, 1.0F, 1.0F);
        }
    }

    @Override
    public void tick() {
        Entity entity = this.getOwner();
        if (this.level().isClientSide || (entity == null || !entity.isRemoved()) && this.level().hasChunkAt(this.blockPosition())) {
            super.tick();

            HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
            if (hitresult.getType() != HitResult.Type.MISS && !onProjectileImpact(this, hitresult)) {
                this.onHit(hitresult);
            }

            this.checkInsideBlocks();
            Vec3 vec3 = this.getDeltaMovement();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;

            ProjectileUtil.rotateTowardsMovement(this, 0.2F);
            float f = this.getInertia();
            if (this.isInWater()) {
                for(int i = 0; i < 4; ++i) {
                    float f1 = 0.25F;
                    this.level().addParticle(ParticleTypes.FLAME, d0 - vec3.x * 0.25D, d1 - vec3.y * 0.25D, d2 - vec3.z * 0.25D, vec3.x, vec3.y, vec3.z);
                }

                f = 1.6F;
            }

            this.setDeltaMovement(vec3.add(this.xPower, this.yPower, this.zPower).scale((double)f));
            this.level().addParticle(this.getTrailParticle(), d0, d1 + 0.5D, d2, 0.0D, 0.0D, 0.0D);
            this.setPos(d0, d1, d2);
        } else {
            this.discard();
        }
    }

    protected void onHit(@NotNull HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.discard();
        }
    }

    public float getLightLevelDependentMagicValue() {
        return 1.0F;
    }

    protected boolean shouldBurn() {
        return false;
    }

    protected @NotNull ParticleOptions getTrailParticle() {
        return ParticleTypes.FLAME;
    }

    public boolean isPickable() {
        return false;
    }

    public boolean hurt(DamageSource pSource, float pAmount) {
        return false;
    }

}

