package latte.roseclient.value;


public class EnumValue<E extends Enum<E>> extends Value<E>{



    private final Class<E> enumClass;




    public EnumValue(
            String name,
            E value
    ){

        super(
                name,
                value
        );


        this.enumClass =
                value.getDeclaringClass();

    }





    public void cycle(){


        E[] values =
                enumClass.getEnumConstants();



        int next =
                value.ordinal() + 1;



        if(next >= values.length){

            next = 0;

        }



        value =
                values[next];


    }




}