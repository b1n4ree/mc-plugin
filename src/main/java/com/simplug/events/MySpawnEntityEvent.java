package com.simplug.events;

import com.simplug.data.entity.PlayerData;
import com.simplug.service.PlayerDataService;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.List;

public class MySpawnEntityEvent implements Listener {

    private final PlayerDataService playerDataService;
    private final JoinEvent joinEvent;
    private int countCow;
    private int countPig;

    public MySpawnEntityEvent(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
        joinEvent = new JoinEvent(playerDataService);
    }


    @EventHandler
    public void spawn(EntitySpawnEvent entitySpawnEvent) {

        List<Player> playerList = entitySpawnEvent.getLocation().getWorld().getPlayers();
        PlayerData playerData = playerDataService.getByPlayerName(joinEvent.getPlayerName());

        Player player = null;
        LivingEntity livingEntity = null;
        if (entitySpawnEvent.getEntity().getType().equals(EntityType.COW)) {

            livingEntity = (LivingEntity) entitySpawnEvent.getEntity();
            livingEntity.registerAttribute(Attribute.GENERIC_MAX_HEALTH);
            livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);

            if (livingEntity.getHealth() >= 20) {

                livingEntity.setHealth(livingEntity.getHealth() + 1);
            } else {

                System.out.println("Достигнуто максимальное хп = " + livingEntity.getHealth());
            }
        }
    }
}
