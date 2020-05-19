package de.MangoleHD.IMBedwars.Functions.PlayerManagement;

import de.MangoleHD.IMBedwars.Data;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.ArrayList;
import java.util.HashMap;

public class TeamManager {

    public static void createTeams() {

        if(Data.teamnumber >= 2){
            new Team(ChatColor.RED, Material.RED_BED);
            new Team(ChatColor.BLUE, Material.LIGHT_BLUE_BED);
        }
        if(Data.teamnumber >= 4){
            new Team(ChatColor.GREEN, Material.GREEN_BED);
            new Team(ChatColor.YELLOW, Material.YELLOW_BED);
        }
        if(Data.teamnumber >= 8){
            new Team(ChatColor.GOLD, Material.ORANGE_BED);
            new Team(ChatColor.DARK_RED, Material.RED_BED);
            new Team(ChatColor.DARK_GREEN, Material.LIME_BED);
            new Team(ChatColor.AQUA, Material.CYAN_BED);
        }
        if(Data.teamnumber >= 16){
            new Team(ChatColor.DARK_AQUA, Material.CYAN_BED);
            new Team(ChatColor.DARK_BLUE, Material.BLUE_BED);
            new Team(ChatColor.LIGHT_PURPLE, Material.PINK_BED);
            new Team(ChatColor.DARK_PURPLE, Material.PURPLE_BED);
            new Team(ChatColor.WHITE, Material.WHITE_BED);
            new Team(ChatColor.GRAY, Material.LIGHT_GRAY_BED);
            new Team(ChatColor.DARK_GRAY, Material.GRAY_BED);
            new Team(ChatColor.BLACK, Material.BLACK_BED);
        }
    }

    public static void autoFill() {
        final int[] biggestTeam = {0};
        Data.teams.forEach(team -> {
            if (team.getUsers().size() > biggestTeam[0]) {
                biggestTeam[0] = team.getUsers().size();
            }
        });
        Data.users.forEach(user -> {
            if (!user.isInATeam()) {
                if (biggestTeam[0] != 0) {
                    Data.teams.forEach(team -> {
                        if (!user.isInATeam()) {
                            if (team.getUsers().size() < biggestTeam[0]) {
                                team.addUser(user);
                            }
                        }
                    });
                } else {
                    Data.teams.get(0).addUser(user);
                    biggestTeam[0]++;
                }
            }
        });
    }

    public static void autoDelete() {
        if (Data.teams.size() > 0) {
            ArrayList<Team> toDelete = new ArrayList<>();
            Data.teams.forEach(team -> {
                if(team.getUsers().size() == 0){
                    toDelete.add(team);
                }
            });
            toDelete.forEach(team -> {
                Data.teams.remove(team);
            });
        }
    }
}
