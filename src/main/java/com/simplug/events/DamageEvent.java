package com.simplug.events;

import com.simplug.Main;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
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
            entityDamageEvent.getEntity().setCustomNameVisible(true);
            entityDamageEvent.setDamage(entityDamageEvent.getDamage() + 40);

            if (entityDamageEvent.getEntity() instanceof LivingEntity) {

                ((LivingEntity) entityDamageEvent.getEntity()).setHealth(((LivingEntity)
                        entityDamageEvent.getEntity()).getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                Double hp = ((LivingEntity) entityDamageEvent.getEntity()).getHealth();
                Main.loggerGet().info("HP = " + hp);
                entityDamageEvent.getEntity().customName(Component.text("HP ").color(TextColor.color(69, 255, 1))
                        .append(Component.text("" + hp).color(TextColor.color(255, 0, 13))));
            }
        }
    }
}
