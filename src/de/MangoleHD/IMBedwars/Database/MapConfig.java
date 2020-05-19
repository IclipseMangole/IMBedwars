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
        mapFile = new File("world/" + Data.instance.getDescription().getName(), "map.yml");
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
        FileConfiguration cfg = mapFileConfiguration;
        cfg.options().copyDefaults(true);
        Location loc = new Location(Bukkit.getWorld("map"),0,0,0);

        cfg.addDefault("teamsize", 4);
        cfg.addDefault("teamnumber",4);
        cfg.addDefault("bronzenumber",4);
        cfg.addDefault("silvernumber",4);
        cfg.addDefault("goldnumber", 4);
        cfg.addDefault("perMinuteBronze", 60);
        cfg.addDefault("perMinuteSilver", 6);
        cfg.addDefault("perMinuteGold", 1);
        cfg.addDefault("shopEntityType", EntityType.VILLAGER);
        cfg.addDefault("Location.spawn.0", loc);
        cfg.addDefault("Location.spawn.1", loc);
        cfg.addDefault("Location.spawn.2", loc);
        cfg.addDefault("Location.spawn.3", loc);
        cfg.addDefault("Location.spawn.4", loc);
        cfg.addDefault("Location.spawn.5", loc);
        cfg.addDefault("Location.spawn.6", loc);
        cfg.addDefault("Location.spawn.7", loc);
        cfg.addDefault("Location.spawn.8", loc);
        cfg.addDefault("Location.spawn.9", loc);
        cfg.addDefault("Location.spawn.10", loc);
        cfg.addDefault("Location.spawn.11", loc);
        cfg.addDefault("Location.spawn.12", loc);
        cfg.addDefault("Location.spawn.13", loc);
        cfg.addDefault("Location.spawn.14", loc);
        cfg.addDefault("Location.spawn.15", loc);
        cfg.addDefault("Location.bronze.0", loc);
        cfg.addDefault("Location.bronze.1", loc);
        cfg.addDefault("Location.bronze.2", loc);
        cfg.addDefault("Location.bronze.3", loc);
        cfg.addDefault("Location.bronze.4", loc);
        cfg.addDefault("Location.bronze.5", loc);
        cfg.addDefault("Location.bronze.6", loc);
        cfg.addDefault("Location.bronze.7", loc);
        cfg.addDefault("Location.bronze.8", loc);
        cfg.addDefault("Location.bronze.9", loc);
        cfg.addDefault("Location.bronze.10", loc);
        cfg.addDefault("Location.bronze.11", loc);
        cfg.addDefault("Location.bronze.12", loc);
        cfg.addDefault("Location.bronze.13", loc);
        cfg.addDefault("Location.bronze.14", loc);
        cfg.addDefault("Location.bronze.15", loc);
        cfg.addDefault("Location.silver.0", loc);
        cfg.addDefault("Location.silver.1", loc);
        cfg.addDefault("Location.silver.2", loc);
        cfg.addDefault("Location.silver.3", loc);
        cfg.addDefault("Location.silver.4", loc);
        cfg.addDefault("Location.silver.5", loc);
        cfg.addDefault("Location.silver.6", loc);
        cfg.addDefault("Location.silver.7", loc);
        cfg.addDefault("Location.silver.8", loc);
        cfg.addDefault("Location.silver.9", loc);
        cfg.addDefault("Location.silver.10", loc);
        cfg.addDefault("Location.silver.11", loc);
        cfg.addDefault("Location.silver.12", loc);
        cfg.addDefault("Location.silver.13", loc);
        cfg.addDefault("Location.silver.14", loc);
        cfg.addDefault("Location.silver.15", loc);
        cfg.addDefault("Location.gold.0", loc);
        cfg.addDefault("Location.gold.1", loc);
        cfg.addDefault("Location.gold.2", loc);
        cfg.addDefault("Location.gold.3", loc);
        cfg.addDefault("Location.gold.4", loc);
        cfg.addDefault("Location.gold.5", loc);
        cfg.addDefault("Location.gold.6", loc);
        cfg.addDefault("Location.gold.7", loc);
        cfg.addDefault("Location.gold.8", loc);
        cfg.addDefault("Location.gold.9", loc);
        cfg.addDefault("Location.gold.10", loc);
        cfg.addDefault("Location.gold.11", loc);
        cfg.addDefault("Location.gold.12", loc);
        cfg.addDefault("Location.gold.13", loc);
        cfg.addDefault("Location.gold.14", loc);
        cfg.addDefault("Location.gold.15", loc);
        cfg.addDefault("Location.gold.16", loc);
        cfg.addDefault("Location.gold.17", loc);
        cfg.addDefault("Location.gold.18", loc);
        cfg.addDefault("Location.gold.19", loc);
        cfg.addDefault("Location.shop.0", loc);
        cfg.addDefault("Location.shop.1", loc);
        cfg.addDefault("Location.shop.2", loc);
        cfg.addDefault("Location.shop.3", loc);
        cfg.addDefault("Location.shop.4", loc);
        cfg.addDefault("Location.shop.5", loc);
        cfg.addDefault("Location.shop.6", loc);
        cfg.addDefault("Location.shop.7", loc);
        cfg.addDefault("Location.shop.8", loc);
        cfg.addDefault("Location.shop.9", loc);
        cfg.addDefault("Location.shop.10", loc);
        cfg.addDefault("Location.shop.11", loc);
        cfg.addDefault("Location.shop.12", loc);
        cfg.addDefault("Location.shop.13", loc);
        cfg.addDefault("Location.shop.14", loc);
        cfg.addDefault("Location.shop.15", loc);

    }

    public void loadMapConfig() {
        FileConfiguration cfg = mapFileConfiguration;

        Data.teamsize = cfg.getInt("teamsize");
        Data.teamnumber = cfg.getInt("teamnumber");
        Data.bronzenumber = cfg.getInt("bronzenumber");
        Data.silvernumber = cfg.getInt("silvernumber");
        Data.goldnumber = cfg.getInt("goldnumber");
        Data.perMinuteBronze = cfg.getInt("perMinuteBronze");
        Data.perMinuteSilver = cfg.getInt("perMinuteSilver");
        Data.perMinuteGold = cfg.getInt("perMinuteGold");
        Data.shopEntityType = (EntityType) cfg.get("shopEntityType");
    }

    public void loadMapLocation(){
        FileConfiguration mfg = mapFileConfiguration;

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
}
