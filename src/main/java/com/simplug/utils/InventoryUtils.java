package com.simplug.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {

    public Inventory inventoryWeaponLvl() {

        Inventory inventory = Bukkit.createInventory(null, 54, Component.text("Weapon Up").color(
                TextColor.color(0, 255, 248)
        ));



        return inventory;
    }
}
