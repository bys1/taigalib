package eu.taigacraft.lib.sql;

public class Column {
	
	private String name;
	private ColumnType type;
	private byte length;
	private boolean nul;
	private boolean autoIncrement;
	
	public Column(String name, ColumnType type, byte length) {
		this(name,type,length,true,false);
	}
	
	public Column(String name, ColumnType type, byte length, boolean nul) {
		this(name,type,length,nul,false);
	}
	
	public Column(String name, ColumnType type, byte length, boolean nul, boolean autoIncrement) {
		this.name = name;
		this.type = type;
		this.length = length;
		this.nul = nul;
		setAutoIncrement(autoIncrement);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public ColumnType getType() {
		return type;
	}
	
	public void setType(ColumnType type) {
		this.type = type;
	}
	
	public byte getLength() {
		return length;
	}
	
	public void setLength(byte length) {
		this.length = length;
	}
	
	public boolean getNull() {
		return nul;
	}
	
	public void setNull(boolean nul) {
		this.nul = nul;
	}
	
	public boolean getAutoIncrement() {
		return autoIncrement;
	}
	
	public void setAutoIncrement(boolean autoIncrement) {
		this.autoIncrement = this.type != ColumnType.STRING && this.type != ColumnType.BOOLEAN ? autoIncrement : false;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("");
		
		builder.append(" `" + name + "`");
		builder.append(" " + type.toString());
		builder.append(" ( " + length + " ) ");
		builder.append(nul ? "NULL" : "NOT NULL");
		if (autoIncrement) builder.append(" AUTO_INCREMENT");
		
		return builder.toString();
	}
	
	public enum ColumnType {
		BYTE,SHORT,INTEGER,LONG,BOOLEAN,STRING;
		
		@Override
		public String toString() {
			switch(this) {
			case BYTE: return "BYTE";
			case SHORT: return "SHORT";
			case INTEGER: return "INT";
			case LONG: return "LONG";
			case BOOLEAN: return "BOOLEAN";
			case STRING: return "VARCHAR";
			default: return super.toString();
			}
		}
	}
	
}
