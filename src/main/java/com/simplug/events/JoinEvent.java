package com.simplug.events;

import com.simplug.Main;
import com.simplug.data.entity.PlayerData;
import com.simplug.service.PlayerDataService;
import com.simplug.utils.EntityUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

public class JoinEvent implements Listener {

    private final PlayerDataService playerDataService;
    private final EntityUtils entityUtils;

    public JoinEvent(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
        entityUtils = new EntityUtils();
    }


    @EventHandler
    public void join(PlayerJoinEvent playerJoinEvent) {

        Player player = playerJoinEvent.getPlayer();
        String playerName = player.getName();
        PlayerData playerData = playerDataService.getByPlayerName(playerName);
        playerData.setKillCount(playerData.getKillCountPig() + playerData.getKillCountCow());

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            public void run() {

                player.sendMessage("Start");
                PlayerData playerData1 = playerDataService.getByPlayerName(playerName);
                ScoreboardManager manager = Bukkit.getScoreboardManager();
                player.setScoreboard(manager.getNewScoreboard());
//                    final Scoreboard board = manager.getNewScoreboard();

                Scoreboard board = player.getScoreboard();

                Objective objective;
                if (board.getObjective("simplug") == null) {
                    objective = board.registerNewObjective("simplug", "dummy", Component.text("Stats by " + playerName).color(TextColor.color(200, 43, 169)));
                } else {
                    objective = board.getObjective("simplug");
                }

                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                //objective.displayName(Component.text("DisplayName"));
                //objective.setRenderType((new Random()).nextBoolean() ? RenderType.HEARTS : RenderType.INTEGER);
//                Main.loggerGet().info(" " + playerData1.getIsSpawnableWither());
                Score score = objective.getScore("Всего убийств");
                score.setScore(Math.toIntExact(playerData1.getKillCount()));
                if (playerData1.getIsSpawnableChicken()) {
                    Score scoreChicken = objective.getScore("Убийст цыпочек");
                    scoreChicken.setScore(Math.toIntExact(playerData1.getKillCountChicken()));
                }
                if (playerData1.getIsSpawnableCow()) {
                    Score scoreCow = objective.getScore("Убийств коров");
                    scoreCow.setScore(Math.toIntExact(playerData1.getKillCountCow()));
                }
                if (playerData1.getIsSpawnablePig()) {
                    Score scorePig = objective.getScore("Убийств свинок");
                    scorePig.setScore(Math.toIntExact(playerData1.getKillCountPig()));
                }
                if (playerData1.getIsSpawnableMushroomCow()) {
                    Score scoreMushroomCow = objective.getScore("Убийств грибных");
                    scoreMushroomCow.setScore(Math.toIntExact(playerData1.getKillCountMushroomCow()));
                }
                if (playerData1.getIsSpawnableSheep()) {
                    Score scoreSheep = objective.getScore("Убийств овец");
                    scoreSheep.setScore(Math.toIntExact(playerData1.getKillCountSheep()));
                }
                if (playerData1.getIsSpawnableHorse()) {
                    Score scoreHorse = objective.getScore("Убийств лошадей");
                    scoreHorse.setScore(Math.toIntExact(playerData1.getKillCountHorse()));
                }
                if (playerData1.getIsSpawnableSpider()) {
                    Score scoreSpider = objective.getScore("Убийств пауков");
                    scoreSpider.setScore(Math.toIntExact(playerData1.getKillCountSpider()));
                }
                if (playerData1.getIsSpawnableCaveSpider()) {
                    Score scoreCaveSpider = objective.getScore("Убийств пешерных пауков");
                    scoreCaveSpider.setScore(Math.toIntExact(playerData1.getKillCountCaveSpider()));
                }
                if (playerData1.getIsSpawnableGolem()) {
                    Score scoreGolem = objective.getScore("Убийств големов");
                    scoreGolem.setScore(Math.toIntExact(playerData1.getKillCountGolem()));
                }
                if (playerData1.getIsSpawnableCreeper()) {
                    Score scoreCreeper = objective.getScore("Убийст криперов");
                    scoreCreeper.setScore(Math.toIntExact(playerData1.getKillCountCreeper()));
                }
                if (playerData1.getIsSpawnableZombie()) {
                    Score scoreZombie = objective.getScore("Убийств зомби");
                    scoreZombie.setScore(Math.toIntExact(playerData1.getKillCountZombie()));
                }
                if (playerData1.getIsSpawnablePigZombie()) {
                    Score scorePiglin = objective.getScore("Убийств свино-зомби");
                    scorePiglin.setScore(Math.toIntExact(playerData1.getKillCountPigZombie()));
                }
                if (playerData1.getIsSpawnableSkeleton()) {
                    Score scoreSkeleton = objective.getScore("Убийств скелетов");
                    scoreSkeleton.setScore(Math.toIntExact(playerData1.getKillCountSkeleton()));
                }
                if (playerData1.getIsSpawnableWither()) {
                    Score scoreWither = objective.getScore("Убийств иссушителей");
                    scoreWither.setScore(Math.toIntExact(playerDataService.getByPlayerName(playerName).getKillCountWither()));
                }
//                player.setScoreboard(board);
            }
        },1, 5);
        player.setInvulnerable(true);

        Long chickenCount = 0L;
        Long cowCount = 0L;
        Long pigCount = 0L;
        Long mushroomCowCount = 0L;
        Long sheepCount = 0L;
        Long horseCount = 0L;
        Long spiderCount = 0L;
        Long caveSpiderCount = 0L;
        Long golemCount = 0L;
        Long creeperCount = 0L;
        Long zombieCount = 0L;
        Long pigZombieCount = 0L;
        Long skeletonCount = 0L;
        Long witherCount = 0L;

        for (Entity entity : player.getWorld().getChunkAt(0).getEntities()) {

            if (EntityType.CHICKEN.equals(entity.getType())) {
                chickenCount++;

            } else if (EntityType.COW.equals(entity.getType())) {
                cowCount++;

            } else if (EntityType.PIG.equals(entity.getType())) {
                pigCount++;

            } else if (EntityType.MUSHROOM_COW.equals(entity.getType())) {
                mushroomCowCount++;

            } else if (EntityType.SHEEP.equals(entity.getType())) {
                sheepCount++;

            } else if (EntityType.HORSE.equals(entity.getType())) {
                horseCount++;

            } else if (EntityType.SPIDER.equals(entity.getType())) {
                spiderCount++;

            } else if (EntityType.CAVE_SPIDER.equals(entity.getType())) {
                caveSpiderCount++;

            } else if (EntityType.IRON_GOLEM.equals(entity.getType())) {
                golemCount++;

            } else if (EntityType.CREEPER.equals(entity.getType())) {
                creeperCount++;

            } else if (EntityType.ZOMBIE.equals(entity.getType())) {
                zombieCount++;

            } else if (EntityType.PIGLIN.equals(entity.getType())) {
                pigZombieCount++;

            } else if (EntityType.SKELETON.equals(entity.getType())) {
                skeletonCount++;

            } else if (EntityType.WITHER.equals(entity.getType())) {
                witherCount++;

            }
        }
        Location chickenLocation = new Location(player.getWorld(), 13, 85, 1);
        Location cowLocation = new Location(player.getWorld(), 13, 85, 5);
        Location pigLocation = new Location(player.getWorld(), 13, 85, 9);
        Location mushRoomCowLocation = new Location(player.getWorld(), 13, 85, 13);
        Location sheepLocation = new Location(player.getWorld(), 9, 85, 1);
        Location horseLocation = new Location(player.getWorld(), 9, 85, 5);
        Location spiderLocation = new Location(player.getWorld(), 9, 85, 9);
        Location caveSpiderLocation = new Location(player.getWorld(), 9, 85, 13);
        Location golemLocation = new Location(player.getWorld(), 5, 85, 1);
        Location creeperLocation = new Location(player.getWorld(), 5, 85, 5);
        Location zombieLocation = new Location(player.getWorld(), 5, 85, 9);
        Location piglinLocation = new Location(player.getWorld(), 5, 85, 13);
        Location skeletonLocation = new Location(player.getWorld(), 1, 85, 1);
        Location witherLocation = new Location(player.getWorld(), 1, 85, 5);

        if (playerData.getIsSpawnableChicken()) {
            if (chickenCount == 0) {
                player.getWorld().spawnEntity(chickenLocation, entityUtils.chicken());
            }
        }
        if (playerData.getIsSpawnableCow()) {
            if (cowCount == 0) {
                player.getWorld().spawnEntity(cowLocation, entityUtils.cow());
            }
        }
        if (playerData.getIsSpawnablePig()) {
            if (pigCount == 0) {
                player.getWorld().spawnEntity(pigLocation, entityUtils.pig());
            }
        }
        if (playerData.getIsSpawnableMushroomCow()) {
            if (mushroomCowCount == 0) {
                player.getWorld().spawnEntity(mushRoomCowLocation, entityUtils.mushroomCow());
            }
        }
        if (playerData.getIsSpawnableSheep()) {
            if (sheepCount == 0) {
                player.getWorld().spawnEntity(sheepLocation, entityUtils.sheep());
            }
        }
        if (playerData.getIsSpawnableHorse()) {
            if (horseCount == 0) {
                player.getWorld().spawnEntity(horseLocation, entityUtils.horse());
            }
        }
        if (playerData.getIsSpawnableSpider()) {
            if (spiderCount == 0) {
                player.getWorld().spawnEntity(spiderLocation, entityUtils.spider());
            }
        }
        if (playerData.getIsSpawnableCaveSpider()) {
            if (caveSpiderCount == 0) {
                player.getWorld().spawnEntity(caveSpiderLocation, entityUtils.caveSpider());
            }
        }
        if (playerData.getIsSpawnableGolem()) {
            if (golemCount == 0) {
                player.getWorld().spawnEntity(golemLocation, entityUtils.golem());
            }
        }
        if (playerData.getIsSpawnableCreeper()) {
            if (creeperCount == 0) {
                player.getWorld().spawnEntity(creeperLocation, entityUtils.creeper());
            }
        }
        if (playerData.getIsSpawnableZombie()) {
            if (zombieCount == 0) {
                player.getWorld().spawnEntity(zombieLocation, entityUtils.zombie());
            }
        }
        if (playerData.getIsSpawnablePigZombie()) {
            if (pigZombieCount == 0) {
                player.getWorld().spawnEntity(piglinLocation, entityUtils.piglin());
            }
        }
        if (playerData.getIsSpawnableSkeleton()) {
            if (skeletonCount == 0) {
                player.getWorld().spawnEntity(skeletonLocation, entityUtils.skeleton());
            }
        }
        if (playerData.getIsSpawnableWither()) {
            if (witherCount == 0) {
                player.getWorld().spawnEntity(witherLocation, entityUtils.wither());
            }
        }
    }
}
