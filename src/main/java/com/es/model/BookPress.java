package com.es.model;

import java.util.List;

public class BookPress {

	private long id;
	private String pressName;
	private List<String> pressMainBook;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPressName() {
		return pressName;
	}

	public void setPressName(String pressName) {
		this.pressName = pressName;
	}

	public List<String> getPressMainBook() {
		return pressMainBook;
	}

	public void setPressMainBook(List<String> pressMainBook) {
		this.pressMainBook = pressMainBook;
	}
}
