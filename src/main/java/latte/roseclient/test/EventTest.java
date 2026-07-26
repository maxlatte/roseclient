package latte.roseclient.test;

import latte.roseclient.event.Subscribe;
import latte.roseclient.event.events.TickEvent;

public class EventTest {

    @Subscribe
    public void onTick(TickEvent event) {

        System.out.println("Tick event received!");

    }
}