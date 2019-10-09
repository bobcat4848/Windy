package tech.bobcat;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Windy extends JavaPlugin {

    private Windy plugin;
    public static FileConfiguration config;

    public void onEnable() {
        plugin = this;
        config = this.getConfig();

        registerCommands();
        registerListeners();
    }

    private void registerCommands() {
        getCommand("windy").setExecutor(new Commands());
    }

    private void registerListeners() {
        //getServer().getPluginManager().registerEvents(new WindChange(), this);
    }
}
