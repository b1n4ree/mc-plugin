package com.simplug;

import com.simplug.command.TestCommand;
import com.simplug.data.dao.PlayerDataDao;
import com.simplug.data.entity.PlayerData;
import com.simplug.events.*;
import com.simplug.gui.TestGui;
import com.simplug.listener.PlayerQuitAndJoinListener;
import com.simplug.service.PlayerDataService;
import de.tr7zw.nbtapi.NBTItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class Main  extends JavaPlugin {

    private Location arenaLocation = new Location(Bukkit.getWorld("world"), 50, 50, 50);
    private static Main instance;
    private static Logger logger;
    private SessionFactory sessionFactory;
    private PlayerDataService playerDataService;
    private PlayerDataDao playerDataDao;

    public static Logger loggerGet() {
        return logger;
    }

    @Override
    public void onEnable() {

        instance = this;
        sessionFactory = loadSessionFactory();
        playerDataDao = new PlayerDataDao(sessionFactory);
        logger = super.getLogger();
        logger.info("Start SimPlug");

        playerDataService = new PlayerDataService(playerDataDao, logger);

        Bukkit.getPluginManager().registerEvents(new ExpEvent(playerDataService), this);
//        Bukkit.getPluginManager().registerEvents(new KillEvent(), this);
        Bukkit.getPluginManager().registerEvents(new DamageEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitAndJoinListener(playerDataService, logger), this);
        registerCommands();
        Bukkit.getPluginManager().registerEvents(new JoinEvent(playerDataService), this);
        Bukkit.getPluginManager().registerEvents(new ClickUpEvent(playerDataService), this);
        Bukkit.getPluginManager().registerEvents(new MySpawnEntityEvent(), this);
    }

    private void registerCommands() {
        this.getCommand("test").setExecutor(new TestCommand(this, logger, playerDataService, new TestGui(playerDataService, this)));
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player player = null;


        if (sender instanceof Player) {

            player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("jitel")) {

                Villager villager = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
                villager.setCustomNameVisible(true);
                villager.setCustomName("Damn");

            } else if (cmd.getName().equalsIgnoreCase("arena")) {

                logger.info(player.getLocation().getWorld().getName());
                player.teleport(new Location(player.getWorld(), 10, 88, 17));


                player.getWorld().spawnEntity(new Location(player.getWorld(), 10, 88, 17), EntityType.COW);

            } else if (cmd.getName().equalsIgnoreCase("chest")) {

                ItemStack itemStack = new ItemStack(Material.CHEST);
                PlayerInventory playerInventory = player.getInventory();
                playerInventory.addItem(itemStack);

            } else if (cmd.getName().equalsIgnoreCase("sword")) {

                ItemStack sword = ModifierSwordNBT.swordWooden();
                NBTItem swordNbt = ModifierSwordNBT.setCritOnWeapon(sword, 200.0, 200.0);
                ItemMeta swordItemMeta = sword.getItemMeta();
                ArrayList<String> lore = new ArrayList<>();

                TextComponent textComponentSword = Component.text()
                                .content("Crit chance=200")
                                        .color(TextColor.color(0, 255, 0)).build()
                                .append(Component.text()
                                        .content("Crit damage=200" )
                                        .color(TextColor.color(20, 130, 200)).build());

                swordItemMeta.lore(Arrays.asList(textComponentSword));
                sword.setItemMeta(swordItemMeta);

//                lore.add("CritChance" + swordNbt.getDouble("CritChance"));
//                lore.add("CritDamage" + swordNbt.getDouble("CritDamage"));
//                sword.setLore(lore);
                PlayerInventory playerInventory = player.getInventory();
                playerInventory.addItem(sword);

            }
            return true;

        } return false;
    }

    public static Main getInstance() {
        return instance;
    }

    private SessionFactory loadSessionFactory() {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        try {

            MetadataSources sources = new MetadataSources(registry);
            sources.addAnnotatedClass(PlayerData.class);

            return sources.buildMetadata().buildSessionFactory();

        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            throw new RuntimeException(e);
        }
    }
}
