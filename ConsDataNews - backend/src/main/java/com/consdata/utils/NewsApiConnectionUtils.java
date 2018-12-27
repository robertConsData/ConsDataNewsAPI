package com.consdata.utils;

import org.json.JSONArray;

public interface NewsApiConnectionUtils {
	
	
	/**
	 * Getting Articles in json array format
	 * 
	 * @param country of news source 
	 * @param category of news 
	 * @return articles in JSONArray format
	 */
	public JSONArray getArticles(String country, String category);
	
	/**
	 * Getting URL to get articles by country and category 
	 * 
	 * @param country of news source 
	 * @param category of news 
	 * @return
	 */
	public String getURL(String country, String category);

}
