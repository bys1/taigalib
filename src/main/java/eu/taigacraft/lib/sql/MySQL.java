package eu.taigacraft.lib.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eu.taigacraft.lib.TaigaPlugin;

public class MySQL {
	
	private TaigaPlugin plugin;
	private Connection connection;
	
	private MySQL(TaigaPlugin plugin, Connection connection) {
		this.plugin = plugin;
		this.connection = connection;
	}
	
	public static MySQL connect(TaigaPlugin plugin, String host, int port, String database, String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException exception) {
			plugin.logger.error("MySQL Driver not available",exception);
			return null;
		}
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database,
					username, password);
		} catch(SQLException exception) {
			plugin.logger.error("Couldn't connect to MySQL",exception);
			return null;
		}
		return new MySQL(plugin,connection);
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public ResultSet get(Statement statement, String query) {
		try {
			return statement.executeQuery(query);
		} catch (SQLException ex) {
			plugin.logger.error("Couldn't get data from MySQL",ex);
			return null;
		}
	}
	
	public int update(Statement statement, String query) {
		try {
			return statement.executeUpdate(query);
		} catch (SQLException ex) {
			plugin.logger.error("Couldn't update MySQL",ex);
			return 0;
		}
	}
	
}
