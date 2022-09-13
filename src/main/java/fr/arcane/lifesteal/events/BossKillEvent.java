package fr.arcane.lifesteal.events;

import fr.arcane.lifesteal.items.HeartApple;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class BossKillEvent implements Listener {

    @EventHandler
    public void onBossKill(EntityDeathEvent e) {

        Entity ent = e.getEntity();

        if (ent.getType() == EntityType.WARDEN || ent.getType() == EntityType.ENDER_DRAGON || ent.getType() == EntityType.WITHER || ent.getType() == EntityType.ELDER_GUARDIAN) {
            if (e.getEntity().getKiller() == null) {
                ItemStack i = HeartApple.BuildItem("Cause Naturelle");
                e.getDrops().add(i);

            } else {
                ItemStack i = HeartApple.BuildItem(e.getEntity().getKiller().getDisplayName());
                e.getDrops().add(i);
            }
        }

    }
}
