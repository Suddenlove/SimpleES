package com.es.index.dump.service;

import java.util.Map;

import com.es.model.BookSaleAmount;

public interface BookSaleAmountService {
	
	Map<Long, BookSaleAmount> getAllBookSaleAmount();
}
