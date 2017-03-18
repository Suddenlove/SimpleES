package com.es.index.dump.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.es.index.cache.CacheCommand;
import com.es.index.cache.CacheManager;
import com.es.index.cache.CacheService;
import com.es.index.dump.dao.BookSaleAttrDao;
import com.es.index.dump.service.BookSaleAttrService;
import com.es.model.BookSaleAttr;

public class BookSaleAttrServiceImpl extends CacheService implements BookSaleAttrService {

	private BookSaleAttrDao bookSaleAttrDao;
	private Map<Long, BookSaleAttr> cacheBookSaleAttrMap;

	public BookSaleAttrServiceImpl() {
		this.serOrder(ORDER.SECONED);
		CacheCommand command = new CacheCommand(this);
		CacheManager.getInstance().registe(command);
	}
	
	@Override
	public Map<Long, BookSaleAttr> getAllBooSaleAttr() {
		return cacheBookSaleAttrMap;
	}


	@Override
	public void tryReload() throws Exception {
		Map<Long, BookSaleAttr> saleAttrMap = new HashMap<Long, BookSaleAttr>();
		List<BookSaleAttr> saleAttrs = bookSaleAttrDao.getAllBookSaleAttr();
		if(CollectionUtils.isNotEmpty(saleAttrs)){
			for(BookSaleAttr saleAttr : saleAttrs){
				saleAttrMap.put(saleAttr.getId(), saleAttr);
			}
		}
		if(saleAttrMap.size() > 0){
			this.cacheBookSaleAttrMap = saleAttrMap;
		}
	}

	public void setBookSaleAttrDao(BookSaleAttrDao bookSaleAttrDao) {
		this.bookSaleAttrDao = bookSaleAttrDao;
	}
}
