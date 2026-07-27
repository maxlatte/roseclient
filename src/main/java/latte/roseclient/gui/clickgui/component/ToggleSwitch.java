package latte.roseclient.gui.clickgui.component;


import latte.roseclient.gui.clickgui.render.RoundedRect;
import latte.roseclient.gui.clickgui.theme.Theme;

import net.minecraft.client.gui.DrawContext;



public class ToggleSwitch {


    private int x;
    private int y;

    private boolean enabled;



    public ToggleSwitch(boolean enabled){

        this.enabled = enabled;

    }




    public void setPosition(
            int x,
            int y
    ){

        this.x = x;
        this.y = y;

    }






    public void render(
            DrawContext context
    ){



        RoundedRect.draw(
                context,
                x,
                y,
                34,
                16,
                8,
                enabled
                        ? Theme.ROSE
                        : Theme.BUTTON
        );



        RoundedRect.draw(
                context,
                enabled
                        ? x + 18
                        : x + 2,
                y + 2,
                12,
                12,
                6,
                Theme.TEXT
        );


    }






    public void toggle(){

        enabled = !enabled;

    }





    public boolean isEnabled(){

        return enabled;

    }


}