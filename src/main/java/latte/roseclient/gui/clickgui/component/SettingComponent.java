package latte.roseclient.gui.clickgui.component;


import latte.roseclient.value.BooleanValue;
import latte.roseclient.value.EnumValue;
import latte.roseclient.value.NumberValue;
import latte.roseclient.value.Value;

import net.minecraft.client.gui.DrawContext;


import java.util.List;



public class SettingComponent {


    private final List<Value<?>> values;


    private int x;
    private int y;



    public SettingComponent(
            List<Value<?>> values
    ){

        this.values = values;

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


        int offset = 0;



        for(Value<?> value : values){



            if(value instanceof BooleanValue bool){



                ToggleSwitch toggle =
                        new ToggleSwitch(
                                bool.getValue()
                        );



                toggle.setPosition(
                        x + 150,
                        y + offset
                );


                toggle.render(context);



                context.drawText(
                        net.minecraft.client.MinecraftClient
                                .getInstance()
                                .textRenderer,

                        bool.getName(),

                        x,
                        y + offset + 4,

                        0xFFFFFFFF,

                        false
                );



            }




            else if(value instanceof NumberValue number){



                SliderComponent slider =
                        new SliderComponent(
                                number.getName(),
                                number.getValue().floatValue(),
                                (float) number.getMin(),
                                (float) number.getMax()
                        );



                slider.setPosition(
                        x,
                        y + offset
                );


                slider.render(context);



            }




            else if(value instanceof EnumValue<?> enumeration){



                EnumComponent component =
                        new EnumComponent(
                                enumeration.getName(),
                                enumeration.getValue()
                                        .toString()
                        );



                component.setPosition(
                        x,
                        y + offset
                );



                component.render(context);


            }



            offset += 40;

        }


    }



}