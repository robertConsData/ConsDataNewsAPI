package com.consdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consdata.entity.News;
import com.consdata.service.NewsServiceImpl;

@RestController
public class NewsControllerImpl implements NewsController {

	@Autowired
	private NewsServiceImpl newsService;
	
	@CrossOrigin(origins = "http://localhost:4200")	
	@RequestMapping("/news/{country}/{category}/")
	public News getNewsByCategory(@PathVariable String country, @PathVariable String category)
	{
		return newsService.getArticlesByCategory(country, category);
	}

}
