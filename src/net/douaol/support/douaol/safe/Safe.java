package net.douaol.support.douaol.safe;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class Safe extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Start enabling Safe...");
        defaultConfigSave();
    }
    public void defaultConfigSave() {
        getLogger().info("Start generating config...");
        File mainconfig = new File("plugins" + File.separator + "Towny" + File.separator + "settings" + File.separator + "config.yml");
        saveConfig();
        getLogger().info("Config was generated successfully.");
        configSelfCheck();
    }
    public void configSelfCheck() {
        boolean versionState = false;
        getLogger().info("Start config self-check...");
        FileConfiguration configSelfChecki = getConfig();
        Double versionSelfCheck = (Double) configSelfChecki.get("version");
        //Start self-checking
        if (versionSelfCheck != null) {
            versionState = true;
        }
            getLogger().info("Start self-fix...");
            if (versionState == false)
                getConfig().set("version", 0.1);
            saveConfig();
            getLogger().info("Self-fix done.");
        loadConfig();
    }
    public void loadConfig() {
        getLogger().info("Start loading configs...");
        FileConfiguration config = getConfig();
        //load config
        Double version = (Double) config.get("version");
        getLogger().info("Version loaded successfully, current version: v" + version);
        configLoadedDone();
    }
    public void configLoadedDone() {
        getLogger().info("Config loaded done.");
    }
}