package de.MangoleHD.IMBedwars.Functions.Shop.Menus;

import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.Iclipse.IMAPI.Util.menu.PopupMenuAPI;
import de.MangoleHD.IMBedwars.Functions.Shop.Buying;
import de.MangoleHD.IMBedwars.Functions.Shop.ShopItemList;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static de.MangoleHD.IMBedwars.Data.dsp;

public class BowMenu {

    public static void openBowMenu(Player player,PopupMenu old) {
        PopupMenu BowMenu = new PopupMenu(dsp.get("bowmenu.title", player), 2);
        final int[] i = {1};

        ShopItemList.shopItemHashMap.forEach((s, shopItem) -> {

            if (s.startsWith("Bow_")) {

                ItemStack bow = shopItem.getItemStack();
                ItemMeta bowMeta = bow.getItemMeta();
                bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 0, false);

                if (s.equals("Bow_normal")) {
                    bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 0, false);
                } else if (s.equals("Bow_medium")) {
                    bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 0, false);
                    bowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK,0,false);
                } else if (s.equals("Bow_premium")) {
                    bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, false);
                    bowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK,0,false);
                }

                bow.setItemMeta(bowMeta);

                MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(),player),bow) {
                    @Override
                    public void onClick(Player player) {
                        Buying.BuyShopItem(shopItem,player,bow);
                    }
                };

                BowMenu.addMenuItem(menuItem, i[0]);

                MenuItem price = new MenuItem("shopitem.price", new ItemStack(shopItem.getPriceMaterial(),shopItem.getPrice())) {
                    @Override
                    public void onClick(Player player) {

                    }
                };

                BowMenu.addMenuItem(price, i[0] + 9);
                i[0] = i[0] + 2;

            }else if(s.equals("Arrow")){

                MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(),player),shopItem.getItemStack()) {
                    @Override
                    public void onClick(Player player) {
                        Buying.BuyShopItem(shopItem,player,shopItem.getItemStack());
                    }
                };

                BowMenu.addMenuItem(menuItem, i[0]);

                MenuItem price = new MenuItem("shopitem.price", new ItemStack(shopItem.getPriceMaterial(),shopItem.getPrice())) {
                    @Override
                    public void onClick(Player player) {

                    }
                };

                BowMenu.addMenuItem(price, i[0] + 9);
                i[0] = i[0] + 2;
            }

        });

        BowMenu.fill(Material.GREEN_STAINED_GLASS_PANE);
        PopupMenuAPI.switchMenu(player,old,BowMenu);
    }
}
