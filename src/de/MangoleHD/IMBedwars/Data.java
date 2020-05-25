package de.MangoleHD.IMBedwars;

import de.Iclipse.IMAPI.Util.Dispatching.Dispatcher;
import de.MangoleHD.IMBedwars.Database.Config;
import de.MangoleHD.IMBedwars.Database.MapConfig;
import de.MangoleHD.IMBedwars.Functions.Bed;
import de.MangoleHD.IMBedwars.Functions.GameStates.GameState;
import de.MangoleHD.IMBedwars.Functions.HUD.Tablist;
import de.MangoleHD.IMBedwars.Functions.LastDamage;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.Team;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.User;
import de.MangoleHD.IMBedwars.Functions.Scheduler;
import de.MangoleHD.IMBedwars.Functions.Shop.Shop;
import de.MangoleHD.IMBedwars.Functions.Spawner;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Data {

    public static Plugin instance;
    public static Scheduler scheduler;
    public static Dispatcher dsp;
    public static ResourceBundle langDE;
    public static ResourceBundle langEN;
    public static GameState state;
    public static Tablist tablist;
    public static int lobbycountdown = 100;
    public static int countdown = lobbycountdown;
    public static int teamsize;
    public static int teamnumber;
    public static int bronzenumber;
    public static int silvernumber;
    public static int goldnumber;
    public static int spawnIntervalBronze;
    public static int spawnIntervalSilver;
    public static int spawnIntervalGold;
    public static EntityType shopEntityType;
    public static int minplayers = teamsize + 1;
    public static Date start;
    public static ArrayList<Team> teams = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Bed> beds = new ArrayList<>();
    public static ArrayList<Spawner> spawners = new ArrayList<>();
    public static ArrayList<Block> placedBlocks = new ArrayList<>();
    public static ArrayList<Shop> shops = new ArrayList<>();
    public static ArrayList<String> popupmenus = new ArrayList<>();
    public static HashMap<Player, LastDamage.LastDamager> lastDamager = new HashMap<>();
    public static Location spawn;
    public static MapConfig mapConfig;
    public static Config config;
    public static HashMap<Team, Location> respawns = new HashMap<>();

}
