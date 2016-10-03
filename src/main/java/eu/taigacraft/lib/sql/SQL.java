package eu.taigacraft.lib.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import eu.taigacraft.lib.TaigaPlugin;

public class SQL {
	
	private TaigaPlugin plugin;
	private Connection connection;
	
	private SQL(TaigaPlugin plugin, Connection connection) {
		this.plugin = plugin;
		this.connection = connection;
	}
	
	public static SQL connectMySQL(TaigaPlugin plugin, String host, int port, String database, String username, String password) {
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
		return new SQL(plugin,connection);
	}
	
	public static SQL connectSQLite(TaigaPlugin plugin, String path) {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch(ClassNotFoundException exception) {
			plugin.logger.error("SQLite/JDBC not available",exception);
			return null;
		}
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:" + path);
		} catch(SQLException exception) {
			plugin.logger.error("Couldn't connect to SQLite",exception);
			return null;
		}
		return new SQL(plugin,connection);
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	public void createTable(Table table) {
		try {
			createStatement().execute("CREATE TABLE " + table.toString() + ";");
		} catch (SQLException ex) {
			plugin.logger.error("Couldn't create table",ex);
		}
	}
	
	public Statement createStatement() {
		try {
			return this.connection.createStatement();
		} catch (SQLException ex) {
			plugin.logger.error("Couldn't create statement",ex);
			return null;
		}
	}
	
	public SQLResult get(String query) {
		return get(createStatement(),query);
	}
	
	public SQLResult get(Statement statement, String query) {
		try {
			return new SQLResult(plugin,statement.executeQuery(query));
		} catch (SQLException ex) {
			plugin.logger.error("Couldn't get data from MySQL",ex);
			return null;
		}
	}
	
	public int update(String query) {
		return update(createStatement(),query);
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
