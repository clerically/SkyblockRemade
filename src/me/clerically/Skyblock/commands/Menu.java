package me.clerically.Skyblock.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Menu implements CommandExecutor {
	
	public static void createGuiSpaces(Inventory gui) {
		for (int i = 0; i < gui.getSize(); i++) {
			ItemStack blankSpace = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
			ItemMeta blankSpaceMeta = blankSpace.getItemMeta();
			blankSpaceMeta.setDisplayName(" ");
			blankSpace.setItemMeta(blankSpaceMeta);
			
			gui.setItem(i, blankSpace);
		}
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player) sender;
			World world = player.getWorld();
			
			Inventory gui = Bukkit.createInventory(player, 54, "Skyblock Menu");
			
			// Create black tiles for spaces not used
			createGuiSpaces(gui);
			
			ItemStack playerProfile = new ItemStack(Material.PLAYER_HEAD, 1);
			SkullMeta playerHeadMeta = (SkullMeta) playerProfile.getItemMeta();
			playerHeadMeta.setDisplayName("§aYour Skyblock Profile");
			playerHeadMeta.setOwningPlayer(player);
			playerProfile.setItemMeta(playerHeadMeta);
			
			ItemStack playerSkills = new ItemStack(Material.DIAMOND_SWORD, 1);
			ItemMeta skillsMeta = playerSkills.getItemMeta();
			skillsMeta.setDisplayName("§aYour Skills");
			ArrayList<String> skillsLore = new ArrayList<String>();
			skillsLore.add("§7View your Skill progression and");
			skillsLore.add("§7rewards.");
			skillsLore.add("");
			skillsLore.add("§60.0 Skill Avg. §8(non-cosmetic)"); 
			skillsMeta.setLore(skillsLore);
			skillsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			playerSkills.setItemMeta(skillsMeta);
			
			ItemStack playerCollection = new ItemStack(Material.PAINTING, 1);
			ItemMeta collectionMeta = playerCollection.getItemMeta();
			collectionMeta.setDisplayName("§aCollection");
			ArrayList<String> collectionLore = new ArrayList<String>();
			collectionLore.add("§7View all of the items available");
			collectionLore.add("§7in Skyblock. Collect more of an");
			collectionLore.add("§7item to unlock rewards on your");
			collectionLore.add("§7way to becoming a master of");
			collectionLore.add("§7Skyblock!");
			collectionLore.add("");
			collectionLore.add("§7Collection Maxed Out: §a100%");
			collectionLore.add("§7Collections Unlocked: §e10/10");
			collectionMeta.setLore(collectionLore);
			playerCollection.setItemMeta(collectionMeta);
			
			ItemStack recipeBook = new ItemStack(Material.BOOK, 1);
			ItemMeta bookMeta = recipeBook.getItemMeta();
			bookMeta.setDisplayName("§aRecipe Book");
			ArrayList<String> bookLore = new ArrayList<String>();
			bookLore.add("§7Through your adventure, you will");
			bookLore.add("§7unlock recipes for all kinds of");
			bookLore.add("§7special items! You can view how");
			bookLore.add("§7to craft these items here.");
			bookLore.add("");
			bookLore.add("§7Recipe Book Completion: §a100%");
			bookLore.add("§7Recipes Unlocked: §e100/100");
			bookMeta.setLore(bookLore);
			recipeBook.setItemMeta(bookMeta);
			
			gui.setItem(13, playerProfile); // Middle
			gui.setItem(19, playerSkills);
			gui.setItem(20, playerCollection);
			gui.setItem(21, recipeBook);
			
			player.openInventory(gui);
		}
		
		return true;
	}
	
}