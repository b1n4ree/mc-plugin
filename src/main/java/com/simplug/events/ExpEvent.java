package com.simplug.events;

import com.simplug.data.entity.PlayerData;
import com.simplug.service.PlayerDataService;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class ExpEvent implements Listener {

    private final PlayerDataService playerDataService;

    public ExpEvent(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
    }


    @EventHandler
    public void getExp(EntityDeathEvent entityDeathEvent) {


        EntityType cow = EntityType.COW;
        EntityType pig = EntityType.PIG;
        Player player = null;

        if (entityDeathEvent.getEntity().getKiller().getPlayer() != null) {

            player = (Player) entityDeathEvent.getEntity().getKiller().getPlayer();

            PlayerData playerData = playerDataService.getByPlayerName(player.getName());
            playerData.setExperience(playerData.getExperience() + entityDeathEvent.getDroppedExp());
            playerData.setKillCount(playerData.getKillCountPig() + playerData.getKillCountCow());

            if (entityDeathEvent.getEntity().getType().equals(cow)) {

                playerData.setKillCountCow(playerData.getKillCountCow() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(new Location(player.getWorld(), 9, 86, 17), cow);

            } else if (entityDeathEvent.getEntity().getType().equals(pig)) {

                playerData.setKillCountPig(playerData.getKillCountPig() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(new Location(player.getWorld(), 9, 86, 13), pig);
            }
        }

    }

    @EventHandler
    public void getCoor(PlayerInteractEvent playerInteractEvent) {

        if (playerInteractEvent.getClickedBlock() != null) {
            {


                int x = playerInteractEvent.getClickedBlock().getX();
                int y = playerInteractEvent.getClickedBlock().getY();
                int z = playerInteractEvent.getClickedBlock().getZ();
                Player player = (Player) playerInteractEvent.getPlayer();

                if (player != null) {

                    Component component = Component.text("X=" + x).color(TextColor.color(255, 0, 13))
                            .append(Component.text(" Y=" + y).color(TextColor.color(69, 255, 1)))
                            .append(Component.text(" Z=" + z).color(TextColor.color(1, 0, 255)));

                    player.sendMessage(component);
                }
            }
        } else {

            playerInteractEvent.setCancelled(true);
        }
    }
}
