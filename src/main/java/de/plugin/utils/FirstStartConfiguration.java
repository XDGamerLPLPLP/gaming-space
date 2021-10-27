package de.plugin.utils;

import de.plugin.configs.Config;
import de.plugin.configs.PermissionConfig;

import java.util.ArrayList;
import java.util.List;

public class FirstStartConfiguration {
    public static void onFirstStart(){
        Config.INS.set("plugin.firststart", true);
        List<String> permissions = new ArrayList<>();
        permissions.add("plugin.player.settingcommand");
        permissions.add("plugin.player.configcommand");
        permissions.add("plugin.player.gamemodecommand");
        permissions.add("plugin.player.multiversecommand");
        permissions.add("plugin.player.permissionscommand");
        permissions.add("plugin.player.setportallocationcommand");
        permissions.add("plugin.player.setportalspawnscommand");
        permissions.add("plugin.player.wartungcommand");
        PermissionConfig.INS.setRankPermission("plugin.permissions", permissions);
        Config.INS.set("plugin.challanges.hearts", 10.0);
        Config.INS.setBoolean("plugin.challanges.dragondeath", false);
        Config.INS.setBoolean("wartung.status", false);
        Config.INS.setBoolean("plugin.world.reseted", false);
        Config.INS.setBoolean("plugin.challanges.playerdeath", false);
    }
}
