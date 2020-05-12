package de.MangoleHD.IMBedwars.Functions.Shop;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMBedwars.Data.dsp;

public class PickaxeMenu {

    public static void openPickaxeMenu(Player player) {
        PopupMenu PickaxeMenu = new PopupMenu(dsp.get("pickaxemenu.title", player), 1);
    }
}
