package latte.roseclient.event.bus;

import latte.roseclient.event.Subscribe;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EventBus {

    private final List<Object> listeners = new ArrayList<>();


    public void register(Object object) {
        listeners.add(object);
    }


    public void post(Object event) {

        for (Object listener : listeners) {

            for (Method method : listener.getClass().getDeclaredMethods()) {

                if (!method.isAnnotationPresent(Subscribe.class))
                    continue;

                if (method.getParameterCount() != 1)
                    continue;


                try {
                    method.setAccessible(true);

                    if (method.getParameterTypes()[0]
                            .isAssignableFrom(event.getClass())) {

                        method.invoke(listener, event);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}