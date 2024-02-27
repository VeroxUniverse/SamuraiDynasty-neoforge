package net.veroxuniverse.epicsamurai.item.armor;

import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.client.RenderProvider;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.veroxuniverse.epicsamurai.client.armors.ninja_armor.netherite.NetheriteNinjaArmorRenderer;
import net.veroxuniverse.epicsamurai.item.armor.lib.SamuraiArmorItem;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class NetheriteNinjaArmorItem extends SamuraiArmorItem {
    public NetheriteNinjaArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    // Creates the render
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private NetheriteNinjaArmorRenderer renderer;

            @Override
            public @NotNull HumanoidModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> original) {
                if (renderer == null)
                    renderer = new NetheriteNinjaArmorRenderer();

                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

}