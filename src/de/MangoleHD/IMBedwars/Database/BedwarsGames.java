package de.MangoleHD.IMBedwars.Database;

import de.Iclipse.IMAPI.Database.MySQL;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BedwarsGames {

    public static void createBedwarsGamesTable(){
        MySQL.update("CREATE TABLE IF NOT EXISTS bedwars_games (id MEDIUMINT NOT NULL AUTO_INCREMENT, start DATETIME, finish DATETIME, teamsize INT(5), map VARCHAR(100), PRIMARY KEY (id))");
    }

    public static void createGame(Date start, Date finish, int teamsize, String map){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        MySQL.update("INSERT INTO bedwars_games (start, finish, teamsize, map) VALUES ('" + sdf.format(start) + "', '" + sdf.format(finish) + "', '" + teamsize + "', '" + map + "')");
    }

    public static void deleteGame(int id) {
        MySQL.update("DELETE FROM baro_games WHERE id = " + id);
        MySQL.update("DELETE FROM baro_stats WHERE game = " + id);
    }
}
