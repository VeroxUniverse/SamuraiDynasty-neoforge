package net.veroxuniverse.samurai_dynasty.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.registry.BlocksRegistry;
import net.veroxuniverse.samurai_dynasty.registry.ItemsRegistry;
import net.veroxuniverse.samurai_dynasty.utils.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,
                             CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, SamuraiDynastyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ItemsRegistry.STEEL_HELMET.get())
                .add(ItemsRegistry.STEEL_SAMURAI_HELMET.get())
                .add(ItemsRegistry.NETHERITE_SAMURAI_HELMET.get())
                .add(ItemsRegistry.LIGHT_SAMURAI_HELMET.get())
                .add(ItemsRegistry.MASTER_SAMURAI_HELMET.get())
                .add(ItemsRegistry.STEEL_NINJA_HELMET.get())
                .add(ItemsRegistry.NETHERITE_NINJA_HELMET.get())
                .add(ItemsRegistry.STRAW_HAT.get());
        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ItemsRegistry.STEEL_CHESTPLATE.get())
                .add(ItemsRegistry.STEEL_SAMURAI_CHESTPLATE.get())
                .add(ItemsRegistry.NETHERITE_SAMURAI_CHESTPLATE.get())
                .add(ItemsRegistry.LIGHT_SAMURAI_CHESTPLATE.get())
                .add(ItemsRegistry.MASTER_SAMURAI_CHESTPLATE.get())
                .add(ItemsRegistry.STEEL_NINJA_CHESTPLATE.get())
                .add(ItemsRegistry.NETHERITE_NINJA_CHESTPLATE.get())
                .add(ItemsRegistry.KIMONO.get());
        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ItemsRegistry.STEEL_LEGGINGS.get())
                .add(ItemsRegistry.STEEL_SAMURAI_LEGGINGS.get())
                .add(ItemsRegistry.NETHERITE_SAMURAI_LEGGINGS.get())
                .add(ItemsRegistry.LIGHT_SAMURAI_LEGGINGS.get())
                .add(ItemsRegistry.MASTER_SAMURAI_LEGGINGS.get())
                .add(ItemsRegistry.NINJA_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ItemsRegistry.STEEL_BOOTS.get())
                .add(ItemsRegistry.STEEL_SAMURAI_BOOTS.get())
                .add(ItemsRegistry.NETHERITE_SAMURAI_BOOTS.get())
                .add(ItemsRegistry.LIGHT_SAMURAI_BOOTS.get())
                .add(ItemsRegistry.MASTER_SAMURAI_BOOTS.get())
                .add(ItemsRegistry.STEEL_NINJA_BOOTS.get())
                .add(ItemsRegistry.NETHERITE_NINJA_BOOTS.get());

        tag(Tags.Items.ARMORS)
                .add(ItemsRegistry.STEEL_HELMET.get())
                .add(ItemsRegistry.STEEL_SAMURAI_HELMET.get())
                .add(ItemsRegistry.NETHERITE_SAMURAI_HELMET.get())
                .add(ItemsRegistry.LIGHT_SAMURAI_HELMET.get())
                .add(ItemsRegistry.MASTER_SAMURAI_HELMET.get())
                .add(ItemsRegistry.STEEL_NINJA_HELMET.get())
                .add(ItemsRegistry.NETHERITE_NINJA_HELMET.get())
                .add(ItemsRegistry.STRAW_HAT.get())
                .add(ItemsRegistry.STEEL_CHESTPLATE.get())
                .add(ItemsRegistry.STEEL_SAMURAI_CHESTPLATE.get())
                .add(ItemsRegistry.NETHERITE_SAMURAI_CHESTPLATE.get())
                .add(ItemsRegistry.LIGHT_SAMURAI_CHESTPLATE.get())
                .add(ItemsRegistry.MASTER_SAMURAI_CHESTPLATE.get())
                .add(ItemsRegistry.STEEL_NINJA_CHESTPLATE.get())
                .add(ItemsRegistry.NETHERITE_NINJA_CHESTPLATE.get())
                .add(ItemsRegistry.KIMONO.get())
                .add(ItemsRegistry.STEEL_LEGGINGS.get())
                .add(ItemsRegistry.STEEL_SAMURAI_LEGGINGS.get())
                .add(ItemsRegistry.NETHERITE_SAMURAI_LEGGINGS.get())
                .add(ItemsRegistry.LIGHT_SAMURAI_LEGGINGS.get())
                .add(ItemsRegistry.MASTER_SAMURAI_LEGGINGS.get())
                .add(ItemsRegistry.NINJA_LEGGINGS.get())
                .add(ItemsRegistry.STEEL_BOOTS.get())
                .add(ItemsRegistry.STEEL_SAMURAI_BOOTS.get())
                .add(ItemsRegistry.NETHERITE_SAMURAI_BOOTS.get())
                .add(ItemsRegistry.LIGHT_SAMURAI_BOOTS.get())
                .add(ItemsRegistry.MASTER_SAMURAI_BOOTS.get())
                .add(ItemsRegistry.STEEL_NINJA_BOOTS.get())
                .add(ItemsRegistry.NETHERITE_NINJA_BOOTS.get());

        tag(ItemTags.BOW_ENCHANTABLE)
                .add(ItemsRegistry.YUMI.get());

        tag(ItemTags.SWORDS)
                .add(ItemsRegistry.KATANA.get())
                .add(ItemsRegistry.WAKIZASHI.get())
                .add(ItemsRegistry.NAGINATA.get())
                .add(ItemsRegistry.NAGAMAKI.get())
                .add(ItemsRegistry.SHUKO.get())
                .add(ItemsRegistry.TETSUBO.get())
                .add(ItemsRegistry.ODACHI.get())
                .add(ItemsRegistry.TONBUKIRI.get())
                .add(ItemsRegistry.KAMAYARI.get())
                .add(ItemsRegistry.MASAKARI.get())
                .add(ItemsRegistry.MASAKARI_NETHERITE.get())
                .add(ItemsRegistry.KUNAI.get())
                .add(ItemsRegistry.SAI.get())
                .add(ItemsRegistry.KABUTOWARI.get())
                .add(ItemsRegistry.KAMA.get())
                .add(ItemsRegistry.KAMA_NETHERITE.get())
                .add(ItemsRegistry.KATANA_NETHERITE.get())
                .add(ItemsRegistry.WAKIZASHI_NETHERITE.get())
                .add(ItemsRegistry.NAGINATA_NETHERITE.get())
                .add(ItemsRegistry.NAGAMAKI_NETHERITE.get())
                .add(ItemsRegistry.SHUKO_NETHERITE.get())
                .add(ItemsRegistry.TETSUBO_NETHERITE.get())
                .add(ItemsRegistry.ODACHI_NETHERITE.get())
                .add(ItemsRegistry.TONBUKIRI_NETHERITE.get())
                .add(ItemsRegistry.KAMAYARI_NETHERITE.get())
                .add(ItemsRegistry.KUNAI_NETHERITE.get())
                .add(ItemsRegistry.SAI_NETHERITE.get())
                .add(ItemsRegistry.KABUTOWARI_NETHERITE.get());

        tag(ItemTags.LOGS_THAT_BURN)
                .add(BlocksRegistry.SPIRIT_WOOD_LOG.get().asItem())
                .add(BlocksRegistry.STRIPPED_SPIRIT_WOOD_LOG.get().asItem())
                .add(BlocksRegistry.SPIRIT_WOOD.get().asItem())
                .add(BlocksRegistry.STRIPPED_SPIRIT_WOOD.get().asItem())
                .add(BlocksRegistry.RED_MAPLE_LOG.get().asItem())
                .add(BlocksRegistry.STRIPPED_RED_MAPLE_LOG.get().asItem());

        tag(ItemTags.PLANKS)
                .add(BlocksRegistry.SPIRIT_WOOD_PLANKS.get().asItem())
                .add(BlocksRegistry.RED_MAPLE_PLANKS.get().asItem());
    }
}