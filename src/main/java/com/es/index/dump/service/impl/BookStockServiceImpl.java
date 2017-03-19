package com.es.index.dump.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.es.index.dump.dao.BookStockDao;
import com.es.index.dump.service.BookStockService;
import com.es.model.BookStock;

public class BookStockServiceImpl implements BookStockService {

	private BookStockDao bookStockDao;

	@Override
	public Map<Long, BookStock> getAllBookStock() {
		Map<Long, BookStock> stockMap = new HashMap<Long, BookStock>();
		List<BookStock> bookStocks = bookStockDao.getAllBookStock();
		if(CollectionUtils.isNotEmpty(bookStocks)){
			for(BookStock bookStock : bookStocks){
				stockMap.put(bookStock.getId(), bookStock);
			}
		}
		return stockMap;
	}

	public void setBookStockDao(BookStockDao bookStockDao) {
		this.bookStockDao = bookStockDao;
	}

}
