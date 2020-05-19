package de.MangoleHD.IMBedwars;

import de.Iclipse.IMAPI.Database.Server;
import de.Iclipse.IMAPI.Functions.Servers.State;
import de.Iclipse.IMAPI.IMAPI;
import de.Iclipse.IMAPI.Util.Dispatching.Dispatcher;
import de.MangoleHD.IMBedwars.Database.Config;
import de.MangoleHD.IMBedwars.Database.MapConfig;
import de.MangoleHD.IMBedwars.Functions.GameStates.Finish;
import de.MangoleHD.IMBedwars.Functions.GameStates.GameState;
import de.MangoleHD.IMBedwars.Functions.GameStates.Lobby;
import de.MangoleHD.IMBedwars.Functions.GameStates.Running;
import de.MangoleHD.IMBedwars.Functions.HUD.Tablist;
import de.MangoleHD.IMBedwars.Functions.LastDamage;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.TeamManager;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.UserStats;
import de.MangoleHD.IMBedwars.Functions.Scheduler;
import de.MangoleHD.IMBedwars.Functions.Shop.ShopItemList;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.*;

import static de.Iclipse.IMAPI.IMAPI.*;
import static de.MangoleHD.IMBedwars.Data.*;
import static de.MangoleHD.IMBedwars.Database.BedwarsGames.createBedwarsGamesTable;
import static de.MangoleHD.IMBedwars.Database.BedwarsStats.createBedwarsStatsTable;

public class Main extends JavaPlugin {

    @Override
    public void onLoad(){
        super.onLoad();
        Data.instance = this;
        config = new Config();
        loadLobby();
    }

    @Override
    public void onEnable(){
        super.onEnable();
        mapConfig = new MapConfig();
        registerListener();
        registerCommands();
        createTables();
        loadResourceBundles();
        Data.state = GameState.Lobby;
        tablist = new Tablist();
        Data.scheduler = new Scheduler();
        scheduler.setTask();
        scheduler.setAsynctask();
        TeamManager.createTeams();
        Server.setState(getServerName(), State.Lobby);
        ShopItemList.createShopItemList();
        config.loadConfigLocation();
        loadMap();
    }

    @Override
    public void onDisable(){
        super.onDisable();
        scheduler.stopTask();
        scheduler.stopAsyncTask();
    }

    public void registerListener(){
        IMAPI.register(new Lobby(), this);
        IMAPI.register(new LastDamage(), this);
        IMAPI.register(new UserStats(), this);
        IMAPI.register(new Running(), this);
        IMAPI.register(new Finish(), this);
    }

    public void registerCommands(){

    }

    public void createTables(){
        createBedwarsGamesTable();
        createBedwarsStatsTable();
    }

    public void loadLobby(){
        if (new File(Bukkit.getWorldContainer().getAbsolutePath() + "/world").exists()) {
            deleteFile(new File(Bukkit.getWorldContainer().getAbsolutePath() + "/world"));
        }
        File from = new File("/home/IMNetzwerk/BuildServer/BedwarsLobby_world/region");
        File to = new File(Data.instance.getDataFolder().getAbsoluteFile().getParentFile().getParentFile().getAbsolutePath() + "/world/region");
        if (to.exists()) {
            to.delete();
        }
        try {
            copyFilesInDirectory(from, to);
            Files.copy(new File("/home/IMNetzwerk/BuildServer/BedwarsLobby_world/level.dat").toPath(), new File(Data.instance.getDataFolder().getAbsoluteFile().getParentFile().getParentFile().getAbsolutePath() + "/world/level.dat").toPath(), StandardCopyOption.REPLACE_EXISTING);
            copyFilesInDirectory(new File("/home/IMNetzwerk/BuildServer/BedwarsLobby_world/maps"), new File(Data.instance.getDataFolder().getAbsoluteFile().getParentFile().getParentFile().getAbsolutePath() + "/world/maps"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(){
        if (new File(Bukkit.getWorldContainer().getAbsolutePath() + "/BedwarsMap").exists()) {
            deleteFile(new File(Bukkit.getWorldContainer().getAbsolutePath() + "/BedwarsMap"));
        }

        File bedwarsMaps = new File(instance.getDataFolder().getAbsoluteFile().getParentFile().getAbsoluteFile().getParentFile().getAbsolutePath() + "Worlds/BedwarsMaps");
        File[] maps;
        maps = bedwarsMaps.listFiles();
        Random random = new Random();
        int i = random.nextInt(maps.length - 1);

        if(maps[i] != null) {
            File mapFile = maps[i];

            File mapRegionFrom = new File(mapFile.getAbsolutePath() + "/region");
            File to = new File(Data.instance.getDataFolder().getAbsoluteFile().getParentFile().getParentFile().getAbsolutePath() + "/BedwarsMap/region");
            if (to.exists()) {
                to.delete();
            }
            try {
                copyFilesInDirectory(mapRegionFrom, to);
                Files.copy(new File(mapFile.toPath() + "/level.dat").toPath(), new File(Data.instance.getDataFolder().getAbsoluteFile().getParentFile().getParentFile().getAbsolutePath() + "/BedwarsMap/level.dat").toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadResourceBundles() {
        try {
            HashMap<String, ResourceBundle> langs = new HashMap<>();
            langDE = ResourceBundle.getBundle("i18n.langDE");
            langEN = ResourceBundle.getBundle("i18n.langEN");
            langs.put("DE", langDE);
            langs.put("EN", langEN);
            Data.dsp = new Dispatcher(this,
                    langs);
        } catch (MissingResourceException e) {
            e.printStackTrace();
            de.Iclipse.IMAPI.Data.dispatching = false;
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Reload oder Bundle not found!");
            de.Iclipse.IMAPI.Data.dispatching = false;
        }
    }
}
