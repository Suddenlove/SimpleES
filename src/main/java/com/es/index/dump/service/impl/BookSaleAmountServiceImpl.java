package com.es.index.dump.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.es.index.cache.CacheCommand;
import com.es.index.cache.CacheManager;
import com.es.index.cache.CacheService;
import com.es.index.dump.dao.BookSaleAmountDao;
import com.es.index.dump.service.BookSaleAmountService;
import com.es.model.BookSaleAmount;

public class BookSaleAmountServiceImpl extends CacheService implements BookSaleAmountService{

	private BookSaleAmountDao bookSaleAmountDao;
	private Map<Long, BookSaleAmount> cacheBookSaleAmountMap;
	
	public BookSaleAmountServiceImpl() {
		this.serOrder(ORDER.FIRST);
		CacheCommand command = new CacheCommand(this);
		CacheManager.getInstance().registe(command);
	}
	
	@Override
	public Map<Long, BookSaleAmount> getAllBookSaleAmount() {
		return cacheBookSaleAmountMap;
	}

	@Override
	public void tryReload() throws Exception {
		Map<Long, BookSaleAmount> amountMap = new HashMap<Long, BookSaleAmount>();
		List<BookSaleAmount> saleAmounts = bookSaleAmountDao.getAllBookSaleAmount();
		if(CollectionUtils.isNotEmpty(saleAmounts)){
			for(BookSaleAmount saleAmount : saleAmounts){
				amountMap.put(saleAmount.getId(), saleAmount);
			}
		}
		if(amountMap.size() > 0){
			this.cacheBookSaleAmountMap = amountMap;
		}
	}
	
	public void setBookSaleAmountDao(BookSaleAmountDao bookSaleAmountDao) {
		this.bookSaleAmountDao = bookSaleAmountDao;
	}

}
