package de.MangoleHD.IMBedwars.Functions.Shop.Menus;

import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.Iclipse.IMAPI.Util.menu.PopupMenuAPI;
import de.MangoleHD.IMBedwars.Functions.Shop.Buying;
import de.MangoleHD.IMBedwars.Functions.Shop.ShopItemList;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static de.MangoleHD.IMBedwars.Data.dsp;

public class SpecialMenu {

    public static void openSpecialMenu(Player player, PopupMenu old) {
        PopupMenu SpecialMenu = new PopupMenu(dsp.get("specialmenu.title", player), 4);
        final int[] i = {0};

        ShopItemList.shopItemHashMap.forEach((s, shopItem) -> {

            if (s.startsWith("Special")) {
                if (s.equals("Special_Heal")) {

                    ItemStack potion = new ItemStack(Material.POTION);
                    PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();
                    potionMeta.setColor(Color.FUCHSIA);
                    potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL,0,0),false);
                    potion.setItemMeta(potionMeta);

                    MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(),player), potion) {
                        @Override
                        public void onClick(Player player) {
                            Buying.BuyShopItem(shopItem,player,potion);
                        }
                    };

                    SpecialMenu.addMenuItem(menuItem,i[0]);

                }else if(s.equals("Special_Strength")){

                    ItemStack potion = new ItemStack(Material.POTION);
                    PotionMeta potionMeta = (PotionMeta) potion.getItemMeta();
                    potionMeta.setColor(Color.RED);
                    potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,600,0),false);
                    potion.setItemMeta(potionMeta);

                    MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(),player), potion) {
                        @Override
                        public void onClick(Player player) {
                            Buying.BuyShopItem(shopItem,player,potion);
                        }
                    };

                    SpecialMenu.addMenuItem(menuItem,i[0]);

                }else{

                    MenuItem menuItem = new MenuItem(dsp.get(shopItem.getName(),player),shopItem.getItemStack()) {
                        @Override
                        public void onClick(Player player) {
                            Buying.BuyShopItem(shopItem,player,shopItem.getItemStack());
                        }
                    };

                    SpecialMenu.addMenuItem(menuItem,i[0]);

                }

                MenuItem price = new MenuItem(dsp.get("shopitem.price",player), new ItemStack(shopItem.getPriceMaterial())) {
                    @Override
                    public void onClick(Player player) {

                    }
                };

                SpecialMenu.addMenuItem(price, i[0]+9);
                i[0] = i[0]+2;
            }
        });

        SpecialMenu.fill(Material.GREEN_STAINED_GLASS_PANE);
        PopupMenuAPI.switchMenu(player,old,SpecialMenu);
    }
}
