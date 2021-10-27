package de.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TestCommand implements CommandExecutor { //<-- Dies ist die Classe und der Implementierte ansatz, bei einem Command steht CommandExecutor und bei einem Event steht Listener aber wen sie nur eine classe haben wollen die sie als platzhalter benutzen können können sie auch nichts hin schreiben
    @Override //<-- Dies Überschreibt die Commands0
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) { //<-- dies wird beim ausführen des commands abgefragt
        if(sender instanceof Player){ //<-- Dies ist die Abfrage ob der der CommandSender ein Spieler ist oder nicht, wenn er es nicht sein sollte dann würde es nicht in die if schleife rein gehen
            Player p = (Player) sender; //<-- Setzt den CommandSender sender zu Player um, vergiss nie nach dem = das (Player) zu setzen.
            p.sendMessage("Dies ist ein Beispiel."); //<-- Dies gibt dem Spieler der den Befehl ausgeführt hat in Minecraft ten text "Dies ist ein Beispiel." aus.
        }
        return false;
    }
}

