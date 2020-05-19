package de.MangoleHD.IMBedwars.Functions;

import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Database.MapConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class SpawnerManager {

    public static void createSpawner(){

        Location loc = new Location(Bukkit.getWorld("map"),0,0,0);

        for(int i = 0; i < Data.bronzenumber; i++){
            new Spawner(Material.TERRACOTTA, loc, Data.perMinuteBronze);
        }
        for(int i = 0; i < Data.silvernumber; i++){
            new Spawner(Material.IRON_BLOCK, loc, Data.perMinuteSilver);

        }
        for(int i = 0; i < Data.goldnumber; i++){
            new Spawner(Material.GOLD_BLOCK, loc, Data.perMinuteGold);
        }
    }
}
