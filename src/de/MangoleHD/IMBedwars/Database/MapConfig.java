package de.MangoleHD.IMBedwars.Database;

import de.MangoleHD.IMBedwars.Data;
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
        mapFile = new File("world/" + Data.instance.getDescription().getName(), "config.yml");
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
        Location loc = new Location(Bukkit.getWorld("world"),0,0,0);

        mfg.addDefault("teamsize", 4);
        mfg.addDefault("teamnumber",4);
        mfg.addDefault("bronzenumber",4);
        mfg.addDefault("silvernumber",4);
        mfg.addDefault("goldnumber", 4);
        mfg.addDefault("perMinuteBronze", 60);
        mfg.addDefault("perMinuteSilver", 6);
        mfg.addDefault("perMinuteGold", 1);
        mfg.addDefault("shopEntityType", EntityType.VILLAGER);
        mfg.addDefault("Location.spawn.0", loc);
        mfg.addDefault("Location.spawn.1", loc);
        mfg.addDefault("Location.spawn.2", loc);
        mfg.addDefault("Location.spawn.3", loc);
        mfg.addDefault("Location.spawn.4", loc);
        mfg.addDefault("Location.spawn.5", loc);
        mfg.addDefault("Location.spawn.6", loc);
        mfg.addDefault("Location.spawn.7", loc);
        mfg.addDefault("Location.spawn.8", loc);
        mfg.addDefault("Location.spawn.9", loc);
        mfg.addDefault("Location.spawn.10", loc);
        mfg.addDefault("Location.spawn.11", loc);
        mfg.addDefault("Location.spawn.12", loc);
        mfg.addDefault("Location.spawn.13", loc);
        mfg.addDefault("Location.spawn.14", loc);
        mfg.addDefault("Location.spawn.15", loc);
        mfg.addDefault("Location.bronze.0", loc);
        mfg.addDefault("Location.bronze.1", loc);
        mfg.addDefault("Location.bronze.2", loc);
        mfg.addDefault("Location.bronze.3", loc);
        mfg.addDefault("Location.bronze.4", loc);
        mfg.addDefault("Location.bronze.5", loc);
        mfg.addDefault("Location.bronze.6", loc);
        mfg.addDefault("Location.bronze.7", loc);
        mfg.addDefault("Location.bronze.8", loc);
        mfg.addDefault("Location.bronze.9", loc);
        mfg.addDefault("Location.bronze.10", loc);
        mfg.addDefault("Location.bronze.11", loc);
        mfg.addDefault("Location.bronze.12", loc);
        mfg.addDefault("Location.bronze.13", loc);
        mfg.addDefault("Location.bronze.14", loc);
        mfg.addDefault("Location.bronze.15", loc);
        mfg.addDefault("Location.silver.0", loc);
        mfg.addDefault("Location.silver.1", loc);
        mfg.addDefault("Location.silver.2", loc);
        mfg.addDefault("Location.silver.3", loc);
        mfg.addDefault("Location.silver.4", loc);
        mfg.addDefault("Location.silver.5", loc);
        mfg.addDefault("Location.silver.6", loc);
        mfg.addDefault("Location.silver.7", loc);
        mfg.addDefault("Location.silver.8", loc);
        mfg.addDefault("Location.silver.9", loc);
        mfg.addDefault("Location.silver.10", loc);
        mfg.addDefault("Location.silver.11", loc);
        mfg.addDefault("Location.silver.12", loc);
        mfg.addDefault("Location.silver.13", loc);
        mfg.addDefault("Location.silver.14", loc);
        mfg.addDefault("Location.silver.15", loc);
        mfg.addDefault("Location.gold.0", loc);
        mfg.addDefault("Location.gold.1", loc);
        mfg.addDefault("Location.gold.2", loc);
        mfg.addDefault("Location.gold.3", loc);
        mfg.addDefault("Location.gold.4", loc);
        mfg.addDefault("Location.gold.5", loc);
        mfg.addDefault("Location.gold.6", loc);
        mfg.addDefault("Location.gold.7", loc);
        mfg.addDefault("Location.gold.8", loc);
        mfg.addDefault("Location.gold.9", loc);
        mfg.addDefault("Location.gold.10", loc);
        mfg.addDefault("Location.gold.11", loc);
        mfg.addDefault("Location.gold.12", loc);
        mfg.addDefault("Location.gold.13", loc);
        mfg.addDefault("Location.gold.14", loc);
        mfg.addDefault("Location.gold.15", loc);
        mfg.addDefault("Location.gold.16", loc);
        mfg.addDefault("Location.gold.17", loc);
        mfg.addDefault("Location.gold.18", loc);
        mfg.addDefault("Location.gold.19", loc);
        mfg.addDefault("Location.shop.0", loc);
        mfg.addDefault("Location.shop.1", loc);
        mfg.addDefault("Location.shop.2", loc);
        mfg.addDefault("Location.shop.3", loc);
        mfg.addDefault("Location.shop.4", loc);
        mfg.addDefault("Location.shop.5", loc);
        mfg.addDefault("Location.shop.6", loc);
        mfg.addDefault("Location.shop.7", loc);
        mfg.addDefault("Location.shop.8", loc);
        mfg.addDefault("Location.shop.9", loc);
        mfg.addDefault("Location.shop.10", loc);
        mfg.addDefault("Location.shop.11", loc);
        mfg.addDefault("Location.shop.12", loc);
        mfg.addDefault("Location.shop.13", loc);
        mfg.addDefault("Location.shop.14", loc);
        mfg.addDefault("Location.shop.15", loc);

    }

    public void loadMapConfig() {
        FileConfiguration mfg = mapFileConfiguration;

        Data.teamsize = mfg.getInt("teamsize");
        Data.teamnumber = mfg.getInt("teamnumber");
        Data.bronzenumber = mfg.getInt("bronzenumber");
        Data.silvernumber = mfg.getInt("silvernumber");
        Data.goldnumber = mfg.getInt("goldnumber");
        Data.perMinuteBronze = mfg.getInt("perMinuteBronze");
        Data.perMinuteSilver = mfg.getInt("perMinuteSilver");
        Data.perMinuteGold = mfg.getInt("perMinuteGold");
        Data.shopEntityType = (EntityType) mfg.get("shopEntityType");

        for(int i = 0 ; i < Data.teams.size(); i++){
            Data.respawns.put(Data.teams.get(i), mfg.getLocation(new StringBuilder().append("Location.spawn.").append(i).toString()));
        }

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

        for(int i = 0 ; i < Data.shops.size(); i++){
            Data.shops.get(i).setLocation(mfg.getLocation(new StringBuilder().append("Location.shop.").append(i).toString()));
        }
    }

    public void loadMapLocation(){
        FileConfiguration mfg = mapFileConfiguration;

        for(int i = 0 ; i < Data.teams.size(); i++){
            Data.respawns.get(Data.teams.get(i)).setWorld(Bukkit.getWorld("world"));
        }

        final int[] bronze = {0};
        final int[] silver = {0};
        final int[] gold = {0};
       for(int i = 0;i< Data.spawners.size();i++){
           Data.spawners.get(i).getLocation().setWorld(Bukkit.getWorld("world"));
       }

        for(int i = 0 ; i < Data.shops.size(); i++){
            Data.shops.get(i).getLocation().setWorld(Bukkit.getWorld("world"));
        }

    }
}
