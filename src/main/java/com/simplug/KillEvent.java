package com.simplug;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class KillEvent implements Listener {

    public Long countKill = 0L;

    @EventHandler
    public void entityDead(EntityDeathEvent entityDeathEvent) {

        if (entityDeathEvent.getEntity().getKiller().getInventory().getItemInMainHand().getType().equals(Material.WOODEN_SWORD)) {


            countKill++;
            Main.loggerGet().info("EXP = " + entityDeathEvent.getEntity().getKiller().getExp());
            ArrayList<String> lore = new ArrayList();
            ItemMeta itemMeta = entityDeathEvent.getEntity().getKiller().getInventory().getItemInMainHand().getItemMeta();
            lore.add("Count kills: " + countKill);
            itemMeta.setLore(lore);
            entityDeathEvent.getEntity().getKiller().getInventory().getItemInMainHand().setItemMeta(itemMeta);


        }


        Main.loggerGet().info("Entity kill - " + entityDeathEvent.getEntity().getType());

        if (entityDeathEvent.getEntity().getType().equals(EntityType.COW)) {
            entityDeathEvent.getEntity().getLocation().getWorld().spawnEntity(
                    entityDeathEvent.getEntity().getLocation(), EntityType.COW);

            Main.loggerGet().info("Killer is " + entityDeathEvent.getEntity().getKiller().getName());

        }
    }
//    @EventHandler
//    public void onInventoryOpen(InventoryOpenEvent e) {
//        Player p =(Player) e.getPlayer();
//        if(e.getInventory().getType() == InventoryType.CHEST) {
//            e.setCancelled(true);
//            p.sendMessage("chest");
//        } else {
//            p.sendMessage("not chest!");
//            return;
//        }
//    }
}
