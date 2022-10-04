package com.simplug.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;

public class MyInventoryInteractIvent implements Listener {

    @EventHandler
    public void interact(InventoryInteractEvent inventoryInteractEvent) {

        inventoryInteractEvent.setCancelled(true);
    }
}
