package me.clerically.Skyblock.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.clerically.Skyblock.commands.Profile;

public class ProfileHandler implements Listener{
	
	@EventHandler
	public void onMenuClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		
		InventoryView menuView = event.getView();
		String menuTitle = menuView.getTitle();
		
		if (menuTitle == "Your Skyblock Profile") {
			event.setCancelled(true);
			
			if (event.getCurrentItem() == null) {
				return;
			} else {
				
				ItemStack item = event.getCurrentItem();
				ItemMeta itemMeta = item.getItemMeta();
				
				
			}
		}
	}
	
}