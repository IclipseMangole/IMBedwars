package de.MangoleHD.IMBedwars.Functions.GameStates;

import de.Iclipse.IMAPI.Database.UserSettings;
import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.Team;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.User;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static de.MangoleHD.IMBedwars.Data.spawn;
import static de.MangoleHD.IMBedwars.Data.tablist;

public class Lobby implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (Data.state == GameState.Lobby) {
            Player player = event.getPlayer();
            LobbyInventory(player);
            tablist.setTablist(player);
            if (!UserSettings.getBoolean(UUIDFetcher.getUUID(player.getName()), "vanish")) {
                event.setJoinMessage(null);
                Bukkit.getOnlinePlayers().forEach(entry -> {
                    if (!entry.equals(player)) {
                        Data.dsp.send(entry, "lobby.join", player.getDisplayName());
                    }
                });
                Data.dsp.send(Bukkit.getConsoleSender(), "lobby.join", player.getDisplayName());
                new User(player);
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (Data.state == GameState.Lobby) {
                if(event.getCause().equals(EntityDamageEvent.DamageCause.VOID)){
                    event.setDamage(0);
                    player.setHealth(20);
                    player.teleport(spawn);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1,1);
                }else{
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onStarve(FoodLevelChangeEvent event) {
        if (Data.state == GameState.Lobby) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (Data.state == GameState.Lobby) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (Data.state == GameState.Lobby) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.DEFAULT) || event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL)) {
            if (Data.state == GameState.Lobby) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (Data.state == GameState.Lobby) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        if (Data.state == GameState.Lobby) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryDrop(PlayerDropItemEvent event) {
        if (Data.state == GameState.Lobby) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onClickBed(PlayerInteractEvent event) {
        if (Data.state == GameState.Lobby) {
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                if (event.getItem().getType().toString().contains("BED")) {
                    openTeamMenu(event.getPlayer());
                    event.setCancelled(true);
                }
            }
        }
    }

    public void openTeamMenu(Player player) {
        PopupMenu Teams = new PopupMenu("Teams", 3);

        MenuItem tnt = new MenuItem(new ItemStack(Material.TNT)) {
            @Override
            public void onClick(Player player) {
                Location loc = player.getLocation();
                loc.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, loc, 3);
            }
        };
        MenuItem red_bed = new MenuItem(new ItemStack(Material.RED_BED)) {
            @Override
            public void onClick(Player player) {
                User user = User.getUser(player);
                for (Team team : Data.teams) {
                    if (team.getMaterial().equals(Material.RED_BED)) {
                        team.addUser(user);
                    }
                }
            }
        };
        MenuItem blue_bed = new MenuItem(new ItemStack(Material.BLUE_BED)) {
            @Override
            public void onClick(Player player) {
                User user = User.getUser(player);
                for (Team team : Data.teams) {
                    if (team.getMaterial().equals(Material.BLUE_BED)) {
                        team.addUser(user);
                    }
                }
            }
        };
        MenuItem green_bed = new MenuItem(new ItemStack(Material.GREEN_BED)) {
            @Override
            public void onClick(Player player) {
                User user = User.getUser(player);
                for (Team team : Data.teams) {
                    if (team.getMaterial().equals(Material.GREEN_BED)) {
                        team.addUser(user);
                    }
                }
            }
        };
        MenuItem yellow_bed = new MenuItem(new ItemStack(Material.YELLOW_BED)) {
            @Override
            public void onClick(Player player) {
                User user = User.getUser(player);
                for (Team team : Data.teams) {
                    if (team.getMaterial().equals(Material.YELLOW_BED)) {
                        team.addUser(user);
                    }
                }
            }
        };

        Teams.addMenuItem(red_bed, 1, 1);
        Teams.addMenuItem(blue_bed, 1, 3);
        Teams.addMenuItem(green_bed, 1, 5);
        Teams.addMenuItem(yellow_bed, 1, 7);
        for (int i = 0; i < 8; i++) {
            Teams.addMenuItem(tnt, i);
        }
        for (int i = 11; i < 17; i = i + 2) {
            Teams.addMenuItem(tnt, i);
        }
        for (int i = 18; i < 26; i++) {
            Teams.addMenuItem(tnt, i);
        }

        Teams.openMenu(player);
    }

    public void LobbyInventory(Player player) {
        Inventory inventory = player.getInventory();
        inventory.clear();
        player.setGameMode(GameMode.SURVIVAL);
        player.setHealth(20);
        player.getActivePotionEffects().clear();
        player.setAllowFlight(false);
        inventory.setItem(0, new ItemStack(Material.RED_BED));
    }
}
