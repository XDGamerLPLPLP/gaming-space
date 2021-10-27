package de.plugin.plugin.tablist;

import de.plugin.Plugin;
import de.plugin.configs.Config;
import de.plugin.configs.PermissionConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TablistManager {

    public void setPlayerList(Player player){
        player.setPlayerListHeaderFooter(ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "              " +
                ChatColor.DARK_GRAY + "[ " + ChatColor.BLUE + "Gaming" + ChatColor.DARK_GRAY + " ]" +
                ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "              " + ChatColor.RESET,
                ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "              " + ChatColor.DARK_GRAY + "[ " +
                        ChatColor.BLUE + "      " + ChatColor.DARK_GRAY +
                        " ]" + ChatColor.DARK_GRAY.toString() + ChatColor.STRIKETHROUGH + "              " + ChatColor.RESET /*+"\n" +
                ChatColor.BLUE + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()*/);
    }
   public void setPlayerTeams(Player player){
       Plugin.INSTANCE.log("1");
        Scoreboard scoreboard = player.getScoreboard();
        Team member = scoreboard.getTeam("dmember");
        if(member == null){
            member = scoreboard.registerNewTeam("dmember");
        }
       Team tester = scoreboard.getTeam("ctester");
       if(tester == null){
           tester = scoreboard.registerNewTeam("ctester");
       }
       Team dev = scoreboard.getTeam("bdev");
       if(dev == null){
           dev = scoreboard.registerNewTeam("bdev");
       }
        Team admin = scoreboard.getTeam("aadmin");
        if(admin == null){
            admin = scoreboard.registerNewTeam("aadmin");
        }

        for(Player target : Bukkit.getOnlinePlayers()){
            Plugin.INSTANCE.log("2");
            if(PermissionConfig.INS.contains("groups." + target.getUniqueId()+ ".rank")) {
                if(PermissionConfig.INS.get("groups." + target.getUniqueId()+ ".rank").equals("member")){
                    Plugin.INSTANCE.log("23");
                    member.addEntry(target.getName());
                }else if(PermissionConfig.INS.get("groups." + target.getUniqueId()+ ".rank").equals("tester")){
                    tester.addEntry(target.getName());
                }else if(PermissionConfig.INS.get("groups." + target.getUniqueId()+ ".rank").equals("developer")){
                    dev.addEntry(target.getName());
                }else if(PermissionConfig.INS.get("groups." + target.getUniqueId()+ ".rank").equals("admin")){
                    admin.addEntry(target.getName());
                }
            }
        }

    }
    public void setPlayerName(Player p){
        Plugin.INSTANCE.log("3");
        for(Player player : Bukkit.getOnlinePlayers()) {
            if (PermissionConfig.INS.contains("groups." + player.getUniqueId() + ".rank")) {
                if (PermissionConfig.INS.get("groups." + player.getUniqueId() + ".rank").equals("member")) {
                    Plugin.INSTANCE.log("34");
                    String b = Config.INS.getString("plugin.member.prefix");
                    player.setDisplayName("§" + b + " §r§7" + player.getName());
                    player.setPlayerListName("§" + b + " §r§7" + player.getName());
                } else if (PermissionConfig.INS.get("groups." + player.getUniqueId() + ".rank").equals("tester")) {
                    player.setCustomName("§" + Config.INS.getString("plugin.tester.prefix") + " §r§7" + player.getName());
                } else if (PermissionConfig.INS.get("groups." + player.getUniqueId() + ".rank").equals("developer")) {
                    player.setCustomName("§" + Config.INS.getString("plugin.developer.prefix") + " §r§7" + player.getName());
                } else if (PermissionConfig.INS.get("groups." + player.getUniqueId() + ".rank").equals("admin")) {
                    player.setCustomName("§" + Config.INS.getString("plugin.admin.prefix") + " §r§7" + player.getName());
                }
            }
        }
    }
}
