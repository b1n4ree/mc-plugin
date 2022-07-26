package com.simplug.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Contract;

import java.util.List;

public interface IItemStackBuilder {

    @Contract("_ -> this")
    public ItemStackBuilder material(Material material);

    @Contract("_ -> this")
    public ItemStackBuilder amount(int amount);

    @Contract("_ -> this")
    public ItemStackBuilder displayName(Component displayName);

    @Contract("_ -> this")
    public ItemStackBuilder lore(List<Component> lore);

    public ItemStackBuilder unbreakable();

    public ItemStackBuilder hideAttributes();

    public ItemStack build();
}
