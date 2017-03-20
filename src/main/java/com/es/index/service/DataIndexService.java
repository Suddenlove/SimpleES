package com.es.index.service;

import java.util.List;
import java.util.Map;

public interface DataIndexService {
	
	String initIndex(String indexName) throws Exception;
	
	boolean buildIndex(String indexName, String indexVersion, List<Map<Long, Object>> indexDocMap) throws Exception;
	
	boolean changeIndex(String indexName, String indexVersion) throws Exception;
	
	boolean updateIndex(List<Long> booIds, List<Map<Long, Object>> indexDocMap) throws Exception;
	
}
