package com.simplug.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public class MyInventoryMoveItemEvent implements Listener {

    @EventHandler
    public void cancelMove(InventoryMoveItemEvent inventoryMoveItemEvent) {

        inventoryMoveItemEvent.setCancelled(true);
    }
}
