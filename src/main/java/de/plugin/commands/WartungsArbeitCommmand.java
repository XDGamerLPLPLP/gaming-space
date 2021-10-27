package de.plugin.commands;

import de.plugin.Plugin;
import de.plugin.configs.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class WartungsArbeitCommmand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("wartung.setstatus")){
            if(args.length == 1){
                if(args[0].equals("on")){
                    Plugin.INSTANCE.wartung = true;
                    Config.INS.set("wartung.status", true);
                    p.sendMessage("§4Die Wartungsarbeiten sind Aktiert!");
                }else if(args[0].equals("off")){
                    Plugin.INSTANCE.wartung = false;
                    Config.INS.set("wartung.status", false);
                    p.sendMessage("§4Die Wartungsarbeiten sind Deaktiviert!");
                }
            }
        }
        return false;
    }
}
