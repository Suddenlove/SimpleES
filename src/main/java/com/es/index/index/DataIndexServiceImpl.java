package com.es.index.index;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.es.client.IndexClient;
import com.es.index.service.DataIndexService;
import com.es.util.mysqlMapping.MySQLMappingService;

public class DataIndexServiceImpl implements DataIndexService{
	
	private Log logger = LogFactory.getLog(DataIndexServiceImpl.class);
	private MySQLMappingService mySQLMappingService;
	private static String indexName = "book";
	IndexClient indexClient = IndexClient.getInstance();

	@Override
	public String initIndex(String indexName) throws Exception {
		long currentTime = System.currentTimeMillis();
		String idxVersionName = currentTime + "_" + currentTime;
		String template = mySQLMappingService.transformMySQL2ES();
		indexClient.createIndex(indexName, template);
		return idxVersionName;
	}

	@Override
	public boolean buildIndex(String indexName, String indexVersion, List<Map<String, Object>> indexDocMap)
			throws Exception {
		if(StringUtils.isBlank(indexName) || StringUtils.isBlank(indexVersion)
				){
			logger.error("error info,indexName : " + indexName + "indexVersion : " + indexVersion);
			return false;
		}
		boolean isSuccess = IndexClient.bulkIndex(indexVersion, indexName, indexDocMap);
		if(!isSuccess){
			logger.error("create index error,indexVersion : " + indexVersion);
		} 
		return isSuccess;
	}

	@Override
	public boolean changeIndex(String indexName, String indexVersion) throws Exception {
		return false;
	}

	@Override
	public boolean updateIndex(List<Long> booIds, List<Map<Long, Object>> indexDocMap) throws Exception {
		return false;
	}

	public void setMySQLMappingService(MySQLMappingService mySQLMappingService) {
		this.mySQLMappingService = mySQLMappingService;
	}
	
}
