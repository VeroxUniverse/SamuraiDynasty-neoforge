package net.veroxuniverse.samurai_dynasty.entity.custom;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import mod.azure.azurelib.common.api.common.animatable.GeoEntity;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.Animation;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.sblforked.api.SmartBrainOwner;
import mod.azure.azurelib.sblforked.api.core.BrainActivityGroup;
import mod.azure.azurelib.sblforked.api.core.behaviour.FirstApplicableBehaviour;
import mod.azure.azurelib.sblforked.api.core.behaviour.OneRandomBehaviour;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.attack.AnimatableMeleeAttack;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.look.LookAtTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.misc.Idle;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.move.MoveToWalkTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.move.StrafeTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.path.SetRandomWalkTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.path.SetWalkTargetToAttackTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.InvalidateAttackTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.SetPlayerLookTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.SetRandomLookTarget;
import mod.azure.azurelib.sblforked.api.core.behaviour.custom.target.TargetOrRetaliate;
import mod.azure.azurelib.sblforked.api.core.sensor.ExtendedSensor;
import mod.azure.azurelib.sblforked.api.core.sensor.vanilla.HurtBySensor;
import mod.azure.azurelib.sblforked.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.LookAtTargetSink;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;
import net.veroxuniverse.samurai_dynasty.entity.variant.KitsuneVariant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.minecraft.world.entity.monster.hoglin.HoglinBase.throwTarget;
public class KitsuneEntity extends Monster implements GeoEntity, SmartBrainOwner<KitsuneEntity> {

    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(KitsuneEntity.class, EntityDataSerializers.INT);

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
    public KitsuneEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(PathType.POWDER_SNOW, -1.0F);
        this.setPathfindingMalus(PathType.DANGER_POWDER_SNOW, -1.0F);
    }

    public static AttributeSupplier setAttributes() {return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.ATTACK_DAMAGE, 8.0f)
                .add(Attributes.ATTACK_SPEED, 0.3f)
                .add(Attributes.FOLLOW_RANGE, 25.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.3F).build();
    }

    /*
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));

        this.goalSelector.addGoal(2, new KitsuneAttackGoal(this, 1.2D, true));
        //this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, true)); Not needed > KitsuneAttackGoal
        //this.goalSelector.addGoal(3, new MoveTowardsTargetGoal(this, 1.2D, 25.0F)); Not needed > KitsuneAttackGoal

        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, false));
        //this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, true)); Villager Attack
    }
     */

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        this.entityData.set(DATA_ID_TYPE_VARIANT, 0);
    }

    public KitsuneVariant getVariant() {
        return KitsuneVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(KitsuneVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData) {
        KitsuneVariant variant = Util.getRandom(KitsuneVariant.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(DATA_ID_TYPE_VARIANT, pCompound.getInt("Variant"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public int getCurrentSwingDuration() {
        return 18;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "move_controller", 5, state -> {
            if (state.isMoving() && !this.swinging){
                state.setAnimation(RawAnimation.begin().then("animation.kitsune.walk", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            } else if (!state.isMoving() && !this.swinging) {
                state.setAnimation(RawAnimation.begin().then("animation.kitsune.idle", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            }
            return PlayState.STOP;
        }));
        controllers.add(new AnimationController<>(this, "attack_controller", 5, state -> {
            if (this.swinging) {
                state.setAnimation(RawAnimation.begin().then("animation.kitsune.attack", Animation.LoopType.PLAY_ONCE));
                return PlayState.CONTINUE;
            }
            state.getController().forceAnimationReset();
            return PlayState.STOP;
        }));

    }

    static boolean hurtAndThrowTarget(LivingEntity pKitsune, LivingEntity pTarget) {
        float f1 = (float)pKitsune.getAttributeValue(Attributes.ATTACK_DAMAGE);
        float f;
        if ((int)f1 > 0) {
            f = f1 / 2.0F + (float)pKitsune.level().random.nextInt((int)f1);
        } else {
            f = f1;
        }

        DamageSource damagesource = pKitsune.damageSources().mobAttack(pKitsune);
        boolean flag = pTarget.hurt(pTarget.damageSources().mobAttack(pKitsune), f);
        if (flag) {
            if (pKitsune.level() instanceof ServerLevel serverlevel) {
                EnchantmentHelper.doPostAttackEffects(serverlevel, pTarget, damagesource);
                throwTarget(pKitsune, pTarget);
            }
        }

        return flag;
    }

    @Override
    public boolean doHurtTarget(@NotNull Entity pEntity) {
        if (!(pEntity instanceof LivingEntity)) {
            return false;
        } else {
            this.playSound(SoundEvents.FOX_BITE, 1.0F, 0.4F);
            return hurtAndThrowTarget(this, (LivingEntity)pEntity);
        }
    }

    public int getMaxSpawnClusterSize() {
        return 6;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.FOX_AMBIENT;
    }

    protected SoundEvent getHurtSound(@NotNull DamageSource damageSourceIn) {
        return SoundEvents.FOX_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.FOX_DEATH;
    }

    protected float getSoundVolume() {
        return 0.5F;
    }

    public float getVoicePitch() {
        return 0.5F;
    }

    @Override
    public List<ExtendedSensor<KitsuneEntity>> getSensors() {
        return ObjectArrayList.of(
                new NearbyLivingEntitySensor<KitsuneEntity>().setPredicate(
                        (target, entity) -> target.isAlive() && entity.hasLineOfSight(target) && !(target instanceof Monster)),
                new HurtBySensor<>()
        );
    }

    @Override
    public BrainActivityGroup<KitsuneEntity> getCoreTasks() {
        return BrainActivityGroup.coreTasks(
                new LookAtTarget<>(),
                new LookAtTargetSink(35, 120),
                new StrafeTarget<>()
                        .speedMod(0.75F),
                new MoveToWalkTarget<>()
        );
    }

    @Override
    public BrainActivityGroup<KitsuneEntity> getIdleTasks() {
        return BrainActivityGroup.idleTasks(new FirstApplicableBehaviour<KitsuneEntity>(
                        new TargetOrRetaliate<>().alertAlliesWhen((mob, entity) -> this.isAggressive()),
                        new SetPlayerLookTarget<>().stopIf(target -> !target.isAlive() || target instanceof Player player && player.isCreative()),
                        new SetRandomLookTarget<>()),
                new OneRandomBehaviour<>(new SetRandomWalkTarget<>().setRadius(20).speedModifier(0.8f),
                        new Idle<>().runFor(entity -> entity.getRandom().nextInt(300, 600))));
    }

    @Override
    public BrainActivityGroup<KitsuneEntity> getFightTasks() {
        return BrainActivityGroup.fightTasks(
                new InvalidateAttackTarget<>(),
                new SetWalkTargetToAttackTarget<>(),
                new AnimatableMeleeAttack<>(5)
                        .whenStarting(pathfinderMob -> {
                            //this.triggerAnim("attackController", "attack");
                            //CrystalChronicles.LOGGER.info("Try Attack");
                        })
        );
    }

}
