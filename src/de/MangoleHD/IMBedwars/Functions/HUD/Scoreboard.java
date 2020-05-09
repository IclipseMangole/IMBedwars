package de.MangoleHD.IMBedwars.Functions.HUD;

import de.Iclipse.IMAPI.Util.ScoreboardSign;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class Scoreboard implements Listener {

    public static HashMap<Player, ScoreboardSign> boards = new HashMap<>();

    public static void scoreboard(){
        Bukkit.getOnlinePlayers().forEach(player -> {
            ScoreboardSign ss;
            if (!boards.containsKey(player)) {
                ss = new ScoreboardSign(player, "§8« §5§lIM§r§fBedwars§r§8 »");
                ss.create();
            } else {
                ss = boards.get(player);
            }
        });
    }
}
