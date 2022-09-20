package com.simplug.events;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class MySpawnEntityEvent implements Listener {

    @EventHandler
    public void spawn(EntitySpawnEvent entitySpawnEvent) {

        Player player = null;
        LivingEntity livingEntity = null;
        if (entitySpawnEvent.getEntity().getType().equals(EntityType.COW)) {

            livingEntity = (LivingEntity) entitySpawnEvent.getEntity();
            livingEntity.registerAttribute(Attribute.GENERIC_MAX_HEALTH);
            livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);

            if (livingEntity.getHealth() >= 20) {

                livingEntity.setHealth(livingEntity.getHealth() + 1);
            } else {

                System.out.println("Достигнуто максимальное хп");
            }

        }
    }
}
