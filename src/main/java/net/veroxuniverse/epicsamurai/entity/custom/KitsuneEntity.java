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
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.veroxuniverse.epicsamurai.enchantment.ModEnchantments;
import net.veroxuniverse.epicsamurai.entity.custom.AI.KitsuneAttackGoal;
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

    private boolean invulnerable;

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
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.ATTACK_DAMAGE, 8.0f)
                .add(Attributes.ATTACK_SPEED, 0.3f)
                .add(Attributes.FOLLOW_RANGE, 25.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.3F).build();
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(1, new FloatGoal(this));

        this.goalSelector.addGoal(2, new KitsuneAttackGoal(this, 1.2D, true));
        //this.goalSelector.addGoal(3, new MoveTowardsTargetGoal(this, 1.2D, 25.0F));

        this.goalSelector.addGoal(4, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Animal.class, false));
    }

    @Override
    public int getCurrentSwingDuration() {
        return 18;
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

    public boolean hasEnchantment(Enchantment pEnchantment, LivingEntity pEntity) {
        if (pEntity != null) {
            return EnchantmentHelper.getEnchantmentLevel(pEnchantment, pEntity) > 0;
        } else {
            return false;
        }
    }

    @Override
    public boolean isInvulnerableTo(DamageSource pSource) {
        LivingEntity attacker = (LivingEntity) pSource.getEntity();
        Enchantment enchantment = ModEnchantments.DEMON_SLAYER.get();

        boolean hasSpiritSlayer = hasEnchantment(enchantment, attacker);

        if (!hasSpiritSlayer && !pSource.isCreativePlayer() && attacker != null) {
            return true;
        } else {
            return pSource.isProjectile() || super.isInvulnerableTo(pSource);
        }
    }



    @Override
    public AnimationFactory getFactory() {
        return FACTORY;
    }

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

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
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
}
