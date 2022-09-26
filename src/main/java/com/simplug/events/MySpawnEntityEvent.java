package com.simplug.events;

import com.simplug.service.PlayerDataService;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
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


        LivingEntity livingEntity = null;
        if (entitySpawnEvent.getEntity().getType().equals(EntityType.COW)) {

            livingEntity = (LivingEntity) entitySpawnEvent.getEntity();
            livingEntity.registerAttribute(Attribute.GENERIC_MAX_HEALTH);
            livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
            livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999, 9999, false, false, true));

            if (livingEntity.getHealth() <= 20) {

                livingEntity.setHealth(livingEntity.getHealth() + 1);
            } else {

                System.out.println("Достигнуто максимальное хп = " + livingEntity.getHealth());
            }
        }

    }
}
