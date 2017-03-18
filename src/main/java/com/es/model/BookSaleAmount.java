package com.es.model;

public class BookSaleAmount {
	
	private long id;
	private int recentAmount;
	private int totalAmount;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRecentAmount() {
		return recentAmount;
	}
	public void setRecentAmount(int recentAmount) {
		this.recentAmount = recentAmount;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
}
