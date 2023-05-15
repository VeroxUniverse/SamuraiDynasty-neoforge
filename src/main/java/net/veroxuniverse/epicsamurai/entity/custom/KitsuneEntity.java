package net.veroxuniverse.epicsamurai.entity.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.entity.custom.AI.KitsuneAttackGoal;
import net.veroxuniverse.epicsamurai.entity.custom.AI.KitsuneRangedAttackGoal;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import static net.minecraft.world.entity.monster.hoglin.HoglinBase.throwTarget;

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

    public static AttributeSupplier setAttributes() {return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 0.3f)
                .add(Attributes.FOLLOW_RANGE, 25.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.23f).build();
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(1, new FloatGoal(this));

        this.goalSelector.addGoal(2, new KitsuneAttackGoal(this, 1.2D, true));
        this.goalSelector.addGoal(3, new KitsuneRangedAttackGoal(this));

        this.goalSelector.addGoal(4, new MoveTowardsTargetGoal(this, 0.5D, 8.0F));

        this.goalSelector.addGoal(5, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

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

    /*

    public void chooseAttackGoal() {
        if (!this.level.isClientSide) {
            this.goalSelector.removeGoal(this.meleeGoal);
            this.goalSelector.removeGoal(this.rangedGoal);
            if (this.getTarget() != null) {
                if (this.distanceToSqr(this.getTarget()) >= 8.0D) {
                    this.goalSelector.addGoal(2, this.rangedGoal);
                } else {
                    this.goalSelector.addGoal(2, this.meleeGoal);
                }
            }
        }
    }

     */

    static boolean hurtAndThrowTarget(LivingEntity pKitsune, LivingEntity pTarget) {
        float f1 = (float)pKitsune.getAttributeValue(Attributes.ATTACK_DAMAGE);
        float f;
        if ((int)f1 > 0) {
            f = f1 / 2.0F + (float)pKitsune.level.random.nextInt((int)f1);
        } else {
            f = f1;
        }

        boolean flag = pTarget.hurt(DamageSource.mobAttack(pKitsune), f);
        if (flag) {
            pKitsune.doEnchantDamageEffects(pKitsune, pTarget);
            throwTarget(pKitsune, pTarget);
        }

        return flag;
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {
        if (!(pEntity instanceof LivingEntity)) {
            return false;
        } else {
            this.playSound(SoundEvents.FOX_BITE, 1.0F, 0.6F);
            return hurtAndThrowTarget(this, (LivingEntity)pEntity);
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
