package com.es.client;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import com.es.util.PropertiesUtil;
import com.google.gson.Gson;

public class IndexClient {

	static Log logger = LogFactory.getLog(IndexClient.class);
	private static TransportClient client = null;
	private static Properties properties = PropertiesUtil.getProperties();
	private static IndexClient indexClient;

	private IndexClient() {

	}

	public static synchronized IndexClient getInstance() {
		if (indexClient == null) {
			initClient();
		}
		return indexClient;
	}
	
	public void createIndex(String indexName, String templateContent){
		CreateIndexRequest request = new CreateIndexRequest(indexName).source(templateContent);
		client.admin().indices().create(request).actionGet();
	}
	
	public static boolean bulkIndex(String indexVerison, String indexName, List<Map<String, Object>> indexMap){
		BulkRequestBuilder bulkIndexBuilder = client.prepareBulk();
		Object id;
		String jsonStr;
		Gson gson = new Gson();
		for(Map<String, Object> map : indexMap){
			id = map.get("id");
			if(id == null){
				continue;
			}
			jsonStr = gson.toJson(map);
			IndexRequestBuilder requestBuilder = client.prepareIndex(indexName, indexVerison,null).setSource(jsonStr).setId(String.valueOf(id));
			bulkIndexBuilder.add(requestBuilder);
		}
		BulkResponse response = bulkIndexBuilder.execute().actionGet();
		if(response.hasFailures()){
			logger.error("bulk index error : " + response.buildFailureMessage());
			return false;
		}
		return true;
	}

	private static void initClient() {
		try {
			String nodes = properties.getProperty("nodes");
			String esName = properties.getProperty("cluster.name");

			client = TransportClient.builder().settings(settings(esName)).build();

			if (nodes != null && nodes.length() > 0) {
				String ipports[] = nodes.split(",");
				if (ipports != null && ipports.length > 0) {
					for (String ipport : ipports) {
						if (ipport != null && ipport.length() > 0) {
							String str[] = ipport.split(":");
							if (str != null && str.length == 2) {
								String str0 = str[0].trim();
								String str1 = str[1].trim();
								client.addTransportAddress(new InetSocketTransportAddress(
										new InetSocketAddress(str0, Integer.valueOf(str1))));
							}
						}
					}
				}
			}
			indexClient = new IndexClient();
		} catch (Exception e) {
			logger.error("init error:", e);
		}
	}

	private static Settings settings(String elasticsearchName) {
		return Settings.settingsBuilder().put("cluster.name", elasticsearchName).put("client.transport.sniff", true)
				.put("client.transport.ignore_cluster_name", false).put("client.transport.ping_timeout", "5s")
				.put("client.transport.nodes_sampler_interval", "5s").build();
	}

}
