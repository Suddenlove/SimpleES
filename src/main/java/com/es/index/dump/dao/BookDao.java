package com.es.index.dump.dao;

import java.util.List;

import com.es.model.BookBook;

public interface BookDao {
	
	List<BookBook> getAllBook(List<Long> bookIds);

}
