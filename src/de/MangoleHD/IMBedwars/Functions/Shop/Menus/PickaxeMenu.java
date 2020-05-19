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

public class PickaxeMenu {

    public static void openPickaxeMenu(Player player, PopupMenu old) {
        PopupMenu PickaxeMenu = new PopupMenu(dsp.get("pickaxemenu.title", player), 2);
        final int[] i = {1};

        ShopItemList.shopItemHashMap.forEach((s, shopItem) -> {
            if (s.startsWith("Pickaxe_")) {
                if (s.equals("Pickaxe_wood") || s.equals("Pickaxe_stone1")) {

                    MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(), player), shopItem.getItemStack()) {
                        @Override
                        public void onClick(Player player) {
                            Buying.BuyShopItem(shopItem,player,shopItem.getItemStack());
                        }
                    };

                    PickaxeMenu.addMenuItem(menuItem,i[0]);

                }else if(s.equals("Pickaxe_stone2")){

                    ItemStack pickaxe = shopItem.getItemStack();
                    ItemMeta pickaxeMeta = pickaxe.getItemMeta();
                    pickaxeMeta.addEnchant(Enchantment.DIG_SPEED,1,false);
                    pickaxe.setItemMeta(pickaxeMeta);

                    MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(),player), pickaxe) {
                        @Override
                        public void onClick(Player player) {
                            Buying.BuyShopItem(shopItem,player,pickaxe);
                        }
                    };

                    PickaxeMenu.addMenuItem(menuItem, i[0]);

                }else if(s.equals("Pickaxe_iron")){

                    ItemStack pickaxe = shopItem.getItemStack();
                    ItemMeta pickaxeMeta = pickaxe.getItemMeta();
                    pickaxeMeta.addEnchant(Enchantment.DIG_SPEED,0,false);
                    pickaxe.setItemMeta(pickaxeMeta);
                    MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(),player), pickaxe) {
                        @Override
                        public void onClick(Player player) {
                            Buying.BuyShopItem(shopItem,player,pickaxe);
                        }
                    };

                    PickaxeMenu.addMenuItem(menuItem,i[0]);
                }

                MenuItem price =new MenuItem(dsp.get("shopitem.price",player),new ItemStack(shopItem.getPriceMaterial())) {
                    @Override
                    public void onClick(Player player) {

                    }
                };

                PickaxeMenu.addMenuItem(price, i[0]+9);
                i[0] = i[0]+2;
            }
        });

        PickaxeMenu.fill(Material.GREEN_STAINED_GLASS_PANE);
        PopupMenuAPI.switchMenu(player,old,PickaxeMenu);
    }
}
