package latte.roseclient.value;


public class NumberValue extends Value<Double>{


    private final double min;
    private final double max;



    public NumberValue(
            String name,
            double value,
            double min,
            double max
    ){

        super(
                name,
                value
        );


        this.min = min;
        this.max = max;

    }






    public double getMin(){

        return min;

    }




    public double getMax(){

        return max;

    }



}