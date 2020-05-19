package de.MangoleHD.IMBedwars.Functions.Shop;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopItem {

    String name;
    Material material;
    int number;
    int price;
    Material priceMaterial;

    public ShopItem(String name, Material material, int number, int price, Material priceMaterial){
        this.name = name;
        this.material = material;
        this.number = number;
        this.price = price;
        this.priceMaterial = priceMaterial;
    }

    public ItemStack getItemStack(){
        ItemStack itemStack = new ItemStack(material, number);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ShopItem getShopItem(){
        return this;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPriceMaterial(Material priceMaterial) {
        this.priceMaterial = priceMaterial;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Material getMaterial() {
        return material;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Material getPriceMaterial() {
        return priceMaterial;
    }

    public int getNumber() {
        return number;
    }
}
