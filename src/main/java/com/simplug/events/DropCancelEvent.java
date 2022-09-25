package com.simplug.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;

public class DropCancelEvent implements Listener {

    @EventHandler
    public void drop(EntityDropItemEvent entityDropItemEvent) {

        System.out.println("DropItemEvent");
        entityDropItemEvent.setCancelled(true);
    }
}
