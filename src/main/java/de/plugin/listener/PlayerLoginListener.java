package de.plugin.listener;

import de.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class PlayerLoginListener implements Listener {
    @EventHandler
    public void onPlayerLogin(AsyncPlayerPreLoginEvent e){
        if(Plugin.INSTANCE.wartung) {
            for(OfflinePlayer offlinePlayer: Bukkit.getWhitelistedPlayers()){
                if(offlinePlayer.getName().equalsIgnoreCase(e.getName())){
                    return;
                }
            }

            if (!Bukkit.getOfflinePlayer(e.getName()).isOp()) {
                e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, ChatColor.BOLD + "§4FishyFan\n" +
                        ChatColor.RESET + ChatColor.RED + "Der Server ist gerade in Wartungsarbeit!");
            }
        }
    }
}
