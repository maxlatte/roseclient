package latte.roseclient.init;

import latte.roseclient.RoseClient;
import latte.roseclient.feature.modules.render.FPSCounter;
import latte.roseclient.feature.modules.misc.TestModule;

public final class ModuleInitializer {


    public static void init() {

        registerModules();

    }


    private static void registerModules() {

        RoseClient.MODULE_MANAGER.register(
            new FPSCounter()
        );

        RoseClient.MODULE_MANAGER.register(
            new TestModule()
        );

    }

}