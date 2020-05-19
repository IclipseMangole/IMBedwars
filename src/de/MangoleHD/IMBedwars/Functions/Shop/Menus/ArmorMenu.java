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

import java.awt.*;

import static de.MangoleHD.IMBedwars.Data.dsp;

public class ArmorMenu {

    public static void openArmorMenu(Player player, PopupMenu old) {
        PopupMenu ArmorMenu = new PopupMenu(dsp.get("armormenu.title", player), 4);

        final int[] i = {0};

        ShopItemList.shopItemHashMap.forEach((s, shopItem) -> {

            if(s.startsWith("Armor_")) {
                if (s.startsWith("Armor_Leather")) {

                    ItemStack leather = shopItem.getItemStack();
                    ItemMeta leatherMeta = leather.getItemMeta();
                    leatherMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, false);
                    leather.setItemMeta(leatherMeta);
                    MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(), player), leather) {
                        @Override
                        public void onClick(Player player) {
                            Buying.BuyShopItem(shopItem, player, leather);
                        }
                    };

                    ArmorMenu.addMenuItem(menuItem, i[0]);

                } else if (s.startsWith("Armor_Chain")) {

                    if (s.equals("Armor_ChainChestplate1")) {

                        ItemStack chain = shopItem.getItemStack();
                        ItemMeta chainMeta = chain.getItemMeta();
                        chainMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, false);
                        chain.setItemMeta(chainMeta);
                        MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(), player), chain) {
                            @Override
                            public void onClick(Player player) {
                                Buying.BuyShopItem(shopItem, player, chain);
                            }
                        };

                        ArmorMenu.addMenuItem(menuItem, i[0]);

                    } else if (s.equals("Armor_ChainChestplate2")) {

                        ItemStack chain = shopItem.getItemStack();
                        ItemMeta chainMeta = chain.getItemMeta();
                        chainMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
                        chain.setItemMeta(chainMeta);
                        MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(), player), chain) {
                            @Override
                            public void onClick(Player player) {
                                Buying.BuyShopItem(shopItem, player, chain);
                            }
                        };

                        ArmorMenu.addMenuItem(menuItem, i[0]);

                    } else if (s.equals("Armor_ChainChestplate3")) {

                        ItemStack chain = shopItem.getItemStack();
                        ItemMeta chainMeta = chain.getItemMeta();
                        chainMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false);
                        chain.setItemMeta(chainMeta);
                        MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(), player), chain) {
                            @Override
                            public void onClick(Player player) {
                                Buying.BuyShopItem(shopItem, player, chain);
                            }
                        };

                        ArmorMenu.addMenuItem(menuItem, i[0]);

                    }
                } else if (s.startsWith("Armor_Iron")) {

                    ItemStack iron = shopItem.getItemStack();
                    ItemMeta ironMeta = iron.getItemMeta();
                    ironMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 0, false);
                    iron.setItemMeta(ironMeta);
                    MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(), player), iron) {
                        @Override
                        public void onClick(Player player) {
                            Buying.BuyShopItem(shopItem, player, iron);
                        }
                    };

                    ArmorMenu.addMenuItem(menuItem, i[0]);

                }

                MenuItem price = new MenuItem(dsp.get("shopitem.price", player), new ItemStack(shopItem.getPriceMaterial(),shopItem.getPrice())) {
                    @Override
                    public void onClick(Player player) {

                    }
                };

                ArmorMenu.addMenuItem(price, i[0] + 9);
                i[0] = i[0] + 2;
            }

        });

        ArmorMenu.fill(Material.GREEN_STAINED_GLASS_PANE);
        PopupMenuAPI.switchMenu(player, old, ArmorMenu);
    }
}
