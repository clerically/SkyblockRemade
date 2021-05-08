package me.clerically.Skyblock.commands;

import java.util.ArrayList;

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

public class Skills implements CommandExecutor {
	
	public static float getSkillAverage(Player player) {
		// TODO: This lol
		
		return 0.0f;
	}
	
	private static void updateHeaderIcon(Inventory gui, Player player) {
		ItemStack playerSkills = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta skillsMeta = playerSkills.getItemMeta();
		
		skillsMeta.setDisplayName("�aYour Skills");
		
		ArrayList<String> skillsLore = new ArrayList<String>();
		skillsLore.add("�7View your Skill progression and");
		skillsLore.add("�7rewards.");
		skillsLore.add("");
		skillsLore.add(String.format("�6%f Skill Avg. �8(non-cosmetic)", getSkillAverage(player)));
		
		skillsMeta.setLore(skillsLore);
		
		skillsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		playerSkills.setItemMeta(skillsMeta);
		
		gui.setItem(4, playerSkills); // Top center
	}
	
	public static void open(Player player) {
		Inventory gui = Bukkit.createInventory(player, 54, "Your Skills");
		SkyblockUtils.createGuiSpaces(gui);
		
		updateHeaderIcon(gui, player);
		
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
