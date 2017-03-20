package com.es.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PropertiesUtil {
	private static ResourceLoader loader = ResourceLoader.getInstance();
	private static ConcurrentMap<String, String> configMap = new ConcurrentHashMap<String, String>();
	private static final String DEFAULT_CONFIG_FILE = "common.properties";

	private static Properties prop = null;

	public static String getStringByKey(String key, String propName) {
		try {
			prop = loader.getPropFromProperties(propName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		key = key.trim();
		if (!configMap.containsKey(key)) {
			if (prop.getProperty(key) != null) {
				configMap.put(key, prop.getProperty(key));
			}
		}
		return configMap.get(key);
	}

	public static String getStringByKey(String key) {
		return getStringByKey(key, DEFAULT_CONFIG_FILE);
	}

	public static Properties getProperties() {
		try {
			return loader.getPropFromProperties(DEFAULT_CONFIG_FILE);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<String> getListByKey(String string) {
		List<String> list = new ArrayList<String>();
		String str = getStringByKey(string);
		if (str == null || str.trim().length() == 0) {
			return list;
		}
		String strs[] = str.split(",");
		if (strs != null && strs.length > 0) {
			for (String temp : strs) {
				list.add(temp.trim());
			}
		}
		return list;
	}

	/*public static void main(String[] args) {
		String testValue = PropertiesUtil.getStringByKey("test");
		System.out.println(testValue);
	}*/

}
