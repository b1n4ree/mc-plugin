package com.simplug;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

public class DamageEvent implements Listener {

    private static final Random RANDOM = new Random();


    @EventHandler
    public void damage(EntityDamageByEntityEvent entityDamageEvent) {

        System.out.println("Damage");

        if (entityDamageEvent.getDamager() instanceof Player) {

            Player player = (Player) entityDamageEvent.getDamager();

            if (player.getInventory().getItemInMainHand().getType().equals(Material.WOODEN_SWORD)) {

                int a = RANDOM.nextInt(1, 100);
                if (a <= 20) {
                    entityDamageEvent.setDamage(entityDamageEvent.getDamage() * 20);
                }
                Main.loggerGet().info("Damage = " + entityDamageEvent.getDamage());
            }
        }
    }
}
