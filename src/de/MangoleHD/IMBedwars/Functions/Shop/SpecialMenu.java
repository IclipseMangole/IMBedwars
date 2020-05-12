package de.MangoleHD.IMBedwars.Functions.Shop;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMBedwars.Data.dsp;

public class SpecialMenu {

    public static void openSpecialMenu(Player player) {
        PopupMenu SpecialMenu = new PopupMenu(dsp.get("specialmenu.title", player), 1);
    }
}
