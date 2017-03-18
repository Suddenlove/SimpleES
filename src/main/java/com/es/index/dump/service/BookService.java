package com.es.index.dump.service;

import java.util.List;
import java.util.Map;

import com.es.model.Book;

public interface BookService {
	
	Map<Long, Book> getAllBook(List<Long> bookIds);
}
