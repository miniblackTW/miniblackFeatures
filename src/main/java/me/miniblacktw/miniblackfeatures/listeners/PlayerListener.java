package me.miniblacktw.miniblackfeatures.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item != null && item.getType() == org.bukkit.Material.STICK &&
                item.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Magic Stick")) {

            Vector direction = player.getLocation().getDirection();
            player.getWorld().spawnParticle(Particle.SONIC_BOOM, player.getLocation(), 10, direction.getX(), direction.getY(), direction.getZ(), 0.1);
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getDamager();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item != null && item.getType() == org.bukkit.Material.STICK &&
                item.getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Magic Stick")) {

            Entity entity = event.getEntity();

            entity.getWorld().spawnParticle(Particle.SONIC_BOOM, entity.getLocation(), 10);
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;
                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 100, 1));
                livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 100, 1));
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        player.getWorld().spawnParticle(Particle.SOUL, player.getLocation(), 50);
    }
}
