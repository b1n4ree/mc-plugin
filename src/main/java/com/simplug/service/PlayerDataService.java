package com.simplug.service;

import com.github.benmanes.caffeine.cache.*;
import com.google.common.cache.CacheBuilder;
import com.simplug.Main;
import com.simplug.data.dao.PlayerDataDao;
import com.simplug.data.entity.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class PlayerDataService {

    private final LoadingCache<String, PlayerData> cachePlayerData;

    private final PlayerDataDao playerDataDao;

    private final Logger log;

    private final ScheduledExecutorService executorService;

    public PlayerDataService(PlayerDataDao playerDataDao, Logger log) {
        this.playerDataDao = playerDataDao;
        this.log = log;
        executorService = Executors.newScheduledThreadPool(8);
        cachePlayerData = Caffeine.newBuilder()
                .expireAfterWrite(Duration.ofHours(24))
                .removalListener(new RemovalListener<String, PlayerData>() {
                    @Override
                    public void onRemoval(@Nullable String keyPlayerName, @Nullable PlayerData playerData, RemovalCause removalCause) {
                        playerDataDao.update(playerData);
                        log.info("[Авто-сохранение] (cache.onRemoval) Данные игрока '" + keyPlayerName + "' сохранены в базу данных, removalCause = " + removalCause);
                    }
                })
                .build(playerName -> findOrCreateByPlayerName(playerName));

        initAutoSaveTask();
    }

    private void initAutoSaveTask() {
        executorService.scheduleAtFixedRate(() -> {

            log.info("[Авто-сохранение] Запуск авто-сохранения данных игроков...");
            List<String> onlinePlayerNames = Bukkit
                    .getOnlinePlayers()
                    .stream()
                    .map(HumanEntity::getName)
                    .toList();

            log.info("[Авто-сохранение] Размер списка имен игроков онлайн = " + onlinePlayerNames.size());

            long startMillis = System.currentTimeMillis();
            List<PlayerData> playerDataList = new ArrayList<>(cachePlayerData.getAll(onlinePlayerNames).values());
            log.info("[Авто-сохранение] Получение данных из кэша заняло = " + (System.currentTimeMillis() - startMillis) + "ms");

            log.info("[Авто-сохранение] Сохраняю данные из кэша в базу данных...");
            startMillis = System.currentTimeMillis();
            playerDataDao.updateAll(playerDataList);
            log.info("[Авто-сохранение] Вызов метода сохранения в базу данных занял = " + (System.currentTimeMillis() - startMillis) + "ms");

        }, 5, 5, TimeUnit.MINUTES);
    }

    private PlayerData findOrCreateByPlayerName(String playerName) {
        return playerDataDao.findOrCreateByPlayerName(playerName);
    }

    public PlayerData getByPlayerName(String playerName) {
        return cachePlayerData.get(playerName);
    }

    public void invalidateCached(String playerName) {
        cachePlayerData.invalidate(playerName);
    }

    public void loadCachedAsync(String playerName) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                cachePlayerData.get(playerName);
            }
        });
    }

//    public void shutdown(boolean areYouSure) {
//
//        executorService.shutdown();
//        try {
//            if (!executorService.awaitTermination(2, TimeUnit.SECONDS)) {
//                executorService.shutdownNow();
//
//                if (!executorService.awaitTermination(60, TimeUnit.SECONDS))
//                    System.err.println("ExecutorService did not terminate");
//            }
//        } catch (InterruptedException ie) {
//            executorService.shutdownNow();
//            Thread.currentThread().interrupt();
//        }
//    }
}
