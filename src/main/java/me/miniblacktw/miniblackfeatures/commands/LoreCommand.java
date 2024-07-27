package me.miniblacktw.miniblackfeatures.commands;

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
                player.sendMessage(ChatColor.RED + "§c用法: /lore <your lore>");
                return true;
            }
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item == null || !item.hasItemMeta()) {
                player.sendMessage(ChatColor.RED + "§c你必須拿著一樣物品");
                return true;
            }
            ItemMeta meta = item.getItemMeta();
            List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
            StringBuilder loreBuilder = new StringBuilder();
            for (String arg : args) {
                loreBuilder.append(arg).append(" ");
            }
            lore.add(ChatColor.translateAlternateColorCodes('&', loreBuilder.toString().trim()));
            meta.setLore(lore);
            item.setItemMeta(meta);
            player.sendMessage(ChatColor.GREEN + "§a已將註解添加到你的物品");
        }
        return true;
    }
}
