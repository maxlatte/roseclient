package latte.roseclient.gui.clickgui.util;



public class Animation {


    private float value;


    private float target;



    private float speed;



    public Animation(
            float start
    ){

        this.value = start;
        this.target = start;
        this.speed = 0.15f;

    }







    public void setTarget(
            float target
    ){

        this.target = target;

    }







    public void setSpeed(
            float speed
    ){

        this.speed = speed;

    }








    public void update(){


        value +=
                (target - value)
                *
                speed;



    }








    public float get(){

        return value;

    }







    public boolean finished(){

        return Math.abs(
                target - value
        ) < 0.01f;

    }


}