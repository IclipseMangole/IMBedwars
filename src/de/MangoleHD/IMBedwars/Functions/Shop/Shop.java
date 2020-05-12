package de.MangoleHD.IMBedwars.Functions.Shop;


import de.MangoleHD.IMBedwars.Data;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;



public class Shop {

    Location location;
    EntityType entityType;

    public Shop(Location location, EntityType entityType){
        this.location = location;
        this.entityType = entityType;
        Data.shops.add(this);
    }

    public Shop getShop(){
        return this;
    }

    public void spawnShop(){
        Bukkit.getWorld("world").spawnEntity(location, entityType);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public Location getLocation() {
        return location;
    }
}
