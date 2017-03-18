package com.es.model;

import java.io.Serializable;

public class Book implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private long pressId;
	private long categoryId;
	private int saleAttributeId;
	private String name;
	private String subName;
	private String author;
	private int price;
	private int rank;
	private int sellerType;
	private int status;
	private String onLineTime;
	private int hasEBook;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPressId() {
		return pressId;
	}

	public void setPressId(long pressId) {
		this.pressId = pressId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
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

	public int getSaleAttributeId() {
		return saleAttributeId;
	}

	public void setSaleAttributeId(int saleAttributeId) {
		this.saleAttributeId = saleAttributeId;
	}

	public int getHasEBook() {
		return hasEBook;
	}

	public void setHasEBook(int hasEBook) {
		this.hasEBook = hasEBook;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", pressId=" + pressId + ", categoryId=" + categoryId + ", name=" + name
				+ ", subName=" + subName + ", author=" + author + ", price=" + price + ", rank=" + rank
				+ ", sellerType=" + sellerType + ", status=" + status + ", onLineTime=" + onLineTime
				+ ", saleAttributeId=" + saleAttributeId + ", hasEBook=" + hasEBook + "]";
	}

	@Override
	protected Book clone() throws CloneNotSupportedException {
		super.clone();
		Book b = new Book();
		b.id = this.id;
		b.categoryId = this.categoryId;
		b.pressId = this.pressId;
		b.saleAttributeId = this.saleAttributeId;
		b.name = this.name;
		b.subName = this.subName;
		b.author = this.author;
		b.price = this.price;
		b.rank = this.rank;
		b.sellerType = this.sellerType;
		b.status = this.status;
		b.onLineTime = this.onLineTime;
		b.hasEBook = this.hasEBook;
		return b;
	}

}
