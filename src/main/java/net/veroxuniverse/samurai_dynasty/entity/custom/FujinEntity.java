package net.veroxuniverse.samurai_dynasty.entity.custom;

import mod.azure.azurelib.common.util.MoveAnalysis;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.veroxuniverse.samurai_dynasty.client.entities.FujinDispatcher;
import net.veroxuniverse.samurai_dynasty.entity.boss.DuoBossMob;
import net.veroxuniverse.samurai_dynasty.entity.boss.DuoBossPair;
import net.veroxuniverse.samurai_dynasty.entity.goals.BossFlightMoveControl;
import net.veroxuniverse.samurai_dynasty.entity.goals.DuoBossAttackGoal;
import net.veroxuniverse.samurai_dynasty.entity.goals.FlyTowardsTargetGoal;
import net.veroxuniverse.samurai_dynasty.entity.goals.OrbitNearestPlayerGoal;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Nullable;

public class FujinEntity extends Monster implements DuoBossMob {

    public final FujinDispatcher dispatcher;
    public final MoveAnalysis moveAnalysis;

    public DuoBossPair duoBossPair = new DuoBossPair();

    private static final int WIND_ANIMATION_DELAY = 25;
    private static final double WIND_RANGE = 18.0D;
    private static final double WIND_HALF_ANGLE_DEGREES = 75.0D;
    private static final double WIND_STRENGTH = 2.0D;
    private static final int WIND_TRAVEL_DELAY = 6;

    private int pendingWindDelay = -1;
    private int windTravelTimer = -1;
    private LivingEntity windTarget;
    private Vec3 windLookDirection = Vec3.ZERO;
    private Vec3 windOrigin = Vec3.ZERO;

    private Vec3 forcedVelocity;

    private static final double BARRIER_HP_THRESHOLD = 0.5D;
    private static final int BARRIER_DURATION = 100;
    private static final int BARRIER_COOLDOWN = 300;

    private boolean barrierActive = false;
    private int barrierTimer = -1;
    private int barrierCooldownTimer = 0;

    private static final double PHASE_TWO_HP_THRESHOLD = 0.5D;
    private boolean phaseTwoEntered = false;

    private static final int SHOCKWAVE_WINDUP = 25;
    private static final double SHOCKWAVE_STAND_DISTANCE = 4.0D;
    private static final double SHOCKWAVE_MAX_RADIUS = 13.0D;
    private static final double SHOCKWAVE_EXPAND_PER_TICK = 0.7D;
    private static final double SHOCKWAVE_LAUNCH_STRENGTH = 2.5D;
    private static final double SHOCKWAVE_PUSH_STRENGTH = 1.6D;

    private boolean shockwaveActive = false;
    private int shockwaveWindupTimer = -1;
    private double shockwaveRadius = 0.0D;
    private LivingEntity shockwaveTarget;
    private final Set<UUID> shockwaveHit = new HashSet<>();

