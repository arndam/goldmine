package com.damvin.goldmine.commands;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GoldMineCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players!");
            return true;
        }

        Player player = (Player) sender;
        
        // Check permission
        if (!player.hasPermission("goldmine.use")) {
            player.sendMessage("§cYou don't have permission to use this command!");
            return true;
        }

        // Try to find a chest that the player is looking at
        Block targetBlock = player.getTargetBlock(null, 5);
        
        if (targetBlock.getType() != Material.CHEST && targetBlock.getType() != Material.TRAPPED_CHEST) {
            player.sendMessage("§cYou must be looking at a chest!");
            return true;
        }

        // Get the chest and double its contents
        Chest chest = (Chest) targetBlock.getState();
        doubleChestContents(chest);
        
        player.sendMessage("§aThe contents of the chest have been doubled!");
        return true;
    }
    
    private void doubleChestContents(Chest chest) {
        Inventory inventory = chest.getInventory();
        Map<Integer, ItemStack> originalItems = new HashMap<>();
        
        // Create a snapshot of original items
        for (int i = 0; i < inventory.getSize(); i++) {
            ItemStack item = inventory.getItem(i);
            if (item != null && item.getType() != Material.AIR) {
                originalItems.put(i, item.clone());
            }
        }
        
        // Add duplicate items
        for (ItemStack item : originalItems.values()) {
            // Clone to make sure we don't modify the original
            ItemStack duplicate = item.clone();
            
            // Add the duplicated item to the inventory
            // This handles stacking automatically where possible
            inventory.addItem(duplicate);
        }
        
        // Update the chest state to save changes
        chest.update();
    }
} 