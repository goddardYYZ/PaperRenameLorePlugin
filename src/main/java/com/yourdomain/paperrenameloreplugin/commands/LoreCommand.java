package com.yourdomain.paperrenameloreplugin.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LoreCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Please provide a lore for the item.");
                return false;
            }

            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            if (itemInHand == null || itemInHand.getType().isAir()) {
                player.sendMessage(ChatColor.RED + "You must be holding an item to set lore.");
                return false;
            }

            String loreText = String.join(" ", args);
            ItemMeta meta = itemInHand.getItemMeta();
            if (meta != null) {
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.translateAlternateColorCodes('&', loreText));
                meta.setLore(lore);
                itemInHand.setItemMeta(meta);
                player.sendMessage(ChatColor.GREEN + "Lore set to: " + loreText);
            } else {
                player.sendMessage(ChatColor.RED + "This item cannot have lore.");
            }

            return true;
        }

        return false;
    }
}
