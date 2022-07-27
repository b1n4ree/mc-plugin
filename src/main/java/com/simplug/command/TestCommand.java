package com.simplug.command;

import com.simplug.Main;
import com.simplug.data.entity.PlayerData;
import com.simplug.gui.TestGui;
import com.simplug.service.PlayerDataService;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.logging.Logger;

@RequiredArgsConstructor
public class TestCommand implements CommandExecutor {

    private final Main mainPlugin;

    private final Logger log;

    private final PlayerDataService playerDataService;

    private final TestGui testGui;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;


            player.openInventory(testGui.getInventory());

            long millisStart = System.currentTimeMillis();

            PlayerData playerData = playerDataService.getByPlayerName(player.getName());
            playerData.setExperience(playerData.getExperience() + 10);
            player.sendMessage(Component.text(playerData.toString()
                    + "\n millis=" + (System.currentTimeMillis() - millisStart)));

            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                public void run() {
//                    ScoreboardManager manager = Bukkit.getScoreboardManager();
//                    final Scoreboard board = manager.getNewScoreboard();

                    Scoreboard board = player.getScoreboard();

                    Objective objective;
                    if (board.getObjective("simplug") == null) {
                        objective = board.registerNewObjective("simplug", "dummy", Component.text("DisplayName"));
                    } else {
                        objective = board.getObjective("simplug");
                    }

                    objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                    //objective.displayName(Component.text("DisplayName"));
                    //objective.setRenderType((new Random()).nextBoolean() ? RenderType.HEARTS : RenderType.INTEGER);



                    Score score = objective.getScore("Баланс");
                    score.setScore(1000);
                    Score score1 = objective.getScore("Хуев в жопе");
                    score1.setScore(3);
                    Score score2 = objective.getScore("Комаров убито");
                    score2.setScore(8);
                    Score score3 = objective.getScore("§6ЦветнаяХуйня");
                    score3.setScore((new Random()).nextInt(100));
                    //player.setScoreboard(board);
                }
            },0, 20 * 5);

            player.sendMessage("Test command usage");
        }

        return true;
    }
}
