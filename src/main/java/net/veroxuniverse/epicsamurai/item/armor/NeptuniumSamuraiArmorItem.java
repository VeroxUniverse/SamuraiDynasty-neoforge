package net.veroxuniverse.epicsamurai.item.armor;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.ModList;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.aquaculture.NeptuniumSamuraiArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.lib.SamuraiArmorItem;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class NeptuniumSamuraiArmorItem extends SamuraiArmorItem {

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        if (ModList.get().isLoaded("aquaculture")) {
            consumer.accept(new IClientItemExtensions() {
                private NeptuniumSamuraiArmorRenderer renderer;

                @Override
                public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                       EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                    if (this.renderer == null)
                        this.renderer = new NeptuniumSamuraiArmorRenderer();

                    this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                    return this.renderer;
                }
            });
        }
    }

    public void onArmorTick(@Nonnull ItemStack stack, Level world, Player player) {
        if (player.isEyeInFluidType((FluidType) ForgeMod.WATER_TYPE.get())) {
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
