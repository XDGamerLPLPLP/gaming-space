package de.plugin.commands;

import de.plugin.Plugin;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            Plugin.INSTANCE.log("Du bist kein Spieler!");
            return true;
        }
        Player player = (Player) sender;

        if(player.hasPermission("de.plugin.gamemode")){
            if(label.equalsIgnoreCase( "gmc")) {
                player.setGameMode(GameMode.CREATIVE);
                return true;
            }else if(label.equalsIgnoreCase( "gma")){
                player.setGameMode(GameMode.ADVENTURE);
                return true;
            }else if(label.equalsIgnoreCase( "gms")){
                player.setGameMode(GameMode.ADVENTURE);
                return true;
            }
            player.setGameMode(GameMode.SURVIVAL);
        }else{
            player.sendMessage(Plugin.PREFIX + "Du hast keine Berechtigung für diesen Command!");
            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.4f, 1.4f);
        }
        return false;
    }
}
