package de.MangoleHD.IMBedwars.Functions;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;


public class Spawner {

    Material material;
    Location location;

    public Spawner(Material material, Location location){
        this.material = material;
        this.location = location;
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

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
