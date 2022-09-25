package com.simplug.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class MyInventoryMoveItemEvent implements Listener {

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
