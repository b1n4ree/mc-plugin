package com.simplug.events;

import com.simplug.Main;
import com.simplug.data.entity.PlayerData;
import com.simplug.service.PlayerDataService;
import com.simplug.utils.MyComponents;
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

    private final MyComponents myComponents;
    private final PlayerDataService playerDataService;

    public MySpawnEntityEvent(PlayerDataService playerDataService) {
        myComponents = new MyComponents();
        this.playerDataService = playerDataService;
    }


    @EventHandler
    public void spawn(EntitySpawnEvent entitySpawnEvent) {


        Player player = entitySpawnEvent.getLocation().getWorld().
                getNearbyPlayers(new Location(entitySpawnEvent.getEntity().getWorld(), 9, 86, 17), 100)
                .stream().findFirst().get();

        PlayerData playerData = playerDataService.getByPlayerName(player.getName());
        Long cowLvl = playerData.getSpawnChickenLvl();

        if (entitySpawnEvent.getEntity() instanceof LivingEntity livingEntity) {

            player.sendMessage("Rabotaet att");
            livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0);
            player.sendMessage("Rabotaet attdsa" + livingEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue());
            livingEntity.getAttribute(Attribute.GENERIC_FLYING_SPEED).setBaseValue(0);
            player.sendMessage("Rabotaet attas" + livingEntity.getAttribute(Attribute.GENERIC_FLYING_SPEED).getValue());
            livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(0);
            player.sendMessage("Rabotaet att" + livingEntity.getAttribute(Attribute.GENERIC_ATTACK_SPEED).getValue());
        }

        if (entitySpawnEvent.getEntity().getType().equals(EntityType.COW)) {

            player.sendMessage("Rabotaet spawn");
            Entity entity = entitySpawnEvent.getEntity();

            if (entity instanceof LivingEntity livingEntity) {

                livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(301);
                livingEntity.setHealth(300);

                Main.loggerGet().info("DAMAGE = " + livingEntity.getLastDamage());
                livingEntity.customName(myComponents.hpBar(livingEntity.getHealth(), livingEntity.getHealth()));
                livingEntity.setCustomNameVisible(true);

            }
        }
    }
}
