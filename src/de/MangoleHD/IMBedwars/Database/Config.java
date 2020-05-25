package de.MangoleHD.IMBedwars.Database;

import de.MangoleHD.IMBedwars.Data;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;


public class Config {

    private File configFile;
    private FileConfiguration configFileConfiguration;

    public Config() {
        configFile = new File("plugins/" + Data.instance.getDescription().getName(), "config.yml");
        configFileConfiguration = YamlConfiguration.loadConfiguration(configFile);
        setStandardConfig();
        loadConfig();
    }

    public File getConfigFile() {
        return configFile;
    }

    public FileConfiguration getConfigConfiguration() {
        return configFileConfiguration;
    }

    public void setStandardConfig() {
        FileConfiguration cfg = configFileConfiguration;
        cfg.addDefault("Location.spawn", new Location(Bukkit.getWorld("world"), 0.5, 59, -0.5));
        try {
            cfg.save(getConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadConfig() {
        FileConfiguration cfg = configFileConfiguration;

        Data.spawn = cfg.getLocation("Location.spawn");
    }

    public void loadConfigLocation(){
        Data.spawn.setWorld(Bukkit.getWorld("world"));
    }

}

