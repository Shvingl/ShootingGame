package luke.y.shootingGame;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
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
        new BukkitRunnable() {
            @Override
            public void run() {
                owner.sendTitle("", "" + time, 5, 5, 5);
                owner.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(""+score));

                time--;
                if (time <= 0) {
                    cancel();
                    finishGame();
                }
            }
        }.runTaskTimer(plugin, 20, 20); // Run task every 20 ticks
    }

    private void finishGame() {

    }

    public void increaseScore(int a) {
        score+=a;
    }

    private int score;
    private int time;
}
