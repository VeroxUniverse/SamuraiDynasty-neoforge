package net.veroxuniverse.samurai_dynasty.worldgen;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import net.veroxuniverse.samurai_dynasty.worldgen.features.ModTreeConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {

    public static final TreeGrower SPIRIT_WOOD_TREE_GROWER = new TreeGrower(SamuraiDynastyMod.MOD_ID + ":spirit_wood_tree_grower",
            Optional.empty(), Optional.of(ModTreeConfiguredFeatures.SPIRIT_WOOD_TREES), Optional.empty());

}