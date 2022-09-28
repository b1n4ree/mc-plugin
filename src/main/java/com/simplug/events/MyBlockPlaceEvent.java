package com.simplug.events;

import com.simplug.Main;
import de.tr7zw.nbtapi.NBTBlock;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class MyBlockPlaceEvent implements Listener {

    @EventHandler
    public void place(BlockPlaceEvent blockPlaceEvent) {


        if (blockPlaceEvent.getBlock().getType().equals(Material.DIAMOND_BLOCK)) {

            NBTBlock nbtBlock = new NBTBlock(blockPlaceEvent.getBlock());
            nbtBlock.getData().setString("spawnMobLvl", "up");
            System.out.println("Event BlockPlace is work");
        }
    }
}
