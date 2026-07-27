package latte.roseclient.value;


public class BooleanValue extends Value<Boolean>{



    public BooleanValue(
            String name,
            boolean value
    ){

        super(
                name,
                value
        );

    }




    public void toggle(){

        value = !value;

    }


}