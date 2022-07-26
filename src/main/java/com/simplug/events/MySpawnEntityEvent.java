package com.simplug.events;

import com.simplug.Main;
import com.simplug.service.PlayerDataService;
import com.simplug.utils.MyComponents;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;


public class MySpawnEntityEvent implements Listener {

    private final MyComponents myComponents;
    private final PlayerDataService playerDataService;

    public MySpawnEntityEvent(PlayerDataService playerDataService) {
        myComponents = new MyComponents();
        this.playerDataService = playerDataService;
    }


    @EventHandler
    public void spawn(EntitySpawnEvent entitySpawnEvent) {

        if (entitySpawnEvent.getEntity() instanceof LivingEntity livingEntity) {

            livingEntity.customName(myComponents.hpBar(livingEntity.getHealth(), livingEntity.getHealth()));
            livingEntity.setCustomNameVisible(true);

            Main.loggerGet().info("Vse-taki zarabotala");

            if (livingEntity.getType().equals(EntityType.CHICKEN)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            } else if (livingEntity.getType().equals(EntityType.COW)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            } else if (livingEntity.getType().equals(EntityType.PIG)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            } else if (livingEntity.getType().equals(EntityType.MUSHROOM_COW)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            } else if (livingEntity.getType().equals(EntityType.SHEEP)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            } else if (livingEntity.getType().equals(EntityType.HORSE)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            } else if (livingEntity.getType().equals(EntityType.SPIDER)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            } else if (livingEntity.getType().equals(EntityType.CAVE_SPIDER)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            } else if (livingEntity.getType().equals(EntityType.IRON_GOLEM)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            } else if (livingEntity.getType().equals(EntityType.CREEPER)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            } else if (livingEntity.getType().equals(EntityType.ZOMBIE)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            } else if (livingEntity.getType().equals(EntityType.PIGLIN)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            } else if (livingEntity.getType().equals(EntityType.SKELETON)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            } else if (livingEntity.getType().equals(EntityType.WITHER_SKELETON)) {

                if (livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_ATTACK_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
                }
                if (livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                } else {
                    livingEntity.registerAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                    livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
                }
            }
        }
    }
}
