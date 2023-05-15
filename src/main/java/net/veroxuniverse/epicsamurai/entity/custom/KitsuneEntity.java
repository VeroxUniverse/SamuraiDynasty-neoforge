package net.veroxuniverse.epicsamurai.entity.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.EnumSet;
import java.util.Objects;

public class KitsuneEntity extends Monster implements IAnimatable {

    private final AnimationFactory FACTORY = GeckoLibUtil.createFactory(this);

    private static final AnimationBuilder ATTACK_ANIMATION = new AnimationBuilder().addAnimation("animation.kitsune.attack", ILoopType.EDefaultLoopTypes.PLAY_ONCE);
    private static final AnimationBuilder IDLE_ANIMATION = new AnimationBuilder().addAnimation("animation.kitsune.idle", ILoopType.EDefaultLoopTypes.LOOP);
    private static final AnimationBuilder WALK_ANIMATION = new AnimationBuilder().addAnimation("animation.kitsune.walk", ILoopType.EDefaultLoopTypes.LOOP);

    public KitsuneEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(BlockPathTypes.POWDER_SNOW, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, -1.0F);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 0.3f)
                .add(Attributes.FOLLOW_RANGE, 25.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.23f).build();
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(1, new FloatGoal(this));

        if (KitsuneEntity.this.distanceToSqr(Objects.requireNonNull(KitsuneEntity.this.getTarget())) >= 10.0D) {
            this.goalSelector.addGoal(2, new KitsuneEntity.KitsuneRangedAttackGoal());
        } else if (KitsuneEntity.this.distanceToSqr(Objects.requireNonNull(KitsuneEntity.this.getTarget())) < 10.0D){
            this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, true));
        }

        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Animal.class, true));
    }

    @Override
    public int getCurrentSwingDuration() {
        return 10;
    }

    @Override
    public void registerControllers(AnimationData data) {

        data.addAnimationController(new AnimationController(this, "controller", 0, event -> {
            if (event.isMoving() && !this.swinging){
                event.getController().setAnimation(WALK_ANIMATION);
                return PlayState.CONTINUE;
            } else if (!event.isMoving() && !this.swinging) {
                event.getController().setAnimation(IDLE_ANIMATION);
                return PlayState.CONTINUE;
            }
            return PlayState.STOP;
        }));

        data.addAnimationController(new AnimationController(this, "attackController", 0, event -> {
            if (this.swinging) {
                event.getController().setAnimation(ATTACK_ANIMATION);
                return PlayState.CONTINUE;
            }
            event.getController().markNeedsReload();
            return PlayState.STOP;
        }));
    }

    @Override
    public AnimationFactory getFactory() {
        return FACTORY;
    }

    class KitsuneRangedAttackGoal extends Goal {
        private int attackTime;

        public KitsuneRangedAttackGoal() {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity livingentity = KitsuneEntity.this.getTarget();
            if (livingentity != null && livingentity.isAlive()) {
                return KitsuneEntity.this.level.getDifficulty() != Difficulty.PEACEFUL;
            } else {
                return false;
            }
        }

        public void start() {
        }

        public void stop() {
        }

        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public void tick() {
            if (KitsuneEntity.this.level.getDifficulty() != Difficulty.PEACEFUL) {
                --this.attackTime;
                LivingEntity livingentity = KitsuneEntity.this.getTarget();
                if (livingentity != null) {
                    KitsuneEntity.this.getLookControl().setLookAt(livingentity, 180.0F, 180.0F);
                    double d0 = KitsuneEntity.this.distanceToSqr(livingentity);
                    if (d0 < 400.0D) {
                        if (this.attackTime <= 0) {
                            this.attackTime = 20 + KitsuneEntity.this.random.nextInt(10) * 20 / 2;
                            KitsuneEntity.this.level.addFreshEntity(new KitsuneProjectileEntity(KitsuneEntity.this.level, KitsuneEntity.this, livingentity, KitsuneEntity.this.getDirection().getAxis()));
                            KitsuneEntity.this.playSound(SoundEvents.SHULKER_SHOOT, 2.0F, (KitsuneEntity.this.random.nextFloat() - KitsuneEntity.this.random.nextFloat()) * 0.2F + 1.0F);
                        }
                    } else {
                        KitsuneEntity.this.setTarget((LivingEntity)null);
                    }

                    super.tick();
                }
            }
        }
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        if (!(pEntity instanceof LivingEntity)) {
            return false;
        } else {
            this.playSound(SoundEvents.FOX_BITE, 1.0F, 0.6F);
            return true;
        }
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.FOX_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.FOX_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.FOX_DEATH;
    }

    protected float getSoundVolume() {
        return 0.7F;
    }

    public float getVoicePitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 0.4F;
    }

}
