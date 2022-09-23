package com.simplug.events;

import com.simplug.data.entity.PlayerData;
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
    public String playerName;

    public JoinEvent(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
        playerName = new String();
    }

    public String getPlayerName(){
        return playerName;
    }

    @EventHandler
    public void join(PlayerJoinEvent playerJoinEvent) {

        EntityType cow = EntityType.COW;
        EntityType pig = EntityType.PIG;
        Player player = playerJoinEvent.getPlayer();
        player.setInvulnerable(true);
        playerName = player.getName();

        PlayerData playerData = playerDataService.getByPlayerName(playerName);
        playerData.setKillCount(playerData.getKillCountPig() + playerData.getKillCountCow());



        Component component = Component.text("Еблан красноголовый").color(TextColor.color(255, 0, 13));

        if (player.getLocation().getY() < 100) {

            player.setCustomNameVisible(true);
            player.getWorld().spawnEntity(new Location(player.getWorld(), 9, 86, 17), cow).setCustomName(ChatColor.RED + "Eblan KraSnogoloviy");
            player.getWorld().spawnEntity(new Location(player.getWorld(), 9, 86, 13), pig).setCustomName(ChatColor.RED + "Eblan RozoVogoloviy");
        }
    }
}
