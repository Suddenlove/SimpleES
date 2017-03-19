package com.es.frame;

import java.util.HashMap;
import java.util.Map;

public class AttrContext {
	
	private Map<String, Object> _attrContext;
	public AttrContext() {
		_attrContext = new HashMap<String, Object>();
	}
	
	public void remove(String name){
		_attrContext.remove(name);
	}
	
	public Object get(String name){
		return _attrContext.get(name);
	}
	
	public void set(String name,Object object){
		if(object == null){
			_attrContext.remove(name);
		}else {
			_attrContext.put(name, object);
		}
	}
}
