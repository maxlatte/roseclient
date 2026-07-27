package latte.roseclient.gui.clickgui.component;


import latte.roseclient.feature.modules.Module;
import latte.roseclient.gui.clickgui.render.RoundedRect;
import latte.roseclient.gui.clickgui.util.Animation;
import latte.roseclient.gui.clickgui.theme.Theme;


import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;



public class ModuleButton {



    private final Module module;


    private final SettingComponent settings;



    private int x;

    private int y;



    private boolean expanded;



    private final Animation expandAnimation =
            new Animation(0);



    private final Animation hoverAnimation =
            new Animation(0);









    public ModuleButton(
            Module module
    ){

        this.module = module;


        settings =
                new SettingComponent(
                        module.getValues()
                );


    }









    public void setPosition(
            int x,
            int y
    ){

        this.x = x;
        this.y = y;

    }









    public void render(
            DrawContext context,
            int mouseX,
            int mouseY
    ){



        boolean hover =
                mouseX >= x &&
                mouseX <= x + 260 &&
                mouseY >= y &&
                mouseY <= y + 34;





        /*
            Animation updates
        */


        hoverAnimation.setTarget(
                hover ? 1 : 0
        );


        hoverAnimation.update();





        expandAnimation.setTarget(
                expanded ? 1 : 0
        );


        expandAnimation.update();







        int color;



        if(module.isEnabled()){


            color = Theme.ROSE;


        }

        else if(hoverAnimation.get() > 0.01f){


            color = Theme.BUTTON_HOVER;


        }

        else{


            color = Theme.BUTTON;


        }









        RoundedRect.draw(
                context,
                x,
                y,
                260,
                34,
                10,
                color
        );









        MinecraftClient client =
                MinecraftClient.getInstance();







        context.drawText(
                client.textRenderer,

                module.getName(),

                x + 12,

                y + 12,

                Theme.TEXT,

                false
        );









        context.drawText(
                client.textRenderer,

                module.isEnabled()
                        ?
                        "ON"
                        :
                        "OFF",

                x + 220,

                y + 12,

                module.isEnabled()
                        ?
                        Theme.ROSE_LIGHT
                        :
                        Theme.SUBTEXT,

                false
        );









        /*
            Animated settings panel
        */


        float animation =
                expandAnimation.get();





        if(animation > 0.01f){



            int targetHeight =
                    Math.max(
                            50,
                            module.getValues()
                                    .size()
                                    * 40
                    );



            int height =
                    (int)
                    (
                        targetHeight
                        *
                        animation
                    );






            RoundedRect.draw(
                    context,

                    x,

                    y + 38,

                    260,

                    height,

                    10,

                    Theme.PANEL
            );







            settings.setPosition(
                    x + 15,

                    y + 50
            );



            settings.render(context);



        }



    }









    public boolean mouseClicked(
            double mouseX,
            double mouseY,
            int button
    ){





        if(
                mouseX >= x &&
                mouseX <= x + 260 &&
                mouseY >= y &&
                mouseY <= y + 34
        ){



            if(button == 0){


                module.toggle();


            }






            if(button == 1){


                expanded =
                        !expanded;


            }







            return true;


        }






        return false;


    }









    public boolean isExpanded(){


        return expanded;


    }









    public Module getModule(){


        return module;


    }




}