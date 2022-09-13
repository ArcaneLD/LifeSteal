package fr.arcane.lifesteal.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class HeartApple implements Listener {



    public static ItemStack BuildItem(String s) {

        ItemStack i = new ItemStack(Material.APPLE, 1);
        ItemMeta iM = i.getItemMeta();

        iM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        iM.addEnchant(Enchantment.DURABILITY, 1, true);
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lRecover Apple"));


        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.translateAlternateColorCodes('&', "&cRestore un coeur définitif à celui qui la mange."));
        lore.add(ChatColor.translateAlternateColorCodes('&', "&cRécoltée par : " + s));
        iM.setLore(lore);

        i.setItemMeta(iM);

        return i;
    }

    @EventHandler
    public void onAppleEat(PlayerItemConsumeEvent e) {
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4&lRecover Apple"))) {

            Player p = e.getPlayer();


            if (!(p.getMaxHealth() >= 24)) {

                p.setMaxHealth(p.getMaxHealth() + 2);

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[LifeStealHardcore] Tu as récupéré un coeur définitif car tu as mangé une Recover Apple"));
            } else {
                e.setCancelled(true);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c[LifeStealHardcore] Tu as atteint le maximum possible de coeurs définitifs"));
            }
        }
    }


}
