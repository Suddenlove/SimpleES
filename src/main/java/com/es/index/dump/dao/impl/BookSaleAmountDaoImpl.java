package com.es.index.dump.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.es.index.dump.dao.BookSaleAmountDao;
import com.es.model.BookSaleAmount;

@SuppressWarnings("deprecation")
public class BookSaleAmountDaoImpl extends SqlMapClientDaoSupport implements BookSaleAmountDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<BookSaleAmount> getAllBookSaleAmount() {
		return getSqlMapClientTemplate().queryForList("getAllBookSaleAmount");
	}

}
