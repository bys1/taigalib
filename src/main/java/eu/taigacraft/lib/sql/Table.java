package eu.taigacraft.lib.sql;

public class Table {
	
	private String name;
	private String primaryKey;
	private Column[] columns;
	
	public Table(String name, String primaryKey, Column... columns) {
		this.name = name;
		this.primaryKey = primaryKey;
		this.columns = columns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Column[] getColumns() {
		return columns;
	}

	public void setColumns(Column... columns) {
		this.columns = columns;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("");
		
		builder.append(name);
		builder.append(" ( ");
		for (Column column : columns) {
			builder.append(column.toString() + ", ");
		}
		builder.append("PRIMARY KEY ( " + primaryKey + " )");
		builder.append(" )");
		
		return builder.toString();
	}
	
}
