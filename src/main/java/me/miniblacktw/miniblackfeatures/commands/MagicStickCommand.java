package me.miniblacktw.miniblackfeatures.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MagicStickCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("只有玩家能使用此指令");
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("miniblack.magicstick")) {
            player.sendMessage(ChatColor.RED + "你沒有權限");
            return true;
        }

        ItemStack magicStick = new ItemStack(Material.STICK);
        ItemMeta meta = magicStick.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Magic Stick");
        magicStick.setItemMeta(meta);

        player.getInventory().addItem(magicStick);
        player.sendMessage(ChatColor.GREEN + "你拿到了一根魔法棒 :D");
        return true;
    }
}
