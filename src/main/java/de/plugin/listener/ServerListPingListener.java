package de.plugin.listener;

import de.plugin.Plugin;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerListPingListener implements Listener {
    @EventHandler
    public void onServerPing(ServerListPingEvent e){
        if(Plugin.INSTANCE.wartung){
            e.setMaxPlayers(0);
            e.setMotd(ChatColor.RED + "Der Server ist gerade in Wartungsarbeit!");
        }
    }
}
