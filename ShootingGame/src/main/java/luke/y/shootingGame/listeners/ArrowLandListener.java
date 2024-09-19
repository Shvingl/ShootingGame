package luke.y.shootingGame.listeners;

import luke.y.shootingGame.ShootingGame;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;
import java.util.Random;

public class ArrowLandListener implements Listener {
    ShootingGame plugin;
    Random random = new Random();

    public ArrowLandListener(ShootingGame plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        Player player = (Player) e.getEntity().getShooter();
        if (!plugin.gameMap.containsKey(player))
            return;
        if (!(e.getEntity().getShooter() instanceof Player))
            return;
        if (!(Objects.requireNonNull(e.getHitBlock()).getType() == Material.TARGET)) {
            e.getHitBlock().getWorld().playSound(e.getHitBlock().getLocation(), Sound.ENTITY_VILLAGER_NO, 3, 1);
        }
        else {
            e.getHitBlock().setType(Material.AIR);
            plugin.gameMap.get(player).increaseScore(1);
            e.getEntity().remove();
            plugin.addToRespawn(e.getHitBlock().getLocation());
            e.getHitBlock().getWorld().playSound(e.getHitBlock().getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 3, 1);
            new BukkitRunnable() {
                @Override
                public void run() {
                    plugin.respawnTarget(e.getHitBlock().getLocation());
                    plugin.removeToRespawn(e.getHitBlock().getLocation());
                    cancel();
                }
            }.runTaskTimer(plugin, random.nextInt(40, 80), 0);
        }
    }
}
