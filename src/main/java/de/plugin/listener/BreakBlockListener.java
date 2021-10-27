package de.plugin.listener;

import de.plugin.Plugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBlockListener implements Listener {
    @EventHandler
    public void breakBlock(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(!e.getPlayer().hasPermission("blockbreak.break")){
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "You don't have the permission to do that!");
        }
    }
}
