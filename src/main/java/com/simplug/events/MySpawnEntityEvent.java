package com.simplug.events;

import com.simplug.service.PlayerDataService;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;


public class MySpawnEntityEvent implements Listener {

    private final PlayerDataService playerDataService;

    public MySpawnEntityEvent(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
    }


    @EventHandler
    public void spawn(EntitySpawnEvent entitySpawnEvent) {


        Player player = entitySpawnEvent.getLocation().getWorld().
                getNearbyPlayers(new Location(entitySpawnEvent.getEntity().getWorld(), 9, 86, 17), 100)
                .stream().findFirst().get();

        if (entitySpawnEvent.getEntity().getType().equals(EntityType.COW)) {

            player.sendMessage("Rapotaet spawn");
            Entity entity = entitySpawnEvent.getEntity();

            if (entity instanceof LivingEntity) {

                LivingEntity livingEntity = (LivingEntity) entity;

                if (livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH) != null) {

                    livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);

                } else {

                    livingEntity.registerAttribute(Attribute.GENERIC_MAX_HEALTH);
                    livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40);
                }
            }
        }
    }
}
