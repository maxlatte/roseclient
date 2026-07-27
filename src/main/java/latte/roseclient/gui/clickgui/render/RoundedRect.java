package latte.roseclient.gui.clickgui.render;


import net.minecraft.client.gui.DrawContext;



public class RoundedRect {


    public static void draw(
            DrawContext context,
            int x,
            int y,
            int width,
            int height,
            int radius,
            int color
    ) {


        context.fill(
                x + radius,
                y,
                x + width - radius,
                y + height,
                color
        );


        context.fill(
                x,
                y + radius,
                x + width,
                y + height - radius,
                color
        );



        for(int i = 0; i <= radius; i++) {


            context.fill(
                    x + radius - i,
                    y + radius - i,
                    x + radius - i + 1,
                    y + radius - i + 1,
                    color
            );


            context.fill(
                    x + width-radius+i,
                    y+radius-i,
                    x+width-radius+i+1,
                    y+radius-i+1,
                    color
            );

        }

    }

}