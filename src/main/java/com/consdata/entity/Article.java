package com.consdata.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class Article {

	@JsonProperty("author")
	private String author;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("publishedAt")
	private String date;
	
	@JsonProperty("url")
	private String articleUrl;
	
	@JsonProperty("urlToImage")
	private String imageUrl;
	
	@JsonProperty("source")
	private Source source; 
	
	@JsonProperty("content")
	private String content; 
	
}
