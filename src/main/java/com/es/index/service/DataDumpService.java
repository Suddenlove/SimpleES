package com.es.index.service;

import java.util.List;
import java.util.Map;

import com.es.index.dump.service.BookPressServcie;
import com.es.index.dump.service.BookSaleAmountService;
import com.es.index.dump.service.BookSaleAttrService;
import com.es.index.dump.service.BookService;
import com.es.index.dump.service.BookStockService;
import com.es.index.dump.service.CategoryService;
import com.es.model.BookBook;
import com.es.model.BookPress;
import com.es.model.BookSaleAmount;
import com.es.model.BookSaleAttr;
import com.es.model.BookStock;
import com.es.model.Category;

public class DataDumpService {

	private BookService bookService;
	private BookSaleAmountService bookSaleAmountService;
	private BookSaleAttrService bookSaleAttrService;
	private BookPressServcie bookPressServcie;
	private BookStockService bookStockService;
	private CategoryService categoryService;

	public Map<Long, BookBook> getAllBook(List<Long> bookIds) {
		return bookService.getAllBook(bookIds);
	}

	public Map<Long, BookSaleAmount> getAllSaleAmount() {
		return bookSaleAmountService.getAllBookSaleAmount();
	}

	public Map<Long, BookSaleAttr> getAllSaleAttr() {
		return bookSaleAttrService.getAllBooSaleAttr();
	}

	public Map<Long, BookPress> getAllPress() {
		return bookPressServcie.getAllBookPress();
	}

	public Map<Long, BookStock> getAllStock() {
		return bookStockService.getAllBookStock();
	}

	public Map<Long, Category> getAllCategory() {
		return categoryService.getAllCateogryServcie();
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public void setBookSaleAmountService(BookSaleAmountService bookSaleAmountService) {
		this.bookSaleAmountService = bookSaleAmountService;
	}

	public void setBookSaleAttrService(BookSaleAttrService bookSaleAttrService) {
		this.bookSaleAttrService = bookSaleAttrService;
	}

	public void setBookPressServcie(BookPressServcie bookPressServcie) {
		this.bookPressServcie = bookPressServcie;
	}

	public void setBookStockService(BookStockService bookStockService) {
		this.bookStockService = bookStockService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
}
