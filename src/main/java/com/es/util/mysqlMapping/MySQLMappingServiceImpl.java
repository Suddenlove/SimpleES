package com.es.util.mysqlMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.google.gson.Gson;

public class MySQLMappingServiceImpl implements MySQLMappingService{

	private MySQLMappingDao mySQLMappingDao;
	private static final String[] noOrYes = new String[]{"no", "yes"};
	
	@Override
	public String transformMySQL2ES() {
		List<MySQLMapping> mySQLMappings = mySQLMappingDao.getAllMySQLMapping();
		if(CollectionUtils.isEmpty(mySQLMappings)){
			return null;
		}
		Map<String, Object> settingMap = new HashMap<String, Object>();
		Map<String, Object> indexMap = new HashMap<String, Object>();
		Map<String, Object> settingConfigMap = new HashMap<String, Object>();
		settingConfigMap.put("number_of_shards", 5);
		settingConfigMap.put("number_of_replicas", 1);
		indexMap.put("index", settingConfigMap);
		settingMap.put("settings", indexMap);
		
		Map<String, Object> mappingMap = new HashMap<String, Object>();
		Map<String, Object> _typeMap = new HashMap<String, Object>();
		Map<String, Object> propertyMap = new HashMap<String, Object>();
		Map<String, Object> fieldMap = new HashMap<String, Object>();
		for(MySQLMapping mySQLMapping : mySQLMappings){
			Map<String, Object> typeMap = new HashMap<String, Object>();
			typeMap.put("index", noOrYes[mySQLMapping.getIsIndex()]);
			typeMap.put("type", mySQLMapping.getType());
			typeMap.put("store", noOrYes[mySQLMapping.getIsStore()]);
			fieldMap.put(mySQLMapping.getField(), typeMap);
		}
		propertyMap.put("properties", fieldMap);
		_typeMap.put("book", propertyMap);
		mappingMap.put("mappings", _typeMap);
		Gson gson = new Gson();
		return gson.toJson(settingMap) + "," + gson.toJson(mappingMap);
	}

	public void setMySQLMappingDao(MySQLMappingDao mySQLMappingDao) {
		this.mySQLMappingDao = mySQLMappingDao;
	}

}
