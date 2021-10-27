/*package de.plugin.commands;

import com.mojang.authlib.BaseUserAuthentication;
import de.plugin.configs.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class OpenSign implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            Location loc = (Location) Config.INS.get("world.block.sign");
            Block signBlock = Bukkit.getWorld("world").getBlockAt(loc);
            BlockData state = signBlock.getBlockData();
            Sign sign = (Sign) state;
            HumanEntity sing = p.openSign(sign);
        }
        return false;
    }
}
*/