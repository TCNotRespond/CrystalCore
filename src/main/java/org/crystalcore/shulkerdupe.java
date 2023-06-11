package org.crystalcore;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

import static org.crystalcore.CrystalCore.enableShulkerDupe;
import static org.crystalcore.CrystalCore.shulkercount;

public class shulkerdupe implements Listener {
    private final HashMap<Player,Integer> shulkerBoxCounts = new HashMap<>();
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlockPlaced().getType().toString().contains("SHULKER_BOX") && enableShulkerDupe) {
            Player player = event.getPlayer();
            int count = shulkerBoxCounts.getOrDefault(player, 0);

            if (count == shulkercount) {
                // 第10个潜影盒不消耗
                ItemStack shulkerBoxItem = new ItemStack(event.getBlockPlaced().getType(), 1);
                player.getInventory().addItem(shulkerBoxItem);

                // 清空该玩家的潜影盒数量
                shulkerBoxCounts.put(player, 0);

                // 在这里可以添加其他的处理逻辑，比如给予玩家一些奖励等
            } else {
                // 增加潜影盒数量
                shulkerBoxCounts.put(player, count + 1);
            }
        }
    }
}
