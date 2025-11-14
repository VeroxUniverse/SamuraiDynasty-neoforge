package net.veroxuniverse.samurai_dynasty.utils;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

public class ModTags {

    public static final TagKey<Block> SPIRIT_VALID_GROUND = createBlockTag("spirit_valid_ground");

    private static TagKey<Block> createBlockTag(String name) {
        return TagKey.create(
                Registries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, name)
        );
    }

    public static class Enchantments {

        public static final TagKey<Enchantment> HAS_SHARPNESS =
                createEnchantmentTag("has_sharpness");

        public static final TagKey<Enchantment> HAS_RETURNING_BLADE =
                createEnchantmentTag("has_returning");

        private static TagKey<Enchantment> createEnchantmentTag(String name) {
            return TagKey.create(
                    Registries.ENCHANTMENT,
                    ResourceLocation.fromNamespaceAndPath(SamuraiDynastyMod.MOD_ID, name)
            );
        }
    }

}
