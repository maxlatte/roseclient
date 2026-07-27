package latte.roseclient.keybind;

import latte.roseclient.event.Subscribe;
import latte.roseclient.event.events.KeyEvent;
import latte.roseclient.gui.clickgui.screen.ClickGuiScreen;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;


public class ClientKeyHandler {


    @Subscribe
    public void onKey(KeyEvent event) {


        if (event.getKey() == GLFW.GLFW_KEY_RIGHT_SHIFT) {

            MinecraftClient.getInstance()
                    .setScreen(new ClickGuiScreen());

        }
    }

}