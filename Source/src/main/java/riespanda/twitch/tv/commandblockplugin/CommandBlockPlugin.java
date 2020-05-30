package riespanda.twitch.tv.commandblockplugin;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class CommandBlockPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.print("CommandBlockPlugin by RiesPanda has been enabled!");
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new BlockClickEvent(this),this);

    }




}
