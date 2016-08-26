package eu.taigacraft.lib;

public class Logger {
	
	public enum Level {
		INFO,NOTICE,DEBUG;
	}

	protected TaigaPlugin plugin;
	protected Level level;
	
	public Logger(TaigaPlugin plugin) {
		this.plugin = plugin;
	}
	
	public void info(String message) {
		plugin.getLogger().info(message);
	}
	
	public void warn(String message) {
		plugin.getLogger().log(java.util.logging.Level.WARNING,message);
	}
	
	public void error(String message) {
		plugin.getLogger().log(java.util.logging.Level.SEVERE,message);
	}
	
	public void error(String message, Throwable exception) {
		plugin.getLogger().log(java.util.logging.Level.SEVERE,message,exception);
	}
	
	public void notice(String message) {
		if ( (this.level == Level.NOTICE) || (this.level == Level.DEBUG) ) {
			plugin.getLogger().info("[NOTICE] " + message);
		}
	}
	
	public void debug(String message) {
		if (this.level == Level.DEBUG) {
			plugin.getLogger().info("[DEBUG] " + message);
		}
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
}
