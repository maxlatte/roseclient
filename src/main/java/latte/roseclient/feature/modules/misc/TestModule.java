package latte.roseclient.feature.modules.misc;

import latte.roseclient.feature.modules.Category;
import latte.roseclient.feature.modules.Module;

public class TestModule extends Module {


    public TestModule() {

        super("TestModule", Category.MISC);

        setKey(82); // R key

    }


    @Override
    public void onEnable() {

        System.out.println("TestModule enabled!");

    }


    @Override
    public void onDisable() {

        System.out.println("TestModule disabled!");

    }

}