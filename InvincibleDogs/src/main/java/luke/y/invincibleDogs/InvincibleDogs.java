package luke.y.invincibleDogs;

import org.bukkit.plugin.java.JavaPlugin;

public final class InvincibleDogs extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new MobDeathEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
