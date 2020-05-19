package de.MangoleHD.IMBedwars.Database;

import de.Iclipse.IMAPI.Database.MySQL;

import java.util.UUID;

public class BedwarsStats {

    public static void createBedwarsStatsTable(){
        MySQL.update("CREATE TABLE IF NOT EXISTS bedwars_stats (id MEDIUMINT NOT NULL AUTO_INCREMENT, uuid VARCHAR(100), game INT(5), kills INT(5), deaths INT(5), damageDealt DOUBLE, damageReceived DOUBLE, bedsDestroyed INT(5), blocksPlaced INT(5), blocksDestroyed INT(5), spentBronze INT(5), spentIron INT(5), spentGold INT(5), playedTime BIGINT(5))");
    }

    public static void createStats(UUID uuid, int game, int kills, int deaths, double damageDealt, double damageReceived, int bedsDestroyed, int blocksPlaced, int blocksDestroyed, int spentBronze, int spentIron, int spentGold, long playedTime){
        MySQL.update("INSERT INTO bedwars_stats (uuid, game, kills, deaths, damageDealt, damageReceived, bedsDestroyed, blocksPlaced, blocksDestroyed, spentBronze, spentIron, spentGold, playedTime) VALUES ('" + uuid + "', '" + game + "', '" + kills + "', '" + deaths + "', '" + damageDealt + "', '" + damageReceived + "', '" + bedsDestroyed + "', '" + blocksPlaced + "', '" + blocksDestroyed + "', '" + spentBronze + "', '" + spentIron+ "', '" + spentGold + "', '" + playedTime + "')");
    }

    public static void deleteStats(int game){
        MySQL.update("DELETE FROM bedwars_stats WHERE game = '" + game + "'");
    }

    public static void deleteStats(UUID uuid){
        MySQL.update("DELETE FROM bedwars_stats WHERE uuid = '" + uuid + "'");
    }
}
