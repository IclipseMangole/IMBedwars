package de.MangoleHD.IMBedwars.Functions.GameStates;

import de.Iclipse.IMAPI.Database.ServerManager;
import de.Iclipse.IMAPI.Functions.Servers.State;
import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.TeamManager;
import de.MangoleHD.IMBedwars.Functions.Shop.Shop;
import de.MangoleHD.IMBedwars.Functions.Spawner;

import static de.Iclipse.IMAPI.IMAPI.getServerName;

public class Start {

    public static void startBedwars(){
        Data.state = GameState.Running;
        ServerManager.setState(getServerName(), State.Running);
        Data.users.forEach(user -> {
            user.getPlayer().teleport(Data.respawns.get(user.getTeam()));
        });
        TeamManager.autoFill();
        TeamManager.autoDelete();
        Data.spawners.forEach(Spawner::setSpawner);
        Data.shops.forEach(Shop::spawnShop);
    }
}
