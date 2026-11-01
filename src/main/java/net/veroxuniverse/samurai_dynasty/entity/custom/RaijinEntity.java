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
import net.minecraft.world.effect.MobEffectInstance;
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
import net.veroxuniverse.samurai_dynasty.client.entities.RaijinDispatcher;
import net.veroxuniverse.samurai_dynasty.registry.ModMobEffects;
import net.veroxuniverse.samurai_dynasty.entity.ModEntityTypes;
import net.veroxuniverse.samurai_dynasty.entity.boss.DuoBossMob;
import net.veroxuniverse.samurai_dynasty.entity.boss.DuoBossPair;
import net.veroxuniverse.samurai_dynasty.entity.goals.BossFlightMoveControl;
import net.veroxuniverse.samurai_dynasty.entity.goals.DuoBossAttackGoal;
import net.veroxuniverse.samurai_dynasty.entity.goals.FlyTowardsTargetGoal;
import net.veroxuniverse.samurai_dynasty.entity.goals.OrbitNearestPlayerGoal;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.annotation.Nullable;

public class RaijinEntity extends Monster implements DuoBossMob {

    public final RaijinDispatcher dispatcher;
    public final MoveAnalysis moveAnalysis;

    public DuoBossPair duoBossPair = new DuoBossPair();

    private static final int LIGHTNING_ANIMATION_DELAY = 20;
    private static final int LIGHTNING_STRIKE_COUNT = 6;
    private static final int WARNING_LEAD_TICKS = 30;
    private static final double LIGHTNING_SPREAD = 6.0D;
    private static final double STRIKE_DAMAGE = 16.0D;
    private static final double STRIKE_RADIUS = 2.5D;

    private int pendingLightningDelay = -1;
    private LivingEntity pendingLightningTarget;

    private int strikesRemaining = 0;
    private int strikeTimer = -1;
    private double nextStrikeX, nextStrikeY, nextStrikeZ;
    private LivingEntity stormTarget;

    private Vec3 forcedVelocity;

    private static final double BARRIER_HP_THRESHOLD = 0.5D;
    private static final int BARRIER_DURATION = 100;
    private static final int BARRIER_COOLDOWN = 300;
    private static final int STRUCK_DURATION_TICKS = 100;

    private boolean barrierActive = false;
    private int barrierTimer = -1;
    private int barrierCooldownTimer = 0;

    private static final double PHASE_TWO_HP_THRESHOLD = 0.5D;
    private boolean phaseTwoEntered = false;

    private static final int STAR_BARRAGE_CHARGES = 3;
    private static final int STAR_BARRAGE_WINDUP = 25;
    private static final int STAR_BARRAGE_ARM_COUNT = 8;
    private static final int STAR_BARRAGE_WAVE_COUNT = 3;
    private static final int STAR_BARRAGE_WAVE_INTERVAL = 12;
    private static final double STAR_BARRAGE_STAND_DISTANCE = 4.0D;
    private static final double STAR_BARRAGE_BASE_RADIUS = 3.5D;
    private static final double STAR_BARRAGE_RADIUS_STEP = 3.0D;

    private int starBarrageChargesRemaining = 0;
    private int starBarrageTriggerCooldown = 60;
    private boolean starBarrageActive = false;
    private int starBarrageWindupTimer = -1;
    private int starBarrageWaveTimer = -1;
    private int starBarrageWavesDone = 0;
    private double starBarrageRotation = 0.0D;
    private double starBarrageRotationSpeed = 0.035D;
    private LivingEntity starBarrageTarget;

    private static final int COMBO_STRIKE_MIN_DELAY = 12;
    private static final int COMBO_STRIKE_MAX_DELAY = 22;
    private static final int COMBO_STRIKE_COOLDOWN = 260;
    private int comboStrikeTimer = -1;
    private int comboStrikeCooldownTimer = 0;
    private LivingEntity comboStrikeTarget;

