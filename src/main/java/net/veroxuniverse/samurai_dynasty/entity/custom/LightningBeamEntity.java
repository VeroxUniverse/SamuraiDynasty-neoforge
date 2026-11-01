package net.veroxuniverse.samurai_dynasty.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class LightningBeamEntity extends Entity {

    private static final EntityDataAccessor<Integer> DATA_LIFETIME =
            SynchedEntityData.defineId(LightningBeamEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> DATA_BEAM_HEIGHT =
            SynchedEntityData.defineId(LightningBeamEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DATA_DIR_X =
            SynchedEntityData.defineId(LightningBeamEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DATA_DIR_Y =
            SynchedEntityData.defineId(LightningBeamEntity.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Float> DATA_DIR_Z =
            SynchedEntityData.defineId(LightningBeamEntity.class, EntityDataSerializers.FLOAT);

    public static final int DEFAULT_LIFETIME = 10;
    public static final float DEFAULT_BEAM_HEIGHT = 25.0F;

    public LightningBeamEntity(EntityType<? extends LightningBeamEntity> type, Level level) {
        super(type, level);
        this.noPhysics = true;
        this.setInvulnerable(true);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        builder.define(DATA_LIFETIME, DEFAULT_LIFETIME);
        builder.define(DATA_BEAM_HEIGHT, DEFAULT_BEAM_HEIGHT);
        builder.define(DATA_DIR_X, 0.0F);
        builder.define(DATA_DIR_Y, 1.0F);
        builder.define(DATA_DIR_Z, 0.0F);
    }

    public void setLifetime(int ticks) {
        this.entityData.set(DATA_LIFETIME, ticks);
    }

    public int getLifetime() {
        return this.entityData.get(DATA_LIFETIME);
    }

    public void setBeamHeight(float height) {
        this.entityData.set(DATA_BEAM_HEIGHT, height);
    }

    public float getBeamHeight() {
        return this.entityData.get(DATA_BEAM_HEIGHT);
    }

    public void setBeamDirection(Vec3 direction) {
        Vec3 normalized = direction.lengthSqr() > 0.0001D ? direction.normalize() : new Vec3(0.0D, 1.0D, 0.0D);
        this.entityData.set(DATA_DIR_X, (float) normalized.x);
        this.entityData.set(DATA_DIR_Y, (float) normalized.y);
        this.entityData.set(DATA_DIR_Z, (float) normalized.z);
    }

    public Vec3 getBeamDirection() {
        return new Vec3(this.entityData.get(DATA_DIR_X), this.entityData.get(DATA_DIR_Y), this.entityData.get(DATA_DIR_Z));
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide && this.tickCount >= getLifetime()) {
            this.discard();
        }
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag tag) {
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag tag) {
    }

    @Override
    public boolean isPickable() {
        return false;
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        return true;
    }

    @Override
    public @NotNull AABB getBoundingBoxForCulling() {
        double len = this.getBeamHeight() + 3.0D;
        return new AABB(this.getX() - len, this.getY() - len, this.getZ() - len,
                this.getX() + len, this.getY() + len, this.getZ() + len);
    }
}