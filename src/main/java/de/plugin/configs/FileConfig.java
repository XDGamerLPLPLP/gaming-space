package de.plugin.configs;

import de.plugin.Plugin;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileConfig {
    public static File file;
    public static YamlConfiguration config;
    public static FileConfig INS;
    public FileConfig() {
        INS = this;
        File dir = new File("./plugins/Fishyfanconfig/");
        if(!dir.exists()){
            dir.mkdirs();
        }
        file = new File("./plugins/Fishyfanconfig/", "playerlanguagesettings.yml");
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

    public Object get(String path){
        if(!contains(path)){
            return null;
        }
        return config.get(path);
    }

    public String getString(String path){
        if(!contains(path)){
            return null;
        }
        return config.getString(path);
    }
}
