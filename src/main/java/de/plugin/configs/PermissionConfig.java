package de.plugin.configs;

import de.plugin.Plugin;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PermissionConfig {
    public static File file;
    public static YamlConfiguration config;
    public static PermissionConfig INS;
    public PermissionConfig() {
        INS = this;
        File dir = new File("./plugins/config/");
        if(!dir.exists()){
            dir.mkdirs();
        }
        file = new File("./plugins/config/", "permissions.yml");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(file);
        Plugin.INSTANCE.log(config + "");
    }

    public boolean contains(String path){
        return config.contains(path);
    }

    public void setPermission(String path, List<String> value){
        try {
            config.set(path, value);
            config.save(file);
        }catch (IOException e){ e.printStackTrace();}
    }
    public void setRankPermission(String path,List<String> value){
        try {
            config.set(path, value);
            config.save(file);
        }catch (IOException e){ e.printStackTrace();}
    }
    public void setRank(String path, String value){
        try {
            config.set(path, value);
            config.save(file);
        }catch (IOException e){ e.printStackTrace();}
    }

    public String get(String path){
        if(!contains(path)){
            return null;
        }
        return (String) config.get(path);
    }
    public void removePath(String path){
        try{
            config.set(path, null);
            config.save(file);
        } catch (IOException e) {e.printStackTrace();}
    }
    public static YamlConfiguration getConfiguration() {
        return config;
    }
}
