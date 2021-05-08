package me.clerically.Skyblock;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Helpful utilities for making my life soooo much easier.
 * Only supports 1.16.5
 * 
 * @author Clerically
 * @version 1.0.0
 */

//TODO: Figure out what the FUCK I'm doing here

public final class SkyblockUtils {
	private static Map<String, String[]> mobData = new HashMap<String, String[]>();
	
	// Mob things
	
	public Entity spawnMob(World world, Location location, String[] args) {
		String mobType = args[0].toUpperCase(); // Required
		
		Entity mob = world.spawnEntity(location, EntityType.valueOf(mobType));
		
		String mobId = mob.getUniqueId().toString();
		mobData.put(mobId, args);
		
		int minHealth = Integer.parseInt(mobData.get(mobId)[1]) | 100;  // Integer.parseInt(args[1]) | 100;
		int maxHealth = Integer.parseInt(mobData.get(mobId)[2]); //Integer.parseInt(args[2]) | 100;
		
		int damage = Integer.parseInt(mobData.get(mobId)[3]); //Integer.parseInt(args[3]) | 10;
		int strength = Integer.parseInt(mobData.get(mobId)[4]); //Integer.parseInt(args[4]) | 0;
		int defense = Integer.parseInt(mobData.get(mobId)[5]); //Integer.parseInt(args[5]) | 0;
		
		return mob;
	}
	
	// Gui things
	
	public static void createGuiSpaces(Inventory gui, Boolean doIndexNames) {
		for (int i = 0; i < gui.getSize(); i++) {
			ItemStack blankSpace = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
			ItemMeta blankSpaceMeta = blankSpace.getItemMeta();
			
			if (doIndexNames) {
				blankSpaceMeta.setDisplayName(Integer.toString(i));
			} else {
				blankSpaceMeta.setDisplayName(" ");
			}
			
			blankSpace.setItemMeta(blankSpaceMeta);
			
			gui.setItem(i, blankSpace);
		}
	}
}