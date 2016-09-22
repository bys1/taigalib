package eu.taigacraft.lib.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import eu.taigacraft.lib.TaigaPlugin;

public class SQLResult {
	
	public final TaigaPlugin plugin;
	private final ResultSet result;
	
	SQLResult(TaigaPlugin plugin, ResultSet result) {
		this.plugin = plugin;
		this.result = result;
	}
	
	public boolean next() {
		try {
			return result.next();
		} catch(SQLException e) {
			plugin.logger.error("Couldn't iterate over SQLResult",e);
			return false;
		}
	}
	
	public Object getObject(String column) {
		try {
			return result.getObject(column);
		} catch(SQLException e) {
			plugin.logger.error("Couldn't get data",e);
			return null;
		}
	}
	
	public Byte getByte(String column) {
		Byte value;
		try {
			value = result.getByte(column);
			if (result.wasNull()) value = null;
			return value;
		} catch(SQLException e) {
			plugin.logger.error("Couldn't get data",e);
			return null;
		}
	}
	
	public Short getShort(String column) {
		Short value;
		try {
			value = result.getShort(column);
			if (result.wasNull()) value = null;
			return value;
		} catch(SQLException e) {
			plugin.logger.error("Couldn't get data",e);
			return null;
		}
	}
	
	public Integer getInt(String column) {
		Integer value;
		try {
			value = result.getInt(column);
			if (result.wasNull()) value = null;
			return value;
		} catch(SQLException e) {
			plugin.logger.error("Couldn't get data",e);
			return null;
		}
	}
	
	public Long getLong(String column) {
		Long value;
		try {
			value = result.getLong(column);
			if (result.wasNull()) value = null;
			return value;
		} catch(SQLException e) {
			plugin.logger.error("Couldn't get data",e);
			return null;
		}
	}
	
	public Boolean getBoolean(String column) {
		Boolean value;
		try {
			value = result.getBoolean(column);
			if (result.wasNull()) value = null;
			return value;
		} catch(SQLException e) {
			plugin.logger.error("Couldn't get data",e);
			return null;
		}
	}
	
	public String getString(String column) {
		String value;
		try {
			value = result.getString(column);
			if (result.wasNull()) value = null;
			return value;
		} catch(SQLException e) {
			plugin.logger.error("Couldn't get data",e);
			return null;
		}
	}
	
	public UUID getUUID(String column) {
		if (getString(column) == null) return null;
		return UUID.fromString(getString(column));
	}
	
}
