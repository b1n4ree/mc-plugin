package com.simplug;

import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ModifierArmorNBT {

    public static NBTItem setDamageMirrorOnArmor(ItemStack itemStack, Double damageMirrorChance, Double damageMirrorPercent) {

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setDouble("DamageMirrorChance", damageMirrorChance);
        nbtItem.setDouble("DamageMirrorPercent", damageMirrorPercent);

        return nbtItem;
    }

    public static NBTItem setDamageAbsorbOnArmor(ItemStack itemStack, Double damageAbsorbChance, Double damageAbsorbPercent) {

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setDouble("DamageAbsorbChance", damageAbsorbChance);
        nbtItem.setDouble("DamageAbsorbPersent", damageAbsorbPercent);

        return nbtItem;
    }

    public static NBTItem setAdditionalMoveSpeedOnArmor(ItemStack itemStack, Double additionalMoveSpeed) {

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setDouble("AdditionalMoveSpeed", additionalMoveSpeed);

        return nbtItem;
    }

    public static NBTItem setAdditionalAttackSpeedOnArmor(ItemStack itemStack, Double additionalAttackSpeed) {

        NBTItem nbtItem = new NBTItem(itemStack);
        nbtItem.setDouble("AdditionalAttackSpeed", additionalAttackSpeed);

        return nbtItem;
    }

    public static ItemStack armorLeatherBoots() {

        ItemStack armor = new ItemStack(Material.LEATHER_BOOTS, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorLeatherHelmet() {

        ItemStack armor = new ItemStack(Material.LEATHER_HELMET, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorLeatherLeggings() {

        ItemStack armor = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorLeatherChestplate() {

        ItemStack armor = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorChainmailBoots() {

        ItemStack armor = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorChainmailHelmet() {

        ItemStack armor = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorChainmailLeggings() {

        ItemStack armor = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorChainmailChestplate() {

        ItemStack armor = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }
    //
    public static ItemStack armorIronBoots() {

        ItemStack armor = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorIronHelmet() {

        ItemStack armor = new ItemStack(Material.IRON_HELMET, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorIronLeggings() {

        ItemStack armor = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorIronChestplate() {

        ItemStack armor = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }
    //
    public static ItemStack armorGoldenBoots() {

        ItemStack armor = new ItemStack(Material.GOLDEN_BOOTS, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorGoldenHelmet() {

        ItemStack armor = new ItemStack(Material.GOLDEN_HELMET, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorGoldenLeggings() {

        ItemStack armor = new ItemStack(Material.GOLDEN_LEGGINGS, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorGoldenChestplate() {

        ItemStack armor = new ItemStack(Material.GOLDEN_CHESTPLATE, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }
    //
    public static ItemStack armorDiamondBoots() {

        ItemStack armor = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorDiamondHelmet() {

        ItemStack armor = new ItemStack(Material.DIAMOND_HELMET, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorDiamondLeggings() {

        ItemStack armor = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorDiamondChestplate() {

        ItemStack armor = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }
    //
    public static ItemStack armorNetheriteBoots() {

        ItemStack armor = new ItemStack(Material.NETHERITE_BOOTS, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorNetheriteHelmet() {

        ItemStack armor = new ItemStack(Material.NETHERITE_HELMET, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorNetheriteLeggings() {

        ItemStack armor = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }

    public static ItemStack armorNetheriteChestplate() {

        ItemStack armor = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        ItemMeta armorItemMeta = armor.getItemMeta();
        armorItemMeta.setUnbreakable(true);
        armor.setItemMeta(armorItemMeta);

        return armor;
    }
}
