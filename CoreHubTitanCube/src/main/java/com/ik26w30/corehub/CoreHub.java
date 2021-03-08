package com.ik26w30.corehub;

import com.ik26w30.corehub.commands.GuiCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class CoreHub extends JavaPlugin {
    private static CoreHub instance;


    @Override
    public void onLoad() {
        instance = this;
        saveConfig();
    }

    @Override
    public void onEnable() {
        registerEvents();
        registerCommands();
        getConfig().set("command-gui", "joinserver");
    }

    private void registerCommands() {
        this.getCommand("joinserver").setExecutor(new GuiCommand());
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new EventClass(), this);
    }

    public static CoreHub getInstance() {
        return instance;
    }
}
