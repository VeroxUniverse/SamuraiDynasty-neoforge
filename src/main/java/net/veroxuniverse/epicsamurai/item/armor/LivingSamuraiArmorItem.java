package net.veroxuniverse.epicsamurai.item.armor;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.client.RenderProvider;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.veroxuniverse.epicsamurai.client.armors.samurai_armor.compat_armors.bloodmagic.LivingSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.compat.BloodMagicCompat;
import net.veroxuniverse.epicsamurai.item.armor.lib.SamuraiArmorItem;
import org.jetbrains.annotations.NotNull;
import wayoftime.bloodmagic.common.item.ArmorMaterialLiving;
import wayoftime.bloodmagic.common.item.ExpandedArmor;
import wayoftime.bloodmagic.core.LivingArmorRegistrar;
import wayoftime.bloodmagic.core.living.ILivingContainer;
import wayoftime.bloodmagic.core.living.LivingStats;
import wayoftime.bloodmagic.core.living.LivingUtil;

import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LivingSamuraiArmorItem extends SamuraiArmorItem implements ILivingContainer, ExpandedArmor {
    public LivingSamuraiArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    // Creates the render
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private LivingSamuraiArmorRenderer renderer;

            @Override
            public @NotNull HumanoidModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> original) {
                if (renderer == null)
                    renderer = new LivingSamuraiArmorRenderer();

                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

    @Override
    public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == wayoftime.bloodmagic.common.item.BloodMagicItems.REAGENT_BINDING.get() || super.isValidRepairItem(toRepair, repair);
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        if (this != BloodMagicCompat.LIVING_SAMURAI_CHESTPLATE.get()) {
            return super.damageItem(stack, amount, entity, onBroken);
        }
        int durRemaining = (stack.getMaxDamage() - 1 - stack.getDamageValue());
        return Math.max(Math.min(durRemaining, amount), 0);
    }

    @Override
    public void damageArmor(LivingEntity livingEntity, ItemStack stack, DamageSource source, float damage, EquipmentSlot slot)
    {
        if (slot == EquipmentSlot.CHEST && damage > getMaxDamage() - stack.getDamageValue())
        {
//			livingEntity.attackEntityFrom(source, amount)
//		}
            livingEntity.hurt(livingEntity.damageSources().magic(), 2.0F);
            return;
        }
//        stack.damage((int) damage, livingEntity, entity -> {});
    }

    @Override
    public boolean isEnabled(FeatureFlagSet pEnabledFeatures) {
        return super.isEnabled(pEnabledFeatures);
    }

    @Override
    public InteractionResultHolder<ItemStack> swapWithEquipmentSlot(Item pItem, Level pLevel, Player pPlayer, InteractionHand pHand) {
        return super.swapWithEquipmentSlot(pItem, pLevel, pPlayer, pHand);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack)
    {

        Multimap<Attribute, AttributeModifier> modifiers = HashMultimap.create();
        modifiers.putAll(super.getAttributeModifiers(slot, stack));
        if (slot != EquipmentSlot.CHEST)
            return modifiers;

        if (this.getMaxDamage(stack) - this.getDamage(stack) <= 1)
            return modifiers;

        LivingStats stats = getLivingStats(stack);
        if (stats == null)
            return modifiers;

        stats.getUpgrades().forEach((k, v) -> {
            if (k.getAttributeProvider() != null)
                k.getAttributeProvider().handleAttributes(stats, modifiers, UUID.nameUUIDFromBytes(k.getKey().toString().getBytes()), k, k.getLevel(v.intValue()));
        });

        return modifiers;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        ILivingContainer.appendLivingTooltip(stack, getLivingStats(stack), tooltip, true);
    }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity)
    {
        return hasElytraUpgrade(stack, entity) && stack.getDamageValue() < stack.getMaxDamage() - 1;
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks)
    {
        if (!entity.level().isClientSide && (flightTicks + 1) % 40 == 0)
            stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(net.minecraft.world.entity.EquipmentSlot.CHEST));
        return true;
    }

    public boolean hasElytraUpgrade(ItemStack stack, LivingEntity entity)
    {
        if (stack.getItem() instanceof LivingSamuraiArmorItem && entity instanceof Player && LivingUtil.hasFullSet((Player) entity))
            return LivingStats.fromPlayer((Player) entity, true).getLevel(LivingArmorRegistrar.UPGRADE_ELYTRA.get().getKey()) > 0;
        else
            return false;
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return this.material == ArmorMaterialLiving.INSTANCE;
    }

}
