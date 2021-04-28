package me.clerically.Skyblock.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.clerically.Skyblock.SkyblockUtils;
import me.clerically.Skyblock.commands.Menu;

public class Profile implements CommandExecutor {
	
	public static void open(Player player) {
		Inventory gui = Bukkit.createInventory(player, 54, "Your Skyblock Profile");
		SkyblockUtils.createGuiSpaces(gui);
		
		ItemStack playerProfile = new ItemStack(Material.PLAYER_HEAD, 1);
		SkullMeta playerHeadMeta = (SkullMeta) playerProfile.getItemMeta();
		playerHeadMeta.setDisplayName("§aYour Skyblock Profile");
		playerHeadMeta.setOwningPlayer(player);
		playerProfile.setItemMeta(playerHeadMeta);
		
		gui.setItem(4, playerProfile);
		
		player.openInventory(gui);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			open(player);
		}
		
		return true;
	}
}
