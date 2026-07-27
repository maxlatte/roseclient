package latte.roseclient.gui.clickgui.screen;


import latte.roseclient.RoseClient;

import latte.roseclient.feature.modules.Category;
import latte.roseclient.feature.modules.Module;

import latte.roseclient.gui.clickgui.component.CategoryButton;
import latte.roseclient.gui.clickgui.component.ModuleButton;

import latte.roseclient.gui.clickgui.render.GuiRenderer;
import latte.roseclient.gui.clickgui.render.RoundedRect;

import latte.roseclient.gui.clickgui.theme.Theme;


import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.Click;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;


import java.util.ArrayList;
import java.util.List;



public class ClickGuiScreen extends Screen {


    private final List<CategoryButton> categories =
            new ArrayList<>();


    private final List<ModuleButton> modules =
            new ArrayList<>();



    private Category selected =
            Category.COMBAT;



    private int guiX;
    private int guiY;



    private final int guiWidth = 720;
    private final int guiHeight = 440;




    public ClickGuiScreen(){

        super(
                Text.literal(
                        "Rose Client"
                )
        );


        createCategories();
        updateModules();

    }






    private void createCategories(){


        categories.clear();


        for(Category category :
                Category.values()){


            categories.add(
                    new CategoryButton(category)
            );


        }


    }







    private void updateModules(){


        modules.clear();


        for(Module module :
                RoseClient.MODULE_MANAGER.getModules()){


            if(module.getCategory()
                    == selected){


                modules.add(
                        new ModuleButton(module)
                );


            }


        }


    }









    @Override
    public void render(
            DrawContext context,
            int mouseX,
            int mouseY,
            float delta
    ){


        super.render(
                context,
                mouseX,
                mouseY,
                delta
        );



        guiX =
                (width - guiWidth) / 2;


        guiY =
                (height - guiHeight) / 2;



        // background dim

        context.fill(
                0,
                0,
                width,
                height,
                0x88000000
        );



        GuiRenderer.drawWindow(
                context,
                guiX,
                guiY,
                guiWidth,
                guiHeight
        );



        GuiRenderer.drawLogo(
                context,
                guiX + 25,
                guiY + 22
        );



        drawCategories(
                context,
                mouseX,
                mouseY
        );


        drawModules(
                context,
                mouseX,
                mouseY
        );


        drawBottomPanel(
                context
        );



    }









    private void drawCategories(
            DrawContext context,
            int mouseX,
            int mouseY
    ){


        int x =
                guiX + 25;


        int y =
                guiY + 90;



        int offset = 0;



        for(CategoryButton button :
                categories){


            button.setPosition(
                    x,
                    y + offset
            );


            button.render(
                    context,
                    button.getCategory()
                            == selected
            );


            offset += 34;


        }


    }









    private void drawModules(
            DrawContext context,
            int mouseX,
            int mouseY
    ){


        int x =
                guiX + 210;


        int y =
                guiY + 90;



        int offset = 0;



        for(ModuleButton button :
                modules){


            button.setPosition(
                    x,
                    y + offset
            );


            button.render(
                    context,
                    mouseX,
                    mouseY
            );


            offset += button.isExpanded() ? 150 : 42;


        }



    }









    private void drawBottomPanel(
            DrawContext context
    ){


        int y =
                guiY + guiHeight - 85;



        // divider above bottom

        context.fill(
                guiX + 25,
                y,
                guiX + 185,
                y + 2,
                Theme.DIVIDER
        );



        // configs button

        RoundedRect.draw(
                context,
                guiX + 25,
                y + 15,
                150,
                32,
                10,
                Theme.BUTTON
        );



        context.drawText(
                textRenderer,
                "Configs",
                guiX + 40,
                y + 26,
                Theme.TEXT,
                false
        );



        // player button

        RoundedRect.draw(
                context,
                guiX + 25,
                y + 55,
                150,
                32,
                10,
                Theme.BUTTON
        );



        context.drawText(
                textRenderer,
                "Player",
                guiX + 40,
                y + 66,
                Theme.TEXT,
                false
        );




        // username placeholder

        MinecraftClient client =
                MinecraftClient.getInstance();



        String username =
                client.player != null
                        ?
                        client.player.getName()
                                .getString()
                        :
                        "Player";



        context.drawText(
                textRenderer,
                username,
                guiX + guiWidth - 100,
                y + 35,
                Theme.TEXT,
                false
        );



    }









    @Override
    public boolean mouseClicked(
            Click click,
            boolean doubled
    ){



        double mouseX =
                click.x();


        double mouseY =
                click.y();


        int button =
                click.button();




        for(CategoryButton category :
                categories){


            if(category.mouseClicked(
                    mouseX,
                    mouseY
            )){


                selected =
                        category.getCategory();



                updateModules();


                return true;


            }


        }





        for(ModuleButton module :
                modules){


            if(module.mouseClicked(
                    mouseX,
                    mouseY,
                    button
            )){


                return true;


            }


        }





        return super.mouseClicked(
                click,
                doubled
        );


    }



}