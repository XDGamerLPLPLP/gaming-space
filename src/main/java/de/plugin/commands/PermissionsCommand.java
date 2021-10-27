package de.plugin.commands;

import de.plugin.Plugin;
import de.plugin.configs.Config;
import de.plugin.configs.PermissionConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class PermissionsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player)) {
            Player pp = (Player) sender;
            //if (pp.hasPermission("plugin.permissionsCommand.add")) {
            // Player add/remove Rank
            if (args[1].equals("add")) {
                for (String removeRanks : PermissionConfig.getConfiguration().getStringList("groups.rank.exist")) {
                    if (removeRanks.equals(args[2])) {
                        Player p = Bukkit.getPlayer(args[0]);
                        PermissionConfig.INS.setRank("groups." + p.getUniqueId() + ".rank", args[2]);
                        Plugin.INSTANCE.setupPermissions(p);
                    }
                }
            } else if (args[1].equals("remove")) {
                for (String removeRanks : PermissionConfig.getConfiguration().getStringList("groups.rank.exist")) {
                    if (removeRanks.equals(args[2])) {
                        Player p = Bukkit.getPlayer(args[0]);
                        PermissionConfig.INS.removePath("groups." + p.getUniqueId() + ".rank");
                        Plugin.INSTANCE.unSetupPermissions(p);
                    }
                }
            }
            //Group add/remove Permission
            if (args[1].equals("group")) {
                if (args[2].equals("add")) {
                    String rank = args[0];
                    List<String> perms = new ArrayList<>();
                    perms.add(args[3]);
                    perms.addAll(PermissionConfig.getConfiguration().getStringList("groups." + rank + ".rank"));
                    PermissionConfig.INS.setRankPermission("groups." + rank + ".rank", perms);
                } else if (args[2].equals("remove")) {
                    String rank = args[0];
                    List<String> perms = new ArrayList<>(PermissionConfig.getConfiguration().getStringList("groups." + rank + ".rank"));
                    perms.remove(args[3]);
                    PermissionConfig.INS.setRankPermission("groups." + rank + ".rank", perms);
                }
            }
            //Group Create
            if (args[0].equals("create")) {
                if (args[1].equals("group")) {
                    List<String> rank = new ArrayList<>();
                    rank.add(args[2]);
                    PermissionConfig.INS.setRankPermission("groups.rank.exist", rank);
                }
            }
            //Group Prefix&Suffix
            if (args[0].equals("member") || args[0].equals("tester") || args[0].equals("developer") || args[0].equals("admin")) {
                Plugin.INSTANCE.log("1");
                if (args[1].equals("group")) {
                    Plugin.INSTANCE.log("1");
                    if (args[2].equals("settings")) {
                        Plugin.INSTANCE.log("1");
                        if (args[3].equals("prefix")) {
                            Plugin.INSTANCE.log("1");
                            if (args[5].equals("red")) {
                                Plugin.INSTANCE.log("1");
                                Config.INS.setString("plugin." + args[0] + ".prefix", "c" + args[4]);
                            } else if (args[5].equals("dark_red")) {
                                Config.INS.setString("plugin." + args[0] + ".prefix", "4" + args[4]);
                            } else if (args[5].equals("gold")) {
                                Config.INS.setString("plugin." + args[0] + ".prefix", "6" + args[4]);
                            } else if (args[5].equals("yellow")) {
                                Config.INS.setString("plugin." + args[0] + ".prefix", "e" + args[4]);
                            } else if (args[5].equals("dark_green")) {
                                Config.INS.setString("plugin." + args[0] + ".prefix", "2" + args[4]);
                            } else if (args[5].equals("green")) {
                                Config.INS.setString("plugin." + args[0] + ".prefix", "a" + args[4]);
                            } else if (args[5].equals("aqua")) {
                                Config.INS.setString("plugin." + args[0] + ".prefix", "c" + args[4]);
                            }
                        }
                    }
                }

           }
        }
        return false;
    }
}
