package com.simplug.events;

import com.simplug.service.PlayerDataService;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private final PlayerDataService playerDataService;

    public JoinEvent(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
    }

    @EventHandler
    public void join(PlayerJoinEvent playerJoinEvent) {

        EntityType cow = EntityType.COW;
        Player player = playerJoinEvent.getPlayer();
        Component component = Component.text("Еблан красноголовый").color(TextColor.color(255, 0, 13));


            if (player.getLocation().getY() < 100) {

                player.setCustomNameVisible(true);
                player.getWorld().spawnEntity(new Location(player.getWorld(), 9, 86, 17), cow).setCustomName(ChatColor.RED + "Eblan KraSnogoloviy");
        }
    }
}
