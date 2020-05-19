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

public class SwordMenu {

    public static void openSwordMenu(Player player, PopupMenu old) {
        PopupMenu SwordMenu = new PopupMenu(dsp.get("swordmenu.title", player), 2);

        final int[] i = {1};

        ShopItemList.shopItemHashMap.forEach((s, shopItem) -> {
            if (s.startsWith("Sword_")) {
                if (s.equals("Sword_Wood") || s.equals("Sword_Stone")) {

                    MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(), player), shopItem.getItemStack()) {
                        @Override
                        public void onClick(Player player) {
                            Buying.BuyShopItem(shopItem,player,shopItem.getItemStack());
                        }
                    };

                    SwordMenu.addMenuItem(menuItem,i[0]);

                }else if(s.equals("Sword_Knockback")){

                    ItemStack stick = shopItem.getItemStack();
                    ItemMeta stickMeta = stick.getItemMeta();
                    stickMeta.addEnchant(Enchantment.KNOCKBACK,0,false);
                    stick.setItemMeta(stickMeta);

                    MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(),player), stick) {
                        @Override
                        public void onClick(Player player) {
                            Buying.BuyShopItem(shopItem,player,stick);
                        }
                    };

                    SwordMenu.addMenuItem(menuItem, i[0]);

                }else if(s.equals("Sword_Iron")){

                    ItemStack iron = shopItem.getItemStack();
                    ItemMeta ironMeta = iron.getItemMeta();
                    ironMeta.addEnchant(Enchantment.DAMAGE_ALL,0,false);
                    iron.setItemMeta(ironMeta);
                    MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(),player), iron) {
                        @Override
                        public void onClick(Player player) {
                            Buying.BuyShopItem(shopItem,player,iron);
                        }
                    };

                    SwordMenu.addMenuItem(menuItem,i[0]);
                }

                MenuItem price =new MenuItem(dsp.get("shopitem.price",player),new ItemStack(shopItem.getPriceMaterial())) {
                    @Override
                    public void onClick(Player player) {

                    }
                };

                SwordMenu.addMenuItem(price, i[0]+9);
                i[0] = i[0]+2;
            }
        });

        SwordMenu.fill(Material.GREEN_STAINED_GLASS_PANE);
        PopupMenuAPI.switchMenu(player,old,SwordMenu);
    }
}
