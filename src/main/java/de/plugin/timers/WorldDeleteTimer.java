package de.plugin.timers;

import de.plugin.Plugin;
import de.plugin.configs.Config;
import de.plugin.utils.ResetWorld;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Timer;

public class WorldDeleteTimer {
    public static Integer  minutes = 0;
    public static Integer hours = 0;

    private Player testplayer;
    private int i = 0;

    private boolean running; // true or false
    private int time;


    public WorldDeleteTimer() {
        this.running = true;
        if(Config.INS.contains("timer.time")) {
            this.time = Config.INS.getInt("timer.time");
        }else{
            this.time = 0;
        }
        run();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getTime(){
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void sendActionBar(){
        if(getTime() == 10){

                setRunning(false);
                ResetWorld.onResetWorld();
        }
    }


    public void save(){
        Config.INS.set("timer.time", time);
    }

    private void run(){
        new BukkitRunnable(){
            @Override
            public void run(){
                sendActionBar();
                if(!isRunning()){
                    return;
                }
                setTime(getTime() + 1);
            }
        }.runTaskTimer(Plugin.INSTANCE, 20, 20);
    }
}
