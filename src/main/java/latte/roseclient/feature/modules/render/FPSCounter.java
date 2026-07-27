package latte.roseclient.feature.modules.render;

import latte.roseclient.feature.modules.Module;
import latte.roseclient.feature.modules.Category;
import net.minecraft.client.MinecraftClient;

public class FPSCounter extends Module {

    public FPSCounter() {
        super("FPS Counter", Category.RENDER);

        setKey(75); // K key
    }

    @Override
    public void onTick() {
        MinecraftClient client = MinecraftClient.getInstance();

        if (client != null) {
            System.out.println("FPS: " + client.getCurrentFps());
        }
    }

    @Override
    public void onEnable() {
        System.out.println("FPS Counter enabled!");
    }

    @Override
    public void onDisable() {
        System.out.println("FPS Counter disabled!");
    }
}