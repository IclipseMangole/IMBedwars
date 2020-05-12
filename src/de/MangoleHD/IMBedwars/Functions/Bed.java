package de.MangoleHD.IMBedwars.Functions;

import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.Team;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Bed {

    Color bedcolor;
    Location bedfoot;
    Location bedhead;
    Team bedteam;

    public Bed(Team bedteam, Location bedfoot, Location bedhead) {
        this.bedteam = bedteam;
        this.bedfoot = bedfoot;
        this.bedhead = bedhead;
        this.bedcolor = bedteam.getTeamColor();
        Data.beds.add(this);
    }

    public Color getBedcolor(){
        return bedcolor;
    }

    public Location getBedfoot(){
        return bedfoot;
    }

    public Location getBedhead(){
        return bedhead;
    }

    public Team getBedteam(){
        return bedteam;
    }

}
