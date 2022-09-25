package com.simplug.events;

import com.simplug.Main;
import com.simplug.data.entity.PlayerData;
import com.simplug.service.PlayerDataService;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import java.util.Random;


public class JoinEvent implements Listener {

    private final PlayerDataService playerDataService;

    public JoinEvent(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
    }


    @EventHandler
    public void join(PlayerJoinEvent playerJoinEvent) {

        Player player = playerJoinEvent.getPlayer();
        String playerName = player.getName();
        PlayerData playerData = playerDataService.getByPlayerName(playerName);
        playerData.setKillCount(playerData.getKillCountPig() + playerData.getKillCountCow());

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



                Score score = objective.getScore("Всего убийств");
                score.setScore(Math.toIntExact(playerDataService.getByPlayerName(playerName).getKillCount()));
                Score score1 = objective.getScore("Убийст коров");
                score1.setScore(Math.toIntExact(playerDataService.getByPlayerName(playerName).getKillCountCow()));
                Score score2 = objective.getScore("Убийст свинок");
                score2.setScore(Math.toIntExact(playerDataService.getByPlayerName(playerName).getKillCountPig()));
                Score score3 = objective.getScore("§6ЦветнаяХуйня");
                score3.setScore((new Random()).nextInt(100));
                //player.setScoreboard(board);
            }
        },1, 5);


        EntityType cow = EntityType.COW;
        EntityType pig = EntityType.PIG;
        player.setInvulnerable(true);




        Component component = Component.text("Еблан красноголовый").color(TextColor.color(255, 0, 13));

        if (player.getLocation().getY() < 100) {

            player.setCustomNameVisible(true);
            player.getWorld().spawnEntity(new Location(player.getWorld(), 9, 86, 17), cow).setCustomName(ChatColor.RED + "Eblan KraSnogoloviy");
            player.getWorld().spawnEntity(new Location(player.getWorld(), 9, 86, 13), pig).setCustomName(ChatColor.RED + "Eblan RozoVogoloviy");
        }
    }
}
