package latte.roseclient.gui.clickgui.util;



public class Timer {


    private long time =
            System.currentTimeMillis();





    public boolean hasReached(
            long milliseconds
    ){


        return System.currentTimeMillis()
                -
                time
                >=
                milliseconds;


    }





    public void reset(){

        time =
                System.currentTimeMillis();

    }


}