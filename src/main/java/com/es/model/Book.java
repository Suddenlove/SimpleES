package com.es.model;

import java.util.List;

public class Book {

	private long id;
	private long categoryId;
	private String categoryName;
	private String name;
	private String subName;
	private String author;
	private int price;
	private int rank;
	private int sellerType;
	private int status;
	private String onLineTime;
	private int hasEBook;
	private long pressId;
	private String pressName;
	private int stock;
	private int stockStatus;
	private List<Long> saleAttrIds;
	private List<String> saleAttrNames;
	private int recentSaleAmount;
	private int totalSaleAmount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSellerType() {
		return sellerType;
	}

	public void setSellerType(int sellerType) {
		this.sellerType = sellerType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOnLineTime() {
		return onLineTime;
	}

	public void setOnLineTime(String onLineTime) {
		this.onLineTime = onLineTime;
	}

	public int getHasEBook() {
		return hasEBook;
	}

	public void setHasEBook(int hasEBook) {
		this.hasEBook = hasEBook;
	}

	public long getPressId() {
		return pressId;
	}

	public void setPressId(long pressId) {
		this.pressId = pressId;
	}

	public String getPressName() {
		return pressName;
	}

	public void setPressName(String pressName) {
		this.pressName = pressName;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockStatus() {
		return stockStatus;
	}

	public void setStockStatus(int stockStatus) {
		this.stockStatus = stockStatus;
	}

	public List<Long> getSaleAttrIds() {
		return saleAttrIds;
	}

	public void setSaleAttrIds(List<Long> saleAttrIds) {
		this.saleAttrIds = saleAttrIds;
	}

	public List<String> getSaleAttrNames() {
		return saleAttrNames;
	}

	public void setSaleAttrNames(List<String> saleAttrNames) {
		this.saleAttrNames = saleAttrNames;
	}

	public int getRecentSaleAmount() {
		return recentSaleAmount;
	}

	public void setRecentSaleAmount(int recentSaleAmount) {
		this.recentSaleAmount = recentSaleAmount;
	}

	public int getTotalSaleAmount() {
		return totalSaleAmount;
	}

	public void setTotalSaleAmount(int totalSaleAmount) {
		this.totalSaleAmount = totalSaleAmount;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", categoryId=" + categoryId + ", categoryName=" + categoryName + ", name=" + name
				+ ", subName=" + subName + ", author=" + author + ", price=" + price + ", rank=" + rank
				+ ", sellerType=" + sellerType + ", status=" + status + ", onLineTime=" + onLineTime + ", hasEBook="
				+ hasEBook + ", pressId=" + pressId + ", pressName=" + pressName + ", stock=" + stock + ", stockStatus="
				+ stockStatus + ", saleAttrIds=" + saleAttrIds + ", saleAttrNames=" + saleAttrNames + ", saleAmount="
				+ ", recentSaleAmount=" + recentSaleAmount + ", totalSaleAmount=" + totalSaleAmount + "]";
	}

}
