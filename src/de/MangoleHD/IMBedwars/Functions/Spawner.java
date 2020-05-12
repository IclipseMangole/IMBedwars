package de.MangoleHD.IMBedwars.Functions;

import de.MangoleHD.IMBedwars.Data;
import org.bukkit.Location;
import org.bukkit.Material;


public class Spawner {

    Material material;
    Location location;
    int spawnsPerMinute;


    public Spawner(Material material, Location location, int spawnsPerMinute){
        this.material = material;
        this.location = location;
        this.spawnsPerMinute = spawnsPerMinute;
        Data.spawners.add(this);
    }

    public Spawner getSpawner(){
        return this;
    }

    public void setSpawner(){
        location.getBlock().setType(material);
    }

    public Location getLocation() {
        return location;
    }

    public Material getMaterial() {
        return material;
    }

    public int getSpawnsPerMinute() {
        return spawnsPerMinute;
    }

    public void setSpawnsPerMinute(int spawnsPerMinute) {
        this.spawnsPerMinute = spawnsPerMinute;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
