package net.veroxuniverse.samurai_dynasty.utils;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.veroxuniverse.samurai_dynasty.SamuraiDynastyMod;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {

    public static final String KEY_CATEGORY_KATANA = "key.category." + SamuraiDynastyMod.MOD_ID +".katana";
    public static final String KEY_KATANA_ACTIVATE = "key." + SamuraiDynastyMod.MOD_ID + ".katana_activate";

    public static final KeyMapping KATANA_KEY = new KeyMapping(KEY_KATANA_ACTIVATE, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, KEY_CATEGORY_KATANA);
}