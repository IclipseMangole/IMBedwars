package de.MangoleHD.IMBedwars.Functions.PlayerManagement;

import de.MangoleHD.IMBedwars.Data;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static de.MangoleHD.IMBedwars.Data.*;
import static de.MangoleHD.IMBedwars.Functions.HUD.Tablist.scoreboard;

public class Team {
    private int id;
    private org.bukkit.scoreboard.Team team;
    private ArrayList<User> users;
    private ChatColor color;
    private Material material;

    public Team(ChatColor color, Material material){
        this.id = Data.teams.size();
        team = scoreboard.getTeam("Team" + id) == null ? scoreboard.registerNewTeam("Team" + id) : scoreboard.getTeam("Team" + id);
        this.color = color;
        team.setAllowFriendlyFire(false);
        this.users = new ArrayList<>();
        this.material = material;
        Data.teams.add(this);
    }

    public int getId(){
        return id;
    }

    public ChatColor getColor(){
        return color;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public ArrayList<User> getAlives() {
        ArrayList<User> list = new ArrayList<>();
        users.forEach(entry -> {
            if (entry.isAlive()) {
                list.add(entry);
            }
        });
        return list;
    }

    public Material getMaterial(){
        return material;
    }

    public org.bukkit.scoreboard.Team getTeam() {
        return team;
    }

    public void setColor(ChatColor color){
        this.color = color;
    }

    public void setMaterial(Material material){
        this.material = material;
    }

    public void setUsers(ArrayList<User> users){
        this.users = users;
    }

    public void removeUser(User u) {
        users.remove(u);
    }

    public void addUser(User u) {
        if (u.getTeam() != null) {
            u.getTeam().removeUser(u);
        }
        users.add(u);
        scoreboard.getTeams().forEach(entry -> {
            entry.removeEntry(u.getPlayer().getName());
        });
        team.addEntry(u.getPlayer().getName());
        tablist.updatePlayer(u.getPlayer());
        dsp.send(u.getPlayer(), "team.changed", this.getColor() + "Team " + dsp.get("color." + this.getColor().asBungee().getName(), u.getPlayer()));
    }

    public boolean isMember(User user){
        return users.contains(user);
    }

    public int getAlive() {
        final int[] alive = {0};
        users.forEach(user -> {
            if (user.isAlive()) {
                alive[0]++;
            }
        });
        return alive[0];
    }

    public ItemStack getTeamItem(Player p) {
        ItemStack item = new ItemStack(this.getMaterial());
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(this.getColor() + "Team " + dsp.get("color." + this.getColor().asBungee().getName(), p) + "§7(" + this.getUsers().size() + "|" + teamsize + ")");
        List<String> lores = new ArrayList<>();
        lores.add("");
        for (int i = 0; i < teamsize; i++) {
            String spielername;
            if (this.getUsers().size() > i) {
                spielername = this.getUsers().get(i).getPlayer().getDisplayName();
            } else {
                spielername = "-";
            }
            lores.add("§7» " + spielername);
        }
        lores.add("");
        lores.add(dsp.get("color.click", p, this.getColor() + "Team " + dsp.get("color." + this.getColor().asBungee().getName(), p)));
        meta.setLore(lores);
        this.getUsers().forEach(entry -> {
            if (entry.getPlayer().equals(p)) {
                meta.addEnchant(Enchantment.LUCK, 1, false);
            }
        });
        item.setItemMeta(meta);
        return item;
    }

    public Color getTeamColor(){
        if(this.getColor().toString().equals("RED")){
            return Color.RED;
        }else if(this.getColor().toString().equals("BLUE")){
            return Color.BLUE;
        }else if(this.getColor().toString().equals("GREEN")){
            return Color.GREEN;
        }else if(this.getColor().toString().equals("YELLOW")){
            return Color.YELLOW;
        }else {
            return null;
        }
    }
}
