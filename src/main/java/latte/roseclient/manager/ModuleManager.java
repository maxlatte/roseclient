package latte.roseclient.manager;

import latte.roseclient.RoseClient;
import latte.roseclient.event.Subscribe;
import latte.roseclient.event.events.TickEvent;
import latte.roseclient.feature.modules.Module;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static final ModuleManager INSTANCE = new ModuleManager();

    private final List<Module> modules = new ArrayList<>();


    public ModuleManager() {
        RoseClient.EVENT_BUS.register(this);
    }


    public void register(Module module) {
        modules.add(module);
    }


    public List<Module> getModules() {
        return modules;
    }


    public Module getModule(String name) {

        for (Module module : modules) {

            if (module.getName().equalsIgnoreCase(name)) {
                return module;
            }

        }

        return null;
    }

    
    @Subscribe
    public void onTick(TickEvent event) {

        for (Module module : modules) {

            if (module.isEnabled()) {
                module.onTick();
            }

        }

    }

    
    public void onKey(int key) {

        for (Module module : modules) {

            if (module.getKey() == key) {

                module.toggle();

            }

        }

    }

}