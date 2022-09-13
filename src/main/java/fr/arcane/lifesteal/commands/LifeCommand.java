package fr.arcane.lifesteal.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LifeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

                try {
                    if (args[0] != null) {
                        if (args[1] != null) {

                    Player p = Bukkit.getPlayer(args[0]);
                    double health = Integer.parseInt(args[1]);
                    p.setMaxHealth(health);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[LifeStealHardcore] Ta vie a été changée par une force supérieure !"));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[LifeStealHardcore] Le Joueur " + p.getName() + " a maintenant " + health + " de vie"));

                        }

                    }
                } catch (Exception e) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[LifeStealHardcore] Erreur. La commande est /life <pseudo> <vie>"));
                }



        return false;
    }
}
