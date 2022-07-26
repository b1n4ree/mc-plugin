package com.simplug.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackBuilder {

    private Material material = Material.DIRT;

    private int amount = 1;

    private Component displayName;

    private List<Component> lore = new ArrayList<>();

    private boolean unbreakable = false;

    private boolean hideAttributes = false;

    public static ItemStackBuilder builder() {
        return new ItemStackBuilder();
    }

    public ItemStackBuilder material(Material material) {
        this.material = material;
        return this;
    }

    public ItemStackBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

    public ItemStackBuilder displayName(Component displayName) {
        this.displayName = displayName;
        return this;
    }

    public ItemStackBuilder displayName(String displayName) {
        this.displayName = Component.text(displayName);
        return this;
    }

    public ItemStackBuilder displayName(String displayName, TextColor textColor) {
        this.displayName = Component.text(displayName, textColor);
        return this;
    }

    public ItemStackBuilder lore(List<Component> lore) {
        this.lore = lore;
        return this;
    }

    public ItemStackBuilder lore(String lore) {
        this.lore.add(Component.text(lore));
        return this;
    }

    public ItemStackBuilder lore(String lore, TextColor textColor) {
        this.lore.add(Component.text(lore, textColor));
        return this;
    }

    public ItemStackBuilder unbreakable() {
        unbreakable = true;
        return this;
    }

    public ItemStackBuilder hideAttributes() {
        hideAttributes = true;
        return this;
    }

    public ItemStack build() {

        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.lore(lore);
        if (displayName != null) itemMeta.displayName(displayName);
        if (unbreakable) itemMeta.setUnbreakable(true);
        if (hideAttributes) itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
