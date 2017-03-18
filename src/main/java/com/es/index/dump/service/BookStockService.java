package com.es.index.dump.service;

import java.util.Map;

import com.es.model.BookStock;

public interface BookStockService {

	Map<Long, BookStock> getAllBookStock();
}
