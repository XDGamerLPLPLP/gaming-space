package de.plugin.listener;

import de.plugin.Plugin;
import de.plugin.commands.InventoryUtills.MainSettingsInventory;
import de.plugin.commands.InventoryUtills.ChallangeSettingsInventory;
import de.plugin.commands.InventoryUtills.PlayerDeathInventory;
import de.plugin.commands.SettingsCommand;
import de.plugin.configs.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryListener implements Listener {
    private static int inv;
    private static Double hearts;
    @EventHandler
    public void handleSettingsMenuClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player p) {
            //MainInventory
            if(e.getView().getTitle().equals(MainSettingsInventory.settingsInventoryName)) {
                e.setCancelled(true);
                if (e.getSlot() == 12) {
                    SettingsCommand.onOpenPluginSettings(p);
                }
            }
            //PlayerDeathInventory
            if(e.getView().getTitle().equals(PlayerDeathInventory.settingsInventoryName)){
                e.setCancelled(true);
                if(e.getSlot() == 12){
                    if(Config.INS.getBoolean("plugin.challanges.playerdeath").equals(true)){
                        Config.INS.setBoolean("plugin.challanges.playerdeath", false);
                        ItemStack r_t = e.getCurrentItem();
                        ItemMeta r_t_m = r_t.getItemMeta();
                        List<String> lorelist = new ArrayList<>();
                        lorelist.add("");
                        lorelist.add( "§c§lStatus:§r§4 Deaktiviert");
                        lorelist.add(" ");
                        lorelist.add("§8Bei Status Aktiviert wird");
                        lorelist.add("§8der Spierler in den");
                        lorelist.add("§8GameMode Spectator gesetzt");
                        lorelist.add("§8wenn er Stirbt.");
                        r_t_m.setLore(lorelist);
                        r_t.setItemMeta(r_t_m);
                    }else if(Config.INS.getBoolean("plugin.challanges.playerdeath").equals(false)){
                        Config.INS.setBoolean("plugin.challanges.playerdeath", true);
                        ItemStack r_t = e.getCurrentItem();
                        ItemMeta r_t_m = r_t.getItemMeta();
                        List<String> lorel = new ArrayList<>();
                        lorel.add("");
                        lorel.add( "§c§lStatus:§r§2 Aktiviert");
                        lorel.add(" ");
                        lorel.add("§8Bei Status Aktiviert wird");
                        lorel.add("§8der Spierler in den");
                        lorel.add("§8GameMode Spectator gesetzt");
                        lorel.add("§8wenn er Stirbt.");
                        r_t_m.setLore(lorel);
                        r_t.setItemMeta(r_t_m);
                    }
                }
                else if(e.getSlot() == 14){

                }
            }
            //ChallangeInventory
            if(e.getView().getTitle().equals(ChallangeSettingsInventory.settingsInventoryName)){
                e.setCancelled(true);
                if(e.getSlot() == 12){
                    if(Config.INS.getBoolean("plugin.challanges.dragondeath").equals(true)) {
                        Config.INS.setBoolean("plugin.challanges.dragondeath", false);
                        ItemStack r_t = e.getCurrentItem();
                        ItemMeta r_t_m = r_t.getItemMeta();
                        List<String> lorelist = new ArrayList<>();
                        lorelist.add("");
                        lorelist.add( "§c§lStatus:§r§4 Deaktiviert");
                        lorelist.add(" ");
                        lorelist.add("§8Bei Status Aktiviert endet");
                        lorelist.add("§8das Spiel bei dem tod des");
                        lorelist.add("§8Ender-Dragon namens Jean.");
                        r_t_m.setLore(lorelist);
                        r_t.setItemMeta(r_t_m);
                    }
                    else if(Config.INS.getBoolean("plugin.challanges.dragondeath").equals(false)){
                        Config.INS.setBoolean("plugin.challanges.dragondeath", true);
                        ItemStack r_t = e.getCurrentItem();
                        ItemMeta r_t_m = r_t.getItemMeta();
                        List<String> lorelist = new ArrayList<>();
                        lorelist.add("");
                        lorelist.add( "§c§lStatus:§r§2 Aktiviert");
                        lorelist.add(" ");
                        lorelist.add("§8Bei Status Aktiviert endet");
                        lorelist.add("§8das Spiel bei dem tod des");
                        lorelist.add("§8Ender-Dragon namens Jean.");
                        r_t_m.setLore(lorelist);
                        r_t.setItemMeta(r_t_m);
                    }
                }
                if(e.getSlot() == 13){
                    if(e.isRightClick()){
                        Config.INS.setDouble("plugin.challanges.hearts",Config.INS.getDouble("plugin.challanges.hearts")  + 1.0);
                        hearts = Config.INS.getDouble("plugin.challanges.hearts");
                        if(hearts > 20.0){
                            hearts = 20.0;
                            Config.INS.setDouble("plugin.challanges.hearts",20.0);
                        }
                        if(hearts == 20.0 || hearts < 20.0) {
                            List<Double> numbers = new ArrayList<>();
                            numbers.add(1.0);
                            numbers.add(2.0);
                            numbers.add(3.0);
                            numbers.add(4.0);
                            numbers.add(5.0);
                            numbers.add(6.0);
                            numbers.add(7.0);
                            numbers.add(8.0);
                            numbers.add(9.0);
                            numbers.add(10.0);
                            numbers.add(11.0);
                            numbers.add(12.0);
                            numbers.add(13.0);
                            numbers.add(14.0);
                            numbers.add(15.0);
                            numbers.add(16.0);
                            numbers.add(17.0);
                            numbers.add(18.0);
                            numbers.add(19.0);
                            numbers.add(20.0);
                            for (double s : numbers) {
                                if (Config.INS.getDouble("plugin.challanges.hearts").equals(s)) {
                                    if(Config.INS.getDouble("plugin.challanges.hearts").equals(20.0)){
                                        ItemStack r_t = e.getCurrentItem();
                                        ItemMeta r_t_m = r_t.getItemMeta();
                                        List<String> lorelist = new ArrayList<>();
                                        lorelist.add("");
                                        lorelist.add("§4§lAnzahl: §r§6" + s);
                                        lorelist.add(" ");
                                        lorelist.add(" ");
                                        lorelist.add("§7Left Click: Lower");
                                        r_t_m.setLore(lorelist);
                                        r_t.setItemMeta(r_t_m);
                                        setPlayerHearts(Config.INS.getDouble("plugin.challanges.hearts"));
                                    }else {
                                        ItemStack r_t = e.getCurrentItem();
                                        ItemMeta r_t_m = r_t.getItemMeta();
                                        List<String> lorelist = new ArrayList<>();
                                        lorelist.add("");
                                        lorelist.add("§4§lAnzahl:§r§6 " + s);
                                        lorelist.add(" ");
                                        lorelist.add("§7Right Click: Higher");
                                        lorelist.add("§7Left Click: Lower");
                                        r_t_m.setLore(lorelist);
                                        r_t.setItemMeta(r_t_m);
                                        setPlayerHearts(Config.INS.getDouble("plugin.challanges.hearts"));
                                    }
                                }

                            }
                        }
                    }
                    if(e.isLeftClick()){
                        Config.INS.setDouble("plugin.challanges.hearts",Config.INS.getDouble("plugin.challanges.hearts")  - 1.0);
                        hearts = Config.INS.getDouble("plugin.challanges.hearts");
                        if(hearts < 1.0){
                            hearts = 1.0;
                            Config.INS.setDouble("plugin.challanges.hearts",1.0);
                        }
                        if(hearts > 1.0 || hearts == 1.0) {
                            List<Double> numbers = new ArrayList<>();
                            numbers.add(1.0);
                            numbers.add(2.0);
                            numbers.add(3.0);
                            numbers.add(4.0);
                            numbers.add(5.0);
                            numbers.add(6.0);
                            numbers.add(7.0);
                            numbers.add(8.0);
                            numbers.add(9.0);
                            numbers.add(10.0);
                            numbers.add(11.0);
                            numbers.add(12.0);
                            numbers.add(13.0);
                            numbers.add(14.0);
                            numbers.add(15.0);
                            numbers.add(16.0);
                            numbers.add(17.0);
                            numbers.add(18.0);
                            numbers.add(19.0);
                            numbers.add(20.0);
                            for (double s : numbers) {
                                if (Config.INS.getDouble("plugin.challanges.hearts").equals(s)) {
                                    if(Config.INS.getDouble("plugin.challanges.hearts").equals(1.0)){
                                        ItemStack r_t = e.getCurrentItem();
                                        ItemMeta r_t_m = r_t.getItemMeta();
                                        List<String> lorelist = new ArrayList<>();
                                        lorelist.add("");
                                        lorelist.add("§4§lAnzahl: §r§6" + s);
                                        lorelist.add(" ");
                                        lorelist.add("§7Right Click: Higher");
                                        lorelist.add(" ");
                                        r_t_m.setLore(lorelist);
                                        r_t.setItemMeta(r_t_m);
                                        setPlayerHearts(Config.INS.getDouble("plugin.challanges.hearts"));
                                    }else {
                                        ItemStack r_t = e.getCurrentItem();
                                        ItemMeta r_t_m = r_t.getItemMeta();
                                        List<String> lorelist = new ArrayList<>();
                                        lorelist.add("");
                                        lorelist.add("§4§lAnzahl:§r§6 " + s);
                                        lorelist.add(" ");
                                        lorelist.add("§7Right Click: Higher");
                                        lorelist.add("§7Left Click: Lower");
                                        r_t_m.setLore(lorelist);
                                        r_t.setItemMeta(r_t_m);
                                        setPlayerHearts(Config.INS.getDouble("plugin.challanges.hearts"));
                                    }
                                }
                            }
                        }
                    }
                }
                if(e.getSlot() == 14){
                    SettingsCommand.onOpenPlayerDeathSettings(p);
                }
            }
        }
    }
    public void setPlayerHearts(Double d){
        for(Player p : Bukkit.getOnlinePlayers()){
            p.setMaxHealth(d);
        }
    }
}
