package net.astro.dlc.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    public static final String KEY_CATEGORY_DLC = "key.category.dlc.dlc";

    public static final String KEY_TEST = "key.dlc.test";

    public static final KeyMapping TEST_KEY = new KeyMapping(KEY_TEST, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_BACKSLASH, KEY_CATEGORY_DLC);
}
