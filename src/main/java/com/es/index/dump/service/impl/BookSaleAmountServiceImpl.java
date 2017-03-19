package com.es.index.dump.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.es.index.dump.dao.BookSaleAmountDao;
import com.es.index.dump.service.BookSaleAmountService;
import com.es.model.BookSaleAmount;

public class BookSaleAmountServiceImpl implements BookSaleAmountService{

	private BookSaleAmountDao bookSaleAmountDao;
	
	@Override
	public Map<Long, BookSaleAmount> getAllBookSaleAmount() {
		Map<Long, BookSaleAmount> amountMap = new HashMap<Long, BookSaleAmount>();
		List<BookSaleAmount> saleAmounts = bookSaleAmountDao.getAllBookSaleAmount();
		if(CollectionUtils.isNotEmpty(saleAmounts)){
			for(BookSaleAmount saleAmount : saleAmounts){
				amountMap.put(saleAmount.getId(), saleAmount);
			}
		}
		return amountMap;
	}

	public void setBookSaleAmountDao(BookSaleAmountDao bookSaleAmountDao) {
		this.bookSaleAmountDao = bookSaleAmountDao;
	}

}
