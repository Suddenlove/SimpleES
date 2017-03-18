package com.es.index.dump.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.es.index.dump.dao.BookDao;
import com.es.model.Book;

@SuppressWarnings("deprecation")
public class BookDaoImpl extends SqlMapClientDaoSupport implements BookDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBook(List<Long> bookIds) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bookIds", bookIds);
		return getSqlMapClientTemplate().queryForList("getAllBooks", map);
	}
	
}
