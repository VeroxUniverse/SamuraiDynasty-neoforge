package net.veroxuniverse.samurai_dynasty.item.armor;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.veroxuniverse.samurai_dynasty.item.armor.lib.SamuraiArmorItem;

import javax.annotation.Nonnull;

public class NeptuniumSamuraiArmorItem extends SamuraiArmorItem {

    public void onArmorTick(@Nonnull ItemStack stack, Level world, Player player) {
        if (player.isEyeInFluidType(ForgeMod.WATER_TYPE.get())) {
            if (this.type == Type.HELMET) {
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 20, 0, false, false, false));
            } else if (this.type == Type.CHESTPLATE) {
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 20, 0, false, false, false));
            } else if (this.type == Type.BOOTS) {
                player.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 20, 0, false, false, false));
            }
        }

    }

    public NeptuniumSamuraiArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

}
