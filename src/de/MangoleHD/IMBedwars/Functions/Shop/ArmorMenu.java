package de.MangoleHD.IMBedwars.Functions.Shop;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMBedwars.Data.dsp;

public class ArmorMenu {

    public static void openArmorMenu(Player player) {
        PopupMenu ArmorMenu = new PopupMenu(dsp.get("armormenu.title", player), 1);
    }
}
