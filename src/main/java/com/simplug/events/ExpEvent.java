package com.simplug.events;

import com.simplug.data.entity.PlayerData;
import com.simplug.service.PlayerDataService;
import com.simplug.utils.EntityUtils;
import de.tr7zw.nbtapi.NBTBlock;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class ExpEvent implements Listener {

    private final PlayerDataService playerDataService;
    private final EntityUtils entityUtils;

    public ExpEvent(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
        entityUtils = new EntityUtils();
    }


    @EventHandler
    public void getExp(EntityDeathEvent entityDeathEvent) {

        Player player = null;
        entityDeathEvent.getDrops().clear();

//        if (entityDeathEvent.getEntity().getKiller() == null) {
//            entityDeathEvent.setCancelled(true);
//        }

        if (entityDeathEvent.getEntity().getKiller() != null) {

            player = (Player) entityDeathEvent.getEntity().getKiller();

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

            PlayerData playerData = playerDataService.getByPlayerName(player.getName());
            playerData.setExperience(playerData.getExperience() + entityDeathEvent.getDroppedExp());
            EntityType entityType = entityDeathEvent.getEntity().getType();

            if (entityType.equals(entityUtils.cow())) {

                playerData.setKillCountCow(playerData.getKillCountCow() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(cowLocation, entityUtils.cow());
                playerData.setKillCount(playerData.getKillCount() + 1);

            } else if (entityType.equals(entityUtils.pig())) {

                playerData.setKillCountPig(playerData.getKillCountPig() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(pigLocation, entityUtils.pig());
                playerData.setKillCount(playerData.getKillCount() + 1);

            } else if (entityType.equals(entityUtils.chicken())) {

                playerData.setKillCountChicken(playerData.getKillCountChicken() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(chickenLocation, entityUtils.chicken());
                playerData.setKillCount(playerData.getKillCount() + 1);

            } else if (entityType.equals(entityUtils.mushroomCow())) {

                playerData.setKillCountMushroomCow(playerData.getKillCountMushroomCow() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(mushRoomCowLocation, entityUtils.mushroomCow());
                playerData.setKillCount(playerData.getKillCount() + 1);

            } else if (entityType.equals(entityUtils.sheep())) {

                playerData.setKillCountSheep(playerData.getKillCountSheep() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(sheepLocation, entityUtils.sheep());
                playerData.setKillCount(playerData.getKillCount() + 1);

            } else if (entityType.equals(entityUtils.horse())) {

                playerData.setKillCountHorse(playerData.getKillCountHorse() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(horseLocation, entityUtils.horse());
                playerData.setKillCount(playerData.getKillCount() + 1);

            } else if (entityType.equals(entityUtils.spider())) {

                playerData.setKillCountSpider(playerData.getKillCountSpider() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(spiderLocation, entityUtils.spider());
                playerData.setKillCount(playerData.getKillCount() + 1);

            } else if (entityType.equals(entityUtils.caveSpider())) {

                playerData.setKillCountCaveSpider(playerData.getKillCountCaveSpider() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(caveSpiderLocation, entityUtils.caveSpider());
                playerData.setKillCount(playerData.getKillCount() + 1);

            } else if (entityType.equals(entityUtils.golem())) {

                playerData.setKillCountGolem(playerData.getKillCountGolem() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(golemLocation, entityUtils.golem());
                playerData.setKillCount(playerData.getKillCount() + 1);

            } else if (entityType.equals(entityUtils.creeper())) {

                playerData.setKillCountCreeper(playerData.getKillCountCreeper() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(creeperLocation, entityUtils.creeper());
                playerData.setKillCount(playerData.getKillCount() + 1);

            } else if (entityType.equals(entityUtils.zombie())) {

                playerData.setKillCountZombie(playerData.getKillCountZombie() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(zombieLocation, entityUtils.zombie());
                playerData.setKillCount(playerData.getKillCount() + 1);

            } else if (entityType.equals(entityUtils.piglin())) {

                playerData.setKillCountPigZombie(playerData.getKillCountPigZombie() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(piglinLocation, entityUtils.piglin());
                playerData.setKillCount(playerData.getKillCount() + 1);

            } else if (entityType.equals(entityUtils.skeleton())) {

                playerData.setKillCountSkeleton(playerData.getKillCountSkeleton() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(skeletonLocation, entityUtils.skeleton());
                playerData.setKillCount(playerData.getKillCount() + 1);

            } else if (entityType.equals(entityUtils.wither())) {

                playerData.setKillCountWither(playerData.getKillCountWither() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(witherLocation, entityUtils.wither());
                playerData.setKillCount(playerData.getKillCount() + 1);
            }
        }
    }

    @EventHandler
    public void getCoor(PlayerInteractEvent playerInteractEvent) {

        if (playerInteractEvent.getClickedBlock() != null) {

            int x = playerInteractEvent.getClickedBlock().getX();
            int y = playerInteractEvent.getClickedBlock().getY();
            int z = playerInteractEvent.getClickedBlock().getZ();
            Player player = (Player) playerInteractEvent.getPlayer();
            player.sendMessage("Chunk " + playerInteractEvent.getClickedBlock().getChunk().getChunkKey());

            PlayerData playerData = playerDataService.getByPlayerName(player.getName());
            Component component = Component.text("X=" + x).color(TextColor.color(255, 0, 13))
                    .append(Component.text(" Y=" + y).color(TextColor.color(69, 255, 1)))
                    .append(Component.text(" Z=" + z).color(TextColor.color(1, 0, 255)));

            player.sendMessage(component);

            if (playerInteractEvent.getClickedBlock().getType().equals(Material.DIAMOND_BLOCK)) {

                NBTBlock nbtBlock = new NBTBlock(playerInteractEvent.getClickedBlock());
                player.sendMessage("SomeD" + nbtBlock.getData().getString("spawnMobLvl"));

                if (nbtBlock.getData().getString("spawnMobLvl").equals("up")) {

                    if (playerDataService.getByPlayerName(player.getName()).getSpawnChickenLvl() < 14) {

                        playerDataService.getByPlayerName(player.getName()).setSpawnChickenLvl(playerData.getSpawnChickenLvl() + 1);
                        player.sendMessage("LVL =" + playerDataService.getByPlayerName(player.getName()).getSpawnChickenLvl());

                    } else {

                        player.sendMessage("Достигнут максимальный уровень моба");
                        player.sendMessage("LVL =" + playerDataService.getByPlayerName(player.getName()).getSpawnChickenLvl());
                    }
                }
            } else if (playerInteractEvent.getClickedBlock().getType().equals(Material.GOLD_BLOCK)) {

                NBTBlock nbtBlock = new NBTBlock(playerInteractEvent.getClickedBlock());
                player.sendMessage("SomeG" + nbtBlock.getData().getString("spawnMobLvl"));

                if (nbtBlock.getData().getString("spawnMobLvl").equals("down")) {

                    if (playerDataService.getByPlayerName(player.getName()).getSpawnChickenLvl() > 0) {

                        playerDataService.getByPlayerName(player.getName()).setSpawnChickenLvl(playerData.getSpawnChickenLvl() - 1);
                        player.sendMessage("LVL =" + playerDataService.getByPlayerName(player.getName()).getSpawnChickenLvl());

                    } else {

                        player.sendMessage("Достигнут минимальный уровень моба");
                        player.sendMessage("LVL =" + playerDataService.getByPlayerName(player.getName()).getSpawnChickenLvl());
                    }
                }
            }
        }
    }
}
