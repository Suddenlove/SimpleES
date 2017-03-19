package com.es.index.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

import org.apache.commons.collections.CollectionUtils;

import com.es.frame.BookRecord;

@SuppressWarnings("rawtypes")
public class ForkJoinPoolProcessor extends RecursiveTask<Map<Long, List<Object>>>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int start;
	private int end;
	private int max;
	private List<BookRecord> list;
	public ForkJoinPoolProcessor(int start, int end, int max, List<BookRecord> list) {
		super();
		this.start = start;
		this.end = end;
		this.max = max;
		this.list = list;
	}
	
	
	@Override
	protected Map<Long, List<Object>> compute() {
		Map<Long, List<Object>> computeMap = new HashMap<Long, List<Object>>();
		if((end -start) < max){
			List<BookRecord> bookRecords = list.subList(start, end);
			return process(bookRecords);
		}else {
			int middle = (start + end) / 2;
			ForkJoinPoolProcessor left = new ForkJoinPoolProcessor(start, middle, max, list);
			ForkJoinPoolProcessor right = new ForkJoinPoolProcessor(middle, end, max, list);
			left.fork();
			right.fork();
			Map<Long, List<Object>> leftMap = left.join();
			Map<Long, List<Object>> rightMap = right.join();
			computeMap = merge(leftMap, rightMap);
			return computeMap;
		}
	}


	private Map<Long, List<Object>> merge(Map<Long, List<Object>> leftMap, Map<Long, List<Object>> rightMap) {
		Map<Long, List<Object>> mergeMap = new HashMap<Long, List<Object>>();
		mergeMap.putAll(leftMap);
		List<Object> objects;
		for(Long key : rightMap.keySet()){
			objects = rightMap.get(key);
			if(mergeMap.containsKey(key)){
				objects.addAll(rightMap.get(key));
			}
			mergeMap.put(key, objects);
		}
		return mergeMap;
	}


	@SuppressWarnings("unchecked")
	private Map<Long, List<Object>> process(List<BookRecord> bookRecords) {
		Map<Long, List<Object>> dataMap = new HashMap<Long, List<Object>>();
		if(CollectionUtils.isNotEmpty(bookRecords)){
			for(BookRecord<Long, Object> bookRecord : bookRecords){
				if(bookRecord.getV() == null){
					continue;
				}
				Long key = (Long) bookRecord.getV();
				List<Object> objects = dataMap.get(key);
				if(objects == null){
					objects = new ArrayList<Object>();
					dataMap.put(key, objects);
				}
				objects.add(bookRecord.getV());
			}
		}
		return dataMap;
	}
}
