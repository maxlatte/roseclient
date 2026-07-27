package latte.roseclient.gui.clickgui.render;


import latte.roseclient.gui.clickgui.theme.Theme;

import net.minecraft.client.gui.DrawContext;



public class ShadowRenderer {


    public static void drawShadow(
            DrawContext context,
            int x,
            int y,
            int width,
            int height
    ){


        RoundedRect.draw(
                context,
                x - 6,
                y - 6,
                width + 12,
                height + 12,
                22,
                Theme.SHADOW
        );


    }


}