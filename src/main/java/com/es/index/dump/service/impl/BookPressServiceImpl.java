package com.es.index.dump.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.es.index.cache.CacheCommand;
import com.es.index.cache.CacheManager;
import com.es.index.cache.CacheService;
import com.es.index.dump.dao.BookPressDao;
import com.es.index.dump.service.BookPressServcie;
import com.es.model.BookPress;


public class BookPressServiceImpl extends CacheService implements BookPressServcie{
	
	private BookPressDao bookPressDao;
	private Map<Long, BookPress> bookPressMap;
	
	public BookPressServiceImpl() {
		this.serOrder(ORDER.FIRST);
		CacheCommand command = new CacheCommand(this);
		CacheManager.getInstance().registe(command);
	}

	@Override
	public Map<Long, BookPress> getAllBookPress() {
		return bookPressMap;
	}

	@Override
	public void tryReload() throws Exception {
		Map<Long, BookPress> pressMap = new HashMap<Long, BookPress>();
		List<BookPress> bookPresses = bookPressDao.getAllBookPress();
		if(CollectionUtils.isNotEmpty(bookPresses)){
			for(BookPress bookPress : bookPresses){
				pressMap.put(bookPress.getId(), bookPress);
			}
		}
		if(pressMap.size() > 0){
			this.bookPressMap = pressMap;
		}
	}
	
	public void setBookPressDao(BookPressDao bookPressDao) {
		this.bookPressDao = bookPressDao;
	}
}
