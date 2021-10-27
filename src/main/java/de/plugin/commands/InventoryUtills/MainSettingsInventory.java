package de.plugin.commands.InventoryUtills;

import de.plugin.configs.Config;
import de.plugin.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class MainSettingsInventory {
    private static int slots = 27;
    public static Inventory settingsInv;
    public static String settingsInventoryName = ChatColor.YELLOW + "Settings";

    public MainSettingsInventory() {
        if (Config.INS.contains("command.setting.slots")) {
            try {
                slots = (int) Config.INS.get("command.setting.slots");
            }catch (NullPointerException ex){
                ex.printStackTrace();
            }
        } else {
            Config.INS.set("command.setting.slots", 27);
        }
        settingsInv = Bukkit.createInventory(null, slots, settingsInventoryName);
        int[] settingsGlassOrder1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        for (int i = 0; i < settingsGlassOrder1.length; i++) {
            settingsInv.setItem(settingsGlassOrder1[i], new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).displayname(" ").build());
        }
        settingsInv.setItem(12, new ItemBuilder(Material.AMETHYST_SHARD).displayname(ChatColor.BLUE + "Plugin Settings").build());
        settingsInv.setItem(14, new ItemBuilder(Material.CLOCK).displayname(ChatColor.BLUE + "Portal Timer").build());
    }
}
