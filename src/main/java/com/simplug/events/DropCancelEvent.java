package com.simplug.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropCancelEvent implements Listener {

    @EventHandler
    public void drop(EntityDropItemEvent entityDropItemEvent) {

        System.out.println("DropItemEvent");
        entityDropItemEvent.getItemDrop().remove();
    }

    @EventHandler
    public void drop1(BlockDropItemEvent blockDropItemEvent) {

        blockDropItemEvent.setCancelled(true);
    }

    @EventHandler
    public void drop2(PlayerDropItemEvent playerDropItemEvent) {

        playerDropItemEvent.setCancelled(true);
    }
}
