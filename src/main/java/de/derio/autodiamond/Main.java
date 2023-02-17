package de.derio.autodiamond;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Main extends JavaPlugin {
    public static Main plugin;
    boolean spawned = false;

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new ItemMergeEvent(), this);

        run();
    }

    @Override
    public void onDisable() {
    }

    public static Main getInstance() {
        return plugin;
    }

    public void run() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Entity all : Bukkit.getWorld("world").getEntities()) {
                    if (all.getType().equals(EntityType.DROPPED_ITEM)) {
                        Item item = (Item) all;

                        if (item.getItemStack().getType().equals(Material.DIAMOND)) {

                            for (Entity entity : Bukkit.getWorld("world").getEntities()) {
                                if (entity.getType().equals(EntityType.DROPPED_ITEM)) {
                                    Item item1 = (Item) entity;
                                    if (item1.getItemStack().getType().equals(Material.DIAMOND)) {
                                        for (Entity entitys : Bukkit.getWorld("world").getEntities()) {
                                            if (entitys.getType().equals(EntityType.DROPPED_ITEM)) {
                                                Item item2 = (Item) entity;
                                                if (item2.getItemStack().getType().equals(Material.STICK)) {
                                                    if (item.getLocation().distance(item1.getLocation()) < 1 && item.getLocation().distance(item2.getLocation()) < 1) {


                                                        if (spawnDiamondSword(item2.getLocation())) {
                                                            try {
                                                                item.remove();
                                                            } catch (Exception exception) {
                                                            }
                                                            try {
                                                                item1.remove();
                                                            } catch (Exception exception) {
                                                            }
                                                            try {
                                                                item2.remove();
                                                            } catch (Exception exception) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else if (item1.getItemStack().getType().equals(Material.STICK)) {
                                        for (Entity entitys : Bukkit.getWorld("world").getEntities()) {
                                            if (entitys.getType().equals(EntityType.DROPPED_ITEM)) {
                                                Item item2 = (Item) entity;
                                                if (item2.getItemStack().getType().equals(Material.DIAMOND)) {
                                                    if (item.getLocation().distance(item1.getLocation()) < 1 && item.getLocation().distance(item2.getLocation()) < 1) {
                                                        if (spawnDiamondSword(item1.getLocation())) {
                                                            try {
                                                                item.remove();
                                                            } catch (Exception exception) {
                                                            }
                                                            try {
                                                                item1.remove();
                                                            } catch (Exception exception) {
                                                            }
                                                            try {
                                                                item2.remove();
                                                            } catch (Exception exception) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }


                        } else if (item.getItemStack().getType().equals(Material.STICK)) {
                            for (Entity entity : Bukkit.getWorld("world").getEntities()) {
                                if (entity.getType().equals(EntityType.DROPPED_ITEM)) {
                                    Item item1 = (Item) entity;
                                    if (item1.getItemStack().getType().equals(Material.DIAMOND)) {
                                        for (Entity entitys : Bukkit.getWorld("world").getEntities()) {
                                            if (entitys.getType().equals(EntityType.DROPPED_ITEM)) {
                                                Item item2 = (Item) entity;
                                                if (item2.getItemStack().getType().equals(Material.DIAMOND)) {
                                                    if (item.getLocation().distance(item1.getLocation()) < 1 && item.getLocation().distance(item2.getLocation()) < 1) {

                                                        if (spawnDiamondSword(item.getLocation())) {
                                                            try {
                                                                item.remove();
                                                            } catch (Exception exception) {
                                                            }
                                                            try {
                                                                item1.remove();
                                                            } catch (Exception exception) {
                                                            }
                                                            try {
                                                                item2.remove();
                                                            } catch (Exception exception) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }


                    }
                }
            }

        }.runTaskTimer(Main.getInstance(), 10, 10);
    }

    public boolean spawnDiamondSword(Location location) {

            Item stickitem = null;
            Item dia1 = null;
            Item dia2 = null;

            boolean diamond1 = false;
            boolean diamond2 = false;
            boolean stick = false;
            for (Entity all : location.getWorld().getEntities()) {
                if (all.getType().equals(EntityType.DROPPED_ITEM)) {

                    Item item = (Item) all;

                    if (item.getLocation().distance(location) < 1) {
                        if (item.getItemStack().getType().equals(Material.DIAMOND) && !diamond1) {
                            dia1 = (Item) all;
                            diamond1 = true;
                        } else if (item.getItemStack().getType().equals(Material.DIAMOND) && !diamond2) {
                            dia2 = (Item) all;
                            diamond2 = true;
                        } else if (item.getItemStack().getType().equals(Material.STICK) && !stick) {
                            stickitem = (Item) all;
                            stick = true;
                        }
                    }


                }
            }
            if (!stick) {
                return false;
            }
            if (!diamond1) {
                return false;
            }
            if (!diamond2) {
                return false;
            }
            if (dia1.getLocation().getBlock().getType().equals(Material.CRAFTING_TABLE)||dia1.getLocation().subtract(0,1,0).getBlock().getType().equals(Material.CRAFTING_TABLE)){


            if (dia2.getLocation().getBlock().getType().equals(Material.CRAFTING_TABLE)||dia2.getLocation().subtract(0,1,0).getBlock().getType().equals(Material.CRAFTING_TABLE)) {


                if (stickitem.getLocation().getBlock().getType().equals(Material.CRAFTING_TABLE) || stickitem.getLocation().subtract(0, 1, 0).getBlock().getType().equals(Material.CRAFTING_TABLE)) {


                        if (!spawned) {

                            try {
                                stickitem.remove();
                                dia1.remove();
                                dia2.remove();

                            } catch (Exception exception) {
                                return false;
                            }

                            for (Entity all : Bukkit.getWorld("world").getEntities()) {
                                if (all.getType().equals(EntityType.PLAYER)){
                                    if (all.getLocation().distance(location)<5){
                                        Player p = (Player) all;
                                        p.playSound(p.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1,1);
                                    }
                                }
                            }


                            Bukkit.getWorld("world").dropItem(location.add(0, 0.5, 0), new ItemStack(Material.DIAMOND_SWORD));
                            spawned = true;
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    spawned = false;
                                }
                            }.runTaskLater(plugin, 15);
                            return true;
                        }
                    }
                }
            }

        return false;
    }
}


