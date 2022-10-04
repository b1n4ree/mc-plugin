package com.simplug.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;

public class MyVehicleEntityCollisionEvent implements Listener {

    @EventHandler
    public void collision(VehicleEntityCollisionEvent vehicleCollisionEvent) {

        vehicleCollisionEvent.setCollisionCancelled(true);
    }
}
