package com.consdata.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.consdata.entity.News;

public interface NewsController 
{
	
	/**
	 * Getting news by chosen country and category 
	 * 
	 * @param country of news source 
	 * @param category of news 
	 * @return News object with  params as fields and list of founded articles
	 */
	@CrossOrigin(origins = "http://localhost:4200")	
	@RequestMapping("/news/{country}/{category}/")
	public News getNewsByCategory(@PathVariable String country, @PathVariable String category);
}
