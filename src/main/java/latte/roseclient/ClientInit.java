package latte.roseclient;

import net.fabricmc.api.ClientModInitializer;

public class ClientInit implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        RoseClient.get().initialize();

    }

}