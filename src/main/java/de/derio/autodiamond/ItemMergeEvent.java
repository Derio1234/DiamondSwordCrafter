package de.derio.autodiamond;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;

public class ItemMergeEvent implements Listener {
    @EventHandler
    public void onItemMerge(org.bukkit.event.entity.ItemMergeEvent e) {
        if (e.getEntity().getItemStack().getType().equals(Material.DIAMOND)||e.getEntity().getItemStack().getType().equals(Material.STICK)) {
            if (e.getEntity().getLocation().getBlock().getType().equals(Material.CRAFTING_TABLE)||e.getEntity().getLocation().subtract(0,1,0).getBlock().getType().equals(Material.CRAFTING_TABLE)) {
                e.setCancelled(true);
            }
        }
    }
}
