package de.plugin.commands;

import de.plugin.commands.InventoryUtills.MainSettingsInventory;
import de.plugin.commands.InventoryUtills.ChallangeSettingsInventory;
import de.plugin.commands.InventoryUtills.PlayerDeathInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SettingsCommand implements CommandExecutor {
    /*if(dodaylightcycle.equals(true)) {
                Config.INS.set("world.portaltimer.isrunning", "true");
            }else if(dodaylightcycle.equals(false)) {
                Config.INS.set("world.portaltimer.isrunning", "false");
            }*/

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("de.plugin.setting.command")){
                p.openInventory(MainSettingsInventory.settingsInv);
            }
        }
        return false;
    }

    public static  void onOpenPluginSettings(Player p){
        p.openInventory(ChallangeSettingsInventory.pluginSettingsInv);
    }
    public static  void onOpenPlayerDeathSettings(Player p){
        p.openInventory(PlayerDeathInventory.settingsInv);
    }
}
