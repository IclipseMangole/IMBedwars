package de.MangoleHD.IMBedwars.Functions.PlayerManagement;

import de.MangoleHD.IMBedwars.Data;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.ArrayList;

public class TeamManager {

    public static void createTeams() {
        new Team(ChatColor.BLUE, Material.BLUE_BED);
        new Team(ChatColor.RED, Material.RED_BED);
        new Team(ChatColor.YELLOW, Material.YELLOW_BED);
        new Team(ChatColor.GREEN, Material.GREEN_BED);
    }

    public static void autoFill() {
        final int[] biggestTeam = {0};
        Data.teams.forEach(entry -> {
            if (entry.getUsers().size() > biggestTeam[0]) {
                biggestTeam[0] = entry.getUsers().size();
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
            for (Team entry : Data.teams) {
                if (entry.getUsers().size() == 0) {
                    toDelete.add(entry);
                }
            }
            toDelete.forEach(entry -> {
                Data.teams.remove(entry);
            });
        }
    }
}
