package de.MangoleHD.IMBedwars.Database;

import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Functions.Spawner;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;

import java.io.File;

public class MapConfig {

    private File mapFile;
    private FileConfiguration mapFileConfiguration;

    public MapConfig() {
        mapFile = new File("world/", "config.yml");
        mapFileConfiguration = YamlConfiguration.loadConfiguration(mapFile);
        setMapConfig();
        loadMapConfig();
    }

    public File getMapFile() {
        return mapFile;
    }

    public FileConfiguration getMapConfiguration() {
        return mapFileConfiguration;
    }

    public void setMapConfig() {
        FileConfiguration mfg = mapFileConfiguration;
        mfg.options().copyDefaults(true);
        Location loc = new Location(Bukkit.getWorld("bedwarsmap"), 0, 0, 0);

        mfg.addDefault("teamsize", 4);
        mfg.addDefault("teamnumber", 4);
        mfg.addDefault("bronzenumber", 4);
        mfg.addDefault("silvernumber", 4);
        mfg.addDefault("goldnumber", 4);
        mfg.addDefault("spawnIntervalBronze", 1);
        mfg.addDefault("spawnIntervalSilver", 10);
        mfg.addDefault("spawnIntervalGold", 60);
        mfg.addDefault("shopEntityType", EntityType.VILLAGER);
        mfg.addDefault("Location.spawn.0", loc);
        mfg.addDefault("Location.spawn.1", loc);
        mfg.addDefault("Location.bronze.0", loc);
        mfg.addDefault("Location.bronze.1", loc);
        mfg.addDefault("Location.silver.0", loc);
        mfg.addDefault("Location.silver.1", loc);
        mfg.addDefault("Location.gold.0", loc);
        mfg.addDefault("Location.gold.1", loc);
        mfg.addDefault("Location.shop.0", loc);
        mfg.addDefault("Location.shop.1", loc);

    }

    public void loadMapConfig() {
        FileConfiguration mfg = mapFileConfiguration;

        Data.teamsize = mfg.getInt("teamsize");
        Data.teamnumber = mfg.getInt("teamnumber");
        Data.bronzenumber = mfg.getInt("bronzenumber");
        Data.silvernumber = mfg.getInt("silvernumber");
        Data.goldnumber = mfg.getInt("goldnumber");
        Data.spawnIntervalBronze = mfg.getInt("spawnIntervalBronze");
        Data.spawnIntervalSilver = mfg.getInt("spawnIntervalSilver");
        Data.spawnIntervalGold = mfg.getInt("spawnIntervalGold");
        Data.shopEntityType = (EntityType) mfg.get("shopEntityType");

        for (int i = 0; i < Data.teams.size(); i++) {
            Data.respawns.put(Data.teams.get(i), mfg.getLocation(new StringBuilder().append("Location.spawn.").append(i).toString()));
        }

        for (int i = 0; mfg.contains("Location.bronze." + i); i++) {
            new Spawner(Material.BRICK, mfg.getLocation("Location.bronze." + i), Data.spawnIntervalBronze);
        }
        for (int i = 0; mfg.contains("Location.silver." + i); i++) {
            new Spawner(Material.BRICK, mfg.getLocation("Location.silver." + i), Data.spawnIntervalSilver);
        }
        for (int i = 0; mfg.contains("Location.bronze." + i); i++) {
            new Spawner(Material.BRICK, mfg.getLocation("Location.bronze." + i), Data.spawnIntervalBronze);
        }

        /*
        final int[] bronze = {0};
        final int[] silver = {0};
        final int[] gold = {0};
        for(int i = 0;i< Data.spawners.size();i++){
            if(Data.spawners.get(i).getMaterial().equals(Material.TERRACOTTA)){
                Data.spawners.get(i).setLocation(mfg.getLocation(new StringBuilder().append("Location.bronze.").append(bronze[0]).toString()));
                bronze[0] = bronze[0]+1;
            }else if(Data.spawners.get(i).getMaterial().equals(Material.IRON_BLOCK)){
                Data.spawners.get(i).setLocation(mfg.getLocation(new StringBuilder().append("Location.silver.").append(silver[0]).toString()));
                silver[0] = silver[0]+1;
            }else if(Data.spawners.get(i).getMaterial().equals(Material.GOLD_BLOCK)){
                Data.spawners.get(i).setLocation(mfg.getLocation(new StringBuilder().append("Location.gold.").append(gold[0]).toString()));
                gold[0] = gold[0]+1;
            }
        }
         */

        for(int i = 0 ; i < Data.shops.size(); i++){
            Data.shops.get(i).setLocation(mfg.getLocation(new StringBuilder().append("Location.shop.").append(i).toString()));
        }
    }

    public void loadMapLocation(){
        FileConfiguration mfg = mapFileConfiguration;

        for(int i = 0 ; i < Data.teams.size(); i++){
            Data.respawns.get(Data.teams.get(i)).setWorld(Bukkit.getWorld("bedwarsmap"));
        }

       for(int i = 0;i< Data.spawners.size();i++){
           Data.spawners.get(i).getLocation().setWorld(Bukkit.getWorld("bedwarsmap"));
       }

        for(int i = 0 ; i < Data.shops.size(); i++){
            Data.shops.get(i).getLocation().setWorld(Bukkit.getWorld("bedwarsmap"));
        }

    }
}
