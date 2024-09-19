package luke.y.shootingGame;

import luke.y.shootingGame.events.FinishShootingGameEvent;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ActiveGame {
    private Player owner;
    ShootingGame plugin;

    public ActiveGame(ShootingGame plugin, Player owner) {
        this.owner = owner;
        this.plugin = plugin;
        this.time = 60;
        this.score = 0;
        owner.playSound(owner, Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
        owner.sendTitle(ChatColor.DARK_GREEN + "START!", "", 5, 40, 10);
        owner.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Čas: "+time + "s"));
        new BukkitRunnable() {
            @Override
            public void run() {
                time--;
                owner.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("Čas: "+time + "s"));
                if (time <= 0) {
                    cancel();
                    finishGame();
                }
            }
        }.runTaskTimer(plugin, 20, 20); // Run task every 20 ticks
    }

    private void finishGame() {
        owner.sendTitle(ChatColor.DARK_GREEN + "Skóre: " + score, "Dobrá práce!", 5, 60, 10);
        owner.playSound(owner, Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
        FinishShootingGameEvent event = new FinishShootingGameEvent(owner, score);
        Bukkit.getServer().getPluginManager().callEvent(event);
        plugin.gameMap.remove(owner);
    }

    public void increaseScore(int a) {
        score+=a;
        owner.sendTitle(ChatColor.GOLD + "" + score, "", 0, 10, 0);
    }

    private int score;
    private int time;
}
