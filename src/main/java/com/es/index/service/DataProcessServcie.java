package com.es.index.service;

import com.es.frame.BookRecord;
import com.es.frame.DataProcessContext;

@SuppressWarnings("hiding")
public interface DataProcessServcie<BookRecord> {
	
	void process(DataProcessContext<BookRecord> processContext) throws Exception;
}
