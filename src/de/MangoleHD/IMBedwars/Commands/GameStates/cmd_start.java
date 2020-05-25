package de.MangoleHD.IMBedwars.Commands.GameStates;

import de.Iclipse.IMAPI.Functions.Vanish;
import de.Iclipse.IMAPI.Util.Command.IMCommand;
import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Functions.GameStates.GameState;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

public class cmd_start {
    @IMCommand(
            name = "start",
            maxArgs = 0,
            minArgs = 0,
            usage = "start.usage",
            description = "start.description",
            permissions = "im.cmd.start"
    )
    public void start(CommandSender sender){
        if(Data.state == GameState.Lobby){
            if((Bukkit.getOnlinePlayers().size() - Vanish.getVanishsOnServer().size()) >= Data.minplayers){
                if(Data.countdown > 10){
                    Data.countdown = 10;
                }
            }
        }
    }
}
