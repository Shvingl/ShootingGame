package luke.y.invincibleDogs;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class MobDeathEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onEntityDeath(EntityDamageEvent event) {
        if (!(event.getEntity().getType().equals(EntityType.WOLF)))
            return;
        Wolf wolf = (Wolf) event.getEntity();
        if (!(wolf.isTamed()))
            return;
        event.setCancelled(true);
    }

}
