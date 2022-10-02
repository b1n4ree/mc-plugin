package com.simplug.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class MyFoodEvent implements Listener {

    @EventHandler
    public void food(FoodLevelChangeEvent foodLevelChangeEvent) {

        foodLevelChangeEvent.setCancelled(true);
    }
}
