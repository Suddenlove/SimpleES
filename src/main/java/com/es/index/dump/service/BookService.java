package com.es.index.dump.service;

import java.util.List;
import java.util.Map;

import com.es.model.BookBook;

public interface BookService {
	
	Map<Long, BookBook> getAllBook(List<Long> bookIds);
}
