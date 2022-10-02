package com.simplug.events;

import com.simplug.data.entity.PlayerData;
import com.simplug.service.PlayerDataService;
import com.simplug.utils.EntityUtils;
import de.tr7zw.nbtapi.NBTBlock;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Location;
import org.bukkit.Material;
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

        if (entityDeathEvent.getEntity().getKiller().getPlayer() != null) {

            player = (Player) entityDeathEvent.getEntity().getKiller().getPlayer();

            PlayerData playerData = playerDataService.getByPlayerName(player.getName());
            playerData.setExperience(playerData.getExperience() + entityDeathEvent.getDroppedExp());

            if (entityDeathEvent.getEntity().getType().equals(entityUtils.cow())) {

                playerData.setKillCountCow(playerData.getKillCountCow() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(new Location(player.getWorld(), 9, 86, 17), entityUtils.cow());
                playerData.setKillCount(playerData.getKillCountPig() + playerData.getKillCountCow());

            } else if (entityDeathEvent.getEntity().getType().equals(entityUtils.pig())) {

                playerData.setKillCountPig(playerData.getKillCountPig() + 1);
                entityDeathEvent.getEntity().getWorld().spawnEntity(new Location(player.getWorld(), 9, 86, 13), entityUtils.pig())
                        .customName(Component.text("Хрюшка").color(TextColor.color(123, 123, 123)));
                playerData.setKillCount(playerData.getKillCountPig() + playerData.getKillCountCow());
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
                        playerDataService.invalidateCached(player.getName());

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
                        playerDataService.invalidateCached(player.getName());

                    } else {

                        player.sendMessage("Достигнут минимальный уровень моба");
                        player.sendMessage("LVL =" + playerDataService.getByPlayerName(player.getName()).getSpawnChickenLvl());
                    }
                }
            }
        }
    }
}
