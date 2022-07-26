package com.simplug;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ModifierSwordNBT {


    public static NBTItem setCritOnWeapon(ItemStack itemStack, Double critChance, Double critDamage) {

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setDouble("CritChance", critChance);
        nbtItem.setDouble("CritDamage", critDamage);

        return nbtItem;
    }

    public static NBTItem setBleedOnWeapon(ItemStack itemStack, Double bleedChance, Double bleedDuration, Double bleedDamagePerSecond) {

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setDouble("BleedChance", bleedChance);
        nbtItem.setDouble("BleedDuration", bleedDuration);
        nbtItem.setDouble("BleedDamage", bleedDamagePerSecond);

        return nbtItem;
    }

    public static NBTItem setSlowOnWeapon(ItemStack itemStack, Double slowChance, Double slowDuration, Double slowDegree) {

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setDouble("SlowChance", slowChance);
        nbtItem.setDouble("SlowDuration", slowDuration);
        nbtItem.setDouble("SlowDegree", slowDegree);

        return nbtItem;
    }

    public static NBTItem setArsonOnWeapon(ItemStack itemStack, Double arsonChance, Double arsonDuration, Double arsonDamage) {

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setDouble("ArsonChance", arsonChance);
        nbtItem.setDouble("ArsonDuration", arsonDuration);
        nbtItem.setDouble("ArsonDamage", arsonDamage);

        return nbtItem;
    }

    public static ItemStack swordWooden() {

        ItemStack sword = new ItemStack(Material.WOODEN_SWORD, 1);
        ItemMeta swordItemMeta = sword.getItemMeta();
        swordItemMeta.setUnbreakable(true);
        sword.setItemMeta(swordItemMeta);

        return sword;
    }

    public static ItemStack swordStone() {

        ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta swordItemMeta = sword.getItemMeta();
        swordItemMeta.setUnbreakable(true);
        sword.setItemMeta(swordItemMeta);

        return sword;
    }

    public static ItemStack swordIron() {

        ItemStack sword = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta swordItemMeta = sword.getItemMeta();
        swordItemMeta.setUnbreakable(true);
        sword.setItemMeta(swordItemMeta);

        return sword;
    }

    public static ItemStack swordGolden() {

        ItemStack sword = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta swordItemMeta = sword.getItemMeta();
        swordItemMeta.setUnbreakable(true);
        sword.setItemMeta(swordItemMeta);

        return sword;
    }

    public static ItemStack swordDiamond() {

        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta swordItemMeta = sword.getItemMeta();
        swordItemMeta.setUnbreakable(true);
        sword.setItemMeta(swordItemMeta);

        return sword;
    }

    public static ItemStack swordNetherite() {

        ItemStack sword = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta swordItemMeta = sword.getItemMeta();
        swordItemMeta.setUnbreakable(true);
        sword.setItemMeta(swordItemMeta);

        return sword;
    }
}
