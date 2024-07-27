package me.miniblacktw.miniblackfeatures.listeners;

import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        event.getEntity().getWorld().spawnParticle(Particle.SOUL, event.getEntity().getLocation(), 1);
    }
}