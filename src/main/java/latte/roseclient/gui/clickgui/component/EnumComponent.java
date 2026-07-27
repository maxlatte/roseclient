package latte.roseclient.gui.clickgui.component;


import latte.roseclient.gui.clickgui.render.RoundedRect;
import latte.roseclient.gui.clickgui.theme.Theme;


import net.minecraft.client.gui.DrawContext;



public class EnumComponent {


    private final String name;


    private String value;



    private int x;
    private int y;




    public EnumComponent(
            String name,
            String value
    ){

        this.name=name;
        this.value=value;

    }





    public void setPosition(
            int x,
            int y
    ){

        this.x=x;
        this.y=y;

    }







    public void render(
            DrawContext context
    ){



        RoundedRect.draw(
                context,
                x,
                y,
                220,
                32,
                10,
                Theme.BUTTON
        );



        context.drawText(
                net.minecraft.client.MinecraftClient
                        .getInstance()
                        .textRenderer,
                name,
                x+12,
                y+11,
                Theme.TEXT,
                false
        );



        context.drawText(
                net.minecraft.client.MinecraftClient
                        .getInstance()
                        .textRenderer,
                value,
                x+130,
                y+11,
                Theme.ROSE,
                false
        );


    }






    public void setValue(
            String value
    ){

        this.value=value;

    }





    public String getValue(){

        return value;

    }


}