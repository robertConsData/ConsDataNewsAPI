package com.consdata.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.consdata.entity.News;

public interface NewsService 
{

	/**
	 * Getting articles by chosen country and category 
	 * 
	 * @param country of news source 
	 * @param category of news 
	 * @return List of articles from chosen country and category
	 */
	public News getArticlesByCategory(@PathVariable String country, @PathVariable String category);
	
}
