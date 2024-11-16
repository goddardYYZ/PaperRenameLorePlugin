package com.yourdomain.paperrenameloreplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class PaperRenameLorePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("PaperRenameLorePlugin has been enabled!");
        
        // Registering commands
        getCommand("rename").setExecutor(new RenameCommand());
        getCommand("lore").setExecutor(new LoreCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("PaperRenameLorePlugin has been disabled.");
    }
}
