package com.simplug.events;

import com.simplug.data.entity.PlayerData;
import com.simplug.service.CountKiilService;
import com.simplug.service.PlayerDataService;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;

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

            inventoryInteractEvent.getWhoClicked().sendMessage(ChatColor.GOLD + "Клик по айтему");
            ExpEvent expEvent = new ExpEvent(playerDataService);

            inventoryInteractEvent.getWhoClicked().sendMessage(ChatColor.BLACK + "" + count);

            if (count >= 100 && countPig >= 50 && countCow >= 50 && inventoryInteractEvent.getCurrentItem().hasItemMeta()) {

                inventoryInteractEvent.getWhoClicked().getInventory().remove(new ItemStack(Material.WOODEN_SWORD));
//                inventoryInteractEvent.getCurrentItem().subtract();
                ItemStack itemStack = new ItemStack(Material.STONE_SWORD);
                inventoryInteractEvent.getWhoClicked().getInventory().setItem(1, itemStack);

            } else if (count >= 200 && countPig >= 100 && countCow >= 100 && inventoryInteractEvent.getCurrentItem().hasItemMeta()) {

                inventoryInteractEvent.getWhoClicked().getInventory().remove(new ItemStack(Material.STONE_SWORD));
//                inventoryInteractEvent.getCurrentItem().subtract();
                ItemStack itemStack = new ItemStack(Material.IRON_SWORD);
                inventoryInteractEvent.getWhoClicked().getInventory().setItem(1, itemStack);

            } else if (count >= 300 && countPig >= 150 && countCow >= 150 && inventoryInteractEvent.getCurrentItem().hasItemMeta()) {

                inventoryInteractEvent.getWhoClicked().getInventory().remove(new ItemStack(Material.IRON_SWORD));
//                inventoryInteractEvent.getCurrentItem().subtract();
                ItemStack itemStack = new ItemStack(Material.GOLDEN_SWORD);
                inventoryInteractEvent.getWhoClicked().getInventory().setItem(1, itemStack);

            } else if (count >= 400 && countPig >= 200 && countCow >= 200 && inventoryInteractEvent.getCurrentItem().hasItemMeta()) {

                inventoryInteractEvent.getWhoClicked().getInventory().remove(new ItemStack(Material.GOLDEN_SWORD));
//                inventoryInteractEvent.getCurrentItem().subtract();
                ItemStack itemStack = new ItemStack(Material.DIAMOND_SWORD);
                inventoryInteractEvent.getWhoClicked().getInventory().setItem(1, itemStack);
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
