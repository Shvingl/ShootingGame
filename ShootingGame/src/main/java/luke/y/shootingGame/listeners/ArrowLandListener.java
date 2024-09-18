package luke.y.shootingGame.listeners;

import luke.y.shootingGame.ShootingGame;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Objects;

public class ArrowLandListener implements Listener {
    ShootingGame plugin;

    public ArrowLandListener(ShootingGame plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (!(e.getEntity().getShooter() instanceof Player))
            return;
        if (!(Objects.requireNonNull(e.getHitBlock()).getType() == Material.TARGET))
            return;
        Player player = (Player) e.getEntity().getShooter();
        if (plugin.gameMap.containsKey(player)) {
            player.sendMessage("You hit a target!");
            e.getHitBlock().setType(Material.AIR);
            plugin.gameMap.get(player).increaseScore(1);
        }
    }
}
