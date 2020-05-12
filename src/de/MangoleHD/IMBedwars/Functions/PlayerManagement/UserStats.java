package de.MangoleHD.IMBedwars.Functions.PlayerManagement;

import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Functions.Bed;
import de.MangoleHD.IMBedwars.Functions.GameStates.GameState;
import de.MangoleHD.IMBedwars.Functions.GameStates.Running;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class UserStats implements Listener {

    @EventHandler
    public void onDamageReceive(EntityDamageEvent event){
        if(Data.state == GameState.Running) {
            if (event.getEntity() instanceof Player) {
                User user = User.getUser(((Player) event.getEntity()).getPlayer());
                user.setDamageReceived(user.getDamageReceived() + event.getDamage());
            }
        }
    }

    @EventHandler
    public void onDamageDeal(EntityDamageByEntityEvent event) {
        if (Data.state == GameState.Running) {
            if (event.getDamager() instanceof Player) {
                if (event.getEntity() instanceof Player) {
                    User user = User.getUser((Player) event.getDamager());
                    user.setDamageDealt(user.getDamageDealt() + event.getDamage());
                }
            }
        }
    }

    @EventHandler
    public void onKill(PlayerDeathEvent event){
        if(Data.state == GameState.Running){
            User user = User.getUser(event.getEntity());
            user.setDeaths(user.getDeaths() + 1);
            if(event.getEntity().getLastDamageCause().getEntity() instanceof Player){
                if (System.currentTimeMillis() < Data.lastDamager.get(user.getPlayer()).getLastDamageTime() + 10000) {
                    Player killer = Data.lastDamager.get(user.getPlayer()).getLastDamager();
                    User k = User.getUser(killer);
                    k.setKills(k.getKills() + 1);
                }
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(Data.state == GameState.Running){
            if(!event.getBlock().getType().toString().endsWith("BED")) {
                if (Data.placedBlocks.contains(event.getBlock())) {
                    User user = User.getUser(event.getPlayer());
                    user.setBlocksDestroyed(user.getBlocksDestroyed() + 1);
                    Data.placedBlocks.remove(event.getBlock());
                } else {
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        if(Data.state == GameState.Running){
            User user = User.getUser(event.getPlayer());
            user.setBlocksPlaced(user.getBlocksPlaced() + 1);
            Data.placedBlocks.add(event.getBlock());
        }
    }

    @EventHandler
    public void onBedBreak(BlockBreakEvent event){
        if(Data.state == GameState.Running) {
            if (event.getBlock().getType().toString().endsWith("BED")) {
                User user = User.getUser(event.getPlayer());
                Block bedblock = event.getBlock();
                for(Bed bed : Data.beds){
                    if(bed.getBedfoot().equals(bedblock.getLocation()) || bed.getBedhead().equals(bedblock.getLocation())){
                        if(bed.getBedcolor().equals(user.getTeam().getTeamColor())){
                            event.setCancelled(true);
                            Data.dsp.send(event.getPlayer(), "bed.destroy.allie");
                        }else{
                            Data.dsp.send(event.getPlayer(), "bed.destroy.enemy");
                            Running.playerDestroyBed(bed);
                            user.setBedsDestroyed(user.getBedsDestroyed() + 1);
                        }
                    }
                }
            }
        }
    }
}
