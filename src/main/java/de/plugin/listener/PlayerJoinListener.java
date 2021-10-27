package de.plugin.listener;

import de.plugin.Plugin;
import de.plugin.configs.Config;
import de.plugin.configs.PermissionConfig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerJoinListener implements Listener {
    public List<String> permissions;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();
        permissions = new ArrayList<>();
        UUID uuid = e.getPlayer().getUniqueId();
        if(!Config.INS.getDouble("plugin.challanges.hearts").equals(20.0)) {
            p.setMaxHealth(Config.INS.getDouble("plugin.challanges.hearts"));
        }
        //PermissionConfig.INS.setPermission("groups." + uuid + ".permissions", perms);
        if(PermissionConfig.INS.contains("groups." + p.getUniqueId() + ".rank")) {
            Plugin.getTablistManager().setPlayerList(p);
            Plugin.getTablistManager().setPlayerTeams(p);
            Plugin.getTablistManager().setPlayerName(p);
            String rank = PermissionConfig.INS.get("groups." + p.getUniqueId()+ ".rank");
            Plugin.INSTANCE.setupPermissions(p);
        }
    }
}
