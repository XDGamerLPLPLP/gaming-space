package de.plugin.configs;

import de.plugin.Plugin;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    public static File file;
    public static YamlConfiguration config;
    public static Config INS;
    public Config() {
        INS = this;
        File dir = new File("./plugins/Fishyfanconfig/");
        if(!dir.exists()){
            dir.mkdirs();
        }
        file = new File("./plugins/Fishyfanconfig/", "config.yml");
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

    public void set(String path, Object value){
        try {
            config.set(path, value);
            config.save(file);
        }catch (IOException e){ e.printStackTrace();}
    }
    public void setPermissions(String path, Object value){
        try {
            config.set(path, value);
            config.save(file);
        }catch (IOException e){ e.printStackTrace();}
    }
    public void setDouble(String path, Double value){
        try {
            config.set(path, value);
            config.save(file);
        }catch (IOException e){ e.printStackTrace();}
    }
    public void setBoolean(String path, Boolean value){
        try {
            config.set(path, value);
            config.save(file);
        }catch (IOException e){ e.printStackTrace();}
    }
    public void setString(String path, String value){
        try {
            config.set(path, value);
            config.save(file);
        }catch (IOException e){ e.printStackTrace();}
    }

    public Object get(String path){
        if(!contains(path)){
            return null;
        }
        return config.get(path);
    }
    public Integer getInt(String path){
        if(!contains(path)){
            return null;
        }
        return config.getInt(path);
    }
    public Double getDouble(String path){
        if(!contains(path)){
            return null;
        }
        return config.getDouble(path);
    }

    public String getString(String path){
        if(!contains(path)){
            return null;
        }
        return config.getString(path);
    }
    public String getPermissions(String path){
        if(!contains(path)){
            return null;
        }
        return config.getString(path);
    }
    public Boolean getBoolean(String path){
        if(!contains(path)){
            return null;
        }
        return config.getBoolean(path);
    }

    public static YamlConfiguration getConfiguration() {
        return config;
    }
}
