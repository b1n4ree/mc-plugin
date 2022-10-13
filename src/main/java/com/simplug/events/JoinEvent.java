package com.simplug.events;

import com.simplug.data.entity.PlayerData;
import com.simplug.service.PlayerDataService;
import com.simplug.utils.EntityUtils;
import com.simplug.utils.InventoryUtils;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private final PlayerDataService playerDataService;
    private final EntityUtils entityUtils;
    private final InventoryUtils inventoryUtils;

    public JoinEvent(PlayerDataService playerDataService, InventoryUtils inventoryUtils) {
        this.playerDataService = playerDataService;
        this.inventoryUtils = inventoryUtils;
        entityUtils = new EntityUtils();
    }


    @EventHandler
    public void join(PlayerJoinEvent playerJoinEvent) {

        Player player = playerJoinEvent.getPlayer();

        player.setCollidable(false);
        String playerName = player.getName();
        PlayerData playerData = playerDataService.getByPlayerName(playerName);

        if (playerData.getIsFirstOnServer()) {

            inventoryUtils.startInventory(player);
            playerData.setIsFirstOnServer(false);
        }
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

        for (Entity entity : player.getWorld().getChunkAt(0).getEntities()) {

            if (EntityType.CHICKEN.equals(entity.getType())) {
                if (chickenCount > 1) {
                    entity.remove();
                    chickenCount = chickenCount - 1;
                }

            } else if (EntityType.COW.equals(entity.getType())) {
                if (cowCount > 1) {
                    entity.remove();
                    cowCount = cowCount - 1;
                }

            } else if (EntityType.PIG.equals(entity.getType())) {
                if (pigCount > 1) {
                    entity.remove();
                    pigCount = pigCount - 1;
                }

            } else if (EntityType.MUSHROOM_COW.equals(entity.getType())) {
                if (mushroomCowCount > 1) {
                    entity.remove();
                    mushroomCowCount = mushroomCowCount - 1;
                }

            } else if (EntityType.SHEEP.equals(entity.getType())) {
                if (sheepCount > 1) {
                    entity.remove();
                    sheepCount = sheepCount - 1;
                }

            } else if (EntityType.HORSE.equals(entity.getType())) {
                if (horseCount > 1) {
                    entity.remove();
                    horseCount = horseCount - 1;
                }

            } else if (EntityType.SPIDER.equals(entity.getType())) {
                if (spiderCount > 1) {
                    entity.remove();
                    spiderCount = spiderCount - 1;
                }

            } else if (EntityType.CAVE_SPIDER.equals(entity.getType())) {
                if (caveSpiderCount > 1) {
                    entity.remove();
                    caveSpiderCount = caveSpiderCount - 1;
                }

            } else if (EntityType.IRON_GOLEM.equals(entity.getType())) {
                if (golemCount > 1) {
                    entity.remove();
                    golemCount = golemCount - 1;
                }

            } else if (EntityType.CREEPER.equals(entity.getType())) {
                if (creeperCount > 1) {
                    entity.remove();
                    creeperCount = creeperCount - 1;
                }

            } else if (EntityType.ZOMBIE.equals(entity.getType())) {
                if (zombieCount > 1) {
                    entity.remove();
                    zombieCount = zombieCount - 1;
                }

            } else if (EntityType.PIGLIN.equals(entity.getType())) {
                if (pigZombieCount > 1) {
                    entity.remove();
                    pigZombieCount = pigZombieCount -1;
                }

            } else if (EntityType.SKELETON.equals(entity.getType())) {
                if (skeletonCount > 1) {
                    entity.remove();
                    skeletonCount = skeletonCount - 1;
                }

            } else if (EntityType.WITHER.equals(entity.getType())) {
                if (witherCount > 1) {
                    entity.remove();
                    witherCount = witherCount - 1;
                }
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

