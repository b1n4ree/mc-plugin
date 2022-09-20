package com.simplug.events;

import com.simplug.Main;
import com.simplug.data.entity.PlayerData;
import com.simplug.service.CountKiilService;
import com.simplug.service.PlayerDataService;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.ArrayList;

public class ExpEvent implements Listener {

    private final CountKiilService countKiilService;
    private final PlayerDataService playerDataService;

    public ExpEvent(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
        countKiilService = new CountKiilService();
    }


    @EventHandler
    public void getExp(EntityDeathEvent entityDeathEvent) {
        EntityType cow = EntityType.COW;

        Player player = null;


        if (entityDeathEvent.getEntity().getKiller() != null) {

            player = (Player) entityDeathEvent.getEntity().getKiller().getPlayer();

            PlayerData playerData = playerDataService.getByPlayerName(player.getName());
            playerData.setExperience(playerData.getExperience() + entityDeathEvent.getDroppedExp());

            if (entityDeathEvent.getEntity().getType().equals(cow)) {

                player.giveExp(1);
                Component component = Component.text("Вы получили ").color(TextColor.color(62, 255, 0))
                        .append(Component.text("1 ед. ").color(TextColor.color(52, 52, 52)));

                player.sendMessage(component);

                if (player.getInventory().getItemInMainHand().getType().equals(Material.WOODEN_SWORD)) {

                    playerData.setKillCount(playerData.getKillCount() + 1);

                    ArrayList<String> lore = new ArrayList();
                    ItemMeta itemMeta = entityDeathEvent.getEntity().getKiller().getInventory().getItemInMainHand().getItemMeta();
                    itemMeta.setUnbreakable(true);
                    lore.add("Count kills: " + playerData.getKillCount());
                    itemMeta.setLore(lore);

                    entityDeathEvent.getEntity().getKiller().getInventory().getItemInMainHand().setItemMeta(itemMeta);
                    player.getWorld().spawnEntity(new Location(player.getWorld(), 9, 86, 17), cow).setCustomName(ChatColor.RED + "Eblan KraSnogoloviy");

                } else if (player.getInventory().getItemInMainHand().getType().equals(Material.STONE_SWORD)) {

                    playerData.setKillCount(playerData.getKillCount() + 1);
                    ArrayList<String> lore = new ArrayList();
                    ItemMeta itemMeta = entityDeathEvent.getEntity().getKiller().getInventory().getItemInMainHand().getItemMeta();
                    itemMeta.setUnbreakable(true);
                    lore.add("Count kills: " + playerData.getKillCount());
                    itemMeta.setLore(lore);

                    entityDeathEvent.getEntity().getKiller().getInventory().getItemInMainHand().setItemMeta(itemMeta);
                    player.getWorld().spawnEntity(new Location(player.getWorld(), 9 , 86, 17), cow);

                }
            }
        }
    }

    @EventHandler
    public void getCoor(PlayerInteractEvent playerInteractEvent) {

        System.out.println(playerInteractEvent.getAction());
        System.out.println(playerInteractEvent.getEventName());

        int x = playerInteractEvent.getClickedBlock().getX();
        int y = playerInteractEvent.getClickedBlock().getY();
        int z = playerInteractEvent.getClickedBlock().getZ();

        Player player = (Player) playerInteractEvent.getPlayer();

        if (player != null) {

            Component component = Component.text("X=" + x).color(TextColor.color(255, 0, 13))
                    .append(Component.text(" Y=" + y).color(TextColor.color(69, 255, 1)))
                    .append(Component.text(" Z=" + z).color(TextColor.color(1, 0, 255)));

            player.sendMessage(component);

        }
    }
}
