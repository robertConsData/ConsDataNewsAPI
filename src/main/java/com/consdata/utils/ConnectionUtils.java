package com.consdata.utils;

import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.stereotype.Component;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Component
public class ConnectionUtils {
	
	private static final String APIKEY = "0ebd108da98748099a2c81546ab02151";

	Logger logger = Logger.getLogger(ConnectionUtils.class);
	
	public String getURL(String country, String category) 
	{
		String newsURL = "";
		try {
			newsURL = buildUrl(country, category);
		} catch (URISyntaxException e) {
			logger.error("Error during building URL to NEWSAPI: " + e);
		}
		return newsURL;
	}
	
	public JSONArray getArticles(String newsApiURL)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get(newsApiURL).asJson();
		} catch (UnirestException e) {
			logger.error("Error during downloading data from NEWSAPI: " + e);
		}
		return jsonResponse.getBody().getObject().getJSONArray("articles");
	}
	
	private String buildUrl(String country, String category) throws URISyntaxException 
	{
		return new URIBuilder()
			            .setScheme("https")
			            .setHost("newsapi.org")
			            .setPath("/v2/top-headlines")
			            .setParameter("country", country)
			            .setParameter("category", category)
			            .setParameter("apiKey", APIKEY)
			            .build().toString();
	}
}
