package com.simplug.listener;

import com.simplug.service.PlayerDataService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.logging.Logger;

public class PlayerQuitAndJoinListener implements Listener {

    private final PlayerDataService playerDataService;

    private final Logger log;

    public PlayerQuitAndJoinListener(PlayerDataService playerDataService, Logger log) {
        this.playerDataService = playerDataService;
        this.log = log;
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent playerQuitEvent) {
        log.info("onPlayerQuitEvent, playerName = " + playerQuitEvent.getPlayer().getName());
        playerDataService.invalidateCached(playerQuitEvent.getPlayer().getName());
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent playerJoinEvent) {
        log.info("onPlayerJoinEvent, playerName = " + playerJoinEvent.getPlayer().getName());
        playerDataService.loadCachedAsync(playerJoinEvent.getPlayer().getName());
    }
}
