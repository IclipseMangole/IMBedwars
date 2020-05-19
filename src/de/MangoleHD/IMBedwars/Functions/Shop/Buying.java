package de.MangoleHD.IMBedwars.Functions.Shop;

import de.Iclipse.IMAPI.Util.UUIDFetcher;
import de.Iclipse.IMAPI.Util.menu.MenuCloseBehaviour;
import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import de.MangoleHD.IMBedwars.Data;
import de.MangoleHD.IMBedwars.Functions.GameStates.GameState;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.User;
import de.MangoleHD.IMBedwars.Functions.PlayerManagement.UserStats;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Map;
import java.util.UUID;
import static de.MangoleHD.IMBedwars.Data.dsp;

public class Buying {

    public static void BuyShopItem(ShopItem shopItem, Player player, ItemStack bought) {

        PlayerInventory playerInventory = player.getInventory();
        UUID uuid = UUIDFetcher.getUUID(player.getName());
        Material priceMaterial = shopItem.getPriceMaterial();
        int price = shopItem.getPrice();
        User user = User.getUser(player);

        if (Data.state == GameState.Running) {
            if (getMaterialNumber(priceMaterial, playerInventory) >= price) {
                if (inventoryNotFull(player, new ItemStack(shopItem.getItemStack()))) {
                    removeMaterialNumber(priceMaterial, playerInventory, price);
                    ItemMeta boughtMeta= bought.getItemMeta();
                    boughtMeta.setDisplayName(dsp.get(shopItem.getName(),player));
                    bought.setItemMeta(boughtMeta);
                    playerInventory.addItem(bought);
                    if (priceMaterial.equals(Material.BRICK)) {
                        user.setSpentBronze(user.getSpentBronze() + price);
                    } else if (priceMaterial.equals(Material.IRON_INGOT)) {
                        user.setSpentIron(user.getSpentIron() + price);
                    } else if(priceMaterial.equals(Material.GOLD_INGOT)){
                        user.setSpentGold(user.getSpentGold() + price);
                    }
                } else {
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
                }
            } else {
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1, 1);
            }
        }
    }

    public static boolean inventoryNotFull(Player p, ItemStack item) {
        if (p.getInventory().firstEmpty() >= 0 && item.getAmount() <= item.getMaxStackSize()) {
            return true;
        }
        Map<Integer, ? extends ItemStack> items = p.getInventory().all(item.getType());
        int amount = item.getAmount();
        for (ItemStack i : items.values()) {
            amount -= i.getMaxStackSize() - i.getAmount();
        }
        return amount <= 0; // more than 0 means there are items that can't be placed
    }

    public static int getMaterialNumber(Material material, PlayerInventory playerInventory) {
        int number = 0;
        for (int i = 0; i < 36; i++) {
            if (playerInventory.getItem(i).getType().equals(material)) {
                number = number + playerInventory.getItem(i).getAmount();
            }
        }
        return number;
    }

    public static void removeMaterialNumber(Material material, PlayerInventory playerInventory, int number) {
        int i = 0;
        ItemStack[] materials = playerInventory.getContents();
        while (number > 0) {
            if (materials[i].getType().equals(material)) {
                if (materials[i].getAmount() > number) {
                    materials[i].setAmount(materials[i].getAmount() - number);
                    number = 0;
                } else {
                    materials[i].setType(Material.AIR);
                    number = number - materials[i].getAmount();
                }
            }
            i++;
            if (i > 37) {
                break;
            }
        }
    }
}
