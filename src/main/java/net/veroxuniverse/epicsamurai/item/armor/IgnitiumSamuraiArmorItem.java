package net.veroxuniverse.epicsamurai.item.armor;

import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.epicsamurai.item.armor.lib.SamuraiArmorItem;

public class IgnitiumSamuraiArmorItem extends SamuraiArmorItem {

    public IgnitiumSamuraiArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }
/*
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private IgnitiumSamuraiArmorRenderer renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                   EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null)
                    this.renderer = new IgnitiumSamuraiArmorRenderer();

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    public void setDamage(ItemStack stack, int damage) {
        if(ModList.get().isLoaded("cataclysm")) {
            if (CMConfig.Armor_Infinity_Durability) {
                super.setDamage(stack, 0);
            }
        } else {
            super.setDamage(stack, damage);
        }

    }

    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (this.type == Type.HELMET) {
            tooltip.add(Component.translatable("item.cataclysm.ignitium_helmet.desc").withStyle(ChatFormatting.DARK_GREEN));
        }

        if (this.type == Type.LEGGINGS) {
            tooltip.add(Component.translatable("item.cataclysm.ignitium_leggings.desc").withStyle(ChatFormatting.DARK_GREEN));
        }

        if (this.type == Type.BOOTS) {
            tooltip.add(Component.translatable("item.cataclysm.ignitium_boots.desc").withStyle(ChatFormatting.DARK_GREEN));
        }

    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return this.material == ArmorMaterialsRegistry.SAMURAI_IGNITIUM;
    }

 */

}