    public RaijinEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.moveControl = new BossFlightMoveControl(this);
        this.setPathfindingMalus(PathType.POWDER_SNOW, -1.0F);
        this.setPathfindingMalus(PathType.DANGER_POWDER_SNOW, -1.0F);
        this.dispatcher = new RaijinDispatcher(this);
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
        this.goalSelector.addGoal(2, new FlyTowardsTargetGoal(this, 1.4D, 11.0D, 0.0D));
        this.goalSelector.addGoal(3, new OrbitNearestPlayerGoal(this, 1.4D, 11.0D, 0.0D));
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
        return this.pendingLightningDelay > 0 || this.strikesRemaining > 0 || this.starBarrageActive;
    }

    @Override
    public boolean hasForcedSignatureChain() {
        return this.starBarrageChargesRemaining > 0;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        if (this.barrierActive) {
            if (!(source.getDirectEntity() instanceof Projectile) && source.getEntity() instanceof LivingEntity attacker) {
                attacker.addEffect(new MobEffectInstance(ModMobEffects.STRUCK, STRUCK_DURATION_TICKS, 0));
                if (this.level() instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK,
                            attacker.getX(), attacker.getY() + attacker.getBbHeight() * 0.5D, attacker.getZ(),
                            15, 0.3D, 0.4D, 0.3D, 0.05D);
                }
                this.playSound(SoundEvents.SHIELD_BLOCK, 1.3F, 1.3F);
            } else {
                if (this.level() instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK,
                            this.getX(), this.getY() + this.getBbHeight() * 0.5D, this.getZ(),
                            6, 0.3D, 0.3D, 0.3D, 0.02D);
                }
                this.playSound(SoundEvents.SHIELD_BLOCK, 1.1F, 1.4F);
            }
            return false;
        }
        return super.hurt(source, amount);
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
            this.playSound(SoundEvents.LIGHTNING_BOLT_THUNDER, 3.0F, 0.6F);
            if (this.level() instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK,
                        this.getX(), this.getY() + this.getBbHeight() * 0.5D, this.getZ(),
                        60, 1.0D, 1.0D, 1.0D, 0.15D);
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
                this.bossEvent.setColor(BossEvent.BossBarColor.RED);
            } else {
                spawnBarrierVisual(serverLevel);
            }
        } else if (barrierCooldownTimer > 0) {
            barrierCooldownTimer--;
        } else {
            barrierActive = true;
            barrierTimer = BARRIER_DURATION;
            this.bossEvent.setColor(BossEvent.BossBarColor.YELLOW);
            this.playSound(SoundEvents.SHIELD_BLOCK, 1.5F, 0.7F);
        }
    }

    private void spawnBarrierVisual(ServerLevel serverLevel) {
        double radius = this.getBbWidth() * 1.2D + 0.5D;
        int points = 18;
        double spin = this.tickCount * 0.04D;
        double goldenAngle = Math.PI * (3.0D - Math.sqrt(5.0D));

        for (int i = 0; i < points; i++) {
            double t = (i + 0.5D) / points;
            double theta = Math.acos(1.0D - 2.0D * t);
            double phi = goldenAngle * i + spin;

            double px = this.getX() + radius * Math.sin(theta) * Math.cos(phi);
            double pz = this.getZ() + radius * Math.sin(theta) * Math.sin(phi);
            double py = this.getY() + this.getBbHeight() * 0.5D + radius * Math.cos(theta);

            serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK, px, py, pz, 1, 0.0D, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public void performSignatureAttack(LivingEntity target) {
        if (this.starBarrageChargesRemaining > 0) {
            startStarBarrage(target);
            return;
        }

        this.dispatcher.attack();
        this.playSound(SoundEvents.LIGHTNING_BOLT_THUNDER, 3.0F, 1.0F);
        this.pendingLightningDelay = LIGHTNING_ANIMATION_DELAY;
        this.pendingLightningTarget = target;
    }

    private void updateStarBarrageTrigger() {
        if (this.starBarrageChargesRemaining > 0 || this.starBarrageActive) {
            return;
        }
        if (this.getHealth() > this.getMaxHealth() * PHASE_TWO_HP_THRESHOLD) {
            return;
        }
        if (this.duoBossPair.isPhaseTwoSpecialInUse()) {
            return;
        }
        if (this.getTarget() == null) {
            return;
        }

        if (this.starBarrageTriggerCooldown > 0) {
            this.starBarrageTriggerCooldown--;
            return;
        }

        if (this.random.nextInt(110) == 0) {
            this.starBarrageChargesRemaining = STAR_BARRAGE_CHARGES;
            this.starBarrageTriggerCooldown = 260;
        }
    }

    @Override
    public int getSignatureAnimationDuration() {
        return LIGHTNING_ANIMATION_DELAY;
    }

    private void startStarBarrage(LivingEntity target) {
        this.starBarrageChargesRemaining--;
        this.starBarrageTarget = target;
        this.duoBossPair.setPhaseTwoSpecialInUse(true);

        double angle = this.random.nextDouble() * Math.PI * 2.0D;
        double nx = target.getX() + Math.cos(angle) * STAR_BARRAGE_STAND_DISTANCE;
        double nz = target.getZ() + Math.sin(angle) * STAR_BARRAGE_STAND_DISTANCE;
        double ny = target.getY() + 2.5D;
        this.moveTo(nx, ny, nz, this.getYRot(), this.getXRot());

        this.dispatcher.attack();
        this.playSound(SoundEvents.LIGHTNING_BOLT_THUNDER, 3.5F, 0.7F);

        this.starBarrageActive = true;
        this.starBarrageWindupTimer = STAR_BARRAGE_WINDUP;
        this.starBarrageWaveTimer = -1;
        this.starBarrageWavesDone = 0;
        this.starBarrageRotation = this.random.nextDouble() * Math.PI * 2.0D;
        this.starBarrageRotationSpeed = (this.random.nextBoolean() ? 1.0D : -1.0D) * 0.035D;
    }

    private void tickStarBarrage(ServerLevel serverLevel) {
        this.starBarrageRotation += this.starBarrageRotationSpeed;
        if (this.random.nextInt(35) == 0) {
            this.starBarrageRotationSpeed = -this.starBarrageRotationSpeed;
        }

        if (this.starBarrageWindupTimer > 0) {
            this.starBarrageWindupTimer--;
            spawnStarTelegraph(serverLevel, STAR_BARRAGE_BASE_RADIUS);
            if (this.starBarrageWindupTimer == 0) {
                this.starBarrageWaveTimer = 0;
            }
            return;
        }

        if (this.starBarrageWaveTimer > 0) {
            this.starBarrageWaveTimer--;
            double upcomingRadius = STAR_BARRAGE_BASE_RADIUS + STAR_BARRAGE_RADIUS_STEP * this.starBarrageWavesDone;
            spawnStarTelegraph(serverLevel, upcomingRadius);
            return;
        }

        if (this.starBarrageWavesDone < STAR_BARRAGE_WAVE_COUNT) {
            executeStarWave(serverLevel);
            this.starBarrageWavesDone++;
            this.starBarrageWaveTimer = STAR_BARRAGE_WAVE_INTERVAL;
        } else {
            this.starBarrageActive = false;
            this.duoBossPair.setPhaseTwoSpecialInUse(false);
        }
    }

    private void spawnStarTelegraph(ServerLevel serverLevel, double radius) {
        for (int i = 0; i < STAR_BARRAGE_ARM_COUNT; i++) {
            double angle = this.starBarrageRotation + (2 * Math.PI / STAR_BARRAGE_ARM_COUNT) * i;
            double px = this.getX() + Math.cos(angle) * radius;
            double pz = this.getZ() + Math.sin(angle) * radius;
            int groundY = serverLevel.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) px, (int) pz);

            int ringPoints = 8;
            double ringRadius = 0.9D;
            for (int r = 0; r < ringPoints; r++) {
                double ringAngle = (2 * Math.PI / ringPoints) * r;
                double rx = px + Math.cos(ringAngle) * ringRadius;
                double rz = pz + Math.sin(ringAngle) * ringRadius;
                serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK, rx, groundY + 0.1D, rz, 1, 0.0D, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    private void executeStarWave(ServerLevel serverLevel) {
        double radius = STAR_BARRAGE_BASE_RADIUS + STAR_BARRAGE_RADIUS_STEP * this.starBarrageWavesDone;
        double centerX = this.getX();
        double centerZ = this.getZ();

        for (int i = 0; i < STAR_BARRAGE_ARM_COUNT; i++) {
            double angle = this.starBarrageRotation + (2 * Math.PI / STAR_BARRAGE_ARM_COUNT) * i;
            double px = centerX + Math.cos(angle) * radius;
            double pz = centerZ + Math.sin(angle) * radius;
            int groundY = serverLevel.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) px, (int) pz);

            LightningBeamEntity beam = ModEntityTypes.LIGHTNING_BEAM.get().create(serverLevel);
            if (beam != null) {
                beam.setPos(px, groundY, pz);
                beam.setLifetime(10);
                beam.setBeamHeight(LightningBeamEntity.DEFAULT_BEAM_HEIGHT * 0.6F);
                beam.setBeamDirection(new Vec3(0.0D, 1.0D, 0.0D));
                serverLevel.addFreshEntity(beam);
            }

            AABB strikeArea = new AABB(px - STRIKE_RADIUS, groundY - 1.0D, pz - STRIKE_RADIUS,
                    px + STRIKE_RADIUS, groundY + 3.0D, pz + STRIKE_RADIUS);
            for (LivingEntity nearby : serverLevel.getEntitiesOfClass(LivingEntity.class, strikeArea,
                    e -> e.isAlive() && !(e instanceof DuoBossMob))) {
                nearby.hurt(serverLevel.damageSources().lightningBolt(), (float) STRIKE_DAMAGE * 0.75F);
            }
        }

        serverLevel.playSound(null, centerX, this.getY(), centerZ,
                SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.HOSTILE, 2.0F, 1.1F);
    }

    private void updateComboStrike(ServerLevel serverLevel) {
        if (this.comboStrikeCooldownTimer > 0) {
            this.comboStrikeCooldownTimer--;
        }

        if (this.comboStrikeTimer < 0) {
            if (this.comboStrikeCooldownTimer <= 0
                    && !this.starBarrageActive
                    && this.pendingLightningDelay <= 0 && this.strikesRemaining <= 0
                    && this.getHealth() <= this.getMaxHealth() * PHASE_TWO_HP_THRESHOLD) {
                LivingEntity airborne = this.duoBossPair.takeComboTarget();
                if (airborne != null) {
                    this.comboStrikeTarget = airborne;
                    this.comboStrikeTimer = COMBO_STRIKE_MIN_DELAY
                            + this.random.nextInt(COMBO_STRIKE_MAX_DELAY - COMBO_STRIKE_MIN_DELAY + 1);
                }
            }
            return;
        }

        if (this.comboStrikeTarget == null || !this.comboStrikeTarget.isAlive()) {
            this.comboStrikeTimer = -1;
            this.comboStrikeTarget = null;
            return;
        }

        serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK,
                this.comboStrikeTarget.getX(), this.comboStrikeTarget.getY() + this.comboStrikeTarget.getBbHeight() + 0.3D,
                this.comboStrikeTarget.getZ(), 2, 0.1D, 0.1D, 0.1D, 0.02D);

        this.comboStrikeTimer--;
        if (this.comboStrikeTimer == 0) {
            double px = this.comboStrikeTarget.getX();
            double py = this.comboStrikeTarget.getY();
            double pz = this.comboStrikeTarget.getZ();

            spawnBeamEffect(serverLevel, px, py, pz);
            this.comboStrikeTarget.hurt(serverLevel.damageSources().lightningBolt(), (float) STRIKE_DAMAGE);
            serverLevel.playSound(null, px, py, pz, SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.HOSTILE, 2.5F, 1.0F);

            this.comboStrikeTarget = null;
            this.comboStrikeTimer = -1;
            this.comboStrikeCooldownTimer = COMBO_STRIKE_COOLDOWN;
        }
    }

    private void scheduleNextStrike(ServerLevel serverLevel, LivingEntity target) {
        this.nextStrikeX = target.getX() + (this.random.nextDouble() - 0.5D) * LIGHTNING_SPREAD;
        this.nextStrikeZ = target.getZ() + (this.random.nextDouble() - 0.5D) * LIGHTNING_SPREAD;
        this.nextStrikeY = serverLevel.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                (int) this.nextStrikeX, (int) this.nextStrikeZ);
        this.strikeTimer = WARNING_LEAD_TICKS;
    }

    private void spawnGroundMarker(ServerLevel serverLevel) {
        int points = 12;
        double radius = 1.2D;
        double spin = (WARNING_LEAD_TICKS - strikeTimer) * 0.15D;

        for (int i = 0; i < points; i++) {
            double angle = spin + (2 * Math.PI / points) * i;
            double px = nextStrikeX + Math.cos(angle) * radius;
            double pz = nextStrikeZ + Math.sin(angle) * radius;
            serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK, px, nextStrikeY + 0.1D, pz,
                    1, 0.0D, 0.0D, 0.0D, 0.0D);
        }
    }

    private void executeStrike(ServerLevel serverLevel, double x, double y, double z) {
        spawnBeamEffect(serverLevel, x, y, z);
        damageNearStrike(serverLevel, x, y, z);

        serverLevel.playSound(null, x, y, z,
                SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.HOSTILE, 2.0F, 1.0F);
    }

    private void spawnBeamEffect(ServerLevel serverLevel, double x, double baseY, double z) {
        LightningBeamEntity beam = ModEntityTypes.LIGHTNING_BEAM.get().create(serverLevel);
        if (beam != null) {
            beam.setPos(x, baseY, z);
            beam.setLifetime(LightningBeamEntity.DEFAULT_LIFETIME);
            beam.setBeamHeight(LightningBeamEntity.DEFAULT_BEAM_HEIGHT);
            beam.setBeamDirection(new Vec3(0.0D, 1.0D, 0.0D));
            serverLevel.addFreshEntity(beam);
        }

        spawnImpactCracks(serverLevel, x, baseY, z);
    }

    private void spawnImpactCracks(ServerLevel serverLevel, double x, double baseY, double z) {
        int crackCount = 5 + this.random.nextInt(3);
        for (int i = 0; i < crackCount; i++) {
            double angle = this.random.nextDouble() * Math.PI * 2.0D;
            double upward = 0.4D + this.random.nextDouble() * 0.5D;
            Vec3 direction = new Vec3(Math.cos(angle), upward, Math.sin(angle)).normalize();

            LightningBeamEntity crack = ModEntityTypes.LIGHTNING_BEAM.get().create(serverLevel);
            if (crack != null) {
                crack.setPos(x, baseY, z);
                crack.setLifetime(6);
                crack.setBeamHeight(1.2F + this.random.nextFloat() * 1.2F);
                crack.setBeamDirection(direction);
                serverLevel.addFreshEntity(crack);
            }
        }
    }

    private void damageNearStrike(ServerLevel serverLevel, double x, double y, double z) {
        AABB strikeArea = new AABB(x - STRIKE_RADIUS, y - 1.0D, z - STRIKE_RADIUS,
                x + STRIKE_RADIUS, y + 3.0D, z + STRIKE_RADIUS);

        for (LivingEntity nearby : serverLevel.getEntitiesOfClass(LivingEntity.class, strikeArea,
                e -> e.isAlive() && !(e instanceof DuoBossMob))) {
            nearby.hurt(serverLevel.damageSources().lightningBolt(), (float) STRIKE_DAMAGE);
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
        double desiredY = this.starBarrageActive ? this.getY() : computeDesiredHoverY();

        double vy = deltaMovement.y;
        if (this.getY() < desiredY) {
            vy = Math.max(0.0D, vy);
            vy += 0.3D - vy * 0.6D;
        } else {
            vy *= 0.6D;
        }

        double vx = this.starBarrageActive ? deltaMovement.x * 0.5D : deltaMovement.x;
        double vz = this.starBarrageActive ? deltaMovement.z * 0.5D : deltaMovement.z;

        this.setDeltaMovement(vx, vy, vz);
        super.aiStep();

        LivingEntity lookTarget = this.starBarrageActive ? this.starBarrageTarget : this.getTarget();
        if (lookTarget == null) {
            lookTarget = pickIdleLookTarget();
        }

        if (this.lookBreakTimer > 0) {
            this.lookBreakTimer--;
        } else if (!this.starBarrageActive && this.random.nextInt(220) == 0) {
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

    private final ServerBossEvent bossEvent = (ServerBossEvent) (new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);

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
            if (this.starBarrageActive) {
                tickStarBarrage(serverLevel);
            }
            updateComboStrike(serverLevel);
        }
        updateStarBarrageTrigger();

        if (this.pendingLightningDelay > 0) {
            this.pendingLightningDelay--;
            if (this.pendingLightningDelay == 0 && this.pendingLightningTarget != null
                    && this.level() instanceof ServerLevel serverLevel) {
                this.stormTarget = this.pendingLightningTarget;
                this.strikesRemaining = LIGHTNING_STRIKE_COUNT;
                scheduleNextStrike(serverLevel, this.stormTarget);
                this.pendingLightningTarget = null;
            }
        }

        if (this.strikesRemaining > 0 && this.level() instanceof ServerLevel serverLevel) {
            if (this.strikeTimer > 0) {
                this.strikeTimer--;
                spawnGroundMarker(serverLevel);
            }
            if (this.strikeTimer == 0) {
                executeStrike(serverLevel, nextStrikeX, nextStrikeY, nextStrikeZ);
                this.strikesRemaining--;
                this.strikeTimer = -1;

                if (this.strikesRemaining > 0 && this.stormTarget != null && this.stormTarget.isAlive()) {
                    scheduleNextStrike(serverLevel, this.stormTarget);
                } else {
                    this.stormTarget = null;
                }
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