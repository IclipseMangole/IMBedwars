package de.MangoleHD.IMBedwars.Functions.Shop;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMBedwars.Data.dsp;

public class BowMenu {

    public static void openBowMenu(Player player) {
        PopupMenu BowMenu = new PopupMenu(dsp.get("bowmenu.title", player), 1);
    }
}
