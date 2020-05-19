package de.MangoleHD.IMBedwars.Functions.Shop.Menus;

import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.Iclipse.IMAPI.Util.menu.PopupMenuAPI;
import de.MangoleHD.IMBedwars.Functions.Shop.Buying;
import de.MangoleHD.IMBedwars.Functions.Shop.ShopItemList;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static de.MangoleHD.IMBedwars.Data.dsp;

public class BlockMenu {

    public static void openBlockMenu(Player player,PopupMenu old) {

        PopupMenu BlockMenu = new PopupMenu(dsp.get("blockmenu.title", player), 4);
        final int[] i = {0};

        ShopItemList.shopItemHashMap.forEach((s, shopItem) -> {
            if (s.startsWith("Block")) {

                MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(), player), shopItem.getItemStack()) {
                    @Override
                    public void onClick(Player player) {
                        Buying.BuyShopItem(shopItem, player, shopItem.getItemStack());
                    }
                };

                MenuItem price = new MenuItem(dsp.get("shopitem.price", player), new ItemStack(shopItem.getPriceMaterial(),shopItem.getPrice())) {
                    @Override
                    public void onClick(Player player) {

                    }
                };

                BlockMenu.addMenuItem(menuItem, i[0]);
                BlockMenu.addMenuItem(price, i[0] + 9);

                i[0] = i[0] + 2;
            }
        });

        BlockMenu.fill(Material.GREEN_STAINED_GLASS_PANE);
        PopupMenuAPI.switchMenu(player,old,BlockMenu);
    }
}
