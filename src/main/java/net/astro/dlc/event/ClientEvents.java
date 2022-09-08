package net.astro.dlc.event;

import net.astro.dlc.DLC;
import net.astro.dlc.client.ModHudOverlay;
import net.astro.dlc.util.KeyBindings;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = DLC.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event){
            if(KeyBindings.TEST_KEY.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("test key"));
            }
        }
    }

    @Mod.EventBusSubscriber(modid = DLC.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBindings.TEST_KEY);
        }

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            event.registerBelow(VanillaGuiOverlay.HOTBAR.id(), "frostbite_effect", ModHudOverlay.HUD_FROSTBITE_OUTLINE);
        }
    }
}
