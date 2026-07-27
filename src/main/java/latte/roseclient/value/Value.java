package latte.roseclient.value;


public abstract class Value<T> {


    private final String name;


    protected T value;



    public Value(
            String name,
            T value
    ){

        this.name = name;
        this.value = value;

    }




    public String getName(){

        return name;

    }





    public T getValue(){

        return value;

    }





    public void setValue(
            T value
    ){

        this.value = value;

    }


}