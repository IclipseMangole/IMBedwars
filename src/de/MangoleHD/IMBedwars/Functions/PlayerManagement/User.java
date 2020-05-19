package de.MangoleHD.IMBedwars.Functions.PlayerManagement;

import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Database.BedwarsStats;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private Player player;
    private int kills;
    private int deaths;
    private double damageDealt;
    private double damageReceived;
    private int bedsDestroyed;
    private int blocksPlaced;
    private int blocksDestroyed;
    private int spentBronze;
    private int spentIron;
    private int spentGold;
    private long finished;

    public User(Player player){
        this.player = player;
        kills = 0;
        deaths = 0;
        damageDealt = 0;
        damageReceived = 0;
        bedsDestroyed = 0;
        blocksPlaced = 0;
        blocksDestroyed = 0;
        spentBronze = 0;
        spentIron = 0;
        spentGold = 0;
        finished = 0;
        Data.users.add(this);
    }

    public static User getUser(Player player){
        for(User user : Data.users){
            if(user.getPlayer().equals(player)){
                return user;
            }
        }
        return null;
    }

    public Player getPlayer(){
        return player;
    }

    public int getKills(){
        return kills;
    }

    public int getDeaths(){
        return deaths;
    }

    public double getDamageDealt(){
        return damageDealt;
    }

    public double getDamageReceived(){
        return damageReceived;
    }

    public int getBedsDestroyed(){
        return bedsDestroyed;
    }

    public int getBlocksPlaced(){
        return blocksPlaced;
    }

    public int getBlocksDestroyed(){
        return blocksDestroyed;
    }

    public int getSpentBronze() {
        return spentBronze;
    }

    public int getSpentIron() {
        return spentIron;
    }

    public int getSpentGold() {
        return spentGold;
    }

    public long getFinished(){
        return finished;
    }

    public void setKills(int kills){
        this.kills = kills;
    }

    public void setDeaths(int deaths){
         this.deaths = deaths;
    }

    public void setDamageDealt(double damageDealt){
        this.damageDealt = damageDealt;
    }

    public void setDamageReceived(double damageReceived){
        this.damageReceived = damageReceived;
    }

    public void setBedsDestroyed(int bedsDestroyed){
        this.bedsDestroyed = bedsDestroyed;
    }

    public void setBlocksPlaced(int blocksPlaced){
        this.blocksPlaced = blocksPlaced;
    }

    public void setBlocksDestroyed(int blocksDestroyed){
        this.blocksDestroyed = blocksDestroyed;
    }

    public void setSpentBronze(int spentBronze) {
        this.spentBronze = spentBronze;
    }

    public void setSpentIron(int spentIron) {
        this.spentIron = spentIron;
    }

    public void setSpentGold(int spentGold) {
        this.spentGold = spentGold;
    }

    public void setFinished(long finished){
        this.finished = finished;
    }

    public boolean isAlive(){
        return finished == 0;
    }

    public Team getTeam(){
        ArrayList<Team> teams =  Data.teams;
        for(int i = 0; i < teams.size(); i++){
            Team team = teams.get(i);
            if(team.isMember(this)){
                return team;
            }
        }
        return null;
    }

    public boolean isInATeam() {
        for (Team team : Data.teams) {
            if (team.isMember(this)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasLivingMates() {
        if (getTeam() != null) {
            if (!isAlive()) {
                return getTeam().getAlive() > 0;
            } else {
                return getTeam().getAlive() > 1;
            }
        }
        return false;
    }

    public void saveStats(int gameID){
        BedwarsStats.createStats(UUIDFetcher.getUUID(player.getName()), gameID, kills, deaths, damageDealt, damageReceived, bedsDestroyed, blocksPlaced, blocksDestroyed, spentBronze, spentIron, spentGold, finished);
    }
}
