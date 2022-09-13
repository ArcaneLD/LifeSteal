package fr.arcane.lifesteal.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {

    @EventHandler
    public void onDeathEvent(PlayerDeathEvent e) {

        Player p = e.getEntity();

        if (p.getMaxHealth() <= 2) {
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&c[LifeStealHardcore] " + e.getEntity().getName() + " est mort mais n'a pas perdu de vie, il est déjà au minimum possible"));

        } else if (p.getMaxHealth() > 3) {
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&c[LifeStealHardcore] " + e.getEntity().getName() + " est mort et a perdu un coeur définitif"));

            p.setMaxHealth(p.getMaxHealth() - 2);

        }
    }
}
