package latte.roseclient.gui.clickgui.component;


import latte.roseclient.gui.clickgui.render.RoundedRect;
import latte.roseclient.gui.clickgui.theme.Theme;


import net.minecraft.client.gui.DrawContext;



public class SliderComponent {


    private final String name;


    private float value;


    private float min;
    private float max;



    private int x;
    private int y;



    public SliderComponent(
            String name,
            float value,
            float min,
            float max
    ){

        this.name=name;
        this.value=value;
        this.min=min;
        this.max=max;

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


        float percent =
                (value-min)
                /
                (max-min);



        RoundedRect.draw(
                context,
                x,
                y,
                220,
                30,
                10,
                Theme.BUTTON
        );



        RoundedRect.draw(
                context,
                x,
                y,
                (int)(220*percent),
                30,
                10,
                Theme.ROSE
        );



        context.drawText(
                net.minecraft.client.MinecraftClient
                        .getInstance()
                        .textRenderer,
                name + ": " + value,
                x+10,
                y+10,
                Theme.TEXT,
                false
        );


    }







    public float getValue(){

        return value;

    }




    public void setValue(
            float value
    ){

        this.value=value;

    }


}