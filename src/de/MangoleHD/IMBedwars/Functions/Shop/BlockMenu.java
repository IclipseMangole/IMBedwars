package de.MangoleHD.IMBedwars.Functions.Shop;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMBedwars.Data.dsp;

public class BlockMenu {

    public static void openBlockMenu(Player player) {
        PopupMenu BlockMenu = new PopupMenu(dsp.get("blockmenu.title", player), 1);
    }
}
