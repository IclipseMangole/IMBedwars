package de.MangoleHD.IMBedwars.Database;

import de.Iclipse.IMAPI.Data;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.Optional;

public class Config {

    public static File getConfigFile(){
        return new File("plugins/" + Data.instance.getDescription().getName(), "config.yml");
    }

    public static FileConfiguration getConfigConfiguration(){
        return YamlConfiguration.loadConfiguration(getConfigFile());
    }

    public static void setStandardConfig(){
        FileConfiguration cfg = getConfigConfiguration();
        cfg.options().copyDefaults(true);
        cfg.addDefault("Location.spawn", new Location(Bukkit.getWorld("world"),0.5,51,0.5));
    }

    public static File getMapFile(){
        return new File("world/" + Data.instance.getDescription().getName(), "map.yml");
    }

    public static FileConfiguration MapConfiguration(){
        return YamlConfiguration.loadConfiguration(getMapFile());
    }

    public static void setMapConfig(){
        FileConfiguration cfg = getConfigConfiguration();
        cfg.options().copyDefaults(true);
        cfg.addDefault("teamsize",4);
        cfg.addDefault("Location.spawn.red", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.spawn.blue", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.spawn.green", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.spawn.yellow", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.bronze.red", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.bronze.blue", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.bronze.green", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.bronze.yellow", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.silver.red", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.silver.blue", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.silver.green", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.silver.yellow", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.gold.1", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.gold.2", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.gold.3", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.gold.4", new Location(Bukkit.getWorld("map"), 0, 0 ,0));
        cfg.addDefault("Location.gold.5", new Location(Bukkit.getWorld("map"), 0, 0 ,0));

    }

}

