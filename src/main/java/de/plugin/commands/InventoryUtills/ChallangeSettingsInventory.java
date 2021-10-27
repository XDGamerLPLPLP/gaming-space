package de.plugin.commands.InventoryUtills;

import de.plugin.configs.Config;
import de.plugin.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class ChallangeSettingsInventory {
    private static int slots = 27;
    public static Inventory pluginSettingsInv;
    public static String settingsInventoryName = ChatColor.YELLOW + "Plugin Settings";
    public ChallangeSettingsInventory(){
        if (Config.INS.contains("command.setting.slots")) {
            try {
                slots = (int) Config.INS.get("command.setting.slots");
            }catch (NullPointerException ex){
                ex.printStackTrace();
            }
        } else {
            Config.INS.set("command.setting.slots", 27);
        }
        pluginSettingsInv = Bukkit.createInventory(null, slots, settingsInventoryName);
        int[] pluginSettingsInvGlass = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,15,16,17,18,19,20,21,22,23,24,25,26};
        for(int i = 0; i < pluginSettingsInvGlass.length; i++) {
            pluginSettingsInv.setItem(pluginSettingsInvGlass[i],new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).displayname("").build());
        }
        if(Config.INS.getBoolean("plugin.challanges.dragondeath").equals(true)) {
            pluginSettingsInv.setItem(12, new ItemBuilder(Material.DRAGON_EGG).displayname("§9Dragon Death").lore("",
                    "§c§lStatus:§r§2 Aktiviert", "", "§8Bei Status Aktiviert endet", "§8das Spiel bei dem tod des", "§8Ender-Dragon namens Jean.").build());
        }
        else if(Config.INS.getBoolean("plugin.challanges.dragondeath").equals(false)){
            pluginSettingsInv.setItem(12, new ItemBuilder(Material.DRAGON_EGG).displayname("§9Dragon Death").lore("",
                    "§c§lStatus:§r§4 Deaktiviert", "", "§8Bei Status Aktiviert endet", "§8das Spiel bei dem tod des", "§8Ender-Dragon namens Jean.").build());
        }
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
        for(double s : numbers) {
            if (Config.INS.getDouble("plugin.challanges.hearts").equals(s)) {
                if(Config.INS.getDouble("plugin.challanges.hearts").equals(1.0)) {
                    pluginSettingsInv.setItem(13, new ItemBuilder(Material.RED_DYE).displayname("§9Herzen Anzahl").lore("",
                            "§c§lAnzahl:§r§6 " + s, "", "§7Right Click: Higher", " ").build());
                }
                if(Config.INS.getDouble("plugin.challanges.hearts").equals(20.0)){
                    pluginSettingsInv.setItem(13, new ItemBuilder(Material.RED_DYE).displayname("§9Herzen Anzahl").lore("",
                            "§c§lAnzahl§r§6: " + s, "", " ", "§7Left Click: Lower").build());
                }else {
                    pluginSettingsInv.setItem(13, new ItemBuilder(Material.RED_DYE).displayname("§9Herzen Anzahl").lore("",
                            "§c§lAnzahl:§r§6 " + s, "", "§7Right Click: Higher", "§7Left Click: Lower").build());
                }
            }
        }
        pluginSettingsInv.setItem(14, new ItemBuilder(Material.BONE).displayname("§9Player Death").build());
    }
}
