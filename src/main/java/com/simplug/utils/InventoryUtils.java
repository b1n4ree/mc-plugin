package com.simplug.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {

    private final ItemsUtils itemsUtils;

    public InventoryUtils() {
        itemsUtils = new ItemsUtils();
    }

    public void startInventory(Player player) {

        player.getInventory().setItem(0, itemsUtils.getMyCustomItemStack(new ItemStack(Material.WOODEN_SWORD)));
        player.getInventory().setItem(1, itemsUtils.getMyCustomItemStack(new ItemStack(Material.WOODEN_PICKAXE)));
        player.getInventory().setItem(2, itemsUtils.getMyCustomItemStack(new ItemStack(Material.WOODEN_AXE)));
        player.getInventory().setItem(4, itemsUtils.getMyCustomItemStack(new ItemStack(Material.DIAMOND)));
    }
}
