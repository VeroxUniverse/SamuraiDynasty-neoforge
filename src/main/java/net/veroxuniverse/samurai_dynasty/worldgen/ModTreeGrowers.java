package net.veroxuniverse.samurai_dynasty.worldgen;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.worldgen.features.ModTreeConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {

    public static final TreeGrower TWISTTHORN_TREE_GROWER = new TreeGrower(SamuraiDynastyMod.MOD_ID + ":twistthorn_tree_grower",
            Optional.empty(), Optional.of(ModTreeConfiguredFeatures.TWISTTHORN_TREES), Optional.empty());

    public static final TreeGrower SPIRIT_BLOSSOM_TREE_GROWER = new TreeGrower(SamuraiDynastyMod.MOD_ID + ":spirit_blossom_tree_grower",
            Optional.empty(), Optional.of(ModTreeConfiguredFeatures.SPIRIT_BLOSSOM_TREES), Optional.empty());

}