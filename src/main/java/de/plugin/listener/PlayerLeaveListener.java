package de.plugin.listener;

import de.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerLeaveListener implements Listener {
    public List<String> permissions;
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){

        Player p = e.getPlayer();
        permissions = new ArrayList<>();
        UUID uuid = e.getPlayer().getUniqueId();
        //PermissionConfig.INS.setPermission("groups." + uuid + ".permissions", perms);
        Plugin.INSTANCE.unSetupPermissions(p);
    }
}
