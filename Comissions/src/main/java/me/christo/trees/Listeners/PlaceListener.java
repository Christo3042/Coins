package me.christo.trees.Listeners;

import me.christo.trees.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Copy Right ©
 * This code is private
 * Owner: Christo
 * From: 10/22/19-2023
 * Any attempts to use these program(s) may result in a penalty of up to $1,000 USD
 **/

public class PlaceListener implements Listener {

    @EventHandler
    public void onPlace(PlayerInteractEvent e) {

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem().getType() == Material.OAK_SAPLING) {
                Player p = (Player) e.getPlayer();

                Main.getInstance().loadSchematic(p);


            }


        }

        //lol
    }
}
