package latte.roseclient.gui.clickgui.render;


import net.minecraft.client.gui.DrawContext;



public class BlurRenderer {


    public static void drawGlass(
            DrawContext context,
            int x,
            int y,
            int width,
            int height
    ){

        RoundedRect.draw(
                context,
                x,
                y,
                width,
                height,
                20,
                0x22FFFFFF
        );


    }

}