    public FujinEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.moveControl = new BossFlightMoveControl(this);
        this.setPathfindingMalus(PathType.POWDER_SNOW, -1.0F);
        this.setPathfindingMalus(PathType.DANGER_POWDER_SNOW, -1.0F);
        this.dispatcher = new FujinDispatcher(this);
        this.moveAnalysis = new MoveAnalysis(this);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 400.0D)
                .add(Attributes.ATTACK_DAMAGE, 16.0f)
                .add(Attributes.ATTACK_SPEED, 0.3f)
                .add(Attributes.FOLLOW_RANGE, 64.0f)
                .add(Attributes.FLYING_SPEED, (double) 0.6F)
                .add(Attributes.ARMOR, 4.0D)
                .add(Attributes.MOVEMENT_SPEED, (double) 0.2F).build();
    }

    protected @NotNull PathNavigation createNavigation(@NotNull Level pLevel) {
        FlyingPathNavigation flyingPathNavigation = new FlyingPathNavigation(this, pLevel);
        flyingPathNavigation.setCanOpenDoors(false);
        flyingPathNavigation.setCanFloat(true);
        flyingPathNavigation.setCanPassDoors(true);
        return flyingPathNavigation;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new DuoBossAttackGoal<>(this));
        this.goalSelector.addGoal(2, new FlyTowardsTargetGoal(this, 1.4D, 11.0D, Math.PI));
        this.goalSelector.addGoal(3, new OrbitNearestPlayerGoal(this, 1.4D, 11.0D, Math.PI));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, 10, false, false, null));
    }

    @Override
    public DuoBossPair getDuoPair() {
        return this.duoBossPair;
    }

    @Override
    public void setForcedVelocity(Vec3 velocity) {
        this.forcedVelocity = velocity;
    }

    @Override
    public boolean isSignatureEffectOngoing() {
        return this.pendingWindDelay > 0 || this.windTravelTimer > 0 || this.shockwaveActive;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        if (this.barrierActive) {
            if (source.getDirectEntity() instanceof Projectile projectile) {
                Vec3 incoming = projectile.getDeltaMovement();
                projectile.setDeltaMovement(incoming.scale(-1.5D));
                projectile.hasImpulse = true;

                if (source.getEntity() instanceof LivingEntity shooter) {
                    shooter.hurt(this.level().damageSources().mobAttack(this), Math.max(amount * 0.75F, 4.0F));
                }

                if (this.level() instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.CLOUD,
                            projectile.getX(), projectile.getY(), projectile.getZ(),
                            6, 0.15D, 0.15D, 0.15D, 0.03D);
                }
                this.playSound(SoundEvents.BREEZE_DEFLECT, 1.3F, 1.0F);
            } else {
                if (this.level() instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.CLOUD,
                            this.getX(), this.getY() + this.getBbHeight() * 0.5D, this.getZ(),
                            6, 0.3D, 0.3D, 0.3D, 0.02D);
                }
                this.playSound(SoundEvents.BREEZE_DEFLECT, 1.1F, 1.1F);
            }
            return false;
        }
        return super.hurt(source, amount);
    }

    private void trySignalAirborneCombo(LivingEntity nearby) {
        LivingEntity partner = this.duoBossPair.getPartner(this);
        if (partner instanceof DuoBossMob partnerMob && partnerMob.isSignatureEffectOngoing()) {
            return;
        }
        if (this.random.nextInt(100) < 60) {
            this.duoBossPair.signalAirborneTarget(nearby);
        }
    }

    private void updateLookTarget() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            this.getLookControl().setLookAt(target, 30.0F, 30.0F);
        } else {
            Player nearest = this.level().getNearestPlayer(this, 40.0D);
            if (nearest != null) {
                this.getLookControl().setLookAt(nearest, 30.0F, 30.0F);
            }
        }
    }

    private void updatePhaseTwoTransition() {
        if (!this.phaseTwoEntered && this.getHealth() <= this.getMaxHealth() * PHASE_TWO_HP_THRESHOLD) {
            this.phaseTwoEntered = true;
            this.bossEvent.setOverlay(BossEvent.BossBarOverlay.NOTCHED_6);
            this.playSound(SoundEvents.BREEZE_WHIRL, 3.0F, 0.6F);
            if (this.level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.CLOUD,
                        this.getX(), this.getY() + this.getBbHeight() * 0.5D, this.getZ(),
                        40, 1.0D, 1.0D, 1.0D, 0.1D);
            }
        }
    }

    private void updateBarrier(ServerLevel serverLevel) {
        if (this.getHealth() > this.getMaxHealth() * BARRIER_HP_THRESHOLD) {
            return;
        }

        if (barrierActive) {
            barrierTimer--;
            if (barrierTimer <= 0) {
                barrierActive = false;
                barrierCooldownTimer = BARRIER_COOLDOWN;
                this.bossEvent.setColor(BossEvent.BossBarColor.BLUE);
            } else {
                spawnBarrierVisual(serverLevel);
            }
        } else if (barrierCooldownTimer > 0) {
            barrierCooldownTimer--;
        } else {
            barrierActive = true;
            barrierTimer = BARRIER_DURATION;
            this.bossEvent.setColor(BossEvent.BossBarColor.WHITE);
            this.playSound(SoundEvents.BREEZE_WHIRL, 1.5F, 0.9F);
        }
    }

    private void spawnBarrierVisual(ServerLevel serverLevel) {
        double radius = this.getBbWidth() * 1.2D + 0.5D;
        int points = 8;
        double spin = this.tickCount * 0.03D;
        double goldenAngle = Math.PI * (3.0D - Math.sqrt(5.0D));

        if (this.tickCount % 2 != 0) {
            return;
        }

        for (int i = 0; i < points; i++) {
            double t = (i + 0.5D) / points;
            double theta = Math.acos(1.0D - 2.0D * t);
            double phi = goldenAngle * i + spin;

            double px = this.getX() + radius * Math.sin(theta) * Math.cos(phi);
            double pz = this.getZ() + radius * Math.sin(theta) * Math.sin(phi);
            double py = this.getY() + this.getBbHeight() * 0.5D + radius * Math.cos(theta);

            serverLevel.sendParticles(ParticleTypes.CLOUD, px, py, pz, 1, 0.0D, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public void performSignatureAttack(LivingEntity target) {
        boolean inPhaseTwo = this.getHealth() <= this.getMaxHealth() * PHASE_TWO_HP_THRESHOLD;

        if (inPhaseTwo && !this.duoBossPair.isPhaseTwoSpecialInUse() && this.random.nextInt(3) == 0) {
            startShockwave(target);
            return;
        }

        this.dispatcher.attack();
        this.playSound(SoundEvents.BREEZE_CHARGE, 2.0F, 1.0F);
        this.windTarget = target;
        this.pendingWindDelay = WIND_ANIMATION_DELAY;
    }

    @Override
    public int getSignatureAnimationDuration() {
        return WIND_ANIMATION_DELAY;
    }

    private void startShockwave(LivingEntity target) {
        this.shockwaveTarget = target;
        this.duoBossPair.setPhaseTwoSpecialInUse(true);

        double angle = this.random.nextDouble() * Math.PI * 2.0D;
        double nx = target.getX() + Math.cos(angle) * SHOCKWAVE_STAND_DISTANCE;
        double nz = target.getZ() + Math.sin(angle) * SHOCKWAVE_STAND_DISTANCE;
        int groundY = this.level().getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                new BlockPos((int) nx, 0, (int) nz)).getY();
        this.moveTo(nx, groundY + 1.5D, nz, this.getYRot(), this.getXRot());

        this.dispatcher.attack();
        this.playSound(SoundEvents.BREEZE_CHARGE, 3.0F, 0.7F);

        this.shockwaveActive = true;
        this.shockwaveWindupTimer = SHOCKWAVE_WINDUP;
        this.shockwaveRadius = 0.0D;
        this.shockwaveHit.clear();
    }

    private void tickShockwave(ServerLevel serverLevel) {
        if (this.shockwaveWindupTimer > 0) {
            this.shockwaveWindupTimer--;
            serverLevel.sendParticles(ParticleTypes.CLOUD,
                    this.getX(), this.getY() - this.getBbHeight() * 0.4D, this.getZ(),
                    3, 0.4D, 0.05D, 0.4D, 0.01D);
            if (this.shockwaveWindupTimer == 0) {
                this.playSound(SoundEvents.BREEZE_WIND_CHARGE_BURST.value(), 2.5F, 0.8F);
            }
            return;
        }

        this.shockwaveRadius += SHOCKWAVE_EXPAND_PER_TICK;

        double baseY = this.getY() - this.getBbHeight() * 0.4D;
        int ringPoints = 24;
        for (int i = 0; i < ringPoints; i++) {
            double angle = (2 * Math.PI / ringPoints) * i;
            double px = this.getX() + Math.cos(angle) * this.shockwaveRadius;
            double pz = this.getZ() + Math.sin(angle) * this.shockwaveRadius;
            int groundY = this.level().getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    new BlockPos((int) px, 0, (int) pz)).getY();
            serverLevel.sendParticles(ParticleTypes.CLOUD, px, groundY + 0.1D, pz, 1, 0.0D, 0.0D, 0.0D, 0.0D);
            serverLevel.sendParticles(ParticleTypes.GUST, px, groundY + 0.1D, pz, 0, 0.0D, 0.3D, 0.0D, 0.15D);
        }

        AABB ringArea = this.getBoundingBox().inflate(this.shockwaveRadius + 1.5D, 4.0D, this.shockwaveRadius + 1.5D);
        for (LivingEntity nearby : this.level().getEntitiesOfClass(LivingEntity.class, ringArea,
                e -> e != this && e.isAlive() && !(e instanceof DuoBossMob))) {
            if (this.shockwaveHit.contains(nearby.getUUID())) {
                continue;
            }
            double horizDist = Math.sqrt((nearby.getX() - this.getX()) * (nearby.getX() - this.getX())
                    + (nearby.getZ() - this.getZ()) * (nearby.getZ() - this.getZ()));
            if (horizDist > this.shockwaveRadius) {
                continue;
            }
            if (!nearby.onGround()) {
                continue;
            }

            this.shockwaveHit.add(nearby.getUUID());
            double dx = nearby.getX() - this.getX();
            double dz = nearby.getZ() - this.getZ();
            double len = Math.sqrt(dx * dx + dz * dz);
            double nx = len > 0.001D ? dx / len : 0.0D;
            double nz = len > 0.001D ? dz / len : 0.0D;

            nearby.setDeltaMovement(nx * SHOCKWAVE_PUSH_STRENGTH, SHOCKWAVE_LAUNCH_STRENGTH, nz * SHOCKWAVE_PUSH_STRENGTH);
            nearby.hurtMarked = true;
            nearby.hurt(this.level().damageSources().mobAttack(this), 6.0F);
            trySignalAirborneCombo(nearby);
        }

        if (this.shockwaveRadius >= SHOCKWAVE_MAX_RADIUS) {
            this.shockwaveActive = false;
            this.duoBossPair.setPhaseTwoSpecialInUse(false);
        }
    }

    private void spawnWindStream(ServerLevel serverLevel, Vec3 origin, Vec3 direction, double progress) {
        int streamCount = 22;
        Vec3 point = origin.add(direction.scale(progress));
        for (int i = 0; i < streamCount; i++) {
            double spreadX = (this.random.nextDouble() - 0.5D) * 0.4D;
            double spreadY = (this.random.nextDouble() - 0.5D) * 0.4D;
            double spreadZ = (this.random.nextDouble() - 0.5D) * 0.4D;
            Vec3 particleDir = direction.add(spreadX, spreadY, spreadZ).normalize();
            double travelSpeed = 1.1D + this.random.nextDouble() * 0.6D;

            serverLevel.sendParticles(ParticleTypes.GUST,
                    point.x, point.y, point.z,
                    0, particleDir.x * travelSpeed, particleDir.y * travelSpeed, particleDir.z * travelSpeed, 1.0D);
        }
    }

    private void beginWindTravel() {
        Vec3 lookDirection;
        if (this.windTarget != null && this.windTarget.isAlive()) {
            Vec3 toTarget = this.windTarget.position().subtract(this.position());
            lookDirection = toTarget.lengthSqr() > 0.001D ? toTarget.normalize() : this.getViewVector(1.0F).normalize();
        } else {
            lookDirection = this.getViewVector(1.0F).normalize();
        }

        this.windLookDirection = lookDirection;
        this.windOrigin = this.position().add(lookDirection.scale(1.2D)).add(0, this.getBbHeight() * 0.5D, 0);

        if (this.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.GUST_EMITTER_LARGE,
                    this.windOrigin.x, this.windOrigin.y, this.windOrigin.z,
                    1, 0.0D, 0.0D, 0.0D, 0.0D);
        }

        this.windTravelTimer = WIND_TRAVEL_DELAY;
    }

    private void castWindBlast() {
        Vec3 lookDirection = this.windLookDirection;
        this.windTarget = null;

        AABB searchArea = this.getBoundingBox().inflate(WIND_RANGE);
        double halfAngleRad = Math.toRadians(WIND_HALF_ANGLE_DEGREES);
        double minDot = Math.cos(halfAngleRad);

        for (LivingEntity nearby : this.level().getEntitiesOfClass(LivingEntity.class, searchArea,
                e -> e != this && e.isAlive() && !(e instanceof DuoBossMob))) {
            Vec3 toEntity = nearby.position().subtract(this.position());
            double distance = toEntity.length();
            if (distance < 0.001D || distance > WIND_RANGE) {
                continue;
            }

            Vec3 toEntityNormalized = toEntity.scale(1.0D / distance);
            double dot = lookDirection.dot(toEntityNormalized);
            if (dot < minDot) {
                continue;
            }

            double falloff = 1.0D - (distance / WIND_RANGE) * 0.5D;
            Vec3 push = toEntityNormalized.scale(WIND_STRENGTH * falloff);
            nearby.setDeltaMovement(nearby.getDeltaMovement().add(push.x, 1.4D, push.z));
            nearby.hurtMarked = true;

            trySignalAirborneCombo(nearby);

            if (this.level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.CLOUD,
                        nearby.getX(), nearby.getY() + nearby.getBbHeight() * 0.5D, nearby.getZ(),
                        4, 0.2D, 0.2D, 0.2D, 0.04D);
            }
        }

        if (!this.level().isClientSide) {
            this.level().playSound(null, this.blockPosition(), SoundEvents.BREEZE_WIND_CHARGE_BURST.value(), SoundSource.HOSTILE, 2.0F, 0.9F);
        }
    }

    @Override
    public void aiStep() {
        if (this.forcedVelocity != null) {
            ((BossFlightMoveControl) this.moveControl).haltMovement();
            super.aiStep();
            this.setDeltaMovement(this.forcedVelocity);
            this.forcedVelocity = null;
            return;
        }

        Vec3 deltaMovement = this.getDeltaMovement();
        double desiredY = this.shockwaveActive ? this.getY() : computeDesiredHoverY();

        double vy = deltaMovement.y;
        if (this.getY() < desiredY) {
            vy = Math.max(0.0D, vy);
            vy += 0.3D - vy * 0.6D;
        } else {
            vy *= 0.6D;
        }

        double vx = this.shockwaveActive ? deltaMovement.x * 0.5D : deltaMovement.x;
        double vz = this.shockwaveActive ? deltaMovement.z * 0.5D : deltaMovement.z;

        this.setDeltaMovement(vx, vy, vz);
        super.aiStep();

        LivingEntity lookTarget = this.shockwaveActive ? this.shockwaveTarget : this.getTarget();
        if (lookTarget == null) {
            lookTarget = pickIdleLookTarget();
        }

        if (this.lookBreakTimer > 0) {
            this.lookBreakTimer--;
        } else if (!this.shockwaveActive && this.random.nextInt(220) == 0) {
            this.lookBreakTimer = 12 + this.random.nextInt(18);
        } else if (lookTarget != null) {
            double dx = lookTarget.getX() - this.getX();
            double dz = lookTarget.getZ() - this.getZ();
            double dy = (lookTarget.getY() + lookTarget.getBbHeight() * 0.5D) - (this.getY() + this.getBbHeight() * 0.5D);
            double horizDist = Math.sqrt(dx * dx + dz * dz);

            float desiredYaw = (float) (Mth.atan2(dz, dx) * (180D / Math.PI)) - 90.0F;
            float newYaw = Mth.approachDegrees(this.getYRot(), desiredYaw, 10.0F);
            this.setYRot(newYaw);
            this.yBodyRot = newYaw;
            this.setYHeadRot(newYaw);

            float desiredPitch = (float) -(Mth.atan2(-dy, horizDist) * (180D / Math.PI));
            this.setXRot(Mth.approachDegrees(this.getXRot(), desiredPitch, 10.0F));
        }
    }

    private LivingEntity pickIdleLookTarget() {
        if (this.idleLookReselectTimer > 0 && this.idleLookTarget != null && this.idleLookTarget.isAlive()) {
            this.idleLookReselectTimer--;
            return this.idleLookTarget;
        }

        List<Player> nearby = this.level().getEntitiesOfClass(Player.class, this.getBoundingBox().inflate(40.0D));
        if (!nearby.isEmpty()) {
            this.idleLookTarget = nearby.get(this.random.nextInt(nearby.size()));
        } else {
            this.idleLookTarget = null;
        }
        this.idleLookReselectTimer = 100 + this.random.nextInt(120);
        return this.idleLookTarget;
    }

    private double lastKnownHoverY = Double.NaN;
    private int lookBreakTimer = 0;
    private LivingEntity idleLookTarget;
    private int idleLookReselectTimer = 0;

    private double computeDesiredHoverY() {
        LivingEntity target = this.getTarget();
        if (target != null) {
            double y = target.getY() + 4.0D;
            this.lastKnownHoverY = y;
            return y;
        }
        BlockPos groundPos = new BlockPos((int) this.getX(), 0, (int) this.getZ());
        int groundY = this.level().getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, groundPos).getY();
        boolean noRelevantGround = groundY <= this.level().getMinBuildHeight() + 1
                || (this.getY() - groundY) > 20.0D;
        double result;
        if (noRelevantGround) {
            result = Double.isNaN(this.lastKnownHoverY) ? this.getY() + 6.0D : this.lastKnownHoverY;
        } else {
            result = groundY + 8.0D;
        }
        this.lastKnownHoverY = result;
        return result;
    }

    private boolean wasMoving = false;

    public void tick() {
        super.tick();
        moveAnalysis.update();

        if (this.level().isClientSide) {
            boolean isMoving = moveAnalysis.isMoving();
            if (isMoving != this.wasMoving) {
                this.wasMoving = isMoving;
                if (isMoving) {
                    dispatcher.walk();
                } else {
                    dispatcher.idle();
                }
            }
        }
    }

    private final ServerBossEvent bossEvent = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.BLUE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

    public void setCustomName(@Nullable Component component) {
        super.setCustomName(component);
        this.bossEvent.setName(this.getDisplayName());
    }

    public void startSeenByPlayer(ServerPlayer serverPlayer) {
        super.startSeenByPlayer(serverPlayer);
        this.bossEvent.addPlayer(serverPlayer);
    }

    public void stopSeenByPlayer(ServerPlayer serverPlayer) {
        super.stopSeenByPlayer(serverPlayer);
        this.bossEvent.removePlayer(serverPlayer);
    }

    public void checkDespawn() {
        if (this.level().getDifficulty() == Difficulty.PEACEFUL && this.shouldDespawnInPeaceful()) {
            this.discard();
        } else {
            this.noActionTime = 0;
        }
    }

    protected void customServerAiStep() {
        super.customServerAiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        this.duoBossPair.tick(this.level().getGameTime());
        updateLookTarget();
        updatePhaseTwoTransition();

        if (this.level() instanceof ServerLevel serverLevel) {
            updateBarrier(serverLevel);
            if (this.shockwaveActive) {
                tickShockwave(serverLevel);
            }
        }

        if (this.pendingWindDelay > 0) {
            this.pendingWindDelay--;
            if (this.pendingWindDelay == 0) {
                beginWindTravel();
            }
        }

        if (this.windTravelTimer > 0) {
            if (this.level() instanceof ServerLevel serverLevel) {
                double progress = 1.0D - (this.windTravelTimer / (double) WIND_TRAVEL_DELAY);
                spawnWindStream(serverLevel, this.windOrigin, this.windLookDirection, progress * WIND_RANGE * 0.6D);
            }
            this.windTravelTimer--;
            if (this.windTravelTimer == 0) {
                castWindBlast();
            }
        }
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, @NotNull DamageSource pSource) {
        return false;
    }

    protected void checkFallDamage(double pY, boolean pOnGround, @NotNull BlockState pState, @NotNull BlockPos pPos) {
    }

    @Override
    public int getCurrentSwingDuration() {
        return 18;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.WITHER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.WITHER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.WITHER_DEATH;
    }

    protected float getSoundVolume() {
        return 0.5F;
    }

    public float getVoicePitch() {
        return 0.5F;
    }

}