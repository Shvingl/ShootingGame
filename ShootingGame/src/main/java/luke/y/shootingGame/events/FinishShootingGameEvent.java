package luke.y.shootingGame.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class FinishShootingGameEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private int score;
    private Player player;
    private String id;

    public FinishShootingGameEvent(Player player, int score) {
        this.score = score;
        this.player = player;
        this.id = "INSERT ID HERE";
    }

    public Player getPlayer() {
        return player;
    }

    public int getScore() {
        return score;
    }

    public String getId() {
        return id;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
