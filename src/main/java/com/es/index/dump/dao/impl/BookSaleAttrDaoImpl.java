package com.es.index.dump.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.es.index.dump.dao.BookSaleAttrDao;
import com.es.model.BookSaleAttr;

@SuppressWarnings("deprecation")
public class BookSaleAttrDaoImpl extends SqlMapClientDaoSupport implements BookSaleAttrDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<BookSaleAttr> getAllBookSaleAttr() {
		return getSqlMapClientTemplate().queryForList("getAllBooSaleAttr");
	}

}
