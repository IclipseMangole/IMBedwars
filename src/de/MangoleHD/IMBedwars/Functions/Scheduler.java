package de.MangoleHD.IMBedwars.Functions;

import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Functions.GameStates.GameState;
import de.MangoleHD.IMBedwars.Functions.HUD.Scoreboard;
import de.MangoleHD.IMBedwars.Functions.HUD.Tablist;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

import java.util.Random;

public class Scheduler {

    BukkitTask task;
    BukkitTask asynctask;

    public void setTask(){
        task = Bukkit.getScheduler().runTaskTimer(Data.instance, new Runnable() {
            @Override
            public void run() {
                if(Data.state == GameState.Lobby){

                }else if(Data.state == GameState.Running){

                }else if(Data.state == GameState.Finish){

                }
            }
        }, 20, 20);
    }

    public void stopTask(){
        task.cancel();
    }

    public void setAsynctask(){
        asynctask = Bukkit.getScheduler().runTaskTimerAsynchronously(Data.instance, new Runnable() {
            @Override
            public void run() {
                if (Data.state == GameState.Running) {

                    Scoreboard.scoreboard();

                } else if (Data.state == GameState.Lobby) {

                    Data.users.forEach(user -> {
                        if (!user.isInATeam()) {
                            user.getPlayer().getInventory().setItem(0, Data.teams.get(new Random().nextInt(Data.teams.size())).getTeamItem(user.getPlayer()));
                        }
                    });

                }else if(Data.state == GameState.Finish){

                }
            }
        },20 ,20);
    }

    public void stopAsyncTask(){
        asynctask.cancel();
    }
}
