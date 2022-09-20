package com.simplug.events;

import com.simplug.data.entity.PlayerData;
import com.simplug.service.CountKiilService;
import com.simplug.service.PlayerDataService;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickUpEvent implements Listener {

    private final CountKiilService countKiilService;
    private final PlayerDataService playerDataService;

    public ClickUpEvent(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
        countKiilService = new CountKiilService();
    }

    @EventHandler
    public void click(InventoryClickEvent inventoryInteractEvent) {

        Player player = null;

        PlayerData playerData = playerDataService.getByPlayerName(inventoryInteractEvent.getWhoClicked().getName());

        Long count = playerData.getKillCount();

        inventoryInteractEvent.getWhoClicked().sendMessage(ChatColor.GOLD + "Клик по айтему");
        ExpEvent expEvent = new ExpEvent(playerDataService);

        inventoryInteractEvent.getWhoClicked().sendMessage(ChatColor.BLACK + "" + count);

        if (count >= 10 && count < 20) {

            inventoryInteractEvent.getWhoClicked().getInventory().removeItem();
            ItemStack itemStack = new ItemStack(Material.STONE_SWORD);
            inventoryInteractEvent.getWhoClicked().getInventory().setItem(1, itemStack);

        } else if (count >= 20) {

            inventoryInteractEvent.getWhoClicked().getInventory().removeItem();
            ItemStack itemStack = new ItemStack(Material.IRON_SWORD);
            inventoryInteractEvent.getWhoClicked().getInventory().setItem(1, itemStack);


        }
    }
}
