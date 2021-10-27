package de.plugin.commands;

import de.plugin.Plugin;
import de.plugin.configs.Config;
import de.plugin.utils.ResetWorld;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerKickEvent;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ResetWorldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            for(Player kp : Bukkit.getOnlinePlayers()){
                String kickMessage = "§c" + p.getName() + "§c hat das §4§lGaming-Network§r§c zurückgesetzt.";
                kp.kickPlayer(kickMessage);
            }
            ResetWorld.onResetWorld();
            Config.INS.setBoolean("plugin.world.reseted", true);
            Bukkit.spigot().restart();
        }
        return false;
    }
}
