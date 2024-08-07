package net.veroxuniverse.samurai_dynasty.entity.custom;

import mod.azure.azurelib.animatable.GeoEntity;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.Animation;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.ForgeEventFactory;
import net.veroxuniverse.samurai_dynasty.entity.ModEntityTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TanukiEntity extends TamableAnimal implements GeoEntity {

    private static final EntityDataAccessor<Integer> HEALING =
            SynchedEntityData.defineId(TanukiEntity.class, EntityDataSerializers.INT);

    private int healTimer; // = 1200;
    private final int coolDownTime = 1200;

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    public TanukiEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setTame(false);
    }

    public static AttributeSupplier setAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.FOLLOW_RANGE, 25D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.3D).build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new SitWhenOrderedToGoal(this));
        //this.goalSelector.addGoal(1, new LeapAtTargetGoal(this, 0.4F));
        //this.goalSelector.addGoal(1, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2D, Ingredient.of(Items.POTION), true));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.2F, 8.0F, 2.0F, false));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.2F));

        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HEALING, 1200);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.entityData.set(HEALING, pCompound.getInt("HealCooldown"));
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("HealCooldown", this.getHealCooldown());
    }

    public void setHealCooldown(int healing) {
        this.entityData.set(HEALING, healing);
    }

    public int getHealCooldown() {
        return this.entityData.get(HEALING);
    }

    @Override
    public void tick(){
        if (getHealCooldown() > coolDownTime + 1) {
            setHealCooldown(coolDownTime + 1);
        }

        if (getHealCooldown() <= coolDownTime) {
            healTimer = getHealCooldown();
            healTimer++;
            setHealCooldown(healTimer);
        }

        if (getHealCooldown() == coolDownTime) {

            Player pOwner = (Player) this.getOwner();

            if (this.getOwner() != null) {
                this.playSound(SoundEvents.ENCHANTMENT_TABLE_USE, 100, 2);
                if(pOwner instanceof ServerPlayer player) {
                    player.displayClientMessage(Component.literal("\u00A7a\u00A7lHeal\u00A77 is ready!"), true);
                }
            }
        }
        super.tick();
    }

    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Item item = itemstack.getItem();

        Item itemForTaming = Items.POTION;

        if(item == itemForTaming && !isTame()) {
            if(this.level().isClientSide()) {
                return InteractionResult.CONSUME;
            } else {
                if (!pPlayer.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }

                if (!ForgeEventFactory.onAnimalTame(this, pPlayer)) {
                    super.tame(pPlayer);
                    this.navigation.recomputePath();
                    this.setTarget(null);
                    this.level().broadcastEntityEvent(this, (byte)7);
                    setOrderedToSit(true);
                    this.setInSittingPose(true);
                }

                return InteractionResult.SUCCESS;
            }
        }

        if(isTame() && pHand == InteractionHand.MAIN_HAND && !pPlayer.isShiftKeyDown() && !isFood(itemstack)) {

            // TOGGLES SITTING FOR OUR ENTITY
            setOrderedToSit(!isOrderedToSit());
            setInSittingPose(!isOrderedToSit());

            return InteractionResult.SUCCESS;
        }

        if(isTame() && pHand == InteractionHand.MAIN_HAND && pPlayer.isShiftKeyDown() && !isFood(itemstack)) {

            if (getHealCooldown() >= coolDownTime) {
                setHealCooldown(0);
                healTimer = 0;
                pPlayer.playSound(SoundEvents.BREWING_STAND_BREW, 100, 1);
                if( pPlayer instanceof ServerPlayer player) {
                    player.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 2, false, false, false));
                    player.displayClientMessage(Component.literal("\u00A7e" + (coolDownTime / 20) + " \u00A77seconds left!"), true);
                }
            } else {
                pPlayer.playSound(SoundEvents.VILLAGER_NO, 100, 1.6f);
                if( pPlayer instanceof ServerPlayer player) {
                    player.displayClientMessage(Component.literal("\u00A7e" + ((coolDownTime - healTimer) / 20) + " \u00A77seconds left!"), true);
                }


            }

            return InteractionResult.SUCCESS;

        }


        return super.mobInteract(pPlayer, pHand);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "move_controller", 5, state -> {
            if (state.isMoving()){
                state.setAnimation(RawAnimation.begin().then("animation.tanuki.walk", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            } else if (!state.isMoving() && !this.isInSittingPose()) {
                state.setAnimation(RawAnimation.begin().then("animation.tanuki.idle", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            }
            return PlayState.STOP;
        }));
        controllers.add(new AnimationController<>(this, "attack_controller", 5, state -> {
            if (this.swinging) {
                state.setAnimation(RawAnimation.begin().then("animation.tanuki.attack", Animation.LoopType.PLAY_ONCE));
                return PlayState.CONTINUE;
            }
            state.getController().forceAnimationReset();
            return PlayState.STOP;
        }));
        controllers.add(new AnimationController<>(this, "sit_controller", 5, state -> {
            if (this.isInSittingPose() && this.isTame()) {
                state.setAnimation(RawAnimation.begin().then("animation.tanuki.sit", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            }
            state.getController().forceAnimationReset();
            return PlayState.STOP;
        }));

    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.WHEAT);
    }

    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.WOLF_STEP, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.CAMEL_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.WOLF_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.CAMEL_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return ModEntityTypes.TANUKI.get().create(pLevel);
    }

}
