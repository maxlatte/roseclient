package latte.roseclient.gui.clickgui.util;



public class GuiMath {


    public static boolean hovered(
            double mouseX,
            double mouseY,
            int x,
            int y,
            int width,
            int height
    ){

        return mouseX >= x &&
                mouseX <= x + width &&
                mouseY >= y &&
                mouseY <= y + height;

    }


}