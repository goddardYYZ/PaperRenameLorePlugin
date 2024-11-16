package com.yourdomain.paperrenameloreplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Please provide a name for the item.");
                return false;
            }

            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            if (itemInHand == null || itemInHand.getType().isAir()) {
                player.sendMessage(ChatColor.RED + "You must be holding an item to rename it.");
                return false;
            }

            String newName = String.join(" ", args);
            ItemMeta meta = itemInHand.getItemMeta();
            if (meta != null) {
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', newName));
                itemInHand.setItemMeta(meta);
                player.sendMessage(ChatColor.GREEN + "Item renamed to: " + newName);
            } else {
                player.sendMessage(ChatColor.RED + "This item cannot be renamed.");
            }

            return true;
        }

        return false;
    }
}
