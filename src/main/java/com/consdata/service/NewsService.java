package com.consdata.service;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.consdata.entity.Article;
import com.consdata.entity.ArticleDTO;
import com.consdata.entity.News;
import com.consdata.utils.NewsApiConnectionUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NewsService {
	
	Logger logger = Logger.getLogger(NewsService.class);
	
	@Autowired
	NewsApiConnectionUtils connectionUtil;

	public News getArticlesByCategory(@PathVariable String country, @PathVariable String category)
	{
        JSONArray jsonarray = connectionUtil.getArticles(country, category);
        List<ArticleDTO> articlesDto = mapToArticleDto(jsonarray);
		return new News(country, category, articlesDto);
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
	
    private ArticleDTO mapToDto(Article article) 
    {
    	ModelMapper modelMapper = new ModelMapper();
    	return modelMapper.map(article, ArticleDTO.class);
    }

}
