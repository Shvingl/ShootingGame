package luke.y.shootingGame;

import luke.y.shootingGame.listeners.ArrowLandListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class ShootingGame extends JavaPlugin {

    public final HashMap<Player, ActiveGame> gameMap = new HashMap<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ArrowLandListener(this), this);

        startGame(Bukkit.getPlayer("LukeWhy135"));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void startGame(Player player) {
        gameMap.put(player, new ActiveGame(this, player));
    }
}
