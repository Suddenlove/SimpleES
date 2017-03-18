package com.es.index.dump.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.es.index.dump.dao.BookStockDao;
import com.es.model.BookStock;

@SuppressWarnings("deprecation")
public class BookStockDaoImpl extends SqlMapClientDaoSupport implements BookStockDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<BookStock> getAllBookStock() {
		return getSqlMapClientTemplate().queryForList("getAllBookStock");
	}

}
