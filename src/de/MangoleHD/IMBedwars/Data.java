package de.MangoleHD.IMBedwars;

import com.mysql.fabric.xmlrpc.base.Array;
import de.Iclipse.IMAPI.Util.Dispatching.Dispatcher;
import de.MangoleHD.IMBedwars.Functions.Bed;
import de.MangoleHD.IMBedwars.Functions.GameStates.GameState;
import de.MangoleHD.IMBedwars.Functions.HUD.Tablist;
import de.MangoleHD.IMBedwars.Functions.LastDamage;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.Team;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.User;
import de.MangoleHD.IMBedwars.Functions.Scheduler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
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
    public static int defaultcountdown = 100;
    public static int countdown = defaultcountdown;
    public static int teamsize = 1;
    public static int minplayers = teamsize + 1;
    public static Date start;
    public static ArrayList<Team> teams = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Bed> beds;
    public static ArrayList<Block> placedBlocks;
    public static HashMap<Player, LastDamage.LastDamager> lastDamager = new HashMap<>();
    public static HashMap<Team, Location> respawns;
    public static Location spawn;

}
