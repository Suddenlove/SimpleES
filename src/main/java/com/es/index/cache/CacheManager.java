package com.es.index.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.es.index.cache.CacheService.ORDER;
import com.es.model.Constant;

public class CacheManager {
	
	private Log logger = LogFactory.getLog(CacheManager.class);
	private static CacheManager instance;
	private Vector<CacheCommand> cacheCommands;
	private Map<String, CacheCommand> cacheCommandMap;
	private volatile boolean isRunning = false;
	
	private CacheManager(){
		cacheCommands = new Vector<CacheCommand>();
		cacheCommandMap = new Hashtable<String, CacheCommand>();
	}
	
	public static CacheManager getInstance(){
		if(instance == null){
			return new CacheManager();
		}
		return instance;
	}
	
	public List<CacheCommand> getCacheCommandList(){
		return cacheCommands;
	}
	
	public synchronized void registe(CacheCommand cacheCommand){
		if(cacheCommand != null){
			cacheCommands.add(cacheCommand);
			cacheCommandMap.put(cacheCommand.getCacheServiceName(), cacheCommand);
		}
	}
	
	public void init(){
		if(isRunning){
			return;
		}
		isRunning = true;
		ayncLoad(cacheCommands);
		
		isRunning = false;
	}

	private void ayncLoad(List<CacheCommand> cacheCommands) {
		if(cacheCommands == null){
			return;
		}
		Map<ORDER, List<CacheCommand>> orderCommandMap = new HashMap<ORDER, List<CacheCommand>>();
		for(CacheCommand cacheCommand : cacheCommands){
			if(orderCommandMap.get(cacheCommand.getOrder()) == null){
				orderCommandMap.put(cacheCommand.getOrder(), new ArrayList<CacheCommand>());
			}
			orderCommandMap.get(cacheCommand.getOrder()).add(cacheCommand);
		}
		logger.info("加载开始...");
		ExecutorService service = Executors.newFixedThreadPool(Constant.CACHE_LOAD_THREAD_POOL_SIZE);
		List<CacheCommand> firstCommands = orderCommandMap.get(ORDER.FIRST);
		logger.info("=====>加载第一个command...");
		if(firstCommands != null){
			excuteLoad(service, firstCommands);
		}
		logger.info("=====>第一个command加载完毕...");
		List<CacheCommand> secondCommands = orderCommandMap.get(ORDER.SECONED);
		logger.info("=====>加载第二个command...");
		if(secondCommands != null){
			excuteLoad(service, secondCommands);
		}
		logger.info("=====>第二个command加载完毕...");
		logger.info("加载完毕...");
		
	}

	private void excuteLoad(ExecutorService service,List<CacheCommand> cacheCommands) {
		List<Future<Boolean>> futures = new ArrayList<Future<Boolean>>();
		for(CacheCommand cacheCommand : cacheCommands){
			Future<Boolean> future = service.submit(cacheCommand);
			futures.add(future);
		}
		for(Future<Boolean> future:futures){
			try {
				future.get(20, TimeUnit.MINUTES);
			} catch (Exception e) {
				logger.error("加载异常...",e);
			}
		}
	}
}
