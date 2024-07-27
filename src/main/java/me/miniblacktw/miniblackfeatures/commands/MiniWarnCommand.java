package me.miniblacktw.miniblackfeatures.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MiniWarnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("miniblack.miniwarn")) {
                if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.getWorld().spawnParticle(Particle.ELDER_GUARDIAN, player.getLocation(), 1);
                        target.sendTitle(ChatColor.RED + "一名管理員正看著你", ChatColor.GOLD + "不要做任何可疑的事", 10, 70, 20);
                    } else {
                        player.sendMessage(ChatColor.RED + "錯誤: 找不到該玩家");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "用法: /miniwarn <玩家>");
                }
            } else {
                player.sendMessage(ChatColor.RED + "你沒有權限");
            }
        }
        return true;
    }
}