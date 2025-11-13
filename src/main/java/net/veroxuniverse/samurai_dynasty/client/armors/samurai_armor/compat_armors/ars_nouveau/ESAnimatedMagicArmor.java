package net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.ars_nouveau;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.hollingsworth.arsnouveau.api.client.IVariantColorProvider;
import com.hollingsworth.arsnouveau.api.mana.IManaEquipment;
import com.hollingsworth.arsnouveau.api.perk.ArmorPerkHolder;
import com.hollingsworth.arsnouveau.api.perk.IPerk;
import com.hollingsworth.arsnouveau.api.perk.IPerkHolder;
import com.hollingsworth.arsnouveau.api.perk.IPerkProvider;
import com.hollingsworth.arsnouveau.api.perk.ITickablePerk;
import com.hollingsworth.arsnouveau.api.perk.PerkAttributes;
import com.hollingsworth.arsnouveau.api.perk.PerkInstance;
import com.hollingsworth.arsnouveau.api.registry.PerkRegistry;
import com.hollingsworth.arsnouveau.api.util.PerkUtil;
import com.hollingsworth.arsnouveau.client.renderer.item.ArmorRenderer;
import com.hollingsworth.arsnouveau.client.renderer.tile.GenericModel;
import com.hollingsworth.arsnouveau.common.armor.Materials;
import com.hollingsworth.arsnouveau.common.crafting.recipes.IDyeable;
import com.hollingsworth.arsnouveau.common.perk.RepairingPerk;
import com.hollingsworth.arsnouveau.setup.registry.ItemsRegistry;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

public class ESAnimatedMagicArmor extends ArmorItem implements IManaEquipment, IDyeable, IVariantColorProvider<ItemStack> {

    public ESAnimatedMagicArmor(ArmorMaterial materialIn, ArmorItem.Type slot, Item.Properties builder, GeoModel<com.hollingsworth.arsnouveau.common.armor.AnimatedMagicArmor> model) {
        super(materialIn, slot, builder);
    }

    public ESAnimatedMagicArmor(ArmorMaterial materialIn, ArmorItem.Type slot, GeoModel<com.hollingsworth.arsnouveau.common.armor.AnimatedMagicArmor> model) {
        this(materialIn, slot, ItemsRegistry.defaultItemProperties().stacksTo(1), model);
    }

    public static com.hollingsworth.arsnouveau.common.armor.AnimatedMagicArmor light(ArmorItem.Type slot) {
        return new com.hollingsworth.arsnouveau.common.armor.AnimatedMagicArmor(Materials.LIGHT, slot, (new GenericModel("light_armor", "item/light_armor")).withEmptyAnim());
    }

    public static com.hollingsworth.arsnouveau.common.armor.AnimatedMagicArmor medium(ArmorItem.Type slot) {
        return new com.hollingsworth.arsnouveau.common.armor.AnimatedMagicArmor(Materials.MEDIUM, slot, (new GenericModel("medium_armor", "item/medium_armor")).withEmptyAnim());
    }

    public static com.hollingsworth.arsnouveau.common.armor.AnimatedMagicArmor heavy(ArmorItem.Type slot) {
        return new com.hollingsworth.arsnouveau.common.armor.AnimatedMagicArmor(Materials.HEAVY, slot, (new GenericModel("heavy_armor", "item/heavy_armor")).withEmptyAnim());
    }

    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (!world.isClientSide()) {
            RepairingPerk.attemptRepair(stack, player);
            IPerkHolder<ItemStack> perkHolder = PerkUtil.getPerkHolder(stack);
            if (perkHolder != null) {
                Iterator var5 = perkHolder.getPerkInstances().iterator();

                while(var5.hasNext()) {
                    PerkInstance instance = (PerkInstance)var5.next();
                    IPerk var8 = instance.getPerk();
                    if (var8 instanceof ITickablePerk) {
                        ITickablePerk tickablePerk = (ITickablePerk)var8;
                        tickablePerk.tick(stack, world, player, instance);
                    }
                }

            }
        }
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot pEquipmentSlot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> attributes = new ImmutableMultimap.Builder();
        attributes.putAll(super.getDefaultAttributeModifiers(pEquipmentSlot));
        if (this.type.getSlot() == pEquipmentSlot) {
            UUID uuid = (UUID)ARMOR_MODIFIER_UUID_PER_TYPE.get(this.type);
            IPerkHolder<ItemStack> perkHolder = PerkUtil.getPerkHolder(stack);
            if (perkHolder != null) {
                attributes.put((Attribute)PerkAttributes.MAX_MANA.get(), new AttributeModifier(uuid, "max_mana_armor", (double)(30 * (perkHolder.getTier() + 1)), Operation.ADDITION));
                attributes.put((Attribute)PerkAttributes.MANA_REGEN_BONUS.get(), new AttributeModifier(uuid, "mana_regen_armor", (double)(perkHolder.getTier() + 1), Operation.ADDITION));
                Iterator var6 = perkHolder.getPerkInstances().iterator();

                while(var6.hasNext()) {
                    PerkInstance perkInstance = (PerkInstance)var6.next();
                    IPerk perk = perkInstance.getPerk();
                    attributes.putAll(perk.getModifiers(this.type.getSlot(), stack, perkInstance.getSlot().value));
                }
            }
        }

        return attributes.build();
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);
        IPerkProvider<ItemStack> perkProvider = PerkRegistry.getPerkProvider(stack.getItem());
        if (perkProvider != null) {
            IPerkHolder var7 = perkProvider.getPerkHolder(stack);
            if (var7 instanceof ArmorPerkHolder) {
                ArmorPerkHolder armorPerkHolder = (ArmorPerkHolder)var7;
                tooltip.add(Component.translatable("ars_nouveau.tier", new Object[]{armorPerkHolder.getTier() + 1}).withStyle(ChatFormatting.GOLD));
            }

            perkProvider.getPerkHolder(stack).appendPerkTooltip(tooltip, stack);
        }

    }

    public void onDye(ItemStack stack, DyeColor dyeColor) {
        IPerkHolder<ItemStack> perkHolder = PerkUtil.getPerkHolder(stack);
        if (perkHolder instanceof ArmorPerkHolder armorPerkHolder) {
            armorPerkHolder.setColor(dyeColor.getName());
        }

    }

    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }


    public void setColor(String color, ItemStack armor) {
    }

    public String getColor(ItemStack object) {
        IPerkHolder<ItemStack> perkHolder = PerkUtil.getPerkHolder(object);
        if (!(perkHolder instanceof ArmorPerkHolder data)) {
            return "purple";
        } else {
            return data.getColor() != null && !data.getColor().isEmpty() ? data.getColor() : "purple";
        }
    }

    public int getMinTier() {
        return 0;
    }
}
