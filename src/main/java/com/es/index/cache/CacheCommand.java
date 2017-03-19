package com.es.index.cache;

import java.util.concurrent.Callable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.es.index.cache.CacheService.ORDER;


public class CacheCommand implements Callable<Boolean>{
	
	private Log logger = LogFactory.getLog(CacheCommand.class);
	private CacheService cacheService;
	public CacheCommand(CacheService cacheService) {
		this.cacheService = cacheService;
	}
	
	public String getCacheServiceName(){
		return cacheService.getClass().getSimpleName();
	}
	
	public ORDER getOrder(){
		return cacheService.getOrder();
	}
	
	@Override
	public Boolean call() throws Exception {
		long start = System.currentTimeMillis();
		cacheService.init();
		long end = System.currentTimeMillis();
		logger.info("加载完毕,耗时:" + (end - start) + "ms");
		return null;
	}

}
