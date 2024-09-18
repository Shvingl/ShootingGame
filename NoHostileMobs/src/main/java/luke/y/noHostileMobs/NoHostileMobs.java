package luke.y.noHostileMobs;

import org.bukkit.plugin.java.JavaPlugin;

public final class NoHostileMobs extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new MobSpawnListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
