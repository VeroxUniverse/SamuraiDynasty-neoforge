package net.veroxuniverse.epicsamurai.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;
import net.veroxuniverse.epicsamurai.registry.ItemsRegistry;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ThrownShurikenEntity extends AbstractArrow {
    private static final EntityDataAccessor<Boolean> ID_FOIL = SynchedEntityData.defineId(ThrownShurikenEntity.class, EntityDataSerializers.BOOLEAN);
    private @NotNull ItemStack shurikenItem = new ItemStack(ItemsRegistry.SHURIKEN.get());
    private boolean dealtDamage;

    private float SHURIKEN_DAMAGE = 6;

    public ThrownShurikenEntity(EntityType<? extends ThrownShurikenEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ThrownShurikenEntity(Level pLevel, LivingEntity pShooter, ItemStack pStack) {
        super(ModEntityTypes.SHURIKEN.get(), pShooter, pLevel);
        this.shurikenItem = pStack.copy();
        this.entityData.set(ID_FOIL, pStack.hasFoil());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_FOIL, false);
    }

    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }
        super.tick();
    }


    protected ItemStack getPickupItem() {
        return new ItemStack(ItemsRegistry.SHURIKEN.get().asItem());
    }

    public boolean isFoil() {
        return this.entityData.get(ID_FOIL);
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 pStartVec, Vec3 pEndVec) {
        return this.dealtDamage ? null : super.findHitEntity(pStartVec, pEndVec);
    }

    protected void onHitEntity(@NotNull EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        entity.hurt(entity.damageSources().thrown(this, this.getOwner()), SHURIKEN_DAMAGE);
    }

    protected boolean tryPickup(Player pPlayer) {
        return super.tryPickup(pPlayer) || this.isNoPhysics() && this.ownedBy(pPlayer) && pPlayer.getInventory().add(this.getPickupItem());
    }
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }


    public void playerTouch(Player pEntity) {
        if (this.ownedBy(pEntity) || this.getOwner() == null) {
            super.playerTouch(pEntity);
        }

    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("Shuriken", 10)) {
            this.shurikenItem = ItemStack.of(pCompound.getCompound("Shuriken"));
        }

        this.dealtDamage = pCompound.getBoolean("DealtDamage");
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.put("Shuriken", this.shurikenItem.save(new CompoundTag()));
        pCompound.putBoolean("DealtDamage", this.dealtDamage);
    }

    public void tickDespawn() {
        if (this.pickup != AbstractArrow.Pickup.ALLOWED) {
            super.tickDespawn();
        }

    }

    public boolean shouldRender(double pX, double pY, double pZ) {
        return true;
    }

}
