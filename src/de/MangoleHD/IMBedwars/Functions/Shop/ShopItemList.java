package de.MangoleHD.IMBedwars.Functions.Shop;

import de.Iclipse.IMAPI.Util.menu.PopupMenu;
import org.bukkit.Material;

import java.util.HashMap;

public class ShopItemList {

    public static HashMap<String, ShopItem> shopItemHashMap = new HashMap<>();

    public static void createShopItemList() {
        //Blöcke
        shopItemHashMap.put("Block_2Sandstone", new ShopItem("blocks.sandstone.name", Material.SANDSTONE, 2, 1, Material.BRICK));
        shopItemHashMap.put("Block_32Sandstone", new ShopItem("blocks.sandstone.name", Material.SANDSTONE, 32, 16, Material.BRICK));
        shopItemHashMap.put("Block_64Sandstone", new ShopItem("blocks.sandstone.name", Material.SANDSTONE, 64, 32, Material.BRICK));
        shopItemHashMap.put("Block_1Endstone", new ShopItem("blocks.endstone.name", Material.END_STONE, 1, 8, Material.BRICK));
        shopItemHashMap.put("Block_4Endstone", new ShopItem("blocks.endstone.name", Material.END_STONE, 4, 32, Material.BRICK));
        shopItemHashMap.put("Block_8Endstone", new ShopItem("blocks.endstone.name", Material.END_STONE, 8, 64, Material.BRICK));
        shopItemHashMap.put("Block_1Ironblock", new ShopItem("blocks.ironblock.name", Material.IRON_BLOCK, 1, 5, Material.IRON_INGOT));
        shopItemHashMap.put("Block_4Ironblock", new ShopItem("blocks.ironblock.name", Material.IRON_BLOCK, 4, 20, Material.IRON_INGOT));
        shopItemHashMap.put("Block_Chest", new ShopItem("blocks.chest.name", Material.CHEST, 1, 2, Material.IRON_INGOT));
        shopItemHashMap.put("Block_Enderchest", new ShopItem("blocks.enderchest.name", Material.ENDER_CHEST, 1, 2, Material.GOLD_INGOT));
        //Armor
        shopItemHashMap.put("Armor_LeatherHelmet", new ShopItem("armor.leatherHelmet.name", Material.LEATHER_HELMET, 1,1, Material.BRICK));
        shopItemHashMap.put("Armor_LeatherChestplate", new ShopItem("armor.leatherChestplate.name", Material.LEATHER_HELMET, 1,1, Material.BRICK));
        shopItemHashMap.put("Armor_LeatherLeggings", new ShopItem("armor.leatherLeggings.name", Material.LEATHER_HELMET, 1,1, Material.BRICK));
        shopItemHashMap.put("Armor_LeatherBoots", new ShopItem("armor.leatherBoots.name", Material.LEATHER_HELMET, 1,1, Material.BRICK));
        shopItemHashMap.put("Armor_ChainChestplate1", new ShopItem("armor.chainChestplate.name", Material.CHAINMAIL_CHESTPLATE, 1,1, Material.IRON_INGOT));
        shopItemHashMap.put("Armor_ChainChestplate2", new ShopItem("armor.chainChestplate.name", Material.CHAINMAIL_CHESTPLATE, 1,3, Material.IRON_INGOT));
        shopItemHashMap.put("Armor_ChainChestplate3", new ShopItem("armor.chainChestplate.name", Material.CHAINMAIL_CHESTPLATE, 1,7, Material.IRON_INGOT));
        shopItemHashMap.put("Armor_IronChestplate", new ShopItem("armor.ironChestplate.name", Material.IRON_CHESTPLATE, 1,5, Material.GOLD_INGOT));
        //Bows and Arrow
        shopItemHashMap.put("Bow_normal", new ShopItem("bow.name", Material.BOW, 1,3, Material.GOLD_INGOT));
        shopItemHashMap.put("Bow_middle", new ShopItem("bow.name", Material.BOW, 1,7, Material.GOLD_INGOT));
        shopItemHashMap.put("Bow_premium", new ShopItem("bow.name", Material.BOW, 1,13, Material.GOLD_INGOT));
        shopItemHashMap.put("Arrow", new ShopItem("arrow.name", Material.ARROW, 1,1, Material.GOLD_INGOT));
        //Food
        shopItemHashMap.put("Food_2apple", new ShopItem("food.apple.name", Material.APPLE, 2, 1, Material.BRICK));
        shopItemHashMap.put("Food_10apple", new ShopItem("food.apple.name", Material.APPLE, 10, 5 , Material.BRICK));
        shopItemHashMap.put("Food_1Beef", new ShopItem("food.beef.name", Material.COOKED_BEEF, 10, 2 , Material.BRICK));
        shopItemHashMap.put("Food_4Beef", new ShopItem("food.beef.name", Material.COOKED_BEEF, 10, 8 , Material.BRICK));
        shopItemHashMap.put("Food_GoldenApple", new ShopItem("food.goldenApple.name", Material.GOLDEN_APPLE, 1, 2 , Material.GOLD_INGOT));
        //Pickaxe
        shopItemHashMap.put("Pickaxe_wood", new ShopItem("pickaxe.wood.name", Material.WOODEN_PICKAXE, 1, 10, Material.BRICK));
        shopItemHashMap.put("Pickaxe_stone1", new ShopItem("pickaxe.stone.name", Material.STONE_PICKAXE, 1, 2, Material.IRON_INGOT));
        shopItemHashMap.put("Pickaxe_stone2", new ShopItem("pickaxe.stone.name", Material.STONE_PICKAXE, 1, 4, Material.IRON_INGOT));
        shopItemHashMap.put("Pickaxe_iron", new ShopItem("pickaxe.iron.name", Material.IRON_PICKAXE, 1, 2, Material.GOLD_INGOT));
        //Swords
        shopItemHashMap.put("Sword_KnockbackStick", new ShopItem("sword.knockback.name", Material.STICK, 1,10, Material.BRICK));
        shopItemHashMap.put("Sword_Wood", new ShopItem("sword.wood.name", Material.WOODEN_SWORD, 1,1, Material.IRON_INGOT));
        shopItemHashMap.put("Sword_Stone", new ShopItem("sword.stone.name", Material.STONE_SWORD, 1,3, Material.IRON_INGOT));
        shopItemHashMap.put("Sword_Iron", new ShopItem("sword.iron.name", Material.IRON_SWORD, 1,5, Material.GOLD_INGOT));
        //Special
        shopItemHashMap.put("Special_Water", new ShopItem("special.water.name", Material.WATER_BUCKET, 1, 2, Material.GOLD_INGOT));
        shopItemHashMap.put("Special_FlintSteel", new ShopItem("special.flintSteel.name", Material.FLINT_AND_STEEL, 1, 3, Material.IRON_INGOT));
        shopItemHashMap.put("Special_Cobweb", new ShopItem("special.cobweb.name", Material.COBWEB, 1, 16, Material.BRICK));
        shopItemHashMap.put("Special_SafetyPlatform", new ShopItem("special.safetyPlatform.name", Material.BLAZE_ROD, 1, 5, Material.IRON_INGOT));
        shopItemHashMap.put("Special_Heal", new ShopItem("special.heal.name", Material.BLAZE_ROD, 1, 5, Material.IRON_INGOT));
        shopItemHashMap.put("Special_Strength", new ShopItem("special.strength.name", Material.BLAZE_ROD, 1, 5, Material.GOLD_INGOT));
        shopItemHashMap.put("Special_Enderpearl", new ShopItem("special.enderpearl.name", Material.BLAZE_ROD, 1, 12, Material.GOLD_INGOT));
        shopItemHashMap.put("Special_Teleport", new ShopItem("special.teleport.name", Material.GUNPOWDER, 1, 5, Material.IRON_INGOT));
        shopItemHashMap.put("Special_Tnt", new ShopItem("special.tnt.name", Material.TNT, 1, 3, Material.GOLD_INGOT));
        shopItemHashMap.put("Special_fishingRod", new ShopItem("special.fishingRod.name", Material.FISHING_ROD, 1, 5, Material.IRON_INGOT));
    }
}
