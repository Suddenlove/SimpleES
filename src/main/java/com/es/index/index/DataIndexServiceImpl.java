package com.es.index.index;

import java.util.List;
import java.util.Map;

import com.es.index.service.DataIndexService;

public class DataIndexServiceImpl implements DataIndexService{

	@Override
	public String initIndex(String indexName) throws Exception {
		return null;
	}

	@Override
	public boolean buildIndex(String indexName, String indexVersion, List<Map<Long, Object>> indexDocMap)
			throws Exception {
		return false;
	}

	@Override
	public boolean changeIndex(String indexName, String indexVersion) throws Exception {
		return false;
	}

	@Override
	public boolean updateIndex(List<Long> booIds, List<Map<Long, Object>> indexDocMap) throws Exception {
		return false;
	}

}
