package net.veroxuniverse.epicsamurai.utils;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.veroxuniverse.epicsamurai.EpicSamuraiMod;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {

    public static final String KEY_CATEGORY_KATANA = "key.category." + EpicSamuraiMod.MOD_ID +".katana";
    public static final String KEY_KATANA_ACTIVATE = "key." + EpicSamuraiMod.MOD_ID + ".katana_activate";

    public static final KeyMapping KATANA_KEY = new KeyMapping(KEY_KATANA_ACTIVATE, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, KEY_CATEGORY_KATANA);
}