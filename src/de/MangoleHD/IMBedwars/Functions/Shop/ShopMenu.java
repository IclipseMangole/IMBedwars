package de.MangoleHD.IMBedwars.Functions.Shop;

import de.Iclipse.IMAPI.Util.menu.MenuItem;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Functions.GameStates.GameState;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.Collections;

import static de.MangoleHD.IMBedwars.Data.dsp;

public class ShopMenu implements Listener {

    @EventHandler
    public void onShop(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        final EntityType[] entityType = new EntityType[1];
        if (Data.state == GameState.Running) {
            Data.shops.forEach(shop -> {
                entityType[0] = shop.getEntityType();
            });
            if (entityType[0].equals(event.getRightClicked().getType())) {
                openShopMenu(player);
            }
        }
    }

    public void openShopMenu(Player player) {
        //Shop
        PopupMenu ShopMenu = new PopupMenu(dsp.get("shopmenu.title", player), 5);

        //Blöcke
        ItemStack block = new ItemStack(Material.SANDSTONE);
        ItemMeta blockMeta = block.getItemMeta();
        blockMeta.setDisplayName(dsp.get("blocks.name", player));
        blockMeta.setLore(Collections.singletonList(dsp.get("blocks.lore", player)));
        block.setItemMeta(blockMeta);
        MenuItem blockItem = new MenuItem(block) {
            @Override
            public void onClick(Player player) {
                BlockMenu.openBlockMenu(player);
            }
        };

        //Essen
        ItemStack food = new ItemStack(Material.SANDSTONE);
        ItemMeta foodMeta = block.getItemMeta();
        foodMeta.setDisplayName(dsp.get("foods.name", player));
        foodMeta.setLore(Collections.singletonList(dsp.get("foods.lore", player)));
        food.setItemMeta(foodMeta);
        MenuItem foodItem = new MenuItem(food) {
            @Override
            public void onClick(Player player) {
                FoodMenu.openFoodMenu(player);
            }
        };

        //Schwerter
        ItemStack sword = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.setDisplayName(dsp.get("swords.name", player));
        swordMeta.setLore(Collections.singletonList(dsp.get("swords.lore", player)));
        swordMeta.addEnchant(Enchantment.DURABILITY, 1, false);
        sword.setItemMeta(swordMeta);
        MenuItem swordItem = new MenuItem(sword) {
            @Override
            public void onClick(Player player) {
                SwordMenu.openSwordMenu(player);
            }
        };

        //Spitzhacknen
        ItemStack pickaxe = new ItemStack(Material.WOODEN_PICKAXE);
        ItemMeta pickaxeMeta = sword.getItemMeta();
        pickaxeMeta.setDisplayName(dsp.get("pickaxes.name", player));
        pickaxeMeta.setLore(Collections.singletonList(dsp.get("pickaxes.lore", player)));
        pickaxeMeta.addEnchant(Enchantment.DURABILITY, 1, false);
        pickaxe.setItemMeta(pickaxeMeta);
        MenuItem pickaxeItem = new MenuItem(pickaxe) {
            @Override
            public void onClick(Player player) {
                PickaxeMenu.openPickaxeMenu(player);
            }
        };

        //Rüstungen
        ItemStack armor = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta armorMeta = sword.getItemMeta();
        armorMeta.setDisplayName(dsp.get("armors.name", player));
        armorMeta.setLore(Collections.singletonList(dsp.get("armors.lore", player)));
        armorMeta.addEnchant(Enchantment.DURABILITY, 1, false);
        armor.setItemMeta(armorMeta);
        MenuItem armorItem = new MenuItem(armor) {
            @Override
            public void onClick(Player player) {
                ArmorMenu.openArmorMenu(player);
            }
        };

        //Bögen
        ItemStack bow = new ItemStack(Material.BOW);
        ItemMeta bowMeta = sword.getItemMeta();
        bowMeta.setDisplayName(dsp.get("bows.name", player));
        bowMeta.setLore(Collections.singletonList(dsp.get("bows.lore", player)));
        bowMeta.addEnchant(Enchantment.DURABILITY, 1, false);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE,1,false);
        bow.setItemMeta(bowMeta);
        MenuItem bowItem = new MenuItem(bow) {
            @Override
            public void onClick(Player player) {
                BowMenu.openBowMenu(player);
            }
        };

        //SpecialItems
        ItemStack special = new ItemStack(Material.NETHER_STAR);
        ItemMeta specialMeta = sword.getItemMeta();
        specialMeta.setDisplayName(dsp.get("specials.name", player));
        specialMeta.setLore(Collections.singletonList(dsp.get("specials.lore", player)));
        specialMeta.addEnchant(Enchantment.DURABILITY, 1, false);
        special.setItemMeta(specialMeta);
        MenuItem specialItem = new MenuItem(special) {
            @Override
            public void onClick(Player player) {
                SpecialMenu.openSpecialMenu(player);
            }
        };
    }
}
