package de.MangoleHD.IMBedwars.Functions;

import de.Iclipse.IMAPI.Functions.Vanish;
import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Database.MapConfig;
import de.MangoleHD.IMBedwars.Functions.GameStates.Start;
import de.MangoleHD.IMBedwars.Functions.Shop.Shop;
import de.MangoleHD.IMBedwars.Functions.Shop.ShopManager;
import net.minecraft.server.v1_15_R1.SoundEffects;
import org.bukkit.Bukkit;
import org.bukkit.Sound;

import static de.MangoleHD.IMBedwars.Data.dsp;

public class Countdown {

    public static void countdown(int seconds){
        if((Bukkit.getOnlinePlayers().size() - Vanish.getVanishsOnServer().size()) >= Data.minplayers){
            if(Data.countdown > 0){
                if(seconds == 100){
                    Bukkit.getOnlinePlayers().forEach(player -> {
                        dsp.send(player,"countdown.message", "" + seconds, dsp.get("unit.seconds",player));
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP,1,1);
                    });
                }
                if(seconds == 50){
                    Bukkit.getOnlinePlayers().forEach(player -> {
                        dsp.send(player,"countdown.message", "" + seconds, dsp.get("unit.seconds",player));
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP,1,1);
                    });
                }
                if(seconds == 20){
                    Bukkit.getOnlinePlayers().forEach(player -> {
                        dsp.send(player,"countdown.message", "" + seconds, dsp.get("unit.seconds",player));
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP,1,1);
                    });
                    SpawnerManager.createSpawner();
                    ShopManager.createShops();
                    Data.mapConfig.loadMapLocation();
                }
                if(seconds == 10){
                    Bukkit.getOnlinePlayers().forEach(player -> {
                        dsp.send(player,"countdown.message", "" + seconds, dsp.get("unit.seconds",player));
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP,1,1);
                    });
                }
                if(seconds < 6){
                    Bukkit.getOnlinePlayers().forEach(player -> {
                        dsp.send(player,"countdown.message", "" + seconds, dsp.get("unit.seconds",player));
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP,1,1);
                    });
                }
                if(seconds == 0){
                    Start.startBedwars();
                }
                Data.countdown--;
                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.setLevel(Data.countdown);
                    player.setExp((float) Data.countdown / (float) Data.lobbycountdown);
                });
            }
        }else{
            Data.countdown = Data.lobbycountdown;
        }
    }
}
