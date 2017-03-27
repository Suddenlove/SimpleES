package com.es.util.mysqlMapping;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

@SuppressWarnings("deprecation")
public class MySQLMappingDaoImpl extends SqlMapClientDaoSupport implements MySQLMappingDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MySQLMapping> getAllMySQLMapping() {
		return getSqlMapClientTemplate().queryForList("getAllMySQLMapping");
	}
}
