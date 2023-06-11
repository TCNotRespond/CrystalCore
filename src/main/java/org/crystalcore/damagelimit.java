package org.crystalcore;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import static org.crystalcore.CrystalCore.enable32kDetection;
public class damagelimit implements Listener {
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (enable32kDetection){
            if (!(event.getPlayer() instanceof Player)) {
                return;
            }

            Player player = (Player) event.getPlayer();
            ItemStack[] contents = player.getInventory().getContents();

            for (ItemStack item : contents) {
                if (item != null && item.getType() != Material.AIR) {
                    if (item.containsEnchantment(Enchantment.DAMAGE_ALL)) {
                        int enchantmentLevel = item.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
                        if (enchantmentLevel == 32767) {
                            player.getInventory().remove(item);
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if (enable32kDetection){

            Player player = (Player) event.getPlayer();
            ItemStack[] contents = player.getInventory().getContents();

            for (ItemStack item : contents) {
                if (item != null && item.getType() != Material.AIR) {
                    if (item.containsEnchantment(Enchantment.DAMAGE_ALL)) {
                        int enchantmentLevel = item.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
                        if (enchantmentLevel == 32767) {
                            player.getInventory().remove(item);
                        }
                    }
                }
            }
        }

    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if (enable32kDetection){

            ItemStack[] contents = event.getInventory().getContents();

            for (ItemStack item : contents) {
                if (item != null && item.getType() != Material.AIR) {
                    if (item.containsEnchantment(Enchantment.DAMAGE_ALL)) {
                        int enchantmentLevel = item.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
                        if (enchantmentLevel == 32767) {
                            event.getInventory().remove(item);
                        }
                    }
                }
            }
        }

    }
    @EventHandler
    public void onEntityDamageByEntity(InventoryOpenEvent event) {
        if (enable32kDetection){
            if (!(event.getPlayer() instanceof Player)) {
                return;
            }

            Player player = (Player) event.getPlayer();
            ItemStack[] contents = player.getInventory().getContents();

            for (ItemStack item : contents) {
                if (item != null && item.getType() != Material.AIR) {
                    if (item.containsEnchantment(Enchantment.DAMAGE_ALL)) {
                        int enchantmentLevel = item.getEnchantmentLevel(Enchantment.DAMAGE_ALL);
                        if (enchantmentLevel == 32767) {
                            player.getInventory().remove(item);
                        }
                    }
                }
            }
        }
    }
}
