package net.veroxuniverse.epicsamurai.entity.custom;
/*
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.veroxuniverse.epicsamurai.entity.ModEntityTypes;
import net.veroxuniverse.epicsamurai.registry.ItemsRegistry;
import org.jetbrains.annotations.NotNull;

public class ShurikenEntity extends ThrowableItemProjectile {

    public ShurikenEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {super(pEntityType, pLevel);}

    public ShurikenEntity(Level pLevel, LivingEntity pShooter) {
        super(ModEntityTypes.SHURIKEN.get(), pShooter, pLevel);
    }

    protected @NotNull Item getDefaultItem() {
        return ItemsRegistry.SHURIKEN.get();
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
        entity.hurt(entity.damageSources().thrown(this, this.getOwner()), 6);
    }

    protected void onHit(@NotNull HitResult pResult) {
        super.onHit(pResult);
        HitResult.Type hitresulttype = pResult.getType();

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {

        ItemEntity dropShuriken = new ItemEntity(this.level(), pResult.getBlockPos().getX(), pResult.getBlockPos().getY() + 1, pResult.getBlockPos().getZ(), new ItemStack(ItemsRegistry.SHURIKEN.get()));
        dropShuriken.setPickUpDelay(0);

        if(!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, ((byte) 3));
            this.level().addFreshEntity(dropShuriken);
        }

        this.discard();
        super.onHitBlock(pResult);
    }
}

 */