package com.es.index.dump.dao;

import java.util.List;

import com.es.model.Book;

public interface BookDao {
	
	List<Book> getAllBook(List<Long> bookIds);

}
