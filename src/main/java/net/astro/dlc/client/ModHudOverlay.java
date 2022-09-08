package net.astro.dlc.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.astro.dlc.DLC;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ModHudOverlay {

    private static final ResourceLocation FROSTBITE_SCREEN = new ResourceLocation(DLC.MOD_ID,"textures/misc/freeze_effect_screen.png");

    public static final IGuiOverlay HUD_FROSTBITE_OUTLINE = ((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, ClientData.getIsFrozen() ? 1 : 0);
        RenderSystem.setShaderTexture(0, FROSTBITE_SCREEN);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(0.0D,  (float)screenHeight, -90.0D).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.vertex((float) screenWidth, (float)screenHeight, -90.0D).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex((float) screenWidth, 0.0D, -90.0D).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex(0.0D, 0.0D, -90.0D).uv(0.0F, 0.0F).endVertex();
        tesselator.end();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    });
}
