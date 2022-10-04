package com.simplug.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;

public class MyEntityCombustEvent implements Listener {

    @EventHandler
    public void combust(EntityCombustEvent entityCombustEvent) {

        entityCombustEvent.setCancelled(true);
    }
}
