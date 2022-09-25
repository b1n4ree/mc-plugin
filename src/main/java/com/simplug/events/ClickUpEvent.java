package com.simplug.events;

import com.simplug.data.entity.PlayerData;
import com.simplug.service.PlayerDataService;
import com.simplug.utils.ItemsUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.ItemStack;


public class ClickUpEvent implements Listener {

    private final ItemsUtils itemsUtils;
    private final PlayerDataService playerDataService;

    public ClickUpEvent(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
        itemsUtils = new ItemsUtils();
    }

    @EventHandler
    public void click(InventoryClickEvent inventoryInteractEvent) {

        if (inventoryInteractEvent.getWhoClicked().getInventory().getItem(2) != null) {
            inventoryInteractEvent.setCancelled(true);
        }

        if (inventoryInteractEvent.getCurrentItem() != null) {
            Player player = null;

            PlayerData playerData = playerDataService.getByPlayerName(inventoryInteractEvent.getWhoClicked().getName());

            Long count = playerData.getKillCount();
            Long countPig = playerData.getKillCountPig();
            Long countCow = playerData.getKillCountCow();

            inventoryInteractEvent.getWhoClicked().sendMessage(ChatColor.GOLD + "Клик по айтему");
            ExpEvent expEvent = new ExpEvent(playerDataService);

            inventoryInteractEvent.getWhoClicked().sendMessage(ChatColor.BLACK + "" + count);

            if (inventoryInteractEvent.getCurrentItem().hasItemMeta()) {

                playerDataService.invalidateCached(inventoryInteractEvent.getWhoClicked().getName());

                inventoryInteractEvent.getWhoClicked().sendMessage("Current item click " + inventoryInteractEvent.getCurrentItem().getType());
                ItemStack itemStack = inventoryInteractEvent.getCurrentItem();

                if (count >= 100 && countPig >= 50 && countCow >= 50 && inventoryInteractEvent.getCurrentItem().getType().equals(Material.WOODEN_SWORD)) {

                    inventoryInteractEvent.getWhoClicked().getInventory().remove(itemStack);
                    inventoryInteractEvent.getWhoClicked().getInventory().setItem(0, itemsUtils.stoneSword());

                } else if (count >= 200 && countPig >= 100 && countCow >= 100 && inventoryInteractEvent.getCurrentItem().getType().equals(Material.STONE_SWORD)) {


                    inventoryInteractEvent.getWhoClicked().getInventory().remove(itemStack);
                    inventoryInteractEvent.getWhoClicked().getInventory().setItem(0, itemsUtils.ironSword());

                } else if (count >= 300 && countPig >= 150 && countCow >= 150 && inventoryInteractEvent.getCurrentItem().getType().equals(Material.IRON_SWORD)) {

                    inventoryInteractEvent.getWhoClicked().getInventory().remove(itemStack);
                    inventoryInteractEvent.getWhoClicked().getInventory().setItem(0, itemsUtils.goldenSword());

                } else if (count >= 400 && countPig >= 200 && countCow >= 200 && inventoryInteractEvent.getCurrentItem().getType().equals(Material.GOLDEN_SWORD)) {

                    inventoryInteractEvent.getWhoClicked().getInventory().remove(itemStack);
                    inventoryInteractEvent.getWhoClicked().getInventory().setItem(0, itemsUtils.diamondSword());
                }
            }
        }
    }

    @EventHandler
    public void cancelMove(InventoryMoveItemEvent inventoryMoveItemEvent) {

        if (inventoryMoveItemEvent.getItem().equals(Material.WOODEN_SWORD)) {
            inventoryMoveItemEvent.setCancelled(false);
        } else if (inventoryMoveItemEvent.getItem().equals(Material.STONE_SWORD)) {
            inventoryMoveItemEvent.setCancelled(false);
        } else if (inventoryMoveItemEvent.getItem().equals(Material.IRON_SWORD)) {
            inventoryMoveItemEvent.setCancelled(false);
        } else if (inventoryMoveItemEvent.getItem().equals(Material.GOLDEN_SWORD)) {
            inventoryMoveItemEvent.setCancelled(false);
        } else if (inventoryMoveItemEvent.getItem().equals(Material.DIAMOND_SWORD)) {
            inventoryMoveItemEvent.setCancelled(false);
        } else {
            inventoryMoveItemEvent.setCancelled(true);
        }
    }

    @EventHandler
    public void drop(EntityDropItemEvent entityDropItemEvent) {

        entityDropItemEvent.setCancelled(true);
    }
}
