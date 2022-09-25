package com.simplug.events;

import com.simplug.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

public class DamageEvent implements Listener {

    private static final Random RANDOM = new Random();


    @EventHandler
    public void damage(EntityDamageByEntityEvent entityDamageEvent) {

        if (entityDamageEvent.getDamager() instanceof Player) {

            Player player = (Player) entityDamageEvent.getDamager();

            entityDamageEvent.setDamage(entityDamageEvent.getDamage() + 40);
            Main.loggerGet().info("Damage = " + entityDamageEvent.getDamage());
        }
    }
}
