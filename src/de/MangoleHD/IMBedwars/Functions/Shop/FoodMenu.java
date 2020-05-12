package de.MangoleHD.IMBedwars.Functions.Shop;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.entity.Player;

import static de.MangoleHD.IMBedwars.Data.dsp;

public class FoodMenu {

    public static void openFoodMenu(Player player) {
        PopupMenu FoodMenu = new PopupMenu(dsp.get("foodmenu.title", player), 1);
    }
}
