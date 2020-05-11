package de.MangoleHD.IMBedwars.Functions.GameStates;

import de.MangoleHD.IMBedwars.Data;

public class Start {

    public void startBedwars(){
        Data.state = GameState.Running;
        Data.users.forEach(user -> {
            user.getPlayer().teleport(Data.respawns.get(user.getTeam()));
        });
    }
}
