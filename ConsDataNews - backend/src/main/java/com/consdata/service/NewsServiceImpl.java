package com.consdata.service;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.consdata.entity.News;

@Service
public class NewsServiceImpl implements NewsService
{
	
	static final String API_KEY = "0ebd108da98748099a2c81546ab02151";
	
	public News getArticlesByCategory(@PathVariable String country, @PathVariable String category)
	{
		RestTemplate restTemplate = new RestTemplate();
		String newsApiUrl = "https://newsapi.org/v2/top-headlines?country={country}&category={category}&apiKey={apiKey}";
		
		return restTemplate.getForObject( newsApiUrl ,News.class, buildUrlVariables(country, category));
	}

	private Map<String, String> buildUrlVariables(String country, String category) 
	{
		Map<String, String> urlVariables = new HashMap<String, String>();
		
        urlVariables.put("country", country);
        urlVariables.put("category", category);
        urlVariables.put("apiKey", API_KEY);
        
		return urlVariables;
	}

}
