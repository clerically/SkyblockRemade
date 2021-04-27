package me.clerically.Skyblock;

import org.bukkit.plugin.java.JavaPlugin;

import me.clerically.Skyblock.commands.Menu;
import me.clerically.Skyblock.commands.Profile;
import me.clerically.Skyblock.commands.Skills;
import me.clerically.Skyblock.listeners.MenuHandler;
import me.clerically.Skyblock.listeners.ProfileHandler;
import me.clerically.Skyblock.listeners.SkillsHandler;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		// Commands
		getCommand("menu").setExecutor(new Menu());
		getCommand("profile").setExecutor(new Profile());
		getCommand("skills").setExecutor(new Skills());
		
		// Listeners
		getServer().getPluginManager().registerEvents(new MenuHandler(), this);
		getServer().getPluginManager().registerEvents(new ProfileHandler(), this);
		getServer().getPluginManager().registerEvents(new SkillsHandler(), this);
	}
	
}