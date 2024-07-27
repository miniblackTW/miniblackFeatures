package me.miniblacktw.miniblackfeatures.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MagicStickListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item != null && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("Magic Stick")) {
            player.getWorld().spawnParticle(Particle.SONIC_BOOM, player.getLocation(), 10);
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player damager = (Player) event.getDamager();
            ItemStack item = damager.getInventory().getItemInMainHand();
            if (item != null && item.hasItemMeta() && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equals("Magic Stick")) {
                if (event.getEntity() instanceof Player) {
                    Player victim = (Player) event.getEntity();
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 1));
                    victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 100, 1));
                }
            }
        }
    }
}
