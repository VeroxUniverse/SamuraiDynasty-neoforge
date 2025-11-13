package net.veroxuniverse.samurai_dynasty.item.armor;

import com.hollingsworth.arsnouveau.common.armor.AnimatedMagicArmor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.client.armors.samurai_armor.compat_armors.ars_nouveau.ESAnimatedMagicArmor;
import software.bernie.geckolib.model.GeoModel;

import javax.annotation.Nullable;

public class MageSamuraiArmorItem extends ESAnimatedMagicArmor {

    public MageSamuraiArmorItem(ArmorMaterial materialIn, ArmorItem.Type slot, Item.Properties builder, GeoModel<AnimatedMagicArmor> model) {
        super(materialIn, slot, builder, model);
    }

    @Override
    public boolean canWalkOnPowderedSnow(ItemStack stack, LivingEntity wearer) {
        return true;
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }


    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, "textures/models/armor/ars_nouveau/ars_samurai_armor_textures_" + this.getColor(stack) + ".png").toString();
    }

}