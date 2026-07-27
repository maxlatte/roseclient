package latte.roseclient;

import latte.roseclient.event.bus.EventBus;
import latte.roseclient.init.ModuleInitializer;
import latte.roseclient.manager.CommandManager;
import latte.roseclient.manager.ConfigManager;
import latte.roseclient.manager.HudManager;
import latte.roseclient.manager.KeybindManager;
import latte.roseclient.manager.ModuleManager;
import latte.roseclient.manager.NotificationManager;
import latte.roseclient.manager.ThemeManager;
import latte.roseclient.keybind.ClientKeyHandler;

public final class RoseClient {

    public static final String NAME = "Rose Client";
    public static final String VERSION = "0.1.0";

    public static final EventBus EVENT_BUS = new EventBus();
    public static final ModuleManager MODULE_MANAGER = new ModuleManager();

    private static RoseClient instance;

    private final CommandManager commandManager;
    private final ConfigManager configManager;
    private final NotificationManager notificationManager;
    private final ThemeManager themeManager;
    private final HudManager hudManager;
    private final KeybindManager keybindManager;


    private RoseClient() {

        commandManager = new CommandManager();
        configManager = new ConfigManager();
        notificationManager = new NotificationManager();
        themeManager = new ThemeManager();
        hudManager = new HudManager();
        keybindManager = new KeybindManager();

    }


    public static RoseClient get() {

        if (instance == null) {
            instance = new RoseClient();
        }

        return instance;

    }


    public static void initialize() {
    
        EVENT_BUS.register(MODULE_MANAGER);
    
        EVENT_BUS.register(new ClientKeyHandler());
    
        ModuleInitializer.init();
    
        System.out.println(NAME + " " + VERSION + " initialized.");
    
    }


    public static EventBus getEventBus() {
        return EVENT_BUS;
    }


    public static ModuleManager getModuleManager() {
        return MODULE_MANAGER;
    }


    public CommandManager getCommandManager() {
        return commandManager;
    }


    public ConfigManager getConfigManager() {
        return configManager;
    }


    public NotificationManager getNotificationManager() {
        return notificationManager;
    }


    public ThemeManager getThemeManager() {
        return themeManager;
    }


    public HudManager getHudManager() {
        return hudManager;
    }


    public KeybindManager getKeybindManager() {
        return keybindManager;
    }

}