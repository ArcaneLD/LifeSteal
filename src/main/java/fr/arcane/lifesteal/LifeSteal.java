package fr.arcane.lifesteal;

import fr.arcane.lifesteal.commands.LifeCommand;
import fr.arcane.lifesteal.events.BossKillEvent;
import fr.arcane.lifesteal.events.DeathEvent;
import fr.arcane.lifesteal.items.HeartApple;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LifeSteal extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new HeartApple(), this);
        Bukkit.getPluginManager().registerEvents(new DeathEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BossKillEvent(), this);

        getCommand("life").setExecutor(new LifeCommand());

    }

    @Override
    public void onDisable() {
        System.out.println("[LifeStealHardcore] Saving health");
    }



}
