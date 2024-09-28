package net.veroxuniverse.samurai_dynasty.utils;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

public class ModTags {

    public static class Enchantments {

        public static final TagKey<Enchantment> HAS_SHARPNESS = create("has_sharpness");
        public static final TagKey<Enchantment> HAS_RETURNING_BLADE = create("has_returning");

        private static TagKey<Enchantment> create(String name) {
            return TagKey.create(Registries.ENCHANTMENT, ResourceLocation.withDefaultNamespace(name));
        }

    }

}
