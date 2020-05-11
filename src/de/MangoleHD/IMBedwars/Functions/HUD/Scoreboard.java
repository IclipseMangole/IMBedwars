package de.MangoleHD.IMBedwars.Functions.HUD;

import de.Iclipse.IMAPI.Util.ScoreboardSign;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.Team;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import java.util.HashMap;

import static de.MangoleHD.IMBedwars.Data.*;

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
            ss.setLine(0, "§5   IM§fBedwars");
            ss.setLine(1, Color.AQUA + "");

            int i;
            for(i = 2; i < teams.size() + 2; i++){
                ss.setLine(i, getScoreboardTeam(teams.get(i), player));
            }

        });
    }

    public static String getScoreboardTeam(Team team, Player player){
        ChatColor color = team.getColor();
        int alive = team.getAlive();
        String bed;
        if(team.isBedAlive()){
            bed = "§aJA";
        }else{
            bed = "§cNEIN";
        }

        return String.valueOf(new StringBuilder().append(color + team.getTeam().getDisplayName()).append("§f: " + alive).append(" " + dsp.get("bed.name",player) + ": ").append(bed));
    }
}
