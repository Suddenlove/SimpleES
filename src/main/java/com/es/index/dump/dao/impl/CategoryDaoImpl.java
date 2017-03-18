package com.es.index.dump.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.es.index.dump.dao.CategoryDao;
import com.es.model.Category;

@SuppressWarnings("deprecation")
public class CategoryDaoImpl extends SqlMapClientDaoSupport implements CategoryDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategory() {
		return getSqlMapClientTemplate().queryForList("getAllCategory");
	}
}
