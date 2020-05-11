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

import static de.MangoleHD.IMBedwars.Data.*;

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
                if (event.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                    event.setDamage(0);
                    player.setHealth(20);
                    player.teleport(spawn);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1, 1);
                } else {
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
        PopupMenu Teams = new PopupMenu("Teams", 5);

        MenuItem tnt = new MenuItem(new ItemStack(Material.TNT)) {
            @Override
            public void onClick(Player player) {
                Location loc = player.getLocation();
                loc.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, loc, 1);
            }
        };
        //4 TEAMS
        if (teams.size() == 4) {

            final int[] i = {19};
            teams.forEach(team -> {

                ItemStack teamItem = team.getTeamItem(player);
                Teams.addMenuItem(new MenuItem(teamItem) {
                    @Override
                    public void onClick(Player player) {
                        User user = User.getUser(player);
                        if(user.getTeam() != null) {
                            if (team.getUsers().contains(user)) {
                                dsp.send(player, "team.join.already");
                            } else if (team.getUsers().size() >= teamsize) {
                                dsp.send(player, "team.join.full");
                            } else {
                                dsp.send(player, "team.join", "" + team.getTeam().getDisplayName());
                                team.addUser(user);
                                Teams.closeMenu(player);
                                Teams.updateMenu();
                                player.getInventory().setItem(0, user.getTeam().getTeamItem(player));
                            }
                        }else{
                            dsp.send(player, "team.join", "" + team.getTeam().getDisplayName());
                            team.addUser(user);
                            Teams.closeMenu(player);
                            Teams.updateMenu();
                            player.getInventory().setItem(0, user.getTeam().getTeamItem(player));
                        }
                    }
                }, i[0]);

                i[0] += 2;
            });

            Teams.fill(Material.TNT);

            //8 TEAMS
        } else if (teams.size() == 8) {

            final int[] i = {8};

            teams.forEach(team -> {

                switch (i[0]) {
                    case 16:
                        i[0] += 8;
                        break;

                    default:
                        i[0] += 2;
                        break;
                }
                    ItemStack teamItem = team.getTeamItem(player);
                    Teams.addMenuItem(new MenuItem(teamItem) {
                        @Override
                        public void onClick(Player player) {
                            User user = User.getUser(player);
                            if (user.getTeam() != null) {
                                if (team.getUsers().contains(user)) {
                                    dsp.send(player, "team.join.already");
                                } else if (team.getUsers().size() >= teamsize) {
                                    dsp.send(player, "team.join.full");
                                } else {
                                    dsp.send(player, "team.join", "" + team.getTeam().getDisplayName());
                                    team.addUser(user);
                                    Teams.closeMenu(player);
                                    Teams.updateMenu();
                                    player.getInventory().setItem(0, user.getTeam().getTeamItem(player));
                                }
                            } else {
                                dsp.send(player, "team.join", "" + team.getTeam().getDisplayName());
                                team.addUser(user);
                                Teams.closeMenu(player);
                                Teams.updateMenu();
                                player.getInventory().setItem(0, user.getTeam().getTeamItem(player));
                            }
                        }
                    }, i[0]);

            });

            Teams.fill(Material.TNT);

            //16 TEAMS
        } else if (teams.size() == 16) {

            final int[] i = {9};

            teams.forEach(team -> {

                switch (i[0]) {
                    case 16:

                    case 25:
                        i[0] += 3;
                        break;

                    case 19:
                        i[0] += 6;
                        break;

                    default:
                        i[0]++;
                        break;
                }
                ItemStack teamItem = team.getTeamItem(player);
                Teams.addMenuItem(new MenuItem(teamItem) {
                    @Override
                    public void onClick(Player player) {
                        User user = User.getUser(player);
                        if (user.getTeam() != null) {
                            if (team.getUsers().contains(user)) {
                                dsp.send(player, "team.join.already");
                            } else if (team.getUsers().size() >= teamsize) {
                                dsp.send(player, "team.join.full");
                            } else {
                                dsp.send(player, "team.join", "" + team.getTeam().getDisplayName());
                                team.addUser(user);
                                Teams.closeMenu(player);
                                Teams.updateMenu();
                                player.getInventory().setItem(0, user.getTeam().getTeamItem(player));
                            }
                        } else {
                            dsp.send(player, "team.join", "" + team.getTeam().getDisplayName());
                            team.addUser(user);
                            Teams.closeMenu(player);
                            Teams.updateMenu();
                            player.getInventory().setItem(0, user.getTeam().getTeamItem(player));
                        }
                    }
                }, i[0]);

            });

            Teams.fill(Material.TNT);

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
