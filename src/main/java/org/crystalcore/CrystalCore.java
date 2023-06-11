package org.crystalcore;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class CrystalCore extends JavaPlugin implements Listener {
    public static boolean enableShulkerDupe;
    public static boolean enable32kDetection;
    public static Integer shulkercount;


    @Override
    public void onEnable() {
        boolean raw_enableShulkerDupe = getConfig().getBoolean("enable-shulker-dupe");
        boolean raw_enable32kDetection = getConfig().getBoolean("enable-32k-detection");
        int raw_shulkercount = getConfig().getInt("shulker-dupe-count");
        saveDefaultConfig();
        enableShulkerDupe = raw_enableShulkerDupe;
        enable32kDetection = raw_enable32kDetection;
        shulkercount = raw_shulkercount;

        // 注册事件监听器
        getServer().getPluginManager().registerEvents(new shulkerdupe(),this);
        getServer().getPluginManager().registerEvents(new damagelimit(), this);

    }
}

