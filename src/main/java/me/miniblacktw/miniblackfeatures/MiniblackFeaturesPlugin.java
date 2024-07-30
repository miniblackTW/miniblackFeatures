package me.miniblacktw.miniblackfeatures;

import me.miniblacktw.miniblackfeatures.commands.*;
import me.miniblacktw.miniblackfeatures.listeners.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class MiniblackFeaturesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("lore").setExecutor(new LoreCommand());
        this.getCommand("shriek").setExecutor(new ShriekCommand());
        this.getCommand("magicstick").setExecutor(new MagicStickCommand());
        this.getCommand("miniwarn").setExecutor(new MiniWarnCommand());
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
