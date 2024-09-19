package luke.y.shootingGame;

import luke.y.shootingGame.commands.StartShooter;
import luke.y.shootingGame.listeners.ArrowLandListener;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public final class ShootingGame extends JavaPlugin {

    public final HashMap<Player, ActiveGame> gameMap = new HashMap<>();
    private final ArrayList<Location> toRespawn = new ArrayList<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ArrowLandListener(this), this);
        getCommand("startshooter").setExecutor(new StartShooter(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        for (Location location : toRespawn) {
            respawnTarget(location);
        }
    }

    public void addToRespawn(Location loc) {
        toRespawn.add(loc);
    }

    public void removeToRespawn(Location loc) {
        toRespawn.remove(loc);
    }

    public void startGame(Player player) {
        gameMap.put(player, new ActiveGame(this, player));
    }

    public void respawnTarget(Location location) {
        if (toRespawn.contains(location)) {
            location.getBlock().setType(Material.TARGET);
        }
    }
}
