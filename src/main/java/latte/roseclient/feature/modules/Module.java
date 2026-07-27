package latte.roseclient.feature.modules;


import latte.roseclient.value.Value;

import java.util.ArrayList;
import java.util.List;



public abstract class Module {


    private final String name;

    private final Category category;


    private boolean enabled;


    private int key = -1;



    private final List<Value<?>> values =
            new ArrayList<>();




    public Module(
            String name,
            Category category
    ){

        this.name = name;
        this.category = category;

    }






    public void toggle(){

        setEnabled(!enabled);

    }





    public void setEnabled(
            boolean enabled
    ){

        if(this.enabled == enabled)
            return;


        this.enabled = enabled;


        if(enabled){

            onEnable();

        }else{

            onDisable();

        }

    }





    public void addValue(
            Value<?> value
    ){

        values.add(value);

    }





    public List<Value<?>> getValues(){

        return values;

    }





    public void onEnable(){}


    public void onDisable(){}


    public void onTick(){}






    public String getName(){

        return name;

    }





    public Category getCategory(){

        return category;

    }





    public boolean isEnabled(){

        return enabled;

    }





    public int getKey(){

        return key;

    }





    public void setKey(
            int key
    ){

        this.key = key;

    }



}