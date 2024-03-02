package net.veroxuniverse.epicsamurai.item.ranged;

import com.google.common.collect.Lists;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.client.RenderProvider;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.Animation;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.veroxuniverse.epicsamurai.client.weapons.tanegashima.TanegashimaItemRenderer;
import net.veroxuniverse.epicsamurai.entity.custom.BulletEntity;
import net.veroxuniverse.epicsamurai.item.BulletItem;
import net.veroxuniverse.epicsamurai.registry.ItemsRegistry;
import net.veroxuniverse.epicsamurai.sound.ESSounds;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class GunItem extends GunItemBase implements Vanishable, GeoItem {

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    private static final String TAG_LOADED = "Loaded";
    private static final String TAG_LOADED_PROJECTILES = "LoadedBullets";
    private static final int MAX_LOAD_DURATION = 40;
    public static final int DEFAULT_RANGE = 100;
    private boolean startSoundPlayed = false;
    private boolean midLoadSoundPlayed = false;
    private static final float START_SOUND_PERCENT = 0.2F;
    private static final float MID_SOUND_PERCENT = 0.5F;
    private static final float BULLET_POWER = 14.0F;
    private static final float FIREWORK_POWER = 1.6F;

    public GunItem(Item.Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return BULLET_ONLY;
    }

    public Predicate<ItemStack> getSupportedHeldProjectiles() {
        return BULLET_OR_FIREWORK;
    }


    @Override
    public int getDefaultProjectileRange() {
        return 100;
    }



    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (isLoaded(itemstack)) {
            performShooting(pLevel, pPlayer, pHand, itemstack, getShootingPower(itemstack), 1.0F);
            setLoaded(itemstack, false);
            return InteractionResultHolder.consume(itemstack);
        } else if (!pPlayer.getProjectile(itemstack).isEmpty()) {
            if (!isLoaded(itemstack)) {
                this.startSoundPlayed = false;
                this.midLoadSoundPlayed = false;
                pPlayer.startUsingItem(pHand);
            }

            return InteractionResultHolder.consume(itemstack);
        } else {
            return InteractionResultHolder.fail(itemstack);
        }
    }

    private static float getShootingPower(ItemStack pGunStack) {
        return containsLoadedProjectile(pGunStack, Items.FIREWORK_ROCKET) ? FIREWORK_POWER : BULLET_POWER;
    }
    
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        int i = this.getUseDuration(pStack) - pTimeLeft;
        float f = getPowerForTime(i, pStack);
        if (f >= 1.0F && !isLoaded(pStack) && tryLoadBullets(pEntityLiving, pStack)) {
            setLoaded(pStack, true);
            SoundSource soundsource = pEntityLiving instanceof Player ? SoundSource.PLAYERS : SoundSource.HOSTILE;
            pLevel.playSound((Player) null, pEntityLiving.getX(), pEntityLiving.getY(), pEntityLiving.getZ(), ESSounds.GUN_RELOAD_DROP.get(), soundsource, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.5F + 1.0F) + 0.2F);
        }

    }

    private static boolean tryLoadBullets(LivingEntity pShooter, ItemStack pGunStack) {
        int i = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MULTISHOT, pGunStack);
        int j = i == 0 ? 1 : 3;
        boolean flag = pShooter instanceof Player && ((Player) pShooter).getAbilities().instabuild;
        ItemStack itemstack = pShooter.getProjectile(pGunStack);
        ItemStack itemstack1 = itemstack.copy();

        for (int k = 0; k < j; ++k) {
            if (k > 0) {
                itemstack = itemstack1.copy();
            }

            if (itemstack.isEmpty() && flag) {
                itemstack = new ItemStack(ItemsRegistry.BULLET.get());
                itemstack1 = itemstack.copy();
            }

            if (!loadBullet(pShooter, pGunStack, itemstack, k > 0, flag)) {
                return false;
            }
        }
        return true;
    }

    private static boolean loadBullet(LivingEntity pShooter, ItemStack pGunStack, ItemStack pAmmoStack,
                                      boolean pHasAmmo, boolean pIsCreative) {
        if (pAmmoStack.isEmpty()) {
            return false;
        } else {
            boolean flag = pIsCreative && pAmmoStack.getItem() instanceof BulletItem;
            ItemStack itemstack;
            if (!flag && !pIsCreative && !pHasAmmo) {
                itemstack = pAmmoStack.split(1);
                if (pAmmoStack.isEmpty() && pShooter instanceof Player) {
                    ((Player) pShooter).getInventory().removeItem(pAmmoStack);
                }
            } else {

                itemstack = pAmmoStack.copy();
            }

            addLoadedProjectile(pGunStack, itemstack);
            return true;
        }
    }

    public static boolean isLoaded(ItemStack pGunStack) {
        CompoundTag compoundtag = pGunStack.getTag();
        return compoundtag != null && compoundtag.getBoolean("Loaded");
    }

    public static void setLoaded(ItemStack pGunStack, boolean pIsLoaded) {
        CompoundTag compoundtag = pGunStack.getOrCreateTag();
        compoundtag.putBoolean("Loaded", pIsLoaded);
    }

    private static void addLoadedProjectile(ItemStack pGunStack, ItemStack pAmmoStack) {
        CompoundTag compoundtag = pGunStack.getOrCreateTag();
        ListTag listtag;
        if (compoundtag.contains("LoadedBullets", 9)) {
            listtag = compoundtag.getList("LoadedBullets", 10);
        } else {
            listtag = new ListTag();
        }

        CompoundTag compoundtag1 = new CompoundTag();
        pAmmoStack.save(compoundtag1);
        listtag.add(compoundtag1);
        compoundtag.put("LoadedBullets", listtag);
    }

    private static List<ItemStack> getLoadedBullets(ItemStack pGunStack) {
        List<ItemStack> list = Lists.newArrayList();
        CompoundTag compoundtag = pGunStack.getTag();
        if (compoundtag != null && compoundtag.contains("LoadedBullets", 9)) {
            ListTag listtag = compoundtag.getList("LoadedBullets", 10);
            if (listtag != null) {
                for (int i = 0; i < listtag.size(); ++i) {
                    CompoundTag compoundtag1 = listtag.getCompound(i);
                    list.add(ItemStack.of(compoundtag1));
                }
            }
        }

        return list;
    }

    private static void clearLoadedBullets(ItemStack pGunStack) {
        CompoundTag compoundtag = pGunStack.getTag();
        if (compoundtag != null) {
            ListTag listtag = compoundtag.getList("LoadedBullets", 9);
            listtag.clear();
            compoundtag.put("LoadedBullets", listtag);
        }

    }

    public static boolean containsLoadedProjectile(ItemStack pGunStack, Item pAmmoItem) {
        return getLoadedBullets(pGunStack).stream().anyMatch((itemStack) -> {
            return itemStack.is(pAmmoItem);
        });
    }

    private static void shootProjectile(Level pLevel, LivingEntity pShooter, InteractionHand pHand, ItemStack
            pGunStack, ItemStack pAmmoStack, float pSoundPitch, boolean pIsCreativeMode, float pVelocity,
                                        float pInaccuracy, float pProjectileAngle) {
        if (!pLevel.isClientSide) {
            boolean flag = pAmmoStack.is(Items.FIREWORK_ROCKET);
            Projectile projectile;
            if (flag) {
                projectile = new FireworkRocketEntity(pLevel, pAmmoStack, pShooter, pShooter.getX(), pShooter.getEyeY() - (double) 0.15F, pShooter.getZ(), true);
            } else {
                projectile = getBullet(pLevel, pShooter, pGunStack, pAmmoStack);
            }

            Vec3 vec31 = pShooter.getUpVector(1.0F);
            Quaternionf quaternionf = (new Quaternionf()).setAngleAxis((double) (pProjectileAngle * ((float) Math.PI / 180F)), vec31.x, vec31.y, vec31.z);
            Vec3 vec3 = pShooter.getViewVector(1.0F);
            Vector3f vector3f = vec3.toVector3f().rotate(quaternionf);
            projectile.shoot((double) vector3f.x(), (double) vector3f.y(), (double) vector3f.z(), pVelocity, pInaccuracy);


            pGunStack.hurtAndBreak(flag ? 3 : 1, pShooter, (p_40858_) -> {
                p_40858_.broadcastBreakEvent(pHand);
            });
            pLevel.addFreshEntity(projectile);
            pLevel.playSound((Player) null, pShooter.getX(), pShooter.getY(), pShooter.getZ(), ESSounds.GUN_SHOOT.get(), SoundSource.PLAYERS, 1.0F, pSoundPitch);
        }
    }

    private static BulletEntity getBullet(Level pLevel, LivingEntity pLivingEntity, ItemStack pGunStack, ItemStack pAmmoStack) {
        BulletItem bulletItem = (BulletItem)(pAmmoStack.getItem() instanceof BulletItem ? pAmmoStack.getItem() : ItemsRegistry.BULLET);
        BulletEntity bullet = bulletItem.createBullet(pLevel, pGunStack, pLivingEntity, 14);

        bullet.setSoundEvent(ESSounds.GUN_HIT.get());
        bullet.setShotFromCrossbow(true);
        return bullet;
    }

    public static void performShooting(Level pLevel, LivingEntity pShooter, InteractionHand pUsedHand, ItemStack
            pGunStack, float pVelocity, float pInaccuracy) {
        if (pShooter instanceof Player player && net.minecraftforge.event.ForgeEventFactory.onArrowLoose(pGunStack, pShooter.level(), player, 1, true) < 0)
            return;
        List<ItemStack> list = getLoadedBullets(pGunStack);
        float[] afloat = getShotPitches(pShooter.getRandom());

        Projectile bullet = null;

        for (int i = 0; i < list.size(); ++i) {
            ItemStack itemstack = list.get(i);
            boolean flag = pShooter instanceof Player && ((Player) pShooter).getAbilities().instabuild;
            if (!itemstack.isEmpty()) {
                if (i == 0) {
                    shootProjectile(pLevel, pShooter, pUsedHand, pGunStack, itemstack, afloat[i], flag, pVelocity, pInaccuracy, 0.0F);
                } else if (i == 1) {
                    shootProjectile(pLevel, pShooter, pUsedHand, pGunStack, itemstack, afloat[i], flag, pVelocity, pInaccuracy, -10.0F);
                } else if (i == 2) {
                    shootProjectile(pLevel, pShooter, pUsedHand, pGunStack, itemstack, afloat[i], flag, pVelocity, pInaccuracy, 10.0F);
                }
            }
        }
        onGunShot(pLevel, pShooter, pGunStack);
    }

    private static float[] getShotPitches(RandomSource pRandom) {
        boolean flag = pRandom.nextBoolean();
        return new float[]{1.0F, getRandomShotPitch(flag, pRandom), getRandomShotPitch(!flag, pRandom)};
    }

    private static float getRandomShotPitch(boolean pIsHighPitched, RandomSource pRandom) {
        float f = pIsHighPitched ? 0.63F : 0.43F;
        return 1.0F / (pRandom.nextFloat() * 0.5F + 1.8F) + f;
    }

    private static void onGunShot(Level pLevel, LivingEntity pShooter, ItemStack pGunStack) {
        if (pShooter instanceof ServerPlayer serverplayer) {
            if (!pLevel.isClientSide) {
                CriteriaTriggers.SHOT_CROSSBOW.trigger(serverplayer, pGunStack);
            }

            serverplayer.awardStat(Stats.ITEM_USED.get(pGunStack.getItem()));
        }
        clearLoadedBullets(pGunStack);
    }

    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pCount) {
        if (!pLevel.isClientSide) {
            SoundEvent soundevent1 = ESSounds.GUN_RELOAD.get();
            float f = (float) (pStack.getUseDuration() - pCount) / (float) getLoadDuration(pStack);
            if (f < 0.2F) {
                this.startSoundPlayed = false;
                this.midLoadSoundPlayed = false;
            }

            if (f >= 0.2F && !this.startSoundPlayed) {
                this.startSoundPlayed = true;
                pLevel.playSound((Player) null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), soundevent1, SoundSource.PLAYERS, 0.5F, 1.0F);
            }

            if (f >= 0.5F && soundevent1 != null && !this.midLoadSoundPlayed) {
                this.midLoadSoundPlayed = true;
                pLevel.playSound((Player) null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(), soundevent1, SoundSource.PLAYERS, 0.5F, 1.0F);
            }
        }

    }
    
    public int getUseDuration(ItemStack pStack) {
        return getLoadDuration(pStack) + 3;
    }

    public static int getLoadDuration(ItemStack pGunStack) {
        return MAX_LOAD_DURATION;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.CROSSBOW;
    }

    private static float getPowerForTime(int pUseTime, ItemStack pGunStack) {
        float f = (float) pUseTime / (float) getLoadDuration(pGunStack);
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    public void appendHoverText(net.minecraft.world.item.ItemStack pStack, @Nullable Level
            pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        List<ItemStack> list = getLoadedBullets(pStack);
        if (isLoaded(pStack) && !list.isEmpty()) {
            ItemStack itemstack = list.get(0);
            pTooltip.add(Component.translatable("item.minecraft.crossbow.projectile").append(CommonComponents.SPACE).append(itemstack.getDisplayName()));
            if (pFlag.isAdvanced() && itemstack.is(Items.FIREWORK_ROCKET)) {
                List<Component> list1 = Lists.newArrayList();
                Items.FIREWORK_ROCKET.appendHoverText(itemstack, pLevel, list1, pFlag);
                if (!list1.isEmpty()) {
                    for (int i = 0; i < list1.size(); ++i) {
                        list1.set(i, Component.literal("  ").append(list1.get(i)).withStyle(ChatFormatting.GRAY));
                    }

                    pTooltip.addAll(list1);
                }
            }

        }
    }
    
    public boolean useOnRelease(net.minecraft.world.item.ItemStack pStack) {
        return pStack.is(this);
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            // Your render made above
            private TanegashimaItemRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null)
                    return new TanegashimaItemRenderer();
                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, state -> {
            state.setAnimation(RawAnimation.begin().then("animation.tanegashima.idle", Animation.LoopType.LOOP));
            return PlayState.STOP;
        }));
        controllerRegistrar.add(new AnimationController<>(this, "controller_reload", 0, state -> PlayState.CONTINUE)
                .triggerableAnim("reload", RawAnimation.begin().thenPlay("animation.tanegashima.reload")));
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

}

