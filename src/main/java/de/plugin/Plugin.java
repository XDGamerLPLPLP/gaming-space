package de.plugin;

import de.plugin.commands.*;
import de.plugin.commands.InventoryUtills.MainSettingsInventory;
import de.plugin.commands.InventoryUtills.ChallangeSettingsInventory;
import de.plugin.commands.InventoryUtills.PlayerDeathInventory;
import de.plugin.commands.PermissionsCommand;
import de.plugin.commands.tabcomplete.PermissionsTabCompleter;
import de.plugin.listener.*;
import de.plugin.listener.BreakBlockListener;
import de.plugin.listener.InventoryListener;
import de.plugin.configs.Config;
//import de.plugin.utils.CustomChunkGenerator;
import de.plugin.configs.FileConfig;
import de.plugin.configs.PermissionConfig;
import de.plugin.plugin.tablist.TablistManager;
import de.plugin.utils.FirstStartConfiguration;
import de.plugin.utils.ResetWorld;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
//import org.bukkit.generator.ChunkGenerator;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

public final class Plugin extends JavaPlugin {
    public Timer timer;
    private static de.plugin.plugin.tablist.TablistManager tablistManager;
    public HashMap<UUID, PermissionAttachment> playerPermissions = new HashMap<UUID, PermissionAttachment>();
    public HashMap<UUID, PermissionAttachment> playerremovePermissions = new HashMap<UUID, PermissionAttachment>();
    public static String PREFIX = "§a§4FishenJoe §7§o";
    public static Plugin INSTANCE;
    public boolean wartung = false;
    public boolean t = false;

    public Plugin(){
        INSTANCE = this;
        new Config();
        new FileConfig();
        new PermissionConfig();
        onStartConfig();
        timer = new Timer();
        if(Bukkit.getWorlds().contains("world")){
            ResetWorld.onResetWorld();
        }
        tablistManager = new TablistManager();
    }

    @Override
    public void onEnable() {
        Config.INS.setBoolean("plugin.start.config", true);
        log( "Plugin geladen.");
        this.register();
        if(Config.INS.contains("wartung.status")) {
            wartung = Config.INS.getBoolean("wartung.status");
        }
    }

    @Override
    public void onDisable() {
        if(Config.INS.getBoolean("plugin.start.config").equals(true)){
            Config.INS.setBoolean("plugin.start.config", false);
        }
        // Plugin shutdown logic
        log( "Plugin endladen");
    }

    public void log(String text){
        Bukkit.getConsoleSender().sendMessage(text);
    }

    public void register(){
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new InventoryListener(), this);
        pluginManager.registerEvents(new BreakBlockListener(), this);
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new PlayerLeaveListener(), this);
        pluginManager.registerEvents(new PlayerLoginListener(), this);
        pluginManager.registerEvents(new ServerListPingListener(), this);
        pluginManager.registerEvents(new PlayerDeathListener(), this);

        Bukkit.getPluginCommand("wartung").setExecutor(new WartungsArbeitCommmand());
        Bukkit.getPluginCommand("settings").setExecutor(new SettingsCommand());
        Bukkit.getPluginCommand("gms").setExecutor(new GamemodeCommand());
        Bukkit.getPluginCommand("multiv").setExecutor(new MultiverseCommand());
        Bukkit.getPluginCommand("pex").setExecutor(new PermissionsCommand());
        Bukkit.getPluginCommand("pex").setTabCompleter(new PermissionsTabCompleter());
        Bukkit.getPluginCommand("reset").setExecutor(new ResetWorldCommand());

        if(Config.INS.getBoolean("plugin.world.reseted").equals(true)){
            new ResetWorld();
        }
        new MainSettingsInventory();
        new ChallangeSettingsInventory();
        new PlayerDeathInventory();
    }
    public void setupPermissions(Player p){
        UUID uuid = p.getUniqueId();
        PermissionAttachment attachment = p.addAttachment(this);
        attachment.getPermissible().recalculatePermissions();
        this.playerPermissions.put(p.getUniqueId(),attachment);
        PermissionAttachment attachments = this.playerPermissions.get(uuid);
        attachments.getPermissible().recalculatePermissions();
        log(attachments + "");
            String rank = PermissionConfig.INS.get("groups." + uuid + ".rank");
            for (String perms : PermissionConfig.getConfiguration().getStringList("groups." + rank + ".rank")) {
                log(perms + "");
                attachments.setPermission(perms, true);
                attachments.getPermissible().recalculatePermissions();
                this.playerremovePermissions.put(uuid, attachments);
            }
    }
    public void unSetupPermissions(Player p){
        UUID uuid = p.getUniqueId();
        PermissionAttachment attachments = this.playerremovePermissions.get(uuid);
        attachments.getPermissible().recalculatePermissions();
        List<String> rankList = new ArrayList<>();
        rankList.add("member");
        rankList.add("tester");
        rankList.add("developer");
        rankList.add("admin");
        p.recalculatePermissions();
        p.removeAttachment(attachments);
        p.recalculatePermissions();
    }
    private void onStartConfig(){
        //Config
        File dir = new File("./plugins/Fishyfanconfig/");
        if(!dir.exists()){
            dir.mkdirs();
        }
        Config.file = new File("./plugins/Fishyfanconfig/", "config.yml");
        if(!Config.file.exists()){
            try {
                Config.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Config.config = YamlConfiguration.loadConfiguration(Config.file);

        //FileConfig
        File di = new File("./plugins/Fishyfanconfig/");
        if(!di.exists()){
            di.mkdirs();
        }
        FileConfig.file = new File("./plugins/Fishyfanconfig/", "playerlanguagesettings.yml");
        if(!FileConfig.file.exists()){
            try {
                FileConfig.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileConfig.config = YamlConfiguration.loadConfiguration(FileConfig.file);

        //PermissionsConfig
        File dirs = new File("./plugins/config/");
        if(!dirs.exists()){
            dirs.mkdirs();
        }
        PermissionConfig.file = new File("./plugins/config/", "permissions.yml");
        if(!PermissionConfig.file.exists()){
            try {
                PermissionConfig.file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PermissionConfig.config = YamlConfiguration.loadConfiguration(PermissionConfig.file);
        if(!Config.INS.contains("plugin.firststart")){
            FirstStartConfiguration.onFirstStart();
        }
    }
    public Timer getTimer() {
        return timer;
    }
    public static TablistManager getTablistManager() {
        return tablistManager;
    }
    /*
    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        return new CustomChunkGenerator();
    }*/
}
