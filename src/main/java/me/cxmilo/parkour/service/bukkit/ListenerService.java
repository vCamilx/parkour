package me.cxmilo.parkour.service.bukkit;

import me.cxmilo.parkour.ParkourPlugin;
import me.cxmilo.parkour.listener.PlayerCheckPointListener;
import me.cxmilo.parkour.listener.PlayerParkourSetupListener;
import me.cxmilo.parkour.service.Service;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public class ListenerService
        implements Service {

    private final ParkourPlugin plugin;
    private final PluginManager pluginManager;

    public ListenerService(ParkourPlugin plugin) {
        this.plugin = plugin;
        this.pluginManager = Bukkit.getPluginManager();
    }

    private void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            pluginManager.registerEvents(listener, plugin);
        }
    }

    @Override
    public void start() {
        registerListeners(
                new PlayerCheckPointListener(plugin),
                new PlayerParkourSetupListener(plugin)
        );
    }
}