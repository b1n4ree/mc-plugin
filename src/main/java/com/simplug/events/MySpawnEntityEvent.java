package com.simplug.events;

import com.simplug.service.PlayerDataService;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class MySpawnEntityEvent implements Listener {

    private final PlayerDataService playerDataService;
    private int countCow;
    private int countPig;

    public MySpawnEntityEvent(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
    }


    @EventHandler
    public void spawn(EntitySpawnEvent entitySpawnEvent) {


        entitySpawnEvent.getLocation().getWorld().
                getNearbyPlayers(new Location(entitySpawnEvent.getEntity().getWorld(), 9, 86, 17), 100)
                .forEach(player -> {
                    Player player1 = player;
                });
        if (entitySpawnEvent.getEntity().getType().equals(EntityType.COW)) {

            EntityType entityType = entitySpawnEvent.getEntity().getType();

            if (entityType.getDefaultAttributes().getAttribute(Attribute.GENERIC_MAX_HEALTH) != null) {

                entityType.getDefaultAttributes().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(3);
            }

            if (livingEntity.getHealth() <= 20) {

                livingEntity.setHealth(livingEntity.getHealth() + 1);
            } else {

                System.out.println("Достигнуто максимальное хп = " + livingEntity.getHealth());
            }
        }

    }
}
