package com.es.index.dump.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.es.index.cache.CacheCommand;
import com.es.index.cache.CacheManager;
import com.es.index.cache.CacheService;
import com.es.index.dump.dao.BookStockDao;
import com.es.index.dump.service.BookStockService;
import com.es.model.BookStock;

public class BookStockServiceImpl extends CacheService implements BookStockService {

	private BookStockDao bookStockDao;
	private Map<Long, BookStock> cacheBookStockMap;
	public BookStockServiceImpl() {
		this.serOrder(ORDER.SECONED);
		CacheCommand command = new CacheCommand(this);
		CacheManager.getInstance().registe(command);
	}
	

	@Override
	public Map<Long, BookStock> getAllBookStock() {
		return cacheBookStockMap;
	}

	public void setBookStockDao(BookStockDao bookStockDao) {
		this.bookStockDao = bookStockDao;
	}

	@Override
	public void tryReload() throws Exception {
		Map<Long, BookStock> stockMap = new HashMap<Long, BookStock>();
		List<BookStock> bookStocks = bookStockDao.getAllBookStock();
		if(CollectionUtils.isNotEmpty(bookStocks)){
			for(BookStock bookStock : bookStocks){
				stockMap.put(bookStock.getId(), bookStock);
			}
		}
		if(stockMap.size() > 0){
			this.cacheBookStockMap = stockMap;
		}
	}

}
