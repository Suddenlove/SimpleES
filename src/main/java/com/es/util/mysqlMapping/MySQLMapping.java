package com.es.util.mysqlMapping;

public class MySQLMapping {

	private long id;
	private String field;
	private String type;
	private int isIndex;
	private int isStore;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public int getIsIndex() {
		return isIndex;
	}

	public void setIsIndex(int isIndex) {
		this.isIndex = isIndex;
	}

	public int getIsStore() {
		return isStore;
	}

	public void setIsStore(int isStore) {
		this.isStore = isStore;
	}
}
