package com.simplug.utils;

import com.simplug.data.entity.PlayerData;
import com.simplug.service.PlayerDataService;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {

    private final PlayerDataService playerDataService;
    private final ItemsUtils itemsUtils;

    public InventoryUtils(PlayerDataService playerDataService) {
        this.playerDataService = playerDataService;
        itemsUtils = new ItemsUtils();
    }

    public void startInventory(Player player) {

        ItemStack startSword = itemsUtils.getMyCustomItemStack(new ItemStack(Material.WOODEN_SWORD));
        ItemStack startPickaxe = itemsUtils.getMyCustomItemStack(new ItemStack(Material.WOODEN_PICKAXE));
        ItemStack startAxe = itemsUtils.getMyCustomItemStack(new ItemStack(Material.WOODEN_AXE));

        ItemStack startDiamond = itemsUtils.getMyCustomItemStack(new ItemStack(Material.DIAMOND));
        NBTItem startDiamondNbt = new NBTItem(startDiamond);
        startDiamondNbt.setString("start", "spawn");
        startDiamondNbt.getItem();

        startDiamond = startDiamondNbt.getItem();

        ItemStack updateItem = itemsUtils.getMyCustomItemStack(new ItemStack(Material.DIRT));
        NBTItem updateItemNbt = new NBTItem(updateItem);
        updateItemNbt.setString("start", "update");
        updateItem = updateItemNbt.getItem();

        player.getInventory().setItem(0, startSword);
        player.getInventory().setItem(1, startPickaxe);
        player.getInventory().setItem(2, startAxe);
        player.getInventory().setItem(4, startDiamond);
        player.getInventory().setItem(8, updateItem);
    }

    public Inventory spawnDiamondInventory(Player player) {

        PlayerData playerData = playerDataService.getByPlayerName(player.getName());
        Inventory inventory = Bukkit.createInventory(null, 18);

        ItemStack spawnChicken = itemsUtils.getMyCustomItemStack(new ItemStack(Material.CHICKEN_SPAWN_EGG));
        ItemStack spawnCow = itemsUtils.getMyCustomItemStack(new ItemStack(Material.COW_SPAWN_EGG));
        ItemStack spawnPig = itemsUtils.getMyCustomItemStack(new ItemStack(Material.PIG_SPAWN_EGG));
        ItemStack spawnMushroomCow = itemsUtils.getMyCustomItemStack(new ItemStack(Material.MOOSHROOM_SPAWN_EGG));
        ItemStack spawnSheep = itemsUtils.getMyCustomItemStack(new ItemStack(Material.SHEEP_SPAWN_EGG));
        ItemStack spawnHorse = itemsUtils.getMyCustomItemStack(new ItemStack(Material.HORSE_SPAWN_EGG));
        ItemStack spawnSpider = itemsUtils.getMyCustomItemStack(new ItemStack(Material.SPIDER_SPAWN_EGG));
        ItemStack spawnCaveSpider = itemsUtils.getMyCustomItemStack(new ItemStack(Material.CAVE_SPIDER_SPAWN_EGG));
        ItemStack spawnGolem = itemsUtils.getMyCustomItemStack(new ItemStack(Material.IRON_INGOT));
        ItemStack spawnCreeper = itemsUtils.getMyCustomItemStack(new ItemStack(Material.CREEPER_SPAWN_EGG));
        ItemStack spawnZombie = itemsUtils.getMyCustomItemStack(new ItemStack(Material.ZOMBIE_SPAWN_EGG));
        ItemStack spawnPiglin = itemsUtils.getMyCustomItemStack(new ItemStack(Material.PIGLIN_SPAWN_EGG));
        ItemStack spawnSkeleton = itemsUtils.getMyCustomItemStack(new ItemStack(Material.SKELETON_SPAWN_EGG));
        ItemStack spawnWither = itemsUtils.getMyCustomItemStack(new ItemStack(Material.WITHER_SKELETON_SPAWN_EGG));

        NBTItem spawnChickenNbt = new NBTItem(spawnChicken);
        spawnChickenNbt.setBoolean("spawnChicken", playerData.getIsSpawnableChicken());
        NBTItem spawnCowNbt = new NBTItem(spawnCow);
        spawnCowNbt.setBoolean("spawnCow", playerData.getIsSpawnableCow());
        NBTItem spawnPigNbt = new NBTItem(spawnPig);
        spawnPigNbt.setBoolean("spawnPig", playerData.getIsSpawnablePig());
        NBTItem spawnMushroomCowNbt = new NBTItem(spawnMushroomCow);
        spawnMushroomCowNbt.setBoolean("spawnMushroomCow", playerData.getIsSpawnableMushroomCow());
        NBTItem spawnSheepNbt = new NBTItem(spawnSheep);
        spawnSheepNbt.setBoolean("spawnSheep", playerData.getIsSpawnableSheep());
        NBTItem spawnHorseNbt = new NBTItem(spawnHorse);
        spawnHorseNbt.setBoolean("spawnHorse", playerData.getIsSpawnableHorse());
        NBTItem spawnSpiderNbt = new NBTItem(spawnSpider);
        spawnSpiderNbt.setBoolean("spawnSpider", playerData.getIsSpawnableSpider());
        NBTItem spawnCaveSpiderNbt = new NBTItem(spawnCaveSpider);
        spawnCaveSpiderNbt.setBoolean("spawnCaveSpider", playerData.getIsSpawnableCaveSpider());
        NBTItem spawnGolemNbt = new NBTItem(spawnGolem);
        spawnGolemNbt.setBoolean("spawnGolem", playerData.getIsSpawnableGolem());
        NBTItem spawnCreeperNbt = new NBTItem(spawnCreeper);
        spawnCreeperNbt.setBoolean("spawnCreeper", playerData.getIsSpawnableCreeper());
        NBTItem spawnZombieNbt = new NBTItem(spawnZombie);
        spawnZombieNbt.setBoolean("spawnZombie", playerData.getIsSpawnableZombie());
        NBTItem spawnPiglinNbt = new NBTItem(spawnPiglin);
        spawnPiglinNbt.setBoolean("spawnPiglin", playerData.getIsSpawnablePigZombie());
        NBTItem spawnSkeletonNbt = new NBTItem(spawnSkeleton);
        spawnSkeletonNbt.setBoolean("spawnSkeleton", playerData.getIsSpawnableSkeleton());
        NBTItem spawnWitherNbt = new NBTItem(spawnWither);
        spawnWitherNbt.setBoolean("spawnWither", playerData.getIsSpawnableWither());

        ItemStack fillEmpty = itemsUtils.getMyCustomItemStack(new ItemStack(Material.BLACK_STAINED_GLASS_PANE));

        if (spawnChickenNbt.getBoolean("spawnChiken")) {
            inventory.setItem(0, spawnChickenNbt.getItem());
        } else {
            inventory.setItem(0, fillEmpty);
        }
        if (spawnCowNbt.getBoolean("spawnCow")) {
            inventory.setItem(1, spawnCowNbt.getItem());
        } else {
            inventory.setItem(1, fillEmpty);
        }
        if (spawnPigNbt.getBoolean("spawnPig")) {
            inventory.setItem(2, spawnPigNbt.getItem());
        } else {
            inventory.setItem(2, fillEmpty);
        }
        if (spawnMushroomCowNbt.getBoolean("spawnMushroomCow")) {
            inventory.setItem(3, spawnMushroomCowNbt.getItem());
        } else {
            inventory.setItem(3, fillEmpty);
        }
        if (spawnSheepNbt.getBoolean("spawnSheep")) {
            inventory.setItem(4, spawnSheepNbt.getItem());
        } else {
            inventory.setItem(4, fillEmpty);
        }
        if (spawnHorseNbt.getBoolean("spawnHorse")) {
            inventory.setItem(5, spawnHorseNbt.getItem());
        } else {
            inventory.setItem(5, fillEmpty);
        }
        if (spawnSpiderNbt.getBoolean("spawnSpider")) {
            inventory.setItem(6, spawnSpiderNbt.getItem());
        } else {
            inventory.setItem(6, fillEmpty);
        }
        if (spawnCaveSpiderNbt.getBoolean("spawnCaveSpider")) {
            inventory.setItem(7, spawnCaveSpiderNbt.getItem());
        } else {
            inventory.setItem(7, fillEmpty);
        }
        if (spawnGolemNbt.getBoolean("spawnGolem")) {
            inventory.setItem(8, spawnGolemNbt.getItem());
        } else {
            inventory.setItem(8, fillEmpty);
        }
        if (spawnCreeperNbt.getBoolean("spawnCreeper")) {
            inventory.setItem(9, spawnCreeperNbt.getItem());
        } else {
            inventory.setItem(9, fillEmpty);
        }
        if (spawnZombieNbt.getBoolean("spawnZombie")) {
            inventory.setItem(10, spawnZombieNbt.getItem());
        } else {
            inventory.setItem(10, fillEmpty);
        }
        if (spawnPiglinNbt.getBoolean("spawnPiglin")) {
            inventory.setItem(11, spawnPiglinNbt.getItem());
        } else {
            inventory.setItem(11, fillEmpty);
        }
        if (spawnSkeletonNbt.getBoolean("spawnSkeleton")) {
            inventory.setItem(12, spawnSkeletonNbt.getItem());
        } else {
            inventory.setItem(12, fillEmpty);
        }
        if (spawnWitherNbt.getBoolean("spawnWither")) {
            inventory.setItem(13, spawnWitherNbt.getItem());
        } else {
            inventory.setItem(13, fillEmpty);
        }
        for (int i = 14; i < 18; i++) {
            inventory.setItem(i, fillEmpty);
        }
        return inventory;
    }
}
