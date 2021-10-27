package de.plugin.utils;

import de.plugin.configs.Config;
import org.bukkit.Bukkit;
import org.bukkit.World;

import java.io.File;

public class ResetWorld {

    public static void onResetWorld(){
        if(Config.INS.getBoolean("plugin.world.reseted").equals(true)) {
            World world = Bukkit.getWorld("world");
            World world_nether = Bukkit.getWorld("world_nether");
            World world_the_end = Bukkit.getWorld("world_the_end");
            assert world != null;
            assert world_nether != null;
            assert world_the_end != null;
            File world_file = world.getWorldFolder();
            File world_nether_file = world_nether.getWorldFolder();
            File world_the_end_file = world_the_end.getWorldFolder();
            Bukkit.unloadWorld(world, true);
            delete(world_file);
            delete(world_nether_file);
            delete(world_the_end_file);
            Config.INS.setBoolean("plugin.world.reseted", false);
        }
    }
    public static void delete(File file)
    {
        if (file.isDirectory())
        {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++){
                delete(files[i]);
            }
        }
        file.delete();
    }
}
