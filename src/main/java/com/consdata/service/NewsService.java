package com.consdata.service;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.client.utils.URIBuilder;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.consdata.entity.Article;
import com.consdata.entity.ArticleDTO;
import com.consdata.entity.News;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class NewsService {
	
	Logger logger = Logger.getLogger(NewsService.class);

	public News getArticlesByCategory(@PathVariable String country, @PathVariable String category)
	{
		String url = getURL(country, category);
        JSONArray jsonarray = getArticles(url);
        List<ArticleDTO> articlesDto = mapToArticleDto(jsonarray);
		return new News(country, category, articlesDto);
	}

	private String getURL(String country, String category) 
	{
		String newsURL = "";
		try {
			newsURL = buildUrl(country, category);
		} catch (URISyntaxException e) {
			logger.error("Error during building URL to NEWSAPI: " + e);
		}
		return newsURL;
	}

	private List<ArticleDTO> mapToArticleDto(JSONArray jsonarray) 
	{
		ObjectMapper mapper = new ObjectMapper();
		List<Article> articles = null;
		try {
			articles = mapper.readValue(jsonarray.toString(), new TypeReference<List<Article>>(){});
		} catch (IOException e) {
			logger.error("Error during mapping JSON to Article entity: " + e);
		}

		return articles.stream().map(this::mapToDto).collect(toList());
	}

	private JSONArray getArticles(String newsApiURL)
	{
		HttpResponse<JsonNode> jsonResponse = null;
		try {
			jsonResponse = Unirest.get(newsApiURL).asJson();
		} catch (UnirestException e) {
			logger.error("Error during downloading data from NEWSAPI: " + e);
		}
		return jsonResponse.getBody().getObject().getJSONArray("articles");
	}
	
    private ArticleDTO mapToDto(Article article) 
    {
    	ModelMapper modelMapper = new ModelMapper();
    	return modelMapper.map(article, ArticleDTO.class);
    }
	
	private String buildUrl(String country, String category) throws URISyntaxException 
	{
		String apiKey = "0ebd108da98748099a2c81546ab02151";

		return new URIBuilder()
			            .setScheme("https")
			            .setHost("newsapi.org")
			            .setPath("/v2/top-headlines")
			            .setParameter("country", country)
			            .setParameter("category", category)
			            .setParameter("apiKey", apiKey)
			            .build().toString();
	}
}
