package de.MangoleHD.IMBedwars.Functions.Shop;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMBedwars.Data.dsp;

public class SwordMenu {

    public static void openSwordMenu(Player player) {
        PopupMenu SwordMenu = new PopupMenu(dsp.get("swordmenu.title", player), 1);
    }
}
