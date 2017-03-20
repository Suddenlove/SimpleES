package com.es.model;

import java.io.Serializable;
import java.util.List;

public class BookBook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private long pressId;
	private long categoryId;
	private String name;
	private String subName;
	private String author;
	private int price;
	private int rank;
	private int sellerType;
	private int status;
	private String onLineTime;
	private int hasEBook;
	private List<Long> saleAttrs;

	public long getId() {
		return id;
	}

	public List<Long> getSaleAttrs() {
		return saleAttrs;
	}

	public void setSaleAttrs(List<Long> saleAttrs) {
		this.saleAttrs = saleAttrs;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

}
