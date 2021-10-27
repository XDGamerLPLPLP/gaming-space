package de.plugin.listener;

import de.plugin.configs.Config;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();
        assert p != null;
        if (Config.INS.getBoolean("plugin.challanges.playerdeath").equals(true)){
            p.setGameMode(GameMode.SPECTATOR);
        }
    }
}
