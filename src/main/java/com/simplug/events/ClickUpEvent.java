package com.simplug.events;

import com.simplug.data.entity.PlayerData;
import com.simplug.service.CountKiilService;
import com.simplug.service.PlayerDataService;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ClickUpEvent implements Listener {

    private final CountKiilService countKiilService;
    private final PlayerDataService playerDataService;

    public ClickUpEvent(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
        countKiilService = new CountKiilService();
    }

    @EventHandler
    public void click(InventoryClickEvent inventoryInteractEvent) {

        if (inventoryInteractEvent.getWhoClicked().getInventory().getItem(2) != null) {
            inventoryInteractEvent.setCancelled(true);
        }

        if (inventoryInteractEvent.getCurrentItem() != null) {
            Player player = null;

            PlayerData playerData = playerDataService.getByPlayerName(inventoryInteractEvent.getWhoClicked().getName());

            Long count = playerData.getKillCount();
            Long countPig = playerData.getKillCountPig();
            Long countCow = playerData.getKillCountCow();

            List<Component> list = new ArrayList<>();
            Component component1 = Component.text("Count kill: " + playerData.getKillCount()).color(TextColor.color(255, 59, 244));
            Component component2 = Component.text("Count kill cow: " + playerData.getKillCountCow()).color(TextColor.color(3, 3, 3));
            Component component3 = Component.text("Count kill pig: " + playerData.getKillCountPig()).color(TextColor.color(30, 30, 30));
            list.add(component1);
            list.add(component2);
            list.add(component3);

            inventoryInteractEvent.getWhoClicked().sendMessage(ChatColor.GOLD + "Клик по айтему");
            ExpEvent expEvent = new ExpEvent(playerDataService);

            inventoryInteractEvent.getWhoClicked().sendMessage(ChatColor.BLACK + "" + count);

            if (inventoryInteractEvent.getCurrentItem().hasItemMeta()) {

                inventoryInteractEvent.getWhoClicked().sendMessage("Current item click " + inventoryInteractEvent.getCurrentItem().getType());
                ItemStack itemStack = inventoryInteractEvent.getCurrentItem();

                if (count >= 100 && countPig >= 50 && countCow >= 50 && inventoryInteractEvent.getCurrentItem().getType().equals(Material.WOODEN_SWORD)) {

                    inventoryInteractEvent.getWhoClicked().getInventory().remove(itemStack);
                    ItemStack itemStack1 = new ItemStack(Material.STONE_SWORD);
                    ItemMeta itemMeta = itemStack1.getItemMeta();
                    itemMeta.lore(list);
                    itemMeta.setUnbreakable(true);
                    inventoryInteractEvent.getWhoClicked().getInventory().setItem(1, itemStack1);
                    inventoryInteractEvent.getWhoClicked().getInventory().getItemInMainHand().setItemMeta(itemMeta);

                } else if (count >= 200 && countPig >= 100 && countCow >= 100 && inventoryInteractEvent.getCurrentItem().getType().equals(Material.STONE_SWORD)) {


                    inventoryInteractEvent.getWhoClicked().getInventory().remove(itemStack);
                    ItemStack itemStack1 = new ItemStack(Material.IRON_SWORD);
                    ItemMeta itemMeta = itemStack1.getItemMeta();
                    itemMeta.lore(list);
                    itemMeta.setUnbreakable(true);
                    inventoryInteractEvent.getWhoClicked().getInventory().setItem(1, itemStack1);
                    inventoryInteractEvent.getWhoClicked().getInventory().getItemInMainHand().setItemMeta(itemMeta);

                } else if (count >= 300 && countPig >= 150 && countCow >= 150 && inventoryInteractEvent.getCurrentItem().getType().equals(Material.IRON_SWORD)) {

                    inventoryInteractEvent.getWhoClicked().getInventory().remove(itemStack);
                    ItemStack itemStack1 = new ItemStack(Material.GOLDEN_SWORD);
                    ItemMeta itemMeta = itemStack1.getItemMeta();
                    itemMeta.lore(list);
                    itemMeta.setUnbreakable(true);
                    inventoryInteractEvent.getWhoClicked().getInventory().setItem(1, itemStack1);
                    inventoryInteractEvent.getWhoClicked().getInventory().getItemInMainHand().setItemMeta(itemMeta);

                } else if (count >= 400 && countPig >= 200 && countCow >= 200 && inventoryInteractEvent.getCurrentItem().getType().equals(Material.GOLDEN_SWORD)) {

                    inventoryInteractEvent.getWhoClicked().getInventory().remove(itemStack);
                    ItemStack itemStack1 = new ItemStack(Material.DIAMOND_SWORD);
                    ItemMeta itemMeta = itemStack1.getItemMeta();
                    itemMeta.lore(list);
                    itemMeta.setUnbreakable(true);
                    inventoryInteractEvent.getWhoClicked().getInventory().setItem(1, itemStack1);
                    inventoryInteractEvent.getWhoClicked().getInventory().getItemInMainHand().setItemMeta(itemMeta);
                }
            }
        }
    }

    @EventHandler
    public void cancelMove(InventoryMoveItemEvent inventoryMoveItemEvent) {

        if (inventoryMoveItemEvent.getItem().equals(Material.WOODEN_SWORD)) {
            inventoryMoveItemEvent.setCancelled(false);
        } else if (inventoryMoveItemEvent.getItem().equals(Material.STONE_SWORD)) {
            inventoryMoveItemEvent.setCancelled(false);
        } else if (inventoryMoveItemEvent.getItem().equals(Material.IRON_SWORD)) {
            inventoryMoveItemEvent.setCancelled(false);
        } else if (inventoryMoveItemEvent.getItem().equals(Material.GOLDEN_SWORD)) {
            inventoryMoveItemEvent.setCancelled(false);
        } else if (inventoryMoveItemEvent.getItem().equals(Material.DIAMOND_SWORD)) {
            inventoryMoveItemEvent.setCancelled(false);
        } else {
            inventoryMoveItemEvent.setCancelled(true);
        }
    }
}
