package eu.taigacraft.lib;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.PluginManager;

public final class PermissionManager {
	
	private PluginManager pm;
	private String name;
	private PermissionDefault permissionDefault;
	private Map<String,Boolean> permissions;
	
	public PermissionManager(String name, boolean op) {
		this.pm = TaigaPlugin.getPlugin().getServer().getPluginManager();
		this.name = name;
		if (op == true) {
			this.permissionDefault = PermissionDefault.OP;
		}
		else {
			this.permissionDefault = PermissionDefault.FALSE;
		}
		this.permissions = new HashMap<String,Boolean>();
	}
	
	public final void register(String name, String description) {
		String permission = this.name + "." + name;
		if (this.permissions.containsKey(permission)) {
			return;
		}
		this.pm.addPermission(new Permission(permission,description,this.permissionDefault));
		this.permissions.put(permission,true);
	}
	
	public final void addChildren(Map<String,Boolean> children) {
		this.permissions.putAll(children);
	}
	
	public final Map<String,Boolean> complete() {
		this.pm.addPermission(new Permission(this.name + ".*","Gives you all " + this.name + " permissions.",
				this.permissionDefault,this.permissions));
		this.permissions.put(this.name + ".*",true);
		return this.permissions;
	}
	
}
