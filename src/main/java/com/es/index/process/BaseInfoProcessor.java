package com.es.index.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

import org.apache.commons.collections.CollectionUtils;

import com.es.frame.BookRecord;
import com.es.frame.DataProcessContext;
import com.es.index.service.DataProcessServcie;

@SuppressWarnings("rawtypes")
public class BaseInfoProcessor implements DataProcessServcie<BookRecord>{

	@Override
	public void process(DataProcessContext<BookRecord> processContext) throws Exception{
		List<BookRecord> bookRecords = processContext.getBookRecords();
		if(CollectionUtils.isNotEmpty(bookRecords)){
			ForkJoinPool processPool = new ForkJoinPool();
			Future<Map<Long, List<Object>>> future = processPool.submit(new ForkJoinPoolProcessor(0, bookRecords.size(), 1000, bookRecords));
			Map<Long, List<Object>> resMap = future.get();
			if(resMap != null && resMap.size() > 0){
				List<BookRecord> newRecords = new ArrayList<BookRecord>();
				for(Map.Entry<Long, List<Object>> entry : resMap.entrySet()){
					newRecords.add(new BookRecord<Long, List<Object>>(entry.getKey(), entry.getValue()));
				}
				processContext.setBookRecords(newRecords);
			}
			processPool.shutdown();
		}
	}

}
