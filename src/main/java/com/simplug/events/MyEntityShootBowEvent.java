package com.simplug.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class MyEntityShootBowEvent implements Listener {

    @EventHandler
    public void target(EntityShootBowEvent entityShootBowEvent) {

        entityShootBowEvent.getEntity().setArrowsStuck(0);
        entityShootBowEvent.setCancelled(true);
    }
}
