package latte.roseclient.gui.clickgui.render;


import latte.roseclient.gui.clickgui.theme.Theme;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;



public class GuiRenderer {



    public static void drawWindow(
            DrawContext context,
            int x,
            int y,
            int width,
            int height
    ){


        // Shadow behind window

        ShadowRenderer.drawShadow(
                context,
                x,
                y,
                width,
                height
        );



        // Main glass panel

        RoundedRect.draw(
                context,
                x,
                y,
                width,
                height,
                18,
                Theme.WINDOW
        );



        // Rose accent line

        context.fill(
                x + 20,
                y + 55,
                x + width - 20,
                y + 58,
                Theme.ROSE
        );


    }








    public static void drawTextHeader(
            DrawContext context,
            int x,
            int y
    ){


        MinecraftClient client =
                MinecraftClient.getInstance();



        context.drawText(
                client.textRenderer,
                "Rose",
                x,
                y,
                Theme.ROSE,
                true
        );



        context.drawText(
                client.textRenderer,
                "Client",
                x + 46,
                y,
                Theme.TEXT,
                true
        );


    }








    public static void drawLogo(
            DrawContext context,
            int x,
            int y
    ){


        MinecraftClient client =
                MinecraftClient.getInstance();



        context.drawText(
                client.textRenderer,
                "🌹",
                x,
                y,
                Theme.ROSE,
                false
        );


    }



}