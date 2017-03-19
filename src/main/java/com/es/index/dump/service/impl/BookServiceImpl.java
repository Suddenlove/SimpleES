package com.es.index.dump.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.es.index.dump.dao.BookDao;
import com.es.index.dump.service.BookService;
import com.es.model.BookBook;

public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	
	@Override
	public Map<Long, BookBook> getAllBook(List<Long> bookIds) {
		Map<Long, BookBook> bookMap = new HashMap<Long, BookBook>();
		List<BookBook> books = bookDao.getAllBook(bookIds);
		if(CollectionUtils.isNotEmpty(books)){
			for(BookBook book : books){
				bookMap.put(book.getId(), book);
			}
		}
		return bookMap;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
