package com.simplug.gui;

import com.simplug.Main;
import com.simplug.service.PlayerDataService;
import com.simplug.utils.ItemStackBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TestGui implements InventoryHolder, Listener {

    private final PlayerDataService playerDataService;

    private final Inventory inventory;

    private final Main mainPlugin;

    public TestGui(PlayerDataService playerDataService, Main mainPlugin) {
        this.playerDataService = playerDataService;

        this.mainPlugin = mainPlugin;

        // Create a new inventory, with no owner (as this isn't a real inventory), a size of nine, called example
        inventory = Bukkit.createInventory(this, 27, Component.text("Торговец"));

        fillInventory();

        Bukkit.getPluginManager().registerEvents(this, mainPlugin);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }

    private void fillInventory() {

        ItemStack itemStack = ItemStackBuilder
                .builder()
                .material(Material.HOPPER)
                .lore("нажми меня, хуй собачий")
                .displayName("Продать все ресурсы")
                .build();

        inventory.addItem(itemStack);

        ItemStack itemStack1 = ItemStackBuilder
                .builder()
                .material(Material.DIAMOND)
                .lore("Класс наёмники")
                .displayName("Выбор класса")
                .build();

        inventory.addItem(itemStack1);

    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent e) {
        if (!e.getInventory().equals(inventory)) return;

        e.setCancelled(true);

        final ItemStack clickedItem = e.getCurrentItem();

        // verify current item is not null
        if (clickedItem == null || clickedItem.getType().isAir()) return;

        final Player p = (Player) e.getWhoClicked();

        // Using slots click is the best option for your inventory click's
        if (Material.DIAMOND.equals(e.getCurrentItem().getType())) {

            playerDataService.getByPlayerName(p.getName()).setClassName("Galamaz");

        }
        p.sendMessage("You clicked at slot " + e.getRawSlot());
    }

    @EventHandler
    public void onInventoryClick(final InventoryDragEvent e) {
        if (e.getInventory().equals(inventory)) {
            e.setCancelled(true);
        }
    }

}
