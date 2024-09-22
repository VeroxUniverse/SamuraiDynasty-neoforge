package net.veroxuniverse.samurai_dynasty.datagen.enchantment;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;

public class ModEnchantments {

    public static final ResourceKey<Enchantment> RETURNING_BLADE = key("returning_blade");

    public static void bootstrap(BootstrapContext<Enchantment> context) {
        HolderGetter<DamageType> holdergetter = context.lookup(Registries.DAMAGE_TYPE);
        HolderGetter<Enchantment> holdergetter1 = context.lookup(Registries.ENCHANTMENT);
        HolderGetter<Item> holdergetter2 = context.lookup(Registries.ITEM);
        HolderGetter<Block> holdergetter3 = context.lookup(Registries.BLOCK);

        register(
                context,
                RETURNING_BLADE,
                Enchantment.enchantment(
                                Enchantment.definition(
                                        holdergetter2.getOrThrow(ItemTags.DURABILITY_ENCHANTABLE),
                                        2,
                                        1,
                                        Enchantment.dynamicCost(25, 25),
                                        Enchantment.dynamicCost(75, 25),
                                        4,
                                        EquipmentSlotGroup.MAINHAND)));
    }

    private static void register(BootstrapContext<Enchantment> bootstrapContext, ResourceKey<Enchantment> resourceKey, Enchantment.Builder builder) {
        bootstrapContext.register(resourceKey, builder.build(resourceKey.location()));
    }

    private static ResourceKey<Enchantment> key(String string) {
        return ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.withDefaultNamespace(string));
    }
}
