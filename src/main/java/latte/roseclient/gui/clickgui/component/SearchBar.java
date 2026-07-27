package latte.roseclient.gui.clickgui.component;


import latte.roseclient.gui.clickgui.render.RoundedRect;
import latte.roseclient.gui.clickgui.theme.Theme;


import net.minecraft.client.gui.DrawContext;



public class SearchBar {


    private int x;
    private int y;


    private int width = 220;


    private String text = "";



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
                width,
                28,
                10,
                Theme.BUTTON
        );



        context.drawText(
                net.minecraft.client.MinecraftClient
                        .getInstance()
                        .textRenderer,
                text.isEmpty()
                        ?
                        "Search..."
                        :
                        text,
                x + 12,
                y + 10,
                text.isEmpty()
                        ?
                        Theme.SUBTEXT
                        :
                        Theme.TEXT,
                false
        );


    }





    public void setText(
            String text
    ){

        this.text=text;

    }





    public String getText(){

        return text;

    }


}