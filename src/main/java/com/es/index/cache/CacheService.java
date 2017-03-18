package com.es.index.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class CacheService implements Cache{
	
	private Log logger = LogFactory.getLog(CacheService.class);
	public ORDER order;
	
	public enum ORDER{
		FIRST, SECONED, THIRD, FORTH
	}
	
	public ORDER getOrder(){
		return order;
	}
	
	public void serOrder(ORDER order){
		this.order = order;
	}

	@Override
	public synchronized void init(){
		logger.info("开始初始化...");
		this.reload();
		logger.info("初始化结束...");
	}
	
	@Override
	public synchronized void reload(){
		try {
			logger.info("开始加载缓存数据...");
			this.tryReload();
			logger.info("缓存数据加载完毕...");
		} catch (Exception e) {
			logger.error("缓存加载异常", e);
		}
	}
	
	public abstract void tryReload() throws Exception;
	
}
