package de.plugin.commands.tabcomplete;

import de.plugin.configs.PermissionConfig;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PermissionsTabCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if(args.length == 1){
            List<String> value = new ArrayList<>();
            for(String ranks : PermissionConfig.getConfiguration().getStringList("groups.rank.exist")){
                value.add(ranks);
                for(Player players : Bukkit.getOnlinePlayers()) {
                    value.add(players.getName());
                    value.add("create");
                    return value;
                }
            }
        }
        if(args.length == 2){
            List<String> value = new ArrayList<>();
            if (args[0].equals("member") || args[0].equals("tester") || args[0].equals("developer") || args[0].equals("admin")){
                value.add("group");
                return value;
            }else if(args[0].equals("create")){
                value.add("group");
            }else {
                for(Player p : Bukkit.getOnlinePlayers()) {
                    if(p == Bukkit.getPlayer(args[0]))
                    value.add("add");
                    value.add("remove");
                    return value;
                }
            }
        }
        //groupName group add
        if(args.length == 3){
            List<String> value = new ArrayList<>();
            if((args[0].equals("member") || args[0].equals("tester") || args[0].equals("developer") || args[0].equals("admin"))){
                value.add("add");
                value.add("remove");
                return value;
            }else {
                for(Player p : Bukkit.getOnlinePlayers()) {
                    if (p == Bukkit.getPlayer(args[0])) {
                        for (String ranks : PermissionConfig.getConfiguration().getStringList("groups.rank.exist")) {
                            value.add(ranks);
                            return value;
                        }
                    }
                }
            }
        }
        return null;
    }
}
