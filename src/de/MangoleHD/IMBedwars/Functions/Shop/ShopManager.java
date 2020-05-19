package de.MangoleHD.IMBedwars.Functions.Shop;

import de.MangoleHD.IMBedwars.Data;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

public class ShopManager {

    public static void createShops(){
        Location loc = new Location(Bukkit.getWorld("map"), 0 , 0 ,0);

        for(int i = 0; i < Data.teamnumber; i++){
            new Shop(loc, Data.shopEntityType);
        }
    }
}
