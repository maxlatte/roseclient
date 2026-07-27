package latte.roseclient.gui.clickgui.component;


import latte.roseclient.feature.modules.Category;
import latte.roseclient.gui.clickgui.render.RoundedRect;
import latte.roseclient.gui.clickgui.theme.Theme;


import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;



public class CategoryButton {


    private final Category category;


    private int x;
    private int y;



    public CategoryButton(Category category){

        this.category = category;

    }



    public void setPosition(
            int x,
            int y
    ){

        this.x=x;
        this.y=y;

    }




    public Category getCategory(){

        return category;

    }




    public void render(
            DrawContext context,
            boolean selected
    ){


        if(selected){

            RoundedRect.draw(
                    context,
                    x,
                    y,
                    120,
                    26,
                    8,
                    Theme.ROSE
            );

        }



        MinecraftClient client =
                MinecraftClient.getInstance();



        String name =
                category.name()
                .substring(0,1)
                +
                category.name()
                .substring(1)
                .toLowerCase();



        context.drawText(
                client.textRenderer,
                name,
                x + 12,
                y + 8,
                selected
                        ? Theme.TEXT
                        : Theme.SUBTEXT,
                false
        );


    }





    public boolean mouseClicked(
            double mouseX,
            double mouseY
    ){

        return mouseX >= x &&
                mouseX <= x+120 &&
                mouseY >= y &&
                mouseY <= y+26;

    }


}