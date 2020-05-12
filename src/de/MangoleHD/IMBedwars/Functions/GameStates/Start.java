package de.MangoleHD.IMBedwars.Functions.GameStates;

import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.TeamManager;

public class Start {

    public void startBedwars(){
        Data.state = GameState.Running;
        Data.users.forEach(user -> {
            user.getPlayer().teleport(Data.respawns.get(user.getTeam()));
        });
        TeamManager.autoFill();
        TeamManager.autoDelete();
    }
}
