package eu.taigacraft.lib;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TaigaPlugin extends JavaPlugin {
	
	public final PluginDescriptionFile pdf = getDescription();
	public final Logger logger = new Logger(this);
	public final String name = pdf.getName() + " v" + pdf.getVersion();
	protected final PluginManager pluginManager = getServer().getPluginManager();
	
	@Override
	public void onEnable() {
		logger.info(name + " has been enabled.");
	}
	
	@Override
	public void onDisable() {
		logger.info(name + " has been disabled.");
	}
	
	public static TaigaPlugin getPlugin() {
		return JavaPlugin.getPlugin(TaigaPlugin.class);
	}
	
}
