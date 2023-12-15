/*

package net.veroxuniverse.epicsamurai.item.armor;

import com.hollingsworth.arsnouveau.common.armor.AnimatedMagicArmor;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.fml.ModList;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import net.veroxuniverse.epicsamurai.client.custom_armors.samurai_armor.compat_armors.ars_nouveau.MageSamuraiArmorRenderer;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.model.GeoModel;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class MageSamuraiArmorItem extends AnimatedMagicArmor implements GeoItem {

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public GeoModel<AnimatedMagicArmor> model;

    public MageSamuraiArmorItem(ArmorMaterial materialIn, ArmorItem.Type slot, Item.Properties builder, GeoModel<AnimatedMagicArmor> model) {
        super(materialIn, slot, builder, model);
        this.model = model;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        if (ModList.get().isLoaded("ars_nouveau")) {
            consumer.accept(new IClientItemExtensions() {
                private MageSamuraiArmorRenderer renderer;

                @Override
                public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                       EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                    if (this.renderer == null)
                        this.renderer = new MageSamuraiArmorRenderer();

                    this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                    return this.renderer;
                }
            });
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<MageSamuraiArmorItem> animationState) {
        return PlayState.STOP;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
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
        return new ResourceLocation(EpicSamuraiMod.MOD_ID, "textures/models/armor/ars_nouveau/ars_samurai_armor_textures_" + this.getColor(stack) + ".png").toString();
    }

}

 */

