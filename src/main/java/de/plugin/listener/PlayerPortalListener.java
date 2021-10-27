package de.plugin.listener;

import de.plugin.Plugin;
import de.plugin.configs.Config;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class PlayerPortalListener implements Listener {
    @EventHandler
    public void onPlayerEnterPortal(PlayerPortalEvent e){
        Plugin.INSTANCE.log("1 Test Jallla");
        Location lo = e.getPlayer().getLocation();
        if(lo == Config.INS.get("world.portal.spawner.location")){
            Location spawnloc = (Location) Config.INS.get("world.portal.spawn.location");
            e.setTo(spawnloc);
        }
    }
}
