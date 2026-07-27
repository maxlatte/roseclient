package latte.roseclient.gui.clickgui.util;



public class Ease {



    public static float easeOut(
            float value
    ){


        return 1 -
                (1-value)
                *
                (1-value);


    }






    public static float easeInOut(
            float value
    ){


        return value < 0.5f

                ?

                2 * value * value

                :

                1 -
                (float)Math.pow(
                        -2 * value + 2,
                        2
                )
                /
                2;


    }



}