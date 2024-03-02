package net.veroxuniverse.epicsamurai.entity.custom;

import com.google.common.base.MoreObjects;
import mod.azure.azurelib.core.animatable.GeoAnimatable;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.AnimationState;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.network.packet.EntityPacket;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;
import net.veroxuniverse.epicsamurai.sound.ESSounds;
import org.jetbrains.annotations.NotNull;

public class BulletEntity  extends AbstractArrow implements GeoAnimatable {

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private float bulletdamage;

    public BulletEntity(EntityType<? extends BulletEntity> entityType, Level world) {
        super(entityType, world);
    }

    protected BulletEntity(EntityType<? extends AbstractArrow> pEntityType, double pX, double pY, double pZ, Level pLevel) {
        this((EntityType<? extends BulletEntity>) pEntityType, pLevel);
        this.setPos(pX, pY, pZ);
    }

    protected BulletEntity(EntityType<? extends AbstractArrow> pEntityType, LivingEntity pShooter, Level pLevel) {
        this(pEntityType, pShooter.getX(), pShooter.getEyeY() - (double)0.1F, pShooter.getZ(), pLevel);
        this.setOwner(pShooter);
        if (pShooter instanceof Player) {
            this.pickup = AbstractArrow.Pickup.DISALLOWED;
        }

    }

    public BulletEntity(Level world, LivingEntity owner, float damage) {
        super(ModEntityTypes.BULLET.get(), owner, world);
        this.pickup = Pickup.DISALLOWED;
        this.setOwner(owner);
        this.bulletdamage = damage;
    }


    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }


    @Override
    protected void doPostHurtEffects(@NotNull LivingEntity living) {
        super.doPostHurtEffects(living);
        if (!(living instanceof Player)) {
            living.setDeltaMovement(0, 0, 0);
            living.invulnerableTime = 0;
        }
    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return EntityPacket.createPacket(this);
    }

    @Override
    protected void tickDespawn() {
        if (tickCount >= 40) remove(RemovalReason.KILLED);
    }

    @Override
    protected boolean tryPickup(@NotNull Player player) {
        return false;
    }

    @Override
    public void tick() {
        Entity entity = this.getOwner();
        if (this.level().isClientSide || (entity == null || !entity.isRemoved()) && this.level().hasChunkAt(this.blockPosition())) {
            super.tick();

            HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
            if (hitresult.getType() != HitResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitresult)) {
                this.onHit(hitresult);
            }

            this.checkInsideBlocks();
            Vec3 vec3 = this.getDeltaMovement();
            double d0 = this.getX() + vec3.x;
            double d1 = this.getY() + vec3.y;
            double d2 = this.getZ() + vec3.z;

            ProjectileUtil.rotateTowardsMovement(this, 0.2F);
            var livingEntities = level().getEntitiesOfClass(Monster.class,
                    new AABB(this.getX() - 6.0, this.getY() - 6.0, this.getZ() - 6.0, this.getX() + 6.0,
                            this.getY() + 6.0, this.getZ() + 6.0), entity1 -> entity1 != this.getOwner());
            if (!livingEntities.isEmpty()) {
                var first = livingEntities.get(0);
                var entityPos = new Vec3(first.getX(), first.getY() + first.getEyeHeight(), first.getZ());
                var newPath = entityPos.subtract(this.getX(), this.getY() + this.getEyeHeight(),
                        this.getZ()).normalize().add(
                        this.getDeltaMovement().normalize().multiply(4.0, 4.0, 4.0)).normalize();
                var speed = this.getDeltaMovement().length();
                this.setDeltaMovement(newPath.multiply(speed, speed, speed));
            }
        } else {
            this.discard();
        }

    }

    @Override
    public @NotNull ItemStack getPickupItem() {
        return new ItemStack(Items.AIR);
    }

    @Override
    public boolean isNoGravity() {
        return !this.isInWater();
    }

    @Override
    public void setSoundEvent(@NotNull SoundEvent soundIn) {
        this.getDefaultHitGroundSoundEvent();
    }

    @Override
    protected @NotNull SoundEvent getDefaultHitGroundSoundEvent() {
        return ESSounds.GUN_HIT.get();
    }

    public boolean shouldRenderAtSqrDistance(double pDistance) {
        double d0 = this.getBoundingBox().getSize() * 10.0D;
        if (Double.isNaN(d0)) {
            d0 = 1.0D;
        }

        d0 *= 64.0D * getViewScale();
        return pDistance < d0 * d0;
    }

    protected void onHitBlock(@NotNull BlockHitResult pResult) {
        super.onHitBlock(pResult);
        if (!this.level().isClientSide) {
            this.playSound(ESSounds.GUN_HIT.get(), 1.0F, 1.0F);
        }
    }

    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);
        if (!this.level().isClientSide) {
            Entity entity = pResult.getEntity();
            Entity entity1 = this.getOwner();
            LivingEntity livingentity = entity1 instanceof LivingEntity ? (LivingEntity)entity1 : null;
            boolean flag = entity.hurt(damageSources().mobProjectile(this, livingentity), 0.0F);
            if (flag) {
                assert livingentity != null;
                //this.doEnchantDamageEffects(livingentity, entity);
                if (entity instanceof LivingEntity) {
                    ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 4), MoreObjects.firstNonNull(entity1, this));
                    ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20, 0), MoreObjects.firstNonNull(entity1, this));
                }
            }
        }
    }

    @Override
    public boolean displayFireAnimation() {
        return false;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<BulletEntity> animationState) {
        return PlayState.STOP;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public double getTick(Object object) {
        return 0;
    }
}