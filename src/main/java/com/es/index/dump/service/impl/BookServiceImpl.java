package com.es.index.dump.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.es.index.dump.dao.BookDao;
import com.es.index.dump.service.BookService;
import com.es.model.Book;

public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	
	@Override
	public Map<Long, Book> getAllBook(List<Long> bookIds) {
		Map<Long, Book> bookMap = new HashMap<Long, Book>();
		List<Book> books = bookDao.getAllBook(bookIds);
		if(CollectionUtils.isNotEmpty(books)){
			for(Book book : books){
				bookMap.put(book.getId(), book);
			}
		}
		return bookMap;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
