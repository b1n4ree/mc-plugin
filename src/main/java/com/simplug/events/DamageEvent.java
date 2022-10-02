package com.simplug.events;

import com.simplug.Main;
import com.simplug.utils.MyComponents;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageEvent implements Listener {

    private final MyComponents myComponents;

    public DamageEvent() {
        myComponents = new MyComponents();
    }


    @EventHandler
    public void damage(EntityDamageByEntityEvent entityDamageEvent) {

        Main.loggerGet().info("Entity damage event");
        if (entityDamageEvent.getDamager() instanceof Player) {

            Player player = (Player) entityDamageEvent.getDamager();
            entityDamageEvent.setDamage(entityDamageEvent.getDamage() + 40);

            Main.loggerGet().info("Damage = " + entityDamageEvent.getDamage());

            if (!entityDamageEvent.getEntity().isDead()) {

                LivingEntity livingEntity = (LivingEntity) entityDamageEvent.getEntity();
                livingEntity.customName(myComponents.hpBar(livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue(),
                        livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue() - entityDamageEvent.getDamage()));
            }

//            if (entityDamageEvent.getEntity() instanceof LivingEntity) {
//            }
        }
    }
}
