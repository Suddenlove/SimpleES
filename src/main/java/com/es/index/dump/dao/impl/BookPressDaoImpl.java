package com.es.index.dump.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.es.index.dump.dao.BookPressDao;
import com.es.model.BookPress;

@SuppressWarnings("deprecation")
public class BookPressDaoImpl extends SqlMapClientDaoSupport implements BookPressDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<BookPress> getAllBookPress() {
		return getSqlMapClientTemplate().queryForList("getAllBookPress");
	}

}
