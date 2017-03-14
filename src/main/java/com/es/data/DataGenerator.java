package com.es.data;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

public class DataGenerator {
	
	public static void main(String[] args) {
		File sqlFile = writeSqlFile("C:/Users/AdministratorDesktop/data.sql");
	}

	private static File writeSqlFile(String filePath) {
		File sqlFileTemp = null;
		if(StringUtils.isNoneBlank(filePath)){
			sqlFileTemp = new File(filePath);
		}
		return sqlFileTemp;
	}
	
	
}
