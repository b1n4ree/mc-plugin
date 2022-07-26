package com.simplug;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ModifierPickAndAxeNBT {

    public static NBTItem setDoubleDrop(ItemStack itemStack, Double doubleDropChance) {

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setDouble("DoubleDropChance", doubleDropChance);

        return nbtItem;
    }

    public static NBTItem setDestroyBlockOneHit(ItemStack itemStack, Double destroyBlockOneHitChance) {

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setDouble("DestroyBlockOneHitChance", destroyBlockOneHitChance);

        return nbtItem;
    }

    public static NBTItem setDropLvlUp(ItemStack itemStack, Double dropLvlUpChance, Double dropLvlUpAmount) {

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setDouble("DropLvlUpChance", dropLvlUpChance);
        nbtItem.setDouble("DropLvlUpAmount", dropLvlUpAmount);

        return nbtItem;
    }

    public static NBTItem setDropLvlDown(ItemStack itemStack, Double dropLvlDownChance, Double dropLvlDownAmount) {

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setDouble("DropLvlDownChance", dropLvlDownChance);
        nbtItem.setDouble("DropLvlDownAmount", dropLvlDownAmount);

        return nbtItem;
    }

    public static ItemStack pickWooden() {

        ItemStack pick = new ItemStack(Material.WOODEN_PICKAXE, 1);
        ItemMeta pickItemMeta = pick.getItemMeta();
        pickItemMeta.setUnbreakable(true);
        pick.setItemMeta(pickItemMeta);

        return pick;
    }

    public static ItemStack pickStone() {

        ItemStack pick = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemMeta pickItemMeta = pick.getItemMeta();
        pickItemMeta.setUnbreakable(true);
        pick.setItemMeta(pickItemMeta);

        return pick;
    }

    public static ItemStack pickIron() {

        ItemStack pick = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta pickItemMeta = pick.getItemMeta();
        pickItemMeta.setUnbreakable(true);
        pick.setItemMeta(pickItemMeta);

        return pick;
    }

    public static ItemStack pickGolden() {

        ItemStack pick = new ItemStack(Material.GOLDEN_PICKAXE, 1);
        ItemMeta pickItemMeta = pick.getItemMeta();
        pickItemMeta.setUnbreakable(true);
        pick.setItemMeta(pickItemMeta);

        return pick;
    }

    public static ItemStack pickDiamond() {

        ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta pickItemMeta = pick.getItemMeta();
        pickItemMeta.setUnbreakable(true);
        pick.setItemMeta(pickItemMeta);

        return pick;
    }

    public static ItemStack pickNetherite() {

        ItemStack pick = new ItemStack(Material.NETHERITE_PICKAXE, 1);
        ItemMeta pickItemMeta = pick.getItemMeta();
        pickItemMeta.setUnbreakable(true);
        pick.setItemMeta(pickItemMeta);

        return pick;
    }

    public static ItemStack axeWooden() {

        ItemStack axe = new ItemStack(Material.WOODEN_AXE, 1);
        ItemMeta axeItemMeta = axe.getItemMeta();
        axeItemMeta.setUnbreakable(true);
        axe.setItemMeta(axeItemMeta);

        return axe;
    }

    public static ItemStack axeStone() {

        ItemStack axe = new ItemStack(Material.STONE_AXE, 1);
        ItemMeta axeItemMeta = axe.getItemMeta();
        axeItemMeta.setUnbreakable(true);
        axe.setItemMeta(axeItemMeta);

        return axe;
    }

    public static ItemStack axeIron() {

        ItemStack axe = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta axeItemMeta = axe.getItemMeta();
        axeItemMeta.setUnbreakable(true);
        axe.setItemMeta(axeItemMeta);

        return axe;
    }

    public static ItemStack axeGolden() {

        ItemStack axe = new ItemStack(Material.GOLDEN_AXE, 1);
        ItemMeta axeItemMeta = axe.getItemMeta();
        axeItemMeta.setUnbreakable(true);
        axe.setItemMeta(axeItemMeta);

        return axe;
    }

    public static ItemStack axeDiamond() {

        ItemStack axe = new ItemStack(Material.DIAMOND_AXE, 1);
        ItemMeta axeItemMeta = axe.getItemMeta();
        axeItemMeta.setUnbreakable(true);
        axe.setItemMeta(axeItemMeta);

        return axe;
    }

    public static ItemStack axeNetherite() {

        ItemStack axe = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemMeta axeItemMeta = axe.getItemMeta();
        axeItemMeta.setUnbreakable(true);
        axe.setItemMeta(axeItemMeta);

        return axe;
    }
}
