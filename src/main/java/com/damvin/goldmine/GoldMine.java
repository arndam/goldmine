package com.damvin.goldmine;

import com.damvin.goldmine.commands.GoldMineCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class GoldMine extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register command handler
        this.getCommand("goldmine").setExecutor(new GoldMineCommand());
        
        getLogger().info("GoldMine plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("GoldMine plugin has been disabled!");
    }
} 