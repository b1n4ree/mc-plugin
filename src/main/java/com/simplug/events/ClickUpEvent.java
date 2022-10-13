package com.simplug.events;

import com.simplug.Main;
import com.simplug.data.entity.PlayerData;
import com.simplug.service.PlayerDataService;
import com.simplug.utils.InventoryUtils;
import com.simplug.utils.ItemsUtils;
import de.tr7zw.nbtapi.NBTItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.*;


public class ClickUpEvent implements Listener {

    private final ItemsUtils itemsUtils;
    private final PlayerDataService playerDataService;
    private final InventoryUtils inventoryUtils;

    public ClickUpEvent(PlayerDataService playerDataService, InventoryUtils inventoryUtils) {
        this.playerDataService = playerDataService;
        this.inventoryUtils = inventoryUtils;
        itemsUtils = new ItemsUtils();
    }

    @EventHandler
    public void click(InventoryClickEvent inventoryInteractEvent) {

        if (inventoryInteractEvent.getWhoClicked() instanceof Player player) {
            if (inventoryInteractEvent.getCurrentItem() != null) {

                PlayerData playerData = playerDataService.getByPlayerName(inventoryInteractEvent.getWhoClicked().getName());

                String playerName = playerData.getPlayerName();

                if (playerData.getIsFirstOnServer()) {

                    inventoryUtils.startInventory(player);
                    playerData.setIsFirstOnServer(false);
                }

                inventoryInteractEvent.getWhoClicked().sendMessage(ChatColor.GOLD + "Клик по айтему");

                if (!inventoryInteractEvent.getCurrentItem().getType().equals(Material.AIR)) {
                    ItemStack currentItem = inventoryInteractEvent.getCurrentItem();
                    NBTItem currentItemNbt = new NBTItem(currentItem);

                    if (currentItemNbt.getString("start").equals("spawn")) {

                        player.openInventory(inventoryUtils.spawnDiamondInventory(player));

                    } else if (currentItemNbt.getString("start").equals("update")) {

                        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                            public void run() {

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
                                score.setScore(Math.toIntExact(playerData.getKillCount()));
                                if (playerData.getIsSpawnableChicken()) {
                                    Score scoreChicken = objective.getScore("   Цыпочек");
                                    scoreChicken.setScore(Math.toIntExact(playerData.getKillCountChicken()));
                                }
                                if (playerData.getIsSpawnableCow()) {
                                    Score scoreCow = objective.getScore("   Коров");
                                    scoreCow.setScore(Math.toIntExact(playerData.getKillCountCow()));
                                }
                                if (playerData.getIsSpawnablePig()) {
                                    Score scorePig = objective.getScore("   Свинок");
                                    scorePig.setScore(Math.toIntExact(playerData.getKillCountPig()));
                                }
                                if (playerData.getIsSpawnableMushroomCow()) {
                                    Score scoreMushroomCow = objective.getScore("   Грибных");
                                    scoreMushroomCow.setScore(Math.toIntExact(playerData.getKillCountMushroomCow()));
                                }
                                if (playerData.getIsSpawnableSheep()) {
                                    Score scoreSheep = objective.getScore("   Овец");
                                    scoreSheep.setScore(Math.toIntExact(playerData.getKillCountSheep()));
                                }
                                if (playerData.getIsSpawnableHorse()) {
                                    Score scoreHorse = objective.getScore("   Лошадей");
                                    scoreHorse.setScore(Math.toIntExact(playerData.getKillCountHorse()));
                                }
                                if (playerData.getIsSpawnableSpider()) {
                                    Score scoreSpider = objective.getScore("   Пауков");
                                    scoreSpider.setScore(Math.toIntExact(playerData.getKillCountSpider()));
                                }
                                if (playerData.getIsSpawnableCaveSpider()) {
                                    Score scoreCaveSpider = objective.getScore("   Пешерных");
                                    scoreCaveSpider.setScore(Math.toIntExact(playerData.getKillCountCaveSpider()));
                                }
                                if (playerData.getIsSpawnableGolem()) {
                                    Score scoreGolem = objective.getScore("   Големов");
                                    scoreGolem.setScore(Math.toIntExact(playerData.getKillCountGolem()));
                                }
                                if (playerData.getIsSpawnableCreeper()) {
                                    Score scoreCreeper = objective.getScore("   Криперов");
                                    scoreCreeper.setScore(Math.toIntExact(playerData.getKillCountCreeper()));
                                }
                                if (playerData.getIsSpawnableZombie()) {
                                    Score scoreZombie = objective.getScore("   Зомби");
                                    scoreZombie.setScore(Math.toIntExact(playerData.getKillCountZombie()));
                                }
                                if (playerData.getIsSpawnablePigZombie()) {
                                    Score scorePiglin = objective.getScore("   Свино-зомби");
                                    scorePiglin.setScore(Math.toIntExact(playerData.getKillCountPigZombie()));
                                }
                                if (playerData.getIsSpawnableSkeleton()) {
                                    Score scoreSkeleton = objective.getScore("   Скелетов");
                                    scoreSkeleton.setScore(Math.toIntExact(playerData.getKillCountSkeleton()));
                                }
                                if (playerData.getIsSpawnableWither()) {
                                    Score scoreWither = objective.getScore("   Иссушителей");
                                    scoreWither.setScore(Math.toIntExact(playerDataService.getByPlayerName(playerName).getKillCountWither()));
                                }
//                player.setScoreboard(board);
                            }
                        } ,20, 20);

                        player.sendMessage("Updated");
                    }
                }
            }
        }
    }
}
