package de.plugin.commands;

import de.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MultiverseCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if(player.hasPermission("de.plugin.multiverse")) {
            if (args[0].equalsIgnoreCase("tp")) {
                if (args.length == 2) {
                    String world = args[1];
                    World w = Bukkit.getWorld(world);
                    if (w != null) {
                        player.sendMessage(Plugin.PREFIX + "§aDu bist nun in §e" + w.getName());
                    } else {
                        player.sendMessage(Plugin.PREFIX + "§cDiese Welt existiert nicht!");
                    }
                } else {
                    player.sendMessage(Plugin.PREFIX + "§c/multi tp <world>");
                }
            } else if (args[0].equalsIgnoreCase("create")) {
                if (args.length == 2) {
                    String worldName = args[1];
                    player.sendMessage(Plugin.PREFIX + "§4Welt wird erstellt...!");
                    Bukkit.createWorld(WorldCreator.name(worldName).environment(World.Environment.NORMAL).type(WorldType.NORMAL));
                    player.sendMessage(Plugin.PREFIX + "§4Welt wurde erstellt!");
                    player.teleport(Bukkit.getWorld(worldName).getSpawnLocation());
                }
            }
        }

        return false;
    }
}
