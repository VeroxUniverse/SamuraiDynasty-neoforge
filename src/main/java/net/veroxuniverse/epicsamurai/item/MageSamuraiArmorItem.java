package net.veroxuniverse.epicsamurai.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.hollingsworth.arsnouveau.api.ArsNouveauAPI;
import com.hollingsworth.arsnouveau.api.mana.IManaEquipment;
import com.hollingsworth.arsnouveau.api.perk.*;
import com.hollingsworth.arsnouveau.api.util.PerkUtil;
import com.hollingsworth.arsnouveau.common.perk.RepairingPerk;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import software.bernie.ars_nouveau.geckolib3.item.GeoArmorItem;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.List;
import java.util.UUID;


public class MageSamuraiArmorItem extends GeoArmorItem implements IManaEquipment, IAnimatable {

    private final AnimationFactory FACTORY = GeckoLibUtil.createFactory(this);


    public MageSamuraiArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<>(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.FACTORY;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        //event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.STOP;
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (world.isClientSide())
            return;
        RepairingPerk.attemptRepair(stack, player);
        IPerkHolder<ItemStack> perkHolder = PerkUtil.getPerkHolder(stack);
        if (perkHolder == null)
            return;
        for (PerkInstance instance : perkHolder.getPerkInstances()) {
            if (instance.getPerk() instanceof ITickablePerk tickablePerk) {
                tickablePerk.tick(stack, world, player, instance);
            }
        }
    }

    protected UUID getModifierForSlot(EquipmentSlot pEquipmentSlot) {
        return ARMOR_MODIFIER_UUID_PER_SLOT[pEquipmentSlot.getIndex()];
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot pEquipmentSlot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> attributes = new ImmutableMultimap.Builder<>();
        attributes.putAll(super.getDefaultAttributeModifiers(pEquipmentSlot));
        if (this.slot == pEquipmentSlot) {
            UUID uuid = getModifierForSlot(this.slot);
            IPerkHolder<ItemStack> perkHolder = PerkUtil.getPerkHolder(stack);
            if (perkHolder != null) {
                attributes.put(PerkAttributes.FLAT_MANA_BONUS.get(), new AttributeModifier(uuid, "max_mana_armor", 30 * (perkHolder.getTier() + 1), AttributeModifier.Operation.ADDITION));
                attributes.put(PerkAttributes.MANA_REGEN_BONUS.get(), new AttributeModifier(uuid, "mana_regen_armor", perkHolder.getTier() + 1, AttributeModifier.Operation.ADDITION));
                for (PerkInstance perkInstance : perkHolder.getPerkInstances()) {
                    IPerk perk = perkInstance.getPerk();
                    attributes.putAll(perk.getModifiers(this.slot, stack, perkInstance.getSlot().value));
                }

            }
        }
        return attributes.build();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        IPerkProvider<ItemStack> perkProvider = ArsNouveauAPI.getInstance().getPerkProvider(stack.getItem());
        if (perkProvider != null) {
            if (perkProvider.getPerkHolder(stack) instanceof ArmorPerkHolder armorPerkHolder) {
                tooltip.add(Component.translatable("ars_nouveau.tier", armorPerkHolder.getTier() + 1).withStyle(ChatFormatting.GOLD));
            }
            perkProvider.getPerkHolder(stack).appendPerkTooltip(tooltip, stack);
        }
    }

}