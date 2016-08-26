package eu.taigacraft.lib;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class MainCommand implements CommandExecutor {
	
	protected TaigaPlugin plugin;
	protected ChatColor color;
	
	public MainCommand(TaigaPlugin plugin, ChatColor color) {
		this.plugin = plugin;
		this.color = color;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (args.length == 0) return false;
		
		if (args[0].equalsIgnoreCase("help")) {
			help(sender,label,args);
			return true;
		}
		
		if (args[0].equalsIgnoreCase("version")) {
			version(sender,label,args);
			return true;
		}
		
		if (args[0].equalsIgnoreCase("reload")) {
			reload(sender,label,args);
			return true;
		}
		
		return false;
	}
	
	protected abstract void help(CommandSender sender, String label, String[] args);
	
	protected void version(CommandSender sender, String label, String[] args) {
		sender.sendMessage(this.color + plugin.name + " - by bys1");
	}
	
	protected void reload(CommandSender sender, String label, String[] args) {
		plugin.reloadConfig();
		sender.sendMessage(this.color + plugin.pdf.getName() + " has been reloaded successfully.");
	}

}
