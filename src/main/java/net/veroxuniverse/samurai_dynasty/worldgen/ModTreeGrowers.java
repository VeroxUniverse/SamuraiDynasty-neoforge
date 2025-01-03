package net.veroxuniverse.samurai_dynasty.worldgen;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower RED_MAPLE = new TreeGrower(SamuraiDynastyMod.MOD_ID + ":red_maple",
            Optional.empty(), Optional.of(ModConfiguredFeatures.RED_MAPLE_KEY), Optional.empty());
}