package de.MangoleHD.IMBedwars.Functions.GameStates;

import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Functions.Bed;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.Team;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.User;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Running implements Listener {

    public static void playerDestroyBed(Bed bed){
        Data.beds.remove(bed);
    }

    public void respawnUser(Player player){
        User user = User.getUser(player);
        Location respawn = Data.respawns.get(user.getTeam());
        player.setBedSpawnLocation(respawn);
        player.teleport(respawn);
    }

    public void setSpectator(Player player){
        User user = User.getUser(player);

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        User user = User.getUser(event.getEntity());
        Team team = user.getTeam();
        event.setDeathMessage(null);
        for(Bed bed : Data.beds){
            if(bed.getBedcolor().equals(team.getTeamColor())){
                respawnUser(event.getEntity());
            }else{
                setSpectator(event.getEntity());
            }
        }
    }
}
