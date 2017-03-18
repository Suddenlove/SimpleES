package com.es.index.dump.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.es.index.cache.CacheCommand;
import com.es.index.cache.CacheManager;
import com.es.index.cache.CacheService;
import com.es.index.dump.dao.CategoryDao;
import com.es.index.dump.service.CategoryService;
import com.es.model.Category;

public class CategoryServiceImpl extends CacheService implements CategoryService {

	private CategoryDao categoryDao;
	private Map<Long, Category> cacheLongCategoryMap;
	public CategoryServiceImpl() {
		this.serOrder(ORDER.SECONED);
		CacheCommand command = new CacheCommand(this);
		CacheManager.getInstance().registe(command);
	}

	@Override
	public Map<Long, Category> getAllCateogryServcie() {
		return cacheLongCategoryMap;
	}

	@Override
	public void tryReload() throws Exception {
		Map<Long, Category> cateMap = new HashMap<Long, Category>();
		List<Category> categories = categoryDao.getAllCategory();
		if(CollectionUtils.isNotEmpty(categories)){
			for(Category category : categories){
				cateMap.put(category.getId(), category);
			}
		}
		if(cateMap.size() > 0){
			this.cacheLongCategoryMap = cateMap;
		}
		
	}
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}


}
