package net.veroxuniverse.epicsamurai.entity.custom;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.veroxuniverse.epicsamurai.enchantment.ModEnchantments;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;
import net.veroxuniverse.epicsamurai.registry.ItemsRegistry;
import org.jetbrains.annotations.NotNull;

public class KunaiEntity extends ThrowableItemProjectile {

    public KunaiEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {super(pEntityType, pLevel);}

    public KunaiEntity(Level pLevel, LivingEntity pShooter) {
        super(ModEntityTypes.KUNAI.get(), pShooter, pLevel);
    }

    protected @NotNull Item getDefaultItem() {
        return ItemsRegistry.KUNAI.get();
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return itemstack.isEmpty() ? ParticleTypes.CRIT : new ItemParticleOption(ParticleTypes.ITEM, itemstack);
    }

    public void handleEntityEvent(byte pId) {
        if (pId == 3) {
            ParticleOptions particleoptions = this.getParticle();

            for (int i = 0; i < 8; ++i) {
                this.level().addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }




    protected void onHitEntity(@NotNull EntityHitResult pResult) {
        super.onHitEntity(pResult);
        Entity entity = pResult.getEntity();
        if (this.getOwner() instanceof Player) {
            ItemStack itemstack = ((Player) this.getOwner()).getItemInHand(InteractionHand.MAIN_HAND);
            int sharpnessLvl = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, itemstack);
            if (sharpnessLvl > 0) {
                entity.hurt(entity.damageSources().thrown(this, this.getOwner()), (float) (sharpnessLvl * 0.5D + 6));
            } else {
                entity.hurt(entity.damageSources().thrown(this, this.getOwner()),  6);
            }
        }
    }

    protected void onHit(@NotNull HitResult pResult) {
        super.onHit(pResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }

    }

}
