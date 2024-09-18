package luke.y.noEXPFarms;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.metadata.MetadataValue;

public class EntitySpawnListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onSpawnerSpawn(SpawnerSpawnEvent event) {
        event.getEntity().setMetadata("Test", );
    }

}
