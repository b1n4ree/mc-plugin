package com.simplug.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemsUtils {



    public ItemStack woodenSword(String name) {

        ItemStack itemStack = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public ItemStack stoneSword() {

        ItemStack itemStack = new ItemStack(Material.STONE_SWORD);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public ItemStack ironSword() {

        ItemStack itemStack = new ItemStack(Material.IRON_SWORD);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public ItemStack goldenSword() {

        ItemStack itemStack = new ItemStack(Material.GOLDEN_SWORD);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public ItemStack diamondSword() {

        ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

